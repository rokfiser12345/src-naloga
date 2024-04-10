DROP TABLE IF EXISTS movie_actor;
DROP TABLE IF EXISTS actor;
DROP TABLE IF EXISTS movie;
 create table actor (
        id bigint not null,
        born_date date,
        first_name varchar(255),
        last_name varchar(255),
        primary key (id)
    );

    create table movie (
        id bigint not null,
        description varchar(255),
        title varchar(255),
        year integer,
        primary key (id)
    );

    create table movie_actor (
        movieId bigint not null,
        actorId bigint not null
    );

    create table Movie_pictures (
        Movie_id bigint not null,
        picture varchar(255)
    );

    create sequence actor_SEQ start with 1 increment by 50;

    create sequence movie_SEQ start with 1 increment by 50;

    alter table if exists movie_actor
       add constraint FK69qnqd5hnjn2aykvxcj72r9i5
       foreign key (actor_id)
       references actor;

    alter table if exists movie_actor
       add constraint FKhedvt8u16luotgyoel4fqy7t1
       foreign key (movie_id)
       references movie;

    alter table if exists Movie_pictures
       add constraint FKk3ryarmro95o27iwq0vsnekbg
       foreign key (Movie_id)
       references movie;
