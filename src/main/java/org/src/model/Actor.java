package org.src.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "actor", schema = "postgres")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private short id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "born_date")
    private LocalDate bornDate;

    @ManyToMany (mappedBy = "actor")
    @Column(name = "list_of_movies")
    private short[] actors;
}
