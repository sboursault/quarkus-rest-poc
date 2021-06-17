package com.sb.restclient.adapter;

import io.smallrye.mutiny.Uni;
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
    Uni<Choice> play();  // try with uni

    @POST
    @Path("/add-credits")
    Uni<Void> addCredits();
}