--liquibase formatted sql

-- drop table if exists attributes;
-- drop table if exists attribute_type;

--changeset mech:62 labels:release-0.0.1
create table attribute_type (
    id serial primary key,
    name varchar(100) not null
);

--changeset mech:63 labels:release-0.0.1
insert into attribute_type (name) values ('size');

--changeset mech:64 labels:release-0.0.1
create table attributes (
    id serial primary key,
    type_id integer not null constraint ATTRIBUTE_TYPE_ID_FK references attribute_type(id),
    name varchar(100) not null
);

--changeset mech:65 labels:release-0.0.1
insert into attributes (type_id, name) values (1, 'S');

--changeset mech:66 labels:release-0.0.1
insert into attributes (type_id, name) values (1, 'M');

--changeset mech:67 labels:release-0.0.1
insert into attributes (type_id, name) values (1, 'L');

--changeset mech:68 labels:release-0.0.1
insert into attributes (type_id, name) values (1, 'XS');

--changeset mech:69 labels:release-0.0.1
insert into attributes (type_id, name) values (1, 'XL');

--changeset mech:70 labels:release-0.0.1
insert into attributes (type_id, name) values (1, 'XXL');
