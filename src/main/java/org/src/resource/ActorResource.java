package org.src.resource;


import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.src.model.Actor;
import org.src.repository.ActorRepository;

import java.util.Optional;

@Path("/actor")
public class ActorResource {
    
    @Inject
    ActorRepository actorRepository;

    @GET
    @Path("/{actorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorById(@PathParam("actorId") Integer actorId){
        Optional<Actor> actor = actorRepository.getActor(actorId);
        if (actor.isPresent()) {
            JsonObject jsonActor = Actor.toJson(actor.get());
            return Response.ok(jsonActor.toString()).build();
        }
        else
            return Response.status(Response.Status.NOT_FOUND).entity("No actor was found with provided ID").build();
    }
}
