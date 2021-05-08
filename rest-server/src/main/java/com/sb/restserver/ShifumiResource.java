package com.sb.restserver;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.Random;

@Path("/play")
//@Produces(MediaType.APPLICATION_JSON)
public class ShifumiResource {

    public static enum Choice {
        ROCK, PAPER, SCISSORS
    };

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<Choice> play() {

        return  Uni
                .createFrom()
                .item(
                        Choice.values()[new Random().nextInt(Choice.values().length)]
                );
    }
}