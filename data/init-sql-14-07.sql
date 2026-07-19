-- Active: 1765287408229@@127.0.0.1@3306@bibliotheque
CREATE OR REPLACE DATABASE test_app;
USE test_app;

CREATE TABLE user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(20),
    email VARCHAR(20)
);

INSERT INTO user(username, email) VALUES
('Rohan', 'roro@gmail.com'),
('Noah', 'noah@gmail.com'),
('Tchang', 'tchang@gmail.com')
