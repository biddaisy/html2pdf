package by.radchuk.html2pdf;

/**
 * Defines an interface to convert html files into pdf
 * 
 * @author Vladimir Radchuk
 *
 */
public interface Html2PdfConvertor {

  byte[] toPdfWithPdfBox(String html);

  public byte[] toPdfWithIText(String html);

}
