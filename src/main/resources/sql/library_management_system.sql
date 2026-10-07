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
    phone_number INT NOT NULL,
    address VARCHAR(255) NOT NULL,

);

CREATE TABLE IF NOT EXISTS books(

);

INSERT INTO users (username, password)
VALUES ('admin', 'admin123')
ON DUPLICATE KEY UPDATE username = username;

INSERT INTO students (student_name, address, email, birthday, batch, nic)
VALUES (
    'Kavindu Sandaruwan',
    'No. 45, Temple Road, Maharagama, Sri Lanka',
    'kavindu.sandaruwan@gmail.com',
    '2002-08-14',
    'MIT 2025',
    '200223456789'
)
ON DUPLICATE KEY UPDATE student_name = student_name;
