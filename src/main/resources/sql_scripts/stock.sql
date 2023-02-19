drop table if exists attributes;
drop table if exists attribute_type;
drop table if exists documents_types;

create table attribute_type (
    id long auto_increment primary key,
    name varchar(100)
);

insert into attribute_type (name) values ('size');

create table attributes (
    id long auto_increment primary key,
    type_id long constraint ATTRIBUTE_TYPE_ID_FK references attribute_type(id),
    name varchar(100)
);

insert into attributes (type_id, name) values (1, 'S');
insert into attributes (type_id, name) values (1, 'M');
insert into attributes (type_id, name) values (1, 'L');
insert into attributes (type_id, name) values (1, 'XS');
insert into attributes (type_id, name) values (1, 'XL');
insert into attributes (type_id, name) values (1, 'XXL');

create table documents_types (
    id long auto_increment primary key,
    name varchar(100)
);

insert into documents_types (name) values ('Приход');
insert into documents_types (name) values ('Расход');
insert into documents_types (name) values ('Резерв');

create table documents (
    id long auto_increment primary key,
    qty long,
    type_id long constraint DOCUMENTS_TYPES_ID_FK references documents_types(id),
    product_id long constraint PRODUCTS_DOCUMENTS_ID_FK references products(id),
    attribute_id long constraint ATTRIBUTE_ID_FK references attributes(id)
);

insert into documents (qty, type_id, product_id, attribute_id) values (10, 1, 1, 1);
insert into documents (qty, type_id, product_id, attribute_id) values (20, 1, 1, 2);
insert into documents (qty, type_id, product_id, attribute_id) values (15, 1, 1, 3);
insert into documents (qty, type_id, product_id, attribute_id) values (-5, 2, 1, 3);
