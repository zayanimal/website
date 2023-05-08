--liquibase formatted sql

-- drop table if exists document_type;
-- drop table if exists warehouse;

--changeset mech:71 labels:release-0.0.1
create table document_type (
    id serial primary key,
    name varchar(100) not null
);

--changeset mech:72 labels:release-0.0.1
insert into document_type (name) values ('Приход');

--changeset mech:73 labels:release-0.0.1
insert into document_type (name) values ('Списание');

--changeset mech:74 labels:release-0.0.1
insert into document_type (name) values ('Резерв');

--changeset mech:75 labels:release-0.0.1
create table warehouse (
    id serial primary key,
    name varchar(255) not null
);

--changeset mech:76 labels:release-0.0.1
insert into warehouse (name) values ('Хлебозавод');

--changeset mech:77 labels:release-0.0.1
insert into warehouse (name) values ('Лаборатория');

--changeset mech:78 labels:release-0.0.1
create table documents (
    id serial primary key,
    qty integer not null,
    created timestamp default CURRENT_TIMESTAMP,
    user_id integer not null constraint DOCUMENTS_USERS_ID_FK references users(id),
    type_id integer not null constraint DOCUMENTS_TYPES_ID_FK references document_type(id),
    product_id integer not null constraint PRODUCTS_DOCUMENTS_ID_FK references products(id),
    attribute_id integer not null constraint DOCUMENT_ATTRIBUTE_ID_FK references attributes(id),
    warehouse_id integer not null constraint WAREHOUSE_ID_FK references warehouse(id)
);

--changeset mech:79 labels:release-0.0.1
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (10, 1, 1, 1, 1, 1);

--changeset mech:80 labels:release-0.0.1
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (20, 1, 1, 1, 2, 1);

--changeset mech:81 labels:release-0.0.1
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (15, 1, 1, 1, 3, 1);

--changeset mech:82 labels:release-0.0.1
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (-5, 1, 2, 1, 3, 1);

--changeset mech:83 labels:release-0.0.1
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (10, 1, 1, 1, 1, 2);

--changeset mech:84 labels:release-0.0.1
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (20, 1, 1, 1, 2, 2);

--changeset mech:85 labels:release-0.0.1
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (15, 1, 1, 1, 3, 2);
