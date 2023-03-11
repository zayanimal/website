drop table if exists addresses;
drop table if exists contacts;
drop table if exists recipients;
drop table if exists users_roles;
drop table if exists orders_documents;
drop table if exists documents;
drop table if exists orders_item;
drop table if exists orders;
drop table if exists users;
drop table if exists roles;

create table roles (
    id long auto_increment primary key,
    name varchar(300)
);

insert into roles (name) values ('CUSTOMER');
insert into roles (name) values ('MODERATOR');
insert into roles (name) values ('ADMIN');

create table users (
    id long auto_increment primary key,
    login varchar(100) not null,
    password varchar(1000) not null
);

insert into users (login, password) values ('petryuk', '$2a$10$4nTdvS3ihhL4fjd0gj6QMOr7qKtV3ItyODImYanlcWLH7uhvkjkEK');
insert into users (login, password) values ('ivanchello', '$2a$10$4nTdvS3ihhL4fjd0gj6QMOr7qKtV3ItyODImYanlcWLH7uhvkjkEK');
insert into users (login, password) values ('sem47', '$2a$10$4nTdvS3ihhL4fjd0gj6QMOr7qKtV3ItyODImYanlcWLH7uhvkjkEK');

create table users_roles(
    id long auto_increment primary key,
    user_id long constraint USERS_ID_FK references users(id),
    role_id long constraint ROLE_ID_FK references roles(id)
);

insert into users_roles(user_id, role_id) values (1, 2);
insert into users_roles(user_id, role_id) values (1, 3);
insert into users_roles(user_id, role_id) values (2, 1);
insert into users_roles(user_id, role_id) values (3, 1);

create table addresses (
    id long auto_increment primary key,
    idx varchar(255),
    city varchar(255),
    street varchar(255),
    home varchar(255),
    flat varchar(255),
    user_id long constraint USER_ADDRESS_ID_FK references users(id)
);

insert into addresses (idx, city, street, home, flat, user_id) values ('109232', 'Москва', '1-я Владимирская', 5, 16, 1);
insert into addresses (idx, city, street, home, flat, user_id) values ('775532', 'Москва', 'Комсомольская', 17, 22, 1);
insert into addresses (idx, city, street, home, flat, user_id) values ('223444', 'Москва', 'Ленина', 10, 33, 2);
insert into addresses (idx, city, street, home, flat, user_id) values ('433234', 'Москва', 'Невский проспект', 60, 128, 3);

create table contacts (
    id long auto_increment primary key,
    phone varchar(200),
    email varchar(300),
    user_id long constraint USER_CONTACT_ID_FK references users(id)
);

insert into contacts (phone, email, user_id) values ('+7 (926) 454-50-68', 'petrov@mail.ru', 1);
insert into contacts (phone, email, user_id) values ('+7 (916) 180-12-93', 'ivanov@mail.ru', 2);
insert into contacts (phone, email, user_id) values ('+7 (966) 242-54-89', 'zherebcov@mail.ru', 2);
insert into contacts (phone, email, user_id) values ('+7 (977) 772-99-21', 'semenov@mail.ru', 3);

create table recipients(
    id long auto_increment primary key,
    surname varchar(300),
    name varchar(300),
    middle_name varchar(300),
    user_id long constraint USER_RECIPIENT_ID_FK references users(id)
);

insert into recipients (surname, name, middle_name, user_id) values ('Петрюк', 'Василий', 'Иванович', 1);
insert into recipients (surname, name, middle_name, user_id) values ('Иванов', 'Себастьян', 'Инокентьевич', 2);
insert into recipients (surname, name, middle_name, user_id) values ('Семенюк', 'Митрофан', 'Семёнович', 3);
insert into recipients (surname, name, middle_name, user_id) values ('Мартынов', 'Прохор', 'Матвеевич', 3);
