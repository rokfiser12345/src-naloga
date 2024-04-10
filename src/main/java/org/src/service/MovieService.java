package org.src.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.src.model.Movie;
import org.src.repository.MovieRepository;

import java.util.List;

@ApplicationScoped
public class MovieService {

    @Inject
    MovieRepository movieRepository;

    public Movie findMovieById(Long id)
    {
        return movieRepository.findById(id);
    }
    public List<Movie> listAllMovies()
    {
        return movieRepository.listAll();
    }
    public Movie getMovieByTitle(String title)
    {
        return movieRepository.getMovieByTitle(title);
    }
    public List<Movie> getByPage (int page)
    {
        return movieRepository.getMoviesByPage(page);
    }
    @Transactional
    public Movie createMovie (Movie movie)
    {
        movieRepository.persist(movie);
        return movie;
    }
}
