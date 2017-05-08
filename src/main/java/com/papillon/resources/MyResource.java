package com.papillon.resources;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by papillon on 5/8/2017.
 */
@Path("/{path}/test")
//@Singleton
public class MyResource {

    private int count;
    @PathParam("path") private String pathparam;
    @QueryParam("query") private String queryparam;

    /*@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testMethod(){
        count++;
        return "it works "+count+" pathparam " +pathparam+" queryparam : "+queryparam;
    }*/

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Date testMethod(){
        return Calendar.getInstance().getTime();
    }
}
