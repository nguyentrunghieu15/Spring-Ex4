DROP DATABASE IF EXISTS test;
CREATE DATABASE IF NOT EXISTS test;
USE test;
CREATE TABLE IF NOT EXISTS user
(
   id INT auto_increment PRIMARY KEY,
   name VARCHAR (255),
   username VARCHAR (255),
   email VARCHAR (255),
   street VARCHAR (255),
   suite VARCHAR (255),
   city VARCHAR (255),
   zipcode VARCHAR (20),
   lat float,
   lng float,
   phone VARCHAR (30),
   website VARCHAR (255),
   company_name VARCHAR (255),
   catch_phrase VARCHAR (255),
   bs VARCHAR (255)
);
CREATE TABLE IF NOT EXISTS album
(
   user_id INT,
   id INT AUTO_INCREMENT PRIMARY KEY,
   title VARCHAR (255),
   FOREIGN KEY (user_id) REFERENCES user (id)
);
CREATE TABLE IF NOT EXISTS post
(
   user_id INT,
   id INT AUTO_INCREMENT PRIMARY KEY,
   title VARCHAR (255),
   body text,
   FOREIGN KEY (user_id) REFERENCES user (id)
);
CREATE TABLE IF NOT EXISTS photo
(
   album_id INT,
   id INT AUTO_INCREMENT PRIMARY KEY,
   title VARCHAR (255),
   url VARCHAR (255),
   thumbnail_url VARCHAR (255),
   FOREIGN KEY (album_id) REFERENCES album (id)
);
CREATE TABLE IF NOT EXISTS comment
(
   post_id INT,
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR (255),
   email VARCHAR (255),
   body text,
   FOREIGN KEY (post_id) REFERENCES post (id)
);
CREATE TABLE IF NOT EXISTS todo
(
   user_id INT,
   id INT AUTO_INCREMENT PRIMARY KEY,
   title VARCHAR (255),
   completed BOOLEAN,
   FOREIGN KEY (user_id) REFERENCES user (id)
);