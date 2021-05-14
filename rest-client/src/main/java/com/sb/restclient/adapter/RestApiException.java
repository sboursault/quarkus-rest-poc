package com.sb.restclient.adapter;

import javax.ws.rs.core.Response;

public class RestApiException extends RuntimeException {

    private final int status;
    private final String body;
    private final String error;
    private final String description;

    public RestApiException(int status, String body, String error, String description) {
        super(error + ": " + description);
        this.status = status;
        this.body = body;
        this.error = error;
        this.description = description;
    }

    public RestApiException(int status, String body) {
        super(Response.Status.fromStatusCode(status).getReasonPhrase());
        this.status = status;
        this.body = body;
        this.error = null;
        this.description = null;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }
}
