# use "source (path to file)/command.sql" to execute this file

DROP TABLE users;
DROP TABLE statistics;
DROP TABLE favorites;

CREATE TABLE users (
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(32),
	password VARCHAR(255)
);

CREATE TABLE statistics (
	id INT AUTO_INCREMENT PRIMARY KEY,
	userId INT NOT NULL,
	sumName VARCHAR(32) NOT NULL,
	kills INT NOT NULL,
	deaths INT NOT NULL,
	assists INT NOT NULL,
	creepScore INT NOT NULL,
	gold INT NOT NULL,
        createdTime DATETIME NOT NULL,
	FOREIGN KEY (userId) REFERENCES users(id)
);

CREATE TABLE favorites (
	id INT AUTO_INCREMENT PRIMARY KEY,
	userId INT NOT NULL,
	favId INT NOT NULL,
	FOREIGN KEY (userId) REFERENCES users(id),
	FOREIGN KEY (favId) REFERENCES users(id)
);

SHOW tables;
EXPLAIN Users;
EXPLAIN Statistics;
EXPLAIN Favorites;