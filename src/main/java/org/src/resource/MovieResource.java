package org.src.resource;

import jakarta.inject.Inject;
import jakarta.json.JsonArray;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.src.model.Movie;
import org.src.model.MovieActor;
import org.src.repository.MovieActorRepository;
import org.src.service.MovieActorService;
import org.src.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@Path("/movie")
public class MovieResource
{

    @Inject
    MovieService movieService;

    @Inject
    MovieActorService movieActorService;
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMovies()
    {
        List<Movie> movies = movieService.listAllMovies();
        if (!movies.isEmpty())
        {
            List<JsonObject> jsonMovies = new ArrayList<>();
            for (Movie movie : movies)
            {
                jsonMovies.add(Movie.toJson(movie));
            }
            return Response.ok(jsonMovies.toString()).build();
        }
        else
            return Response.status(Response.Status.NOT_FOUND).entity("There is no movies to be found").build();
    }
    @GET
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieByTitle(@PathParam("title") String title)
    {
        Movie movie = movieService.getMovieByTitle(title);
        if (movie != null)
        {
            JsonObject jsonMovie = Movie.toJson(movie);
            return Response.ok(jsonMovie.toString()).build();
        }
        else
            return Response.status(Response.Status.NOT_FOUND).entity("No movie was found with provided title").build();
    }

    //pages start at 0
    @GET
    @Path("/page/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieByPage(@PathParam("page") int page)
    {
        List<Movie> movies = movieService.getByPage(page);
        if (!movies.isEmpty())
        {
            List<JsonObject> jsonMovies = new ArrayList<>();
            for (Movie movie : movies)
            {
                jsonMovies.add(Movie.toJson(movie));
            }
            return Response.ok(jsonMovies.toString()).build();
        }
        else
            return Response.status(Response.Status.NOT_FOUND).entity("Page " + page + " contains no movies.").build();
    }
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewMovie(JsonObject jsonBody)
    {
        Movie movie = Movie.jsonToMovie(jsonBody);
        JsonArray actors = jsonBody.getJsonArray("actors");
        Movie createdMovie = movieService.createMovie(movie);

        for(JsonValue actorId : actors)
        {
            if(actorId.getValueType() == JsonValue.ValueType.NUMBER)
                movieActorService.createMovieActor(new MovieActor(createdMovie.getId(),((JsonNumber) actorId).longValue()));
        }
        return Response.ok(Movie.toJson(createdMovie)).build();
    }
}
