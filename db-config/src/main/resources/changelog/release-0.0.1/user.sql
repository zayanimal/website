--liquibase formatted sql

-- drop table if exists addresses;
-- drop table if exists contacts;
-- drop table if exists recipients;
-- drop table if exists users_roles;
-- drop table if exists orders_documents;
-- drop table if exists documents;
-- drop table if exists cart_item;
-- drop table if exists orders_item;
-- drop table if exists orders;
-- drop table if exists orders_status;
-- drop table if exists users;
-- drop table if exists roles;

--changeset mech:01 labels:release-0.0.1
create table roles (
    id serial primary key,
    name varchar(300)
);

--changeset mech:02 labels:release-0.0.1
insert into roles (name) values ('CUSTOMER');

--changeset mech:03 labels:release-0.0.1
insert into roles (name) values ('MODERATOR');

--changeset mech:04 labels:release-0.0.1
insert into roles (name) values ('ADMIN');

--changeset mech:05 labels:release-0.0.1
create table users (
    id serial primary key,
    login varchar(100) not null,
    password varchar(1000) not null
);

--changeset mech:06 labels:release-0.0.1
insert into users (login, password) values ('petryuk', '$2a$10$4nTdvS3ihhL4fjd0gj6QMOr7qKtV3ItyODImYanlcWLH7uhvkjkEK');

--changeset mech:07 labels:release-0.0.1
insert into users (login, password) values ('ivanchello', '$2a$10$4nTdvS3ihhL4fjd0gj6QMOr7qKtV3ItyODImYanlcWLH7uhvkjkEK');

--changeset mech:08 labels:release-0.0.1
insert into users (login, password) values ('sem47', '$2a$10$4nTdvS3ihhL4fjd0gj6QMOr7qKtV3ItyODImYanlcWLH7uhvkjkEK');

--changeset mech:09 labels:release-0.0.1
create table users_roles(
    id serial primary key,
    user_id integer constraint USERS_ID_FK references users(id),
    role_id integer constraint ROLE_ID_FK references roles(id)
);

--changeset mech:10 labels:release-0.0.1
insert into users_roles(user_id, role_id) values (1, 2);

--changeset mech:11 labels:release-0.0.1
insert into users_roles(user_id, role_id) values (1, 3);

--changeset mech:12 labels:release-0.0.1
insert into users_roles(user_id, role_id) values (2, 1);

--changeset mech:13 labels:release-0.0.1
insert into users_roles(user_id, role_id) values (3, 1);

--changeset mech:14 labels:release-0.0.1
create table addresses (
    id serial primary key,
    idx varchar(255),
    city varchar(255),
    street varchar(255),
    home varchar(255),
    flat varchar(255),
    user_id integer constraint USER_ADDRESS_ID_FK references users(id)
);

--changeset mech:15 labels:release-0.0.1
insert into addresses (idx, city, street, home, flat, user_id) values ('109232', 'Москва', '1-я Владимирская', 5, 16, 1);

--changeset mech:16 labels:release-0.0.1
insert into addresses (idx, city, street, home, flat, user_id) values ('775532', 'Москва', 'Комсомольская', 17, 22, 1);

--changeset mech:17 labels:release-0.0.1
insert into addresses (idx, city, street, home, flat, user_id) values ('223444', 'Москва', 'Ленина', 10, 33, 2);

--changeset mech:18 labels:release-0.0.1
insert into addresses (idx, city, street, home, flat, user_id) values ('433234', 'Москва', 'Невский проспект', 60, 128, 3);

--changeset mech:19 labels:release-0.0.1
create table contacts (
    id serial primary key,
    phone varchar(200),
    email varchar(300),
    user_id integer constraint USER_CONTACT_ID_FK references users(id)
);

--changeset mech:20 labels:release-0.0.1
insert into contacts (phone, email, user_id) values ('+7 (926) 454-50-68', 'petrov@mail.ru', 1);

--changeset mech:21 labels:release-0.0.1
insert into contacts (phone, email, user_id) values ('+7 (916) 180-12-93', 'ivanov@mail.ru', 2);

--changeset mech:22 labels:release-0.0.1
insert into contacts (phone, email, user_id) values ('+7 (966) 242-54-89', 'zherebcov@mail.ru', 2);

--changeset mech:23 labels:release-0.0.1
insert into contacts (phone, email, user_id) values ('+7 (977) 772-99-21', 'semenov@mail.ru', 3);

--changeset mech:24 labels:release-0.0.1
create table recipients(
    id serial primary key,
    surname varchar(300),
    name varchar(300),
    middle_name varchar(300),
    user_id integer constraint USER_RECIPIENT_ID_FK references users(id)
);

--changeset mech:25 labels:release-0.0.1
insert into recipients (surname, name, middle_name, user_id) values ('Петрюк', 'Василий', 'Иванович', 1);

--changeset mech:26 labels:release-0.0.1
insert into recipients (surname, name, middle_name, user_id) values ('Иванов', 'Себастьян', 'Инокентьевич', 2);

--changeset mech:27 labels:release-0.0.1
insert into recipients (surname, name, middle_name, user_id) values ('Семенюк', 'Митрофан', 'Семёнович', 3);

--changeset mech:28 labels:release-0.0.1
insert into recipients (surname, name, middle_name, user_id) values ('Мартынов', 'Прохор', 'Матвеевич', 3);
