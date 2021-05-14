package com.sb.restserver;

public class QuotaLimitExceededException extends RuntimeException {

    public QuotaLimitExceededException(String message) {
        super(message);
    }
}
