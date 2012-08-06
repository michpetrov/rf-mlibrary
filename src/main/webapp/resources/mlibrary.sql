CREATE DATABASE mlibrary;

USE mlibrary;

CREATE TABLE movies (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(40) NOT NULL,
year INT NOT NULL,
director VARCHAR(40) NOT NULL,
genre VARCHAR(15) NOT NULL,
description VARCHAR(200));

create table reports (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
movie_id INT NOT NULL,
review VARCHAR(200),
rating SMALLINT NOT NULL);

INSERT INTO movies (id, name, year, director, genre, description) VALUES
(1, 'Matrix', 1999, 'Lana & Andy Wachowski', 'Sci-fi', "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers."),
(2, "Alien", 1979, "Ridley Scott", "Sci-fi/Horror", "A mining ship, investigating a suspected SOS, lands on a distant planet. The crew discovers some strange creatures and investigates."),
(3, "Back to the Future", 1985, "Robert Zemeckis", "Sci-fi", "In 1985, Doc Brown invents time travel; in 1955, Marty McFly accidentally prevents his parents from meeting, putting his own existence at stake."),
(4, "Star Wars", 1977, "George Lucas", "Sci-fi", "Luke Skywalker, a spirited farm boy, joins rebel forces to save Princess Leia from the evil Darth Vader, and the galaxy from the Empire's planet-destroying Death Star.");

INSERT INTO reports (id, movie_id, review, rating) VALUES
(1, 1, 'Fantastic movie', 5),
(2, 1, 'Very good', 4),
(3, 2, null, 4),
(4, 3, 'Amazing', 5),
(5, 3, null, 3),
(6, 3, null, 5);
