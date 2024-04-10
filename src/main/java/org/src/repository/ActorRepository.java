package org.src.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.src.model.Actor;


@ApplicationScoped
public class ActorRepository implements PanacheRepository<Actor>
{
}
