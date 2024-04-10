package org.src.model;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imdbID")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn (name = "movie_id"),
            inverseJoinColumns = @JoinColumn (name = "actor_id")
    )
    private List<Actor> actors;

    @Column(name = "pictures")
    private String[] pictures;

    public Movie(Integer id, String title, int year, String description, List<Actor> actors, String[] pictures) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.description = description;
        this.actors = actors;
        this.pictures = pictures;
    }

    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String[] getPictures() {
        return pictures;
    }

    public void setPictures(String[] pictures) {
        this.pictures = pictures;
    }

    public static JsonObject toJson(Movie movie)
    {
        JsonArrayBuilder picturesBuilder = Json.createArrayBuilder();
        for (String picture : movie.getPictures())
        {
            picturesBuilder.add(picture);
        }
        JsonObjectBuilder builder = Json.createObjectBuilder()
                .add("id", movie.getId())
                .add("title", movie.getTitle())
                .add("year", movie.getYear())
                .add("description", movie.getDescription())
                .add("pictures", picturesBuilder);

        return builder.build();
    }
}
