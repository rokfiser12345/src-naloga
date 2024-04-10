package org.src.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_actor")
public class MovieActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movieId")
    private Long movieId;

    @Column(name = "actorId")
    private Long actorId;

    public MovieActor() {
    }

    public MovieActor(Long movieId, Long actorId) {
        this.movieId = movieId;
        this.actorId = actorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActor(Long actorId) {
        this.actorId = actorId;
    }
}
