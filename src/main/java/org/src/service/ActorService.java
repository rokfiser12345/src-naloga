package org.src.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.src.model.Actor;
import org.src.repository.ActorRepository;

import java.util.List;


@ApplicationScoped
public class ActorService {

    @Inject
    ActorRepository actorRepository;

    public Actor findActorById(Long id)
    {
        return actorRepository.findById(id);
    }
    public List<Actor> listAllActors()
    {
        return actorRepository.listAll();
    }
    @Transactional
    public Actor createActor(Actor actor)
    {
        actorRepository.persist(actor);
        return actor;
    }
}
