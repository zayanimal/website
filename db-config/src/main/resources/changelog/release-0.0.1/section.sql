--liquibase formatted sql

-- drop table if exists pictures;
-- drop table if exists features;
-- drop table if exists products;
-- drop table if exists section;
-- drop table if exists categories;

--changeset mech:29 labels:release-0.0.1
create table section (
    id serial primary key,
    name varchar(255),
    enabled boolean not null
);

--changeset mech:30 labels:release-0.0.1
insert into section (name, enabled) values ('Новинки', true);

--changeset mech:31 labels:release-0.0.1
insert into section (name, enabled) values ('Одежда', true);

--changeset mech:32 labels:release-0.0.1
insert into section (name, enabled) values ('Аксессуары', true);

--changeset mech:33 labels:release-0.0.1
insert into section (name, enabled) values ('Журнал', true);

--changeset mech:34 labels:release-0.0.1
insert into section (name, enabled) values ('Аккаунт', true);

--changeset mech:35 labels:release-0.0.1
insert into section (name, enabled) values ('Корзина', true);

--changeset mech:36 labels:release-0.0.1
create table categories (
    id serial primary key,
    name varchar(255),
    section_id integer not null,
    enabled boolean not null
);

--changeset mech:37 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Куртки', 2, true);

--changeset mech:38 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Брюки', 2, true);

--changeset mech:39 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Флиски', 2, true);

--changeset mech:40 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Толстовки', 2, true);

--changeset mech:41 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Рубашки', 2, true);

--changeset mech:42 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Лонгсливы', 2, true);

--changeset mech:43 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Футболки', 2, true);

--changeset mech:44 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Шорты', 2, true);

--changeset mech:45 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Шапки', 3, true);

--changeset mech:46 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Кепки', 3, true);

--changeset mech:47 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Значки', 3, true);

--changeset mech:48 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Нашивки', 3, true);

--changeset mech:49 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Носки', 3, true);

--changeset mech:50 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Поясные сумки', 3, true);

--changeset mech:51 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Варежки', 3, false);

--changeset mech:52 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Шарфы', 3, false);

--changeset mech:53 labels:release-0.0.1
insert into categories (name, section_id, enabled) values ('Шопперы', 3, true);
