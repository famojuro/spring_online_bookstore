package com.innovativeapps.bookstoremanager.util.exception;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GeneralAppExceptionMapper implements ExceptionMapper<GeneralAppException> {
    @Override
    public Response toResponse(GeneralAppException gae) {
        return Response.status(gae.getStatus())
                .entity(new ErrorMessage(gae))
                .type(MediaType.APPLICATION_JSON).
                        build();
    }
}

