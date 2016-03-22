# use "source (path to file)/command.sql" to execute this file

DROP TABLE Users;
DROP TABLE Statistics;
DROP TABLE Favorites;

CREATE TABLE Users (
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(32),
	password VARCHAR(32)
);

CREATE TABLE Statistics (
	id INT AUTO_INCREMENT PRIMARY KEY,
	userId INT,
	sumName VARCHAR(32),
	avKills FLOAT,
	avDeaths FLOAT,
	avAssists FLOAT,
	avCS FLOAT,
	avGold FLOAT,
	FOREIGN KEY (userId) REFERENCES Users(id)
);

CREATE TABLE Favorites (
	id INT AUTO_INCREMENT PRIMARY KEY,
	userId INT,
	favId INT,
	FOREIGN KEY (userId) REFERENCES Users(id),
	FOREIGN KEY (favId) REFERENCES Users(id)
);

SHOW tables;
EXPLAIN Users;
EXPLAIN Statistics;
EXPLAIN Favorites;