package com.sb.restclient;

import com.sb.restclient.adapter.Choice;
import com.sb.restclient.adapter.RestApiException;
import com.sb.restclient.adapter.ShifumiService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Objects;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/gateway")
@Produces(APPLICATION_JSON)
public class ShifumiGatewayResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShifumiGatewayResource.class);

    @Inject
    @RestClient
    ShifumiService service;

    @POST
    @Path("/play")
    public Choice play() {



        //try {
        //    System.out.println("play: " + service.play());
        //} catch (WebApplicationException e) {
        //    System.err.println("status:" + e.getResponse().getStatus());
        //    System.err.println("reason: " + e.getResponse().readEntity(String.class));
        //}

        try {
            Choice choice = service.play();
            LOGGER.info("Shifumi service returned {}", choice);
            return choice;
        } catch (RestApiException e) {
            if (Objects.equals(e.getError(), "QUOTA_LIMIT_EXCEEDED")) {
                LOGGER.info("You reached your quota limit :(");
                return null;
            } else {
                throw e;
            }
        }

    }

    @POST
    @Path("/add-credits")
    public void addCredits() {
        service.addCredits();
    }
}