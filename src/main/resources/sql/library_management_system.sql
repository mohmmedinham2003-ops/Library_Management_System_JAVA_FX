CREATE DATABASE IF NOT EXISTS library_management_system_v1;
USE library_management_system_v1;


CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS members (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    book_title VARCHAR(150) NOT NULL,
    author VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    published_year INT NOT NULL,
    quantity INT NOT NULL
);


INSERT INTO users (username, password)
VALUES ('admin', 'admin123')
ON DUPLICATE KEY UPDATE username = username;


INSERT INTO members (full_name,email,phone_number,address)
VALUES ('Kavindu Sandaruwan','kavindu.sandaruwan@gmail.com','0712345678','No. 45, Temple Road, Maharagama, Sri Lanka')
ON DUPLICATE KEY UPDATE email = email;


INSERT INTO books (book_title,author,category,published_year,quantity)
VALUES ('Java Programming','James Gosling','Programming',2024,10);