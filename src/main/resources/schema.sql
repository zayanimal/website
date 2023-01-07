drop table if exists users;
drop table if exists roles;
drop table if exists contacts;
drop table if exists addresses;
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

create table addresses (
   id long auto_increment primary key,
   idx varchar(1000),
   city_id int constraint CITY_ID_FK references cities(id),
   street varchar(1000),
   home varchar(1000),
   flat varchar(1000)
);

insert into addresses (idx, city_id, street, home, flat) values ('109232', 1, '1-я Владимирская', 5, 16);
insert into addresses (idx, city_id, street, home, flat) values ('223444', 7, 'Ленина', 10, 33);
insert into addresses (idx, city_id, street, home, flat) values ('433234', 2, 'Невский проспект', 60, 128);

create table contacts (
    id long auto_increment primary key,
    phone varchar(200),
    email varchar(300)
);

insert into contacts (phone, email) values ('+7 (926) 454-50-68', 'petrov@mail.ru');
insert into contacts (phone, email) values ('+7 (916) 180-12-93', 'ivanov@mail.ru');
insert into contacts (phone, email) values ('+7 (977) 772-99-21', 'semenov@mail.ru');

create table users (
    id long auto_increment primary key,
    login varchar(100) not null,
    surname varchar(300),
    name varchar(300),
    middle_name varchar(300),
    password varchar(100) not null,
    role_id int not null constraint ROLE_ID_FK references roles(id),
    address_id int constraint ADDRESS_ID_FK references addresses(id),
    contact_id int constraint CONTACT_ID_FK references contacts(id)
);

insert into users (login, surname, name, middle_name, password, role_id, address_id, contact_id) values ('petryuk', 'Петрюк', 'Василий', 'Иванович', '123', 1, 1, 1);
insert into users (login, surname, name, middle_name, password, role_id, address_id, contact_id) values ('ivanchello', 'Иванов', 'Себастьян', 'Инокентьевич', '123', 1, 2, 2);
insert into users (login, surname, name, middle_name, password, role_id, address_id, contact_id) values ('sem47', 'Семенюк', 'Митрофан', 'Семёнович', '123', 1, 3, 3);
