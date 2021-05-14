package com.sb.restserver;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Objects;

@RegisterForReflection
public record Error(
        @JsonProperty("error") String error,
        @JsonProperty("error_description") String errorDescription) {

    @JsonCreator
    public Error {
        error = Objects.requireNonNull(error);
        errorDescription = Objects.requireNonNull(errorDescription);
    }

}