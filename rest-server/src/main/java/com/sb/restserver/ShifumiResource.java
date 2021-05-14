package com.sb.restserver;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.Random;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.*;

@Path("/")
@Produces(APPLICATION_JSON)
public class ShifumiResource {

    private int credits = 3;

    @POST
    @Path("/play")
    public Uni<Choice> play() {

        if (credits <= 0) {
            throw new QuotaLimitExceededException("You used all your credits");
        }

        credits--;

        return Uni
                .createFrom()
                .item(Choice.random());
    }

    @POST
    @Path("/add-credits")
    public void addCredits() {
        credits += 3;
    }
}