package by.radchuk.html2pdf.internal;

import by.radchuk.html2pdf.Html2PdfConvertor;
import by.radchuk.html2pdf.Template;
import lombok.SneakyThrows;
import lombok.Value;

@Value
class TemplateImpl implements Template {

  private com.github.jknack.handlebars.Template template;

  private Html2PdfConvertor html2pdf;

  @Override
  @SneakyThrows
  public byte[] generate(Object object) {
    return html2pdf.toPdfWithIText(template.apply(object));
  }
}
