package org.src.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.src.model.Movie;

import java.util.List;;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie>
{
    private static final int PAGE_SIZE = 2;

    @Transactional
    public List<Movie> getMoviesByPage(int page)
    {
        PanacheQuery<Movie> allMovies = Movie.findAll();
        return allMovies.page(Page.of(page,PAGE_SIZE)).list();
    }

    public Movie getMovieByTitle(String title)
    {
        return find("title", title).firstResult();
    }
}
