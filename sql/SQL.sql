CREATE DATABASE lsdforreal;
USE lsdforreal;
CREATE TABLE Highscore(
  highScoreId int not null AUTO_INCREMENT,
  highScoreScore int not null,
  highScoreName VARCHAR(50) not null,
  highScoreDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(highScoreId)
);
