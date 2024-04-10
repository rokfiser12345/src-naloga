package org.src.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.src.model.MovieActor;

@ApplicationScoped
public class MovieActorRepository implements PanacheRepository<MovieActor>
{
    public MovieActor findMovieActorByMovieIdAndActorId(Long movieId, Long actorId)
    {
        return find("movieId = ?1 and actorId = ?2", movieId, actorId).firstResult();
    }
}
