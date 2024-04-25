-- liquibase formatted sql

-- changeset eujen:1
CREATE TABLE company (
    id          SERIAL primary key,
    name        varchar(50)         not null
);

-- changeset eujen:2
CREATE TABLE model (
    id          SERIAL primary key,
    name        varchar(50)         not null,
    company     BIGINT              not null,
    FOREIGN KEY (company) REFERENCES company (id)
);

-- changeset eujen:3
CREATE TABLE airplane (
    id          SERIAL primary key,
    number      varchar(50)         not null,
    model       BIGINT              not null,
    release     DATE                null,
    FOREIGN KEY (model) REFERENCES model (id)
);

-- changeset eujen:4
CREATE TABLE passenger (
    id          SERIAL primary key,
    fullname            varchar(100)        not null,
    passport_details    varchar(100)        not null,
    birthdate           DATE                null
);

-- changeset eujen:5
CREATE TABLE flight (
    id          SERIAL primary key,
    passenger   BIGINT              not null,
    airplane    BIGINT              not null,
    datetime    TIMESTAMP           null,
    FOREIGN KEY (passenger) REFERENCES passenger (id),
    FOREIGN KEY (airplane) REFERENCES airplane (id)
);

-- changeset eujen:6
INSERT INTO company(id, name) values (1, 'Airbus');
INSERT INTO company(id, name) values (2, 'Boeing');
INSERT INTO company(id, name) values (3, 'Antonov');
INSERT INTO model(id, name, company) values (1, 'Airbus A220', 1);
INSERT INTO model(id, name, company) values (2, 'Airbus A300', 1);
INSERT INTO model(id, name, company) values (3, 'Airbus A310', 1);
INSERT INTO model(id, name, company) values (4, 'Airbus A318', 1);
INSERT INTO model(id, name, company) values (5, 'Airbus A320', 1);
INSERT INTO model(id, name, company) values (6, 'Airbus A321', 1);
INSERT INTO model(id, name, company) values (7, 'Airbus A330', 1);
INSERT INTO model(id, name, company) values (8, 'Boeing 707', 2);
INSERT INTO model(id, name, company) values (9, 'Boeing 747', 2);
INSERT INTO model(id, name, company) values (10, 'Ан-124', 3);
INSERT INTO model(id, name, company) values (11, 'Ан-24', 3);
INSERT INTO model(id, name, company) values (12, 'Ан-74', 3);
INSERT INTO model(id, name, company) values (13, 'Ан-225', 3);
INSERT INTO airplane(id, number, model, release) values (1, '1698', 1, '1999-01-01');
INSERT INTO airplane(id, number, model, release) values (2, '1699', 1, '1999-01-02');
INSERT INTO airplane(id, number, model, release) values (3, '1700', 1, '2000-01-01');
INSERT INTO airplane(id, number, model, release) values (4, '865458', 2, '2001-01-01');
INSERT INTO airplane(id, number, model, release) values (5, '79453', 2, '1999-01-01');
INSERT INTO airplane(id, number, model, release) values (6, '78842', 3, '1999-01-01');
INSERT INTO airplane(id, number, model, release) values (7, '30000', 4, '2005-05-01');
INSERT INTO airplane(id, number, model, release) values (8, '33333', 5, '2006-01-01');
INSERT INTO airplane(id, number, model, release) values (9, '5324', 5, '2008-03-05');
INSERT INTO airplane(id, number, model, release) values (10, '5789', 6, '2012-01-01');
INSERT INTO airplane(id, number, model, release) values (11, '99741', 8, '2006-01-01');
INSERT INTO airplane(id, number, model, release) values (12, '784265', 8, '2008-01-10');
INSERT INTO airplane(id, number, model, release) values (13, '658', 9, '2006-01-07');
INSERT INTO airplane(id, number, model, release) values (14, '456852', 9, '2006-01-05');
INSERT INTO airplane(id, number, model, release) values (15, '458472', 9, '2006-01-04');
INSERT INTO airplane(id, number, model, release) values (16, '5632481', 10, '2010-01-07');
INSERT INTO airplane(id, number, model, release) values (17, '88513', 11, '2012-01-07');
INSERT INTO airplane(id, number, model, release) values (18, '46588745', 12, '2009-01-07');
INSERT INTO airplane(id, number, model, release) values (19, '234548', 12, '2004-01-07');
INSERT INTO airplane(id, number, model, release) values (20, '1565483', 13, '2002-01-07');
INSERT INTO passenger(id, fullname, passport_details, birthdate) values (1, 'Иванов Иван Иванович', '4011 111111', '1970-01-01');
INSERT INTO passenger(id, fullname, passport_details, birthdate) values (2, 'Иванов Андрей Иванович', '4011 111112', '1971-01-01');
INSERT INTO passenger(id, fullname, passport_details, birthdate) values (3, 'Иванов Николай Иванович', '4011 111113', '1972-01-01');
INSERT INTO passenger(id, fullname, passport_details, birthdate) values (4, 'Иванов Владимир Иванович', '4011 111114', '1976-01-01');
INSERT INTO passenger(id, fullname, passport_details, birthdate) values (5, 'Иванов Вадим Иванович', '4011 111115', '1968-01-01');
INSERT INTO passenger(id, fullname, passport_details, birthdate) values (6, 'Иванов Константин Иванович', '4011 111116', '1979-01-01');
INSERT INTO passenger(id, fullname, passport_details, birthdate) values (7, 'Иванов Людвиг Иванович', '4011 111117', '1978-01-01');
INSERT INTO flight(id, passenger, airplane, datetime) values (1, 1, 1, '1978-01-01 11:11:00');
INSERT INTO flight(id, passenger, airplane, datetime) values (2, 1, 2, '1978-01-01 12:11:00');
INSERT INTO flight(id, passenger, airplane, datetime) values (3, 2, 1, '1978-01-01 13:11:00');
INSERT INTO flight(id, passenger, airplane, datetime) values (4, 1, 3, '1978-01-01 14:11:00');
INSERT INTO flight(id, passenger, airplane, datetime) values (5, 3, 5, '1978-01-01 15:11:00');
INSERT INTO flight(id, passenger, airplane, datetime) values (6, 4, 8, '1978-01-01 16:11:00');
INSERT INTO flight(id, passenger, airplane, datetime) values (7, 5, 1, '1978-01-01 17:11:00');
INSERT INTO flight(id, passenger, airplane, datetime) values (8, 6, 15, '1978-01-01 18:11:00');
INSERT INTO flight(id, passenger, airplane, datetime) values (9, 7, 19, '1978-01-01 19:11:00');
