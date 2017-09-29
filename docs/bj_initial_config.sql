CREATE DATABASE jokes_db;

USE jokes_db;

CREATE TABLE simple_messages (
  id int(11) AUTO_INCREMENT NOT NULL,
  message varchar(20) DEFAULT NULL,
  timestamp varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;