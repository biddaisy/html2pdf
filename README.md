# Example Quarkus java REST reporting service
When it comes to generate PDFs using Java the de facto solution is Jasper Reports. Even though it provides a bunch of features and a great set of tools, such as iReport and JasperSoft Studio, the developer might want a simpler and flexible alternative.  
This is an example Quarkus application that illustrate how simple and powerful it could be when use simple html template engine and than convert generated html into pdf.
In this example we use Handlebars as java html template engine. And for your choice two possible ways to convert generated html into pdf:
* Flying Saucer - iText as a rendering engine
* Open html to pdf - PDFBox as a rendering engine
## Useful links
### How to design html 
* https://www.smashingmagazine.com/2015/01/designing-for-print-with-css/ - good overview
* https://www.w3.org/TR/css-gcpm-3/ - specification
* https://www.w3.org/TR/css-page-3/ - specification
### Html template engine
* https://github.com/jknack/handlebars.java
### Rendering of pdf
* https://github.com/flyingsaucerproject/flyingsaucer
* https://github.com/danfickle/openhtmltopdf 

## To check the demo:
* checkout
* run mvn quarkus:dev in root folder of the project
* goto http://localhost:8080/api/print