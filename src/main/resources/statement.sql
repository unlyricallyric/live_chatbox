/*Create database*/
CREATE DATABASE IF NOT EXISTS Blog;

CREATE TABLE Users (
    user_id int NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(32) NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_email VARCHAR(32),
    first_name VARCHAR(32),
    last_name VARCHAR(32),
    PRIMARY KEY (user_id)
);

CREATE TABLE Posts (
    id int NOT NULL AUTO_INCREMENT,
    posted_by VARCHAR(32) NOT NULL,
    post_title VARCHAR(128) NOT NULL,
    post_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    message TEXT,
    PRIMARY KEY (id)
);

/*Insert dummy data to Users table*/
INSERT INTO Users VALUES (1, 'testuser', 'helloWorld', 'Sebastian', 'Jean', 'asdf@gmail.com');

INSERT INTO
Users (user_name, password, first_name, last_name, user_email)
VALUES ('testuser1', 'IloveJava', 'Sebastian1', 'Jean1', 'asdf1@gmail.com');

INSERT INTO
Posts (posted_by, post_title, message)
VALUES ('George', 'JavaScript Tutorial', 'Hello Worled JavaScript');