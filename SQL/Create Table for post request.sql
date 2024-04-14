-- SQL Sccript to create tables for for post request
DROP TABLE IF EXISTS customer5;
DROP TABLE IF EXISTS customer6;

CREATE TABLE Customer5 (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    campus VARCHAR(100),
    phone_number VARCHAR(20),
    date_time DATETIME,
    duration INT,
    vehicle_plate VARCHAR(100),
    vehicle_type VARCHAR(100)
);

CREATE TABLE Customer6 (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    campus VARCHAR(100),
    phone_number VARCHAR(20),
    date_time DATETIME,
    room_number VARCHAR(100),
    occupant_name VARCHAR(100),
    purpose VARCHAR(100),
    duration INT
);
