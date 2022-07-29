package org.gs.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.gs.resource.UrlShortenerDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "UrlShortenerApi")
public interface UrlShortenerApi {

    @GET
    @Path("{alias}")
    @Operation(
            operationId = "getUrlShortener",
            description = "Get url shortener from alias"
    )
    @APIResponse(
            responseCode = "301",
            description = "Url shortener successfully found"
    )
    @APIResponse(
            responseCode = "404",
            description = "Alias not found"
    )
    @APIResponse(
            responseCode = "400",
            description = "Alias not valid"
    )
    Response getUrlShortener(@PathParam("alias") String alias);

    @POST
    @Operation(
            operationId = "createUrlShortener",
            description = "Create a new url shortener"
    )
    @APIResponse(
            responseCode = "200",
            description = "Url shortener successfully created"
    )
    @APIResponse(
            responseCode = "409",
            description = "Alias already exists"
    )
    @APIResponse(
            responseCode = "400",
            description = "Inpu t not valid"
    )
    Response createUrlShortener(UrlShortenerDTO urlShortenerDTO);
}
