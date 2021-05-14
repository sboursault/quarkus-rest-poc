package com.sb.restclient.adapter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import org.jboss.resteasy.spi.UnhandledException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Provider
public class RestApiExceptionMapper implements ResponseExceptionMapper<RestApiException> {

    @Override
    public RestApiException toThrowable(Response response) {
        JsonNode body = toJson(response);
        return new RestApiException(
                response.getStatus(),
                body.get("error").textValue(),
                body.get("error_description").textValue()
        );
    }

    private JsonNode toJson(Response response) {
        try {
            return new ObjectMapper().readTree((InputStream) response.getEntity());
        } catch (IOException e) {
            throw new UnhandledException(e);
        }
    }

}