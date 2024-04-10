package org.src.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.src.model.Actor;
import org.src.model.MovieActor;
import org.src.repository.MovieActorRepository;

@ApplicationScoped
public class MovieActorService {
    @Inject
    MovieActorRepository movieActorRepository;

    @Transactional
    public MovieActor createMovieActor(MovieActor movieActor)
    {
        movieActorRepository.persist(movieActor);
        return movieActor;
    }
}
