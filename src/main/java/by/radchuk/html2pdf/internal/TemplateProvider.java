package by.radchuk.html2pdf.internal;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.io.StringTemplateSource;

import by.radchuk.html2pdf.Html2PdfConvertor;
import by.radchuk.html2pdf.Name;
import lombok.SneakyThrows;

@ApplicationScoped
public class TemplateProvider {

  static ConcurrentHashMap<String, TemplateImpl> cache = new ConcurrentHashMap<>();

  static Handlebars handlebars = new Handlebars();

  @Inject
  Html2PdfConvertor html2pdf;

  @ConfigProperty(name = "templates.path", defaultValue = "templates/")
  String templatesPath;

  @Produces
  @Dependent
  public TemplateImpl createTemplate(InjectionPoint injectionPoint) {
    Name template = injectionPoint.getAnnotated().getAnnotation(Name.class);
    String fileName = template.value();
    return cache.computeIfAbsent(fileName, this::getTemplate);
  }

  @SneakyThrows
  private TemplateImpl getTemplate(String fileName) {
    String name = templatesPath + fileName;
    String content = IOUtils.resourceToString(name, Charset.forName("utf-8"), Thread.currentThread().getContextClassLoader());
    return new TemplateImpl(handlebars.compile(new StringTemplateSource(fileName, content)), html2pdf);
  }
}
