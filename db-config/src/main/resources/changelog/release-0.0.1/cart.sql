--liquibase formatted sql

--changeset mech:98 labels:release-0.0.1
create table cart_item (
    id serial primary key,
    qty integer,
    user_id integer not null constraint USER_CART_FK_ID references users(id),
    product_id integer not null constraint PRODUCT_CART_FK_ID references products(id),
    attribute_id integer not null constraint ATTRIBUTE_CART_ID_FK references attributes(id),
    constraint UNIQUE_CART_ITEM unique (product_id, attribute_id)
);

--changeset mech:99 labels:release-0.0.1
insert into cart_item (qty, user_id, product_id, attribute_id) values (2, 1, 1, 2);
