package org.acme;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/Conversion")
public class ConversionResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String conversionAbout() {
        return "Api de conversão de distancias";
    }
    
    @POST 
    @Path("/km-to-miles")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String kmToMiles(
        String number
    ) {
        Float value = Float.parseFloat(number) * 0.621371f;
        return String.format("%.5f", value);
    }
    
    //The speed in kilometers per hour is equal to the speed in knots multiplied by 1.852.
    @GET 
    @Path("/knots-to-km/{value}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String knotsToKilometers(
        @PathParam("value") String value
    ) {
        Float newvalue = Float.parseFloat(value)*1.852f;
        
        return "{\"valor\": " + newvalue + "}";
    }
}