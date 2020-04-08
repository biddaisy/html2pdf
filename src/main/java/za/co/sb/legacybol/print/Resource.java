package za.co.sb.legacybol.print;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import by.radchuk.html2pdf.Name;
import by.radchuk.html2pdf.Template;
import za.co.sb.legacybol.print.model.DataRO;

@Path("/api/print")
@ApplicationScoped
public class Resource {

  @Inject
  DataRO data;

  @Inject
  @Name("index.html")
  Template template;

  @GET
  @Produces("application/pdf")
  public Response get() {
    return Response.ok(template.generate(data)).header("content-disposition", "inline;filename=report.pdf").build();
  }

}
