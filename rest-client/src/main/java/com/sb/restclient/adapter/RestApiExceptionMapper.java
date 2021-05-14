package com.sb.restclient.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

@Provider
public class RestApiExceptionMapper implements ResponseExceptionMapper<RestApiException> {

    @Override
    public RestApiException toThrowable(Response response) {
        String body = null;
        try {
            body = IOUtils.toString((InputStream) response.getEntity(), UTF_8.name());
            JsonNode json = new ObjectMapper().readTree(body);
            return new RestApiException(
                    response.getStatus(),
                    body,
                    json.get("error").textValue(),
                    json.get("error_description").textValue()
            );
        } catch (Exception e) {
            return new RestApiException(response.getStatus(), body);
        }
    }

}