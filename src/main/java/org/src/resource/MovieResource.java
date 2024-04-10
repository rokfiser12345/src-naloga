package org.src.resource;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.src.model.Movie;
import org.src.repository.MovieRepository;

import java.util.Optional;

@Path("/movie")
public class MovieResource {

    @Inject
    MovieRepository movieRepository;

    @GET
    @Path("/{movieId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieById(@PathParam("movieId") Integer movieId){
        Optional<Movie> movie = movieRepository.getMovie(movieId);
        if (movie.isPresent()) {
            JsonObject jsonMovie = Movie.toJson(movie.get());
            return Response.ok(jsonMovie.toString()).build();
        }
        else
            return Response.status(Response.Status.NOT_FOUND).entity("No movie was found with provided ID").build();
    }

}
