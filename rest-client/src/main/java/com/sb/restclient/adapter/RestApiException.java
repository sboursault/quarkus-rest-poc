package com.sb.restclient.adapter;

public class RestApiException extends RuntimeException {

    private final int status;
    private final String error;
    private final String description;

    public RestApiException(int status, String error, String description) {
        super(error + ": " + description);
        this.status = status;
        this.error = error;
        this.description = description;
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
