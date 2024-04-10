package org.src.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.src.model.Actor;
import org.src.repository.ActorRepository;

import java.util.List;


@ApplicationScoped
public class ActorService
{

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
    @Transactional
    public Actor updateActor(Long id, Actor actor)
    {
        Actor actorToUpdate = actorRepository.findById(id);
        if(actor == null)
        {
            throw new NotFoundException("Actor with id " + id + " not found");
        }
        actorToUpdate.setFirstName(actor.getFirstName());
        actorToUpdate.setLastName(actor.getLastName());
        actorToUpdate.setBornDate(actor.getBornDate());
        actorRepository.persist(actorToUpdate);
        return actor;
    }

    @Transactional
    public boolean deleteActor(Long actorId)
    {
        return actorRepository.deleteById(actorId);
    }
}
