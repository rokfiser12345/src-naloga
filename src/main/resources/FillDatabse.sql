-- Inserting actors
INSERT INTO actor (born_date, first_name, last_name) VALUES
('1975-02-15', 'John', 'Doe'),
('1988-11-23', 'Jane', 'Smith'),
('1990-01-05', 'Alice', 'Johnson'),
('1972-07-30', 'Bob', 'Brown'),
('1985-05-20', 'Nancy', 'Davis'),
('1993-03-10', 'Eve', 'Wilson'),
('1968-08-19', 'Charles', 'Moore'),
('1979-12-22', 'Maria', 'Taylor'),
('1980-10-14', 'David', 'Anderson'),
('1991-06-01', 'Carol', 'Jackson');

-- Inserting movies
INSERT INTO movie (description, pictures, title, year) VALUES
('A thrilling sci-fi adventure', '{sci-fi_adventure.jpg}', 'Sci-Fi Adventure', 2021),
('A romantic drama set in Paris', '{paris_love_story.jpg}', 'Paris Love Story', 2018),
('A historical documentary', '{historical_documentary.jpg}', 'History Unveiled', 2020),
('A gripping crime thriller', '{crime_thriller.jpg}', 'Crime Night', 2019),
('A family comedy', '{family_comedy.jpg}', 'Family Laughs', 2022),
('A horror film set in a haunted house', '{haunted_house.jpg}', 'Haunted House', 2020),
('A western drama about cowboys', '{cowboy_drama.jpg}', 'Cowboy Drama', 2017),
('A mystery film with unexpected twists', '{mystery_twists.jpg}', 'Mystery Twists', 2021),
('An action-packed superhero movie', '{superhero_action.jpg}', 'Superhero Action', 2019),
('A biographical film about a famous scientist', '{famous_scientist.jpg}', 'The Great Mind', 2018);

-- Creating relationships in movie_actor
INSERT INTO movie_actor (movie_id, actor_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(4, 7),
(4, 8),
(5, 9),
(5, 10),
(6, 1),
(7, 2),
(8, 3),
(9, 4),
(10, 5);
