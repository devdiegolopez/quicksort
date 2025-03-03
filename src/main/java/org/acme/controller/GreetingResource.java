package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.domain.data.dto.request.RequestDto;
import org.acme.domain.data.dto.response.ResponseDto;
import org.acme.domain.ports.QuickServicePort;

import java.util.logging.Logger;
/**/
@Path("/hello")
public class GreetingResource {
    @Inject
    QuickServicePort quickServicePort;

    private static final Logger LOG = Logger.getLogger(String.valueOf(GreetingResource.class));
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }
    @GET
    @Path("/{n}")
    public ResponseDto hello(@PathParam("n") int n) {
        RequestDto requestDto = new RequestDto(n);
        LOG.info(String.valueOf(requestDto));
        return quickServicePort.quickSorting(requestDto);
    }


}