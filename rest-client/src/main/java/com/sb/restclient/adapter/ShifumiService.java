package com.sb.restclient.adapter;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/")
@RegisterRestClient(configKey="shifumi-api")
@RegisterProvider(RestApiExceptionMapper.class)
public interface ShifumiService {

    @POST
    @Path("/play")
    Choice play();  // try with uni

    @POST
    @Path("/add-credits")
    Void addCredits();
}