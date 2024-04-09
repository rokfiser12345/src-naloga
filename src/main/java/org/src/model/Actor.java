package org.src.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Actor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
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
