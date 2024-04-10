package org.src.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Entity
@Table(name = "actor")
public class Actor extends PanacheEntity
{
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "born_date")
    private LocalDate bornDate;

    public Actor()
    {
    }

    public Actor(Long id, String firstName, String lastName, LocalDate bornDate)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornDate = bornDate;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public LocalDate getBornDate()
    {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate)
    {
        this.bornDate = bornDate;
    }

    public static JsonObject toJson(Actor actor)
    {
        JsonObjectBuilder builder = Json.createObjectBuilder()
                .add("id", actor.getId())
                .add("first_name", actor.getFirstName())
                .add("last_name", actor.getLastName())
                .add("born_date", actor.getBornDate().toString());

        return builder.build();
    }

    public static Actor jsonToActor(JsonObject jsonObject)
    {
        Actor actor = new Actor();
        LocalDate bornDate = LocalDate.parse(jsonObject.getString("born_date"), DateTimeFormatter.ISO_LOCAL_DATE);
        actor.setFirstName(jsonObject.getString("first_name"));
        actor.setLastName(jsonObject.getString("last_name"));
        actor.setBornDate(bornDate);

        return actor;
    }
}
