package com.sb.restclient;

import com.sb.restclient.adapter.RestApiException;
import com.sb.restclient.adapter.ShifumiService;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import java.util.Objects;

@QuarkusMain
public class ApplicationMain implements QuarkusApplication {

    @Inject
    @RestClient
    ShifumiService service;

    @Override
    public int run(String... args) throws Exception {

        System.out.println("\n1... 2... 3...\n\n");

        //try {
        //    System.out.println("play: " + service.play());
        //} catch (WebApplicationException e) {
        //    System.err.println("status:" + e.getResponse().getStatus());
        //    System.err.println("reason: " + e.getResponse().readEntity(String.class));
        //}

        try {
            System.out.println(service.play());
        } catch (RestApiException e) {
            if (Objects.equals(e.getError(), "QUOTA_LIMIT_EXCEEDED")) {
                System.out.println("You reached your quota limit :(");
            } else {
                throw e;
            }
        }

        System.out.println("\n");

        return 0;

        // zipkin quarkus ?
    }
}