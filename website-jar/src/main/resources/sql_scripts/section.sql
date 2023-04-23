drop table if exists pictures;
drop table if exists features;
drop table if exists products;
drop table if exists section;
drop table if exists categories;

create table section (
    id long auto_increment primary key,
    name varchar(255),
    enabled boolean not null
);

insert into section (name, enabled) values ('Новинки', true);
insert into section (name, enabled) values ('Одежда', true);
insert into section (name, enabled) values ('Аксессуары', true);
insert into section (name, enabled) values ('Журнал', true);
insert into section (name, enabled) values ('Аккаунт', true);
insert into section (name, enabled) values ('Корзина', true);

create table categories (
    id long auto_increment primary key,
    name varchar(255),
    section_id long not null,
    enabled boolean not null
);

insert into categories (name, section_id, enabled) values ('Куртки', 2, true);
insert into categories (name, section_id, enabled) values ('Брюки', 2, true);
insert into categories (name, section_id, enabled) values ('Флиски', 2, true);
insert into categories (name, section_id, enabled) values ('Толстовки', 2, true);
insert into categories (name, section_id, enabled) values ('Рубашки', 2, true);
insert into categories (name, section_id, enabled) values ('Лонгсливы', 2, true);
insert into categories (name, section_id, enabled) values ('Футболки', 2, true);
insert into categories (name, section_id, enabled) values ('Шорты', 2, true);
insert into categories (name, section_id, enabled) values ('Шапки', 3, true);
insert into categories (name, section_id, enabled) values ('Кепки', 3, true);
insert into categories (name, section_id, enabled) values ('Значки', 3, true);
insert into categories (name, section_id, enabled) values ('Нашивки', 3, true);
insert into categories (name, section_id, enabled) values ('Носки', 3, true);
insert into categories (name, section_id, enabled) values ('Поясные сумки', 3, true);
insert into categories (name, section_id, enabled) values ('Варежки', 3, false);
insert into categories (name, section_id, enabled) values ('Шарфы', 3, false);
insert into categories (name, section_id, enabled) values ('Шопперы', 3, true);
