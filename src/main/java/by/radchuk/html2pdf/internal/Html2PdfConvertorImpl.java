package by.radchuk.html2pdf.internal;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.InputSource;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import by.radchuk.html2pdf.Html2PdfConvertor;
import lombok.SneakyThrows;

/**
 * Implementation class for report conversion from html to pdf
 * 
 * @author Vladimir Radchuk
 *
 */
@ApplicationScoped
class Html2PdfConvertorImpl implements Html2PdfConvertor {

  @Override
  @SneakyThrows
  public byte[] toPdfWithPdfBox(String html) {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      PdfRendererBuilder builder = new PdfRendererBuilder();
      builder.useFastMode();
      // builder.
      builder.withHtmlContent(html, "//");
      builder.toStream(baos);
      builder.run();
      return baos.toByteArray();
    }

  }

  @Override
  @SneakyThrows
  public byte[] toPdfWithIText(String html) {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      // create a structured document from the generated HTML
      Document doc = getDocumentBuilder().parse(new InputSource(new CharArrayReader(html.toCharArray())));

      // now we take the document and apply the magic of flying saucer to create
      // a PDF file
      ITextRenderer renderer = new ITextRenderer();
      renderer.setDocument(doc, null);
      renderer.layout();
      renderer.createPDF(baos);
      renderer.finishPDF();
      return baos.toByteArray();
    }
  }

  // we use this method to create a DocumentBuild not so fanatic about XHTML
  private DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(false);
    factory.setValidating(false);
    factory.setFeature("http://xml.org/sax/features/namespaces", false);
    factory.setFeature("http://xml.org/sax/features/validation", false);
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
    return factory.newDocumentBuilder();
  }
}
