package org.src.service;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.src.model.MovieActor;
import org.src.repository.MovieActorRepository;

@ApplicationScoped
public class MovieActorService {
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
        else {
            System.out.println("MovieActor relation already exists, skipping insert");
        }
        return movieActor;
    }
}
