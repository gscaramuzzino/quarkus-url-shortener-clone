package org.gs.exception;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UrlShortenerExceptionMapperTest {

    @Inject
    UrlShortenerExceptionMapper exceptionMapper;

    @Test
    void toResponseAliasAlreadyExists() {
        UrlShortenerException exception = new UrlShortenerException("The alias already exists.");
        assertNotNull(exception);
        assertNotNull(exception.getMessage());
        Response response = exceptionMapper.toResponse(exception);
        assertNotNull(response);
        assertEquals(Response.Status.CONFLICT, response.getStatusInfo());
    }

    @Test
    void toResponseDefault() {
        UrlShortenerException exception = new UrlShortenerException(" ");
        assertNotNull(exception);
        assertNotNull(exception.getMessage());
        Response response = exceptionMapper.toResponse(exception);
        assertNotNull(response);
        assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
    }
}