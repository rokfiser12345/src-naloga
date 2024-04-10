-- Inserting actors
INSERT INTO actor (id, born_date, first_name, last_name) VALUES
(1, '1975-02-15', 'John', 'Doe'),
(2, '1988-11-23', 'Jane', 'Smith'),
(3, '1990-01-05', 'Alice', 'Johnson'),
(4, '1972-07-30', 'Bob', 'Brown'),
(5, '1985-05-20', 'Nancy', 'Davis'),
(6, '1993-03-10', 'Eve', 'Wilson'),
(7, '1968-08-19', 'Charles', 'Moore'),
(8, '1979-12-22', 'Maria', 'Taylor'),
(9, '1980-10-14', 'David', 'Anderson'),
(10, '1991-06-01', 'Carol', 'Jackson');

-- Inserting movies
INSERT INTO movie (id, description, title, year, picture) VALUES
(1, 'A thrilling sci-fi adventure', 'Sci-Fi Adventure', 2021, 'sci-fi_adventure.jpg'),
(2, 'A romantic drama set in Paris', 'Paris Love Story', 2018, 'paris_love_story.jpg'),
(3, 'A historical documentary', 'History Unveiled', 2020, 'historical_documentary.jpg'),
(4, 'A gripping crime thriller', 'Crime Night', 2019, 'crime_thriller.jpg'),
(5, 'A family comedy', 'Family Laughs', 2022, 'family_comedy.jpg'),
(6, 'A horror film set in a haunted house', 'Haunted House', 2020, 'haunted_house.jpg'),
(7, 'A western drama about cowboys', 'Cowboy Drama', 2017, 'cowboy_drama.jpg'),
(8, 'A mystery film with unexpected twists', 'Mystery Twists', 2021, 'mystery_twists.jpg'),
(9, 'An action-packed superhero movie', 'Superhero Action', 2019, 'superhero_action.jpg'),
(10, 'A biographical film about a famous scientist', 'The Great Mind', 2018, 'famous_scientist.jpg');

-- Creating relationships in movie_actor
INSERT INTO movie_actor (id, movie_id, actor_id) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 2, 4),
(5, 3, 5),
(6, 3, 6),
(7, 4, 7),
(8, 4, 8),
(9, 5, 9),
(10, 5, 10),
(11, 6, 1),
(12, 7, 2),
(13, 8, 3),
(14, 9, 4),
(15, 10, 5),
(16, 301, 1),
(17, 301, 3),
(18, 301, 4);
