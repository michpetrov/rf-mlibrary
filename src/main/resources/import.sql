insert into movies (id, name, year, director, genre, description) values (1, 'Matrix', 1999, 'Lana & Andy Wachowski', 'Sci-fi', 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.')
insert into movies (id, name, year, director, genre, description) values (2, 'Alien', 1979, 'Ridley Scott', 'Sci-fi/Horror', 'A mining ship, investigating a suspected SOS, lands on a distant planet. The crew discovers some strange creatures and investigates.')
insert into movies (id, name, year, director, genre, description) values (3, 'Back to the Future', 1985, 'Robert Zemeckis', 'Sci-fi', 'In 1985, Doc Brown invents time travel; in 1955, Marty McFly accidentally prevents his parents from meeting, putting his own existence at stake.'),
insert into movies (id, name, year, director, genre, description) values (4, 'Star Wars', 1977, 'George Lucas', 'Sci-fi', 'Luke Skywalker, a spirited farm boy, joins rebel forces to save Princess Leia from the evil Darth Vader, and the galaxy from the Empire''s planet-destroying Death Star.');


INSERT INTO reports (id, movie_id, review, rating) VALUES (1, 1, 'Fantastic movie', 5)
INSERT INTO reports (id, movie_id, review, rating) VALUES (2, 1, 'Very good', 4)
INSERT INTO reports (id, movie_id, review, rating) VALUES (3, 2, null, 4)
INSERT INTO reports (id, movie_id, review, rating) VALUES (4, 3, 'Amazing', 5)
INSERT INTO reports (id, movie_id, review, rating) VALUES (5, 3, null, 3)
INSERT INTO reports (id, movie_id, review, rating) VALUES (6, 3, null, 5)