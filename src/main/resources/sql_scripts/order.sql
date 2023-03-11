create table orders (
    id long auto_increment primary key,
    created timestamp default CURRENT_TIMESTAMP(),
    user_id long not null constraint USERS_ORDER_FK_ID references users(id)
);

insert into orders (user_id) values (1);

create table orders_item (
    id long auto_increment primary key,
    created timestamp default CURRENT_TIMESTAMP(),
    qty long,
    order_id long not null constraint ORDER_FK_ID references orders(id),
    product_id long not null constraint PRODUCT_ORDER_FK_ID references products(id),
    attribute_id long not null constraint ORDER_ATTRIBUTE_ID_FK references attributes(id)
);

insert into orders_item (qty, order_id, product_id, attribute_id) values (3, 1, 1, 2);

insert into documents (qty, user_id, type_id, product_id, attribute_id, warehouse_id) values (-3, 1, 3, 1, 2, 1);

create table orders_documents (
    id long auto_increment primary key,
    order_item_id long not null constraint ORDER_ITEM_FK_ID references orders_item(id),
    document_id long not null constraint DOCUMENT_ORDER_FK_ID references documents(id)
);

insert into orders_documents (order_item_id, document_id) values(1, 8);
