package com.sb.restserver;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Objects;

@RegisterForReflection
public class Error {

    private final String error;
    private final String errorDescription;

    @JsonCreator
    public Error(@JsonProperty("error") String error,
                 @JsonProperty("error_description") String errorDescription) {
        this.error = Objects.requireNonNull(error);
        this.errorDescription = Objects.requireNonNull(errorDescription);
    }

    public String getError() {
        return error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}