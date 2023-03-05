drop table if exists attributes;
drop table if exists attribute_type;

create table attribute_type (
    id long auto_increment primary key,
    name varchar(100) not null
);

insert into attribute_type (name) values ('size');

create table attributes (
    id long auto_increment primary key,
    type_id long not null constraint ATTRIBUTE_TYPE_ID_FK references attribute_type(id),
    name varchar(100) not null
);

insert into attributes (type_id, name) values (1, 'S');
insert into attributes (type_id, name) values (1, 'M');
insert into attributes (type_id, name) values (1, 'L');
insert into attributes (type_id, name) values (1, 'XS');
insert into attributes (type_id, name) values (1, 'XL');
insert into attributes (type_id, name) values (1, 'XXL');
