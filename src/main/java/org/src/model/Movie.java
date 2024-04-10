package org.src.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movie")
public class Movie extends PanacheEntity {
    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "description")
    private String description;

    @Column(name = "picture")
    private String picture;

    public Movie() {
    }

    public Movie(Long id, String title, int year, String description, List<Actor> actors, String picture) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.description = description;
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public static JsonObject toJson(Movie movie)
    {
        JsonObjectBuilder builder = Json.createObjectBuilder()
                .add("id", movie.getId())
                .add("title", movie.getTitle())
                .add("year", movie.getYear())
                .add("description", movie.getDescription())
                .add("picture", movie.getPicture());

        return builder.build();
    }
    public static Movie jsonToMovie(JsonObject jsonObject)
    {
        Movie movie = new Movie();
        movie.setTitle(jsonObject.getString("title"));
        movie.setDescription(jsonObject.getString("description"));
        movie.setYear(jsonObject.getInt("year"));
        movie.setPicture(jsonObject.getString("picture"));

        return movie;
    }
}
