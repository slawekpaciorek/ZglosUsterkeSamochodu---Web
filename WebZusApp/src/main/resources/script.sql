CREATE SCHEMA zus;

CREATE TABLE users (
  id int PRIMARY KEY AUTO_INCREMENT,
  login VARCHAR(100) UNIQUE NOT NULL ,
  password VARCHAR(100) NOT NULL ,
  imie VARCHAR(100),
  nazwisko VARCHAR(100),
  email VARCHAR(100) UNIQUE NOT NULL,
  idUserType INT NOT NULL ,
  idStatus INT NOT NULL,
  insertDate DATETIME,
  insertUser VARCHAR(100),
  updateDate DATETIME,
  updateUser VARCHAR(100)
);

CREATE TABLE _usersTypes(
  id int PRIMARY KEY NOT NULL ,
  description VARCHAR(100)
);
INSERT into _usersTypes VALUES
  (1, "customer"),
  (2, "service men"),
  (3, "admin");

CREATE TABLE _statuses(
  id int PRIMARY KEY NOT NULL ,
  description VARCHAR(100)
);
INSERT into _statuses VALUES
  (1, "active"),
  (2, "inactive"),
  (3, "in progress"),
  (4, "done"),
  (5, "cancel");

CREATE TABLE orders
(
  id INT PRIMARY KEY AUTO_INCREMENT,
  idUser INT NOT NULL ,
  parts VARCHAR(8000),
  address VARCHAR(8000),
  idStatus INT NOT NULL,
  insertDate DATETIME,
  insertUser VARCHAR(100),
  updateDate DATETIME,
  updateUser VARCHAR(100)
);
