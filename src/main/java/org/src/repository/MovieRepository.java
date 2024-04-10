package org.src.repository;

import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.src.model.Movie;
import org.src.model.Movie$;

import java.util.Optional;

@ApplicationScoped
public class MovieRepository
{

    @Inject
    JPAStreamer jpaStreamer;

    //optional = to dodge null pointer exception
    public Optional<Movie> getMovie(Integer movieId)
    {
        return jpaStreamer.stream(Movie.class)
                .filter(movie -> movie.getId().equals(movieId))
                .findFirst();
    }
}
