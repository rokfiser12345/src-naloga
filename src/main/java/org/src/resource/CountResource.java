package org.src.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/count")
@ApplicationScoped
public class CountResource
{
    @Inject
    RestCallCounter restCallCounter;

    @GET
    @Path("/actor")
    public Response getActorResourceCalls()
    {
        int count = restCallCounter.getActorResourceCallCount();
        return Response.ok(count).build();
    }

    @GET
    @Path("/movie")
    public Response getMovieResourceCalls()
    {
        int count = restCallCounter.getMovieResourceCallCount();
        return Response.ok(count).build();
    }
}
