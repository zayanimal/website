drop table if exists addresses;
drop table if exists contacts;
drop table if exists recipients;
drop table if exists users;
drop table if exists roles;
drop table if exists cities;

create table roles (
   id long auto_increment primary key,
   name varchar(300)
);

insert into roles (name) values ('customer');
insert into roles (name) values ('moderator');
insert into roles (name) values ('admin');

create table cities (
    id long auto_increment primary key,
    name varchar(500)
);

insert into cities (name) values ('Москва');
insert into cities (name) values ('Санкт-Петербург');
insert into cities (name) values ('Казань');
insert into cities (name) values ('Уфа');
insert into cities (name) values ('Нижний Новгород');
insert into cities (name) values ('Иваново');
insert into cities (name) values ('Владимир');

create table users (
    id long auto_increment primary key,
    login varchar(100) not null,
    password varchar(100) not null,
    role_id long not null constraint ROLE_ID_FK references roles(id),
    default_address_id long not null,
    default_contact_id long not null,
    default_recipient_id long not null
);

insert into users (login, password, role_id, default_address_id, default_contact_id, default_recipient_id) values ('petryuk', '123', 1, 1, 1, 1);
insert into users (login, password, role_id, default_address_id, default_contact_id, default_recipient_id) values ('ivanchello', '123', 1, 3, 2, 2);
insert into users (login, password, role_id, default_address_id, default_contact_id, default_recipient_id) values ('sem47', '123', 1, 4, 4, 3);

create table addresses (
   id long auto_increment primary key,
   idx varchar(1000),
   street varchar(1000),
   home varchar(1000),
   flat varchar(1000),
   city_id int constraint CITY_ID_FK references cities(id),
   user_id long constraint USER_ADDRESS_ID_FK references users(id)
);

insert into addresses (idx, street, home, flat, city_id, user_id) values ('109232', '1-я Владимирская', 5, 16, 1, 1);
insert into addresses (idx, street, home, flat, city_id, user_id) values ('775532', 'Комсомольская', 17, 22, 5, 1);
insert into addresses (idx, street, home, flat, city_id, user_id) values ('223444', 'Ленина', 10, 33, 7, 2);
insert into addresses (idx, street, home, flat, city_id, user_id) values ('433234', 'Невский проспект', 60, 128, 2, 3);

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
