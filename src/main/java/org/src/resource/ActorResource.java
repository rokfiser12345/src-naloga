package org.src.resource;


import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.src.model.Actor;
import org.src.model.Movie;
import org.src.service.ActorService;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/actor")
public class ActorResource {
    
    @Inject
    ActorService actorService;

    @GET
    @Path("/{actorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorById(@PathParam("actorId") Long actorId)
    {
        Actor actor = actorService.findActorById(actorId);
        if (actor != null)
        {
            JsonObject jsonActor = Actor.toJson(actor);
            return Response.ok(jsonActor.toString()).build();
        }
        else
            return Response.status(Response.Status.NOT_FOUND).entity("No actor was found with provided ID").build();
    }
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActors()
    {
        List<Actor> actors = actorService.listAllActors();
        if (!actors.isEmpty())
        {
            List<JsonObject> jsonActors = new ArrayList<>();
            for (Actor actor : actors)
            {
                jsonActors.add(Actor.toJson(actor));
            }
            return Response.ok(jsonActors.toString()).build();
        }
        else
            return Response.status(Response.Status.NOT_FOUND).entity("There is no actors to be found").build();
    }
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createActor(JsonObject jsonBody)
    {
        Actor actor = Actor.jsonToActor(jsonBody);
        actorService.createActor(actor);
        return Response.ok(Actor.toJson(actor)).build();
    }
}
