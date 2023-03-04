drop table if exists attributes;
drop table if exists attribute_type;
drop table if exists document_type;
drop table if exists warehouse;

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

create table document_type (
    id long auto_increment primary key,
    name varchar(100) not null
);

insert into document_type (name) values ('Приход');
insert into document_type (name) values ('Списание');
insert into document_type (name) values ('Резерв');

create table warehouse (
    id long auto_increment primary key,
    name varchar(255) not null
);

insert into warehouse (name) values ('Хлебозавод');
insert into warehouse (name) values ('Лаборатория');

create table documents (
    id long auto_increment primary key,
    qty long not null,
    created timestamp default CURRENT_TIMESTAMP(),
    user_id long not null constraint DOCUMENTS_USERS_ID_FK references users(id),
    type_id long not null constraint DOCUMENTS_TYPES_ID_FK references document_type(id),
    product_id long not null constraint PRODUCTS_DOCUMENTS_ID_FK references products(id),
    attribute_id long not null constraint ATTRIBUTE_ID_FK references attributes(id),
    warehouse_id long not null constraint WAREHOUSE_ID_FK references warehouse(id)
);

insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (10, 1, 1, 1, 1, 1);
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (20, 1, 1, 1, 2, 1);
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (-1, 1, 3, 1, 2, 1);
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (-2, 1, 3, 1, 1, 1);
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (15, 1, 1, 1, 3, 1);
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (-5, 1, 2, 1, 3, 1);
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (10, 1, 1, 1, 1, 2);
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (20, 1, 1, 1, 2, 2);
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (15, 1, 1, 1, 3, 2);
