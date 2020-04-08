package by.radchuk.html2pdf;

public interface Template {
  byte[] generate(Object object);
}
