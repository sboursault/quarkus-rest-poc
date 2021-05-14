package com.sb.restserver;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.TOO_MANY_REQUESTS;

@Provider
public class QuotaLimitExceededExceptionMapper implements ExceptionMapper<QuotaLimitExceededException> {

    @Override
    public Response toResponse(QuotaLimitExceededException exception) {
        return Response
                .status(TOO_MANY_REQUESTS)
                .entity(new Error("QUOTA_LIMIT_EXCEEDED", "You used all your credits"))
                .build();
    }

}

