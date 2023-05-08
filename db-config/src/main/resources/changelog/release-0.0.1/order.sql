--liquibase formatted sql

--changeset mech:86 labels:release-0.0.1
create table orders_status (
    id serial primary key,
    name varchar(255) not null
);

--changeset mech:87 labels:release-0.0.1
insert into orders_status (name) values('Ожидание оплаты');

--changeset mech:88 labels:release-0.0.1
insert into orders_status (name) values('Укомплектован');

--changeset mech:89 labels:release-0.0.1
insert into orders_status (name) values('Отправлен');

--changeset mech:90 labels:release-0.0.1
insert into orders_status (name) values('Выполнен');

--changeset mech:91 labels:release-0.0.1
create table orders (
    id serial primary key,
    created timestamp default CURRENT_TIMESTAMP,
    user_id integer not null constraint USERS_ORDER_FK_ID references users(id),
    status_id integer not null constraint STATUS_ORDER_FK_ID references orders_status(id)
);

--changeset mech:92 labels:release-0.0.1
insert into orders (user_id, status_id) values (1, 1);

--changeset mech:93 labels:release-0.0.1
create table orders_item (
    id serial primary key,
    created timestamp default CURRENT_TIMESTAMP,
    qty integer,
    order_id integer not null constraint ORDER_FK_ID references orders(id),
    product_id integer not null constraint PRODUCT_ORDER_FK_ID references products(id),
    attribute_id integer not null constraint ORDER_ATTRIBUTE_ID_FK references attributes(id)
);

--changeset mech:94 labels:release-0.0.1
insert into orders_item (qty, order_id, product_id, attribute_id) values (3, 1, 1, 2);

--changeset mech:95 labels:release-0.0.1
insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (-3, 1, 3, 1, 2, 1);

--changeset mech:96 labels:release-0.0.1
create table orders_documents (
    id serial primary key,
    order_item_id integer not null constraint ORDER_ITEM_FK_ID references orders_item(id),
    document_id integer not null constraint DOCUMENT_ORDER_FK_ID references documents(id)
);

--changeset mech:97 labels:release-0.0.1
insert into orders_documents (order_item_id, document_id) values(1, 8);
