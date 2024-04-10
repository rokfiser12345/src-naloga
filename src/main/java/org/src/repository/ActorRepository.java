package org.src.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.src.model.Actor;

import java.util.Optional;

@ApplicationScoped
public class ActorRepository {

    @Inject
    JPAStreamer jpaStreamer;

    //optional = to dodge null pointer exception
    public Optional<Actor> getActor(Integer actorId)
    {
        return jpaStreamer.stream(Actor.class)
                .filter(actor -> actor.getId().equals(actorId))
                .findFirst();
    }
}
