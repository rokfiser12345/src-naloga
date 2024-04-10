package org.src.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.src.model.MovieActor;
import org.src.repository.MovieActorRepository;

import java.util.List;

@ApplicationScoped
public class MovieActorService
{
    @Inject
    MovieActorRepository movieActorRepository;

    @Transactional
    public MovieActor createUpdateMovieActor(MovieActor movieActor)
    {
        MovieActor existingActor = movieActorRepository.findMovieActorByMovieIdAndActorId(movieActor.getMovieId(), movieActor.getActorId());
        if(existingActor == null)
        {
            System.out.println("adding new one");
            movieActorRepository.persist(movieActor);
        }
        else
        {
            System.out.println("MovieActor relation already exists, skipping insert");
        }
        return movieActor;
    }
    @Transactional
    public boolean deleteMovieActor(Long id)
    {
        return movieActorRepository.deleteById(id);
    }
    public List<MovieActor> findAll()
    {
        return movieActorRepository.listAll();
    }
}
