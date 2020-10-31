/*Create database*/
CREATE DATABASE IF NOT EXISTS Blog;

CREATE TABLE Users (
    user_id int NOT NULL AUTO_INCREMENT,
    user_name varchar(32) NOT NULL,
    password varchar(255),
    user_email varchar(32),
    first_name varchar(32),
    last_name varchar(32),
    PRIMARY KEY (user_id)
);

/*Insert dummy data to Users table*/
INSERT INTO Users VALUES (1, 'testuser', 'helloWorld', 'Sebastian', 'Jean', 'asdf@gmail.com');

INSERT INTO
Users (user_name, password, first_name, last_name, user_email)
VALUES ('testuser1', 'IloveJava', 'Sebastian1', 'Jean1', 'asdf1@gmail.com');