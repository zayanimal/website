create table cart_item (
    id long auto_increment primary key,
    qty long,
    user_id long not null constraint USER_CART_FK_ID references users(id),
    product_id long not null constraint PRODUCT_CART_FK_ID references products(id),
    attribute_id long not null constraint ATTRIBUTE_CART_ID_FK references attributes(id),
    constraint UNIQUE_CART_ITEM unique (product_id, attribute_id)
);

insert into cart_item (qty, user_id, product_id, attribute_id) values (2, 1, 1, 2);
