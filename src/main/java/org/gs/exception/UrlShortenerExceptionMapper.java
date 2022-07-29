package org.gs.exception;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UrlShortenerExceptionMapper implements ExceptionMapper<UrlShortenerException> {

    @ConfigProperty(name = "exception.message.alias_already_exists")
    public String ALIAS_ALREADY_EXISTS;

    @Override
    public Response toResponse(UrlShortenerException exception) {
        Response.Status resultStatus = getStatus(exception.getMessage());
        return Response.status(resultStatus).entity(exception.getCause()).build();
    }

    private Response.Status getStatus(String errorMessage) {
        if(errorMessage.equals(ALIAS_ALREADY_EXISTS)) {
            return Response.Status.CONFLICT;
        }
        return Response.Status.BAD_REQUEST;
    }
}
