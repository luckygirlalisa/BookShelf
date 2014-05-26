DROP database book_shelf;
CREATE DATABASE book_shelf;
GRANT ALL PRIVILEGES ON book_shelf.* TO 'root'@'%' IDENTIFIED BY 'D7n()st1234' WITH GRANT OPTION;
USE book_shelf;

CREATE TABLE book_list
(
  ISBN int AUTO_INCREMENT,
  name varchar(100),
  primary key(ISBN)
);