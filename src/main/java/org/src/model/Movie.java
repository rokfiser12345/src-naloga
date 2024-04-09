package org.src.model;

import jakarta.persistence.*;

@Entity
@Table (name = "movie", schema = "postgres")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imdbID")
    private short id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private short year;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "movie")
    @Column(name = "list_of_actors")
    private short[] actors;

    @Column(name = "pictures")
    private String[] pictures;
}
