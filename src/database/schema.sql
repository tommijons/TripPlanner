-- FLIGHTS TABLE
DROP TABLE IF EXISTS flights;
CREATE TABLE flights (
    id INTEGER PRIMARY KEY,
    departureLocation VARCHAR(3) NOT NULL,
    arrivalLocation VARCHAR(3) NOT NULL,
    departureTime VARCHAR(5),
    arrivalTime VARCHAR(5),
    flightDate DATE,
    price INTEGER,
    airline VARCHAR(265),
    mealService BOOLEAN
);

-- SEATS TABLE
DROP TABLE IF EXISTS seats;
CREATE TABLE seats (
    flight_id INTEGER NOT NULL,
    seatID INTEGER NOT NULL,
    isAvailable BOOLEAN,
    isFirstClass BOOLEAN,
    isEmergency BOOLEAN
);

-- BOOKINGS TABLE
DROP TABLE IF EXISTS bookings;
CREATE TABLE bookings (
    user_email VARCHAR(265),
    flight_id INTEGER,
    seat_id INTEGER
);

-- USERS TABLE
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    name VARCHAR(265),
    email VARCHAR(265) UNIQUE NOT NULL,
    password VARCHAR(265) NOT NULL
);

-- Insert users
INSERT INTO users VALUES ("Admin", "admin@example.com", "123");

-- Insert bookings
INSERT INTO bookings VALUES ("admin@example.com", 1, 3);
INSERT INTO bookings VALUES ("admin@example.com", 1, 4);

-- Insert flights
INSERT INTO flights VALUES (1, 'REY', 'AEY', '11:00', '13:00', date('2021-01-01'), 15000, 'Iceland Air', TRUE);
INSERT INTO flights VALUES (2, 'REY', 'EGS', '11:00', '14:00', date('2021-01-01'), 22500, 'Flugfélag Íslands', TRUE);
INSERT INTO flights VALUES (3, 'REY', 'IFJ', '12:00', '14:00', date('2021-01-01'), 13500, 'Flugfélag Íslands', TRUE);
INSERT INTO flights VALUES (4, 'REY', 'VEY', '10:00', '11:00', date('2021-01-01'), 7500, 'Flugfélag Íslands', FALSE);
INSERT INTO flights VALUES (5, 'REY', 'KEF', '10:00', '10:30', date('2021-01-01'), 7500, 'Flugfélag Íslands', FALSE);
INSERT INTO flights VALUES (6, 'KEF', 'REY', '11:00', '11:30', date('2021-01-01'), 7500, 'Iceland Air', FALSE);
INSERT INTO flights VALUES (7, 'VEY', 'REY', '12:00', '13:00', date('2021-01-01'), 7500, 'Flugfélag Íslands', FALSE);
INSERT INTO flights VALUES (8, 'IFJ', 'REY', '15:00', '17:00', date('2021-01-01'), 13500, 'Flugfélag Íslands', TRUE);
INSERT INTO flights VALUES (9, 'EGS', 'REY', '14:30', '17:30', date('2021-01-01'), 22500, 'Flugfélag Íslands', TRUE);
INSERT INTO flights VALUES (10, 'AEY', 'REY', '14:00', '16:00', date('2021-01-01'), 15000, 'Flugfélag Íslands', TRUE);
INSERT INTO flights VALUES (11, 'AEY', 'EGS', '07:00', '08:30', date('2021-01-01'), 10000, 'Ernir', FALSE);
INSERT INTO flights VALUES (12, 'EGS', 'AEY', '12:30', '14:00', date('2021-01-01'), 12500, 'Ernir', FALSE);
INSERT INTO flights VALUES (13, 'AEY', 'IFJ', '07:30', '09:00', date('2021-01-01'), 10000, 'NorðurFlug', FALSE);
INSERT INTO flights VALUES (14, 'IFJ', 'AEY', '13:00', '14:30', date('2021-01-01'), 12500, 'NorðurFlug', FALSE);
INSERT INTO flights VALUES (15, 'REY', 'AEY', '11:00', '13:00', date('2021-02-01'), 15000, 'Iceland Air', TRUE);
INSERT INTO flights VALUES (16, 'REY', 'EGS', '11:00', '14:00', date('2021-02-01'), 22500, 'Flugfélag Íslands', TRUE);
INSERT INTO flights VALUES (17, 'REY', 'IFJ', '12:00', '14:00', date('2021-02-01'), 13500, 'Flugfélag Íslands', TRUE);
INSERT INTO flights VALUES (18, 'REY', 'VEY', '10:00', '11:00', date('2021-02-01'), 7500, 'Flugfélag Íslands', FALSE);
INSERT INTO flights VALUES (19, 'REY', 'KEF', '10:00', '10:30', date('2021-02-01'), 7500, 'Flugfélag Íslands', FALSE);
INSERT INTO flights VALUES (20, 'KEF', 'REY', '11:00', '11:30', date('2021-02-01'), 7500, 'Iceland Air', FALSE);
INSERT INTO flights VALUES (21, 'VEY', 'REY', '12:00', '13:00', date('2021-02-01'), 7500, 'Flugfélag Íslands', FALSE);
INSERT INTO flights VALUES (22, 'IFJ', 'REY', '15:00', '17:00', date('2021-02-01'), 13500, 'Flugfélag Íslands', TRUE);
INSERT INTO flights VALUES (23, 'EGS', 'REY', '14:30', '17:30', date('2021-02-01'), 22500, 'Flugfélag Íslands', TRUE);
INSERT INTO flights VALUES (24, 'AEY', 'REY', '14:00', '16:00', date('2021-02-01'), 15000, 'Flugfélag Íslands', TRUE);
INSERT INTO flights VALUES (25, 'AEY', 'EGS', '07:00', '08:30', date('2021-02-01'), 10000, 'Ernir', FALSE);
INSERT INTO flights VALUES (26, 'EGS', 'AEY', '12:30', '14:00', date('2021-02-01'), 12500, 'Ernir', FALSE);
INSERT INTO flights VALUES (27, 'AEY', 'IFJ', '07:30', '09:00', date('2021-02-01'), 10000, 'NorðurFlug', FALSE);
INSERT INTO flights VALUES (28, 'IFJ', 'AEY', '13:00', '14:30', date('2021-02-01'), 12500, 'NorðurFlug', FALSE);

-- Insert seats
-- Flight 1
INSERT INTO seats VALUES (1, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (1, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (1, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (1, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (1, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (1, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (1, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (1, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (1, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (1, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (1, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (1, 12, TRUE, FALSE, TRUE);
--Flight 2
INSERT INTO seats VALUES (2, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (2, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (2, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (2, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (2, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (2, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (2, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (2, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (2, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (2, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (2, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (2, 12, TRUE, FALSE, TRUE);
--Flight 3
INSERT INTO seats VALUES (3, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (3, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (3, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (3, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (3, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (3, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (3, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (3, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (3, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (3, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (3, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (3, 12, TRUE, FALSE, TRUE);
--Flight 4
INSERT INTO seats VALUES (4, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (4, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (4, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (4, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (4, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (4, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (4, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (4, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (4, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (4, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (4, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (4, 12, TRUE, FALSE, TRUE);
--Flight 5
INSERT INTO seats VALUES (5, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (5, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (5, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (5, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (5, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (5, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (5, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (5, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (5, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (5, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (5, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (5, 12, TRUE, FALSE, TRUE);
--Flight 6
INSERT INTO seats VALUES (6, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (6, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (6, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (6, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (6, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (6, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (6, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (6, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (6, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (6, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (6, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (6, 12, TRUE, FALSE, TRUE);
--Flight 7
INSERT INTO seats VALUES (7, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (7, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (7, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (7, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (7, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (7, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (7, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (7, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (7, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (7, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (7, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (7, 12, TRUE, FALSE, TRUE);
--Flight 8
INSERT INTO seats VALUES (8, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (8, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (8, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (8, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (8, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (8, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (8, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (8, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (8, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (8, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (8, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (8, 12, TRUE, FALSE, TRUE);
--Flight 9
INSERT INTO seats VALUES (9, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (9, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (9, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (9, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (9, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (9, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (9, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (9, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (9, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (9, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (9, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (9, 12, TRUE, FALSE, TRUE);
--Flight 10
INSERT INTO seats VALUES (10, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (10, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (10, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (10, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (10, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (10, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (10, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (10, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (10, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (10, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (10, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (10, 12, TRUE, FALSE, TRUE);
--Flight 11
INSERT INTO seats VALUES (11, 1, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (11, 2, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (11, 3, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (11, 4, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (11, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (11, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (11, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (11, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (11, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (11, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (11, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (11, 12, TRUE, FALSE, TRUE);
--Flight 12
INSERT INTO seats VALUES (12, 1, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (12, 2, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (12, 3, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (12, 4, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (12, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (12, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (12, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (12, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (12, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (12, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (12, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (12, 12, TRUE, FALSE, TRUE);
--Flight 13
INSERT INTO seats VALUES (13, 1, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (13, 2, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (13, 3, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (13, 4, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (13, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (13, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (13, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (13, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (13, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (13, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (13, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (13, 12, TRUE, FALSE, TRUE);
--Flight 14
INSERT INTO seats VALUES (14, 1, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (14, 2, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (14, 3, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (14, 4, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (14, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (14, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (14, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (14, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (14, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (14, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (14, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (14, 12, TRUE, FALSE, TRUE);
-- Flight 15
INSERT INTO seats VALUES (15, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (15, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (15, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (15, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (15, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (15, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (15, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (15, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (15, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (15, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (15, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (15, 12, TRUE, FALSE, TRUE);
--Flight 16
INSERT INTO seats VALUES (16, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (16, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (16, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (16, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (16, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (16, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (16, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (16, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (16, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (16, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (16, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (16, 12, TRUE, FALSE, TRUE);
--Flight 17
INSERT INTO seats VALUES (17, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (17, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (17, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (17, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (17, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (17, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (17, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (17, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (17, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (17, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (17, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (17, 12, TRUE, FALSE, TRUE);
--Flight 18
INSERT INTO seats VALUES (18, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (18, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (18, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (18, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (18, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (18, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (18, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (18, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (18, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (18, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (18, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (18, 12, TRUE, FALSE, TRUE);
--Flight 19
INSERT INTO seats VALUES (19, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (19, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (19, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (19, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (19, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (19, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (19, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (19, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (19, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (19, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (19, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (19, 12, TRUE, FALSE, TRUE);
--Flight 20
INSERT INTO seats VALUES (20, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (20, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (20, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (20, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (20, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (20, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (20, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (20, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (20, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (20, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (20, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (20, 12, TRUE, FALSE, TRUE);
--Flight 21
INSERT INTO seats VALUES (21, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (21, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (21, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (21, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (21, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (21, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (21, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (21, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (21, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (21, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (21, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (21, 12, TRUE, FALSE, TRUE);
--Flight 22
INSERT INTO seats VALUES (22, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (22, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (22, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (22, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (22, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (22, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (22, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (22, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (22, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (22, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (22, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (22, 12, TRUE, FALSE, TRUE);
--Flight 23
INSERT INTO seats VALUES (23, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (23, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (23, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (23, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (23, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (23, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (23, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (23, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (23, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (23, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (23, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (23, 12, TRUE, FALSE, TRUE);
--Flight 24
INSERT INTO seats VALUES (24, 1, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (24, 2, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (24, 3, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (24, 4, TRUE, TRUE, FALSE);
INSERT INTO seats VALUES (24, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (24, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (24, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (24, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (24, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (24, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (24, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (24, 12, TRUE, FALSE, TRUE);
--Flight 25
INSERT INTO seats VALUES (25, 1, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (25, 2, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (25, 3, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (25, 4, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (25, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (25, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (25, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (25, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (25, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (25, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (25, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (25, 12, TRUE, FALSE, TRUE);
--Flight 26
INSERT INTO seats VALUES (26, 1, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (26, 2, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (26, 3, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (26, 4, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (26, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (26, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (26, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (26, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (26, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (26, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (26, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (26, 12, TRUE, FALSE, TRUE);
--Flight 27
INSERT INTO seats VALUES (27, 1, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (27, 2, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (27, 3, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (27, 4, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (27, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (27, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (27, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (27, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (27, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (27, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (27, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (27, 12, TRUE, FALSE, TRUE);
--Flight 28
INSERT INTO seats VALUES (28, 1, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (28, 2, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (28, 3, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (28, 4, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (28, 5, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (28, 6, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (28, 7, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (28, 8, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (28, 9, TRUE, FALSE, TRUE);
INSERT INTO seats VALUES (28, 10, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (28, 11, TRUE, FALSE, FALSE);
INSERT INTO seats VALUES (28, 12, TRUE, FALSE, TRUE);