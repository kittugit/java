package net.shazam.rnd.cxfrest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import net.shazam.rnd.cxfrest.JsonBean;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

@Path("/hello")
public class HelloWorld {

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String ping(@PathParam("input") String input) {
        return input;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/jsonBean")
    public Response modifyJson(JsonBean input) {
        input.setVal2(input.getVal1());
        return Response.ok().entity(input).build();
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/json")
    public JsonBean modify(JsonBean input) {
        input.setVal1(input.getVal1().toUpperCase());
        input.setVal2(input.getVal2().toUpperCase());
        return input;
    }
    
    @POST
    @Consumes("multipart/form-data")
    @Path("/image")
    public void image(@Multipart(value = "image", type = "image/jpeg") Attachment image){
    	
    	
    		DataHandler handler = image.getDataHandler();
            try {
               InputStream stream = handler.getInputStream();
               MultivaluedMap<String, String> map = image.getHeaders();
               System.out.println("fileName Here" + getFileName(map));
               OutputStream out = new FileOutputStream(new File("C:/uploads/" + getFileName(map)));

               int read = 0;
               byte[] bytes = new byte[1024];
               while ((read = stream.read(bytes)) != -1) {
                  out.write(bytes, 0, read);
               }
               stream.close();
               out.flush();
               out.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
            
    }
    
    
    private String getFileName(MultivaluedMap<String, String> header) {
        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
        for (String filename : contentDisposition) {
           if ((filename.trim().startsWith("filename"))) {
              String[] name = filename.split("=");
              String exactFileName = name[1].trim().replaceAll("\"", "");
              return exactFileName;
           }
        }
        return "unknown";
     }
    
}



