create table cart_item (
    id long auto_increment primary key,
    qty long,
    product_id long not null constraint PRODUCT_CART_FK_ID references products(id),
    attribute_id long not null constraint ATTRIBUTE_CART_ID_FK references attributes(id)
);

insert into cart_item (qty, product_id, attribute_id) values (2, 1, 2);
