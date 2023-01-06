drop table if exists roles;

create table roles (
   id long auto_increment primary key,
   name varchar(300)
);

insert into roles (name) values ('customer');
insert into roles (name) values ('moderator');
insert into roles (name) values ('admin');

drop table if exists cities;

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

drop table if exists addresses;

create table addresses (
   id long auto_increment primary key,
   idx int,
   city_id int constraint CITY_ID_FK references cities(id),
   street varchar(1000),
   home varchar(1000),
   flat varchar(1000)
);

insert into addresses (idx, city_id, street, home, flat) values (109232, 1, '1-я Владимирская', 5, 16);
insert into addresses (idx, city_id, street, home, flat) values (223444, 7, 'Ленина', 10, 33);
insert into addresses (idx, city_id, street, home, flat) values (433234, 2, 'Невский проспект', 60, 128);

drop table if exists contacts;

create table contacts (
    id long auto_increment primary key,
    phone varchar(200),
    email varchar(300),
    telegram varchar(200)
);

insert into contacts (phone, email, telegram) values ('+7 (926) 454-50-68', 'petrov@mail.ru', '@petrov');
insert into contacts (phone, email, telegram) values ('+7 (916) 180-12-93', 'ivanov@mail.ru', '@ivanov');
insert into contacts (phone, email, telegram) values ('+7 (977) 772-99-21', 'semenov@mail.ru', null);

drop table if exists users;

create table users (
    id long auto_increment primary key,
    login varchar(100) not null,
    password varchar(100) not null,
    role_id int not null constraint ROLE_ID_FK references roles(id),
    address_id int constraint ADDRESS_ID_FK references addresses(id),
    contact_id int constraint CONTACT_ID_FK references contacts(id)
);

insert into users (login, password, role_id, address_id, contact_id) values ('petryuk', '123', 1, 1, 1);
insert into users (login, password, role_id, address_id, contact_id) values ('ivanchello', '123', 1, 2, 2);
insert into users (login, password, role_id, address_id, contact_id) values ('sem47', '123', 1, 3, 3);
