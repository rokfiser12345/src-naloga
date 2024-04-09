package org.src.model;

import jakarta.persistence.*;

@Entity
public class Movie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "imdbID")
    private short id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private short year;

    @Column(name = "description")
    private String description;

    @Column(name = "list_of_actors")
    private short[] actors;

    @Column(name = "pictures")
    private String[] pictures;
}
