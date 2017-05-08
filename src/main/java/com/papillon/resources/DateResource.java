package com.papillon.resources;

import com.papillon.datatypes.MyDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by papillon on 5/8/2017.
 */
@Path("/date/{datestring}")
public class DateResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getRequestedDate(@PathParam("datestring") MyDate mydate){
        return mydate.toString();
    }
}
