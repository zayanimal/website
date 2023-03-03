create table orders (
    id long auto_increment primary key,
    created timestamp default CURRENT_TIMESTAMP(),
    user_id long not null constraint USERS_ORDER_FK_ID references users(id)
);

insert into orders (user_id) values (1);

create table orders_products (
    id long auto_increment primary key,
    order_id long not null constraint ORDER_PRODUCT_FK_ID references orders(id),
    product_id long not null constraint PRODUCT_ORDER_FK_ID references products(id)
);

insert into orders_products (order_id, product_id) values (1, 1);
