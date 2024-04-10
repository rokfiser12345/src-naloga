package org.src.resource;


import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.src.model.Actor;
import org.src.model.MovieActor;
import org.src.service.ActorService;
import org.src.service.MovieActorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Path("/actor")
public class ActorResource
{
    @Inject
    RestCallCounter restCallCounter;
    @Inject
    ActorService actorService;
    @Inject
    MovieActorService movieActorService;

    @GET
    @Path("/{actorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorById(@PathParam("actorId") Long actorId)
    {
        restCallCounter.incrementActorResourceCall();
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
        restCallCounter.incrementActorResourceCall();
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
        restCallCounter.incrementActorResourceCall();
        Actor actor = Actor.jsonToActor(jsonBody);
        actorService.createActor(actor);
        return Response.ok(Actor.toJson(actor)).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateActor(@PathParam("id") Long id, JsonObject jsonBody)
    {
        restCallCounter.incrementActorResourceCall();
        Actor actor = Actor.jsonToActor(jsonBody);
        Actor updatedActor = actorService.updateActor(id, actor);
        return Response.ok(updatedActor).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteActor(@PathParam("id") Long actorId)
    {
        restCallCounter.incrementActorResourceCall();
        List<MovieActor> movieActors = movieActorService.findAll();
        for (MovieActor movieActor : movieActors)
        {
            if (Objects.equals(movieActor.getActorId(), actorId))
            {
                movieActorService.deleteMovieActor(movieActor.getId());
            }
        }
        boolean isDeleted = actorService.deleteActor(actorId);
        if(isDeleted)
        {
            return Response.noContent().build();
        }
        else
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
