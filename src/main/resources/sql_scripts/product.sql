create table products (
    id long auto_increment primary key,
    title varchar(500),
    caption varchar(2000),
    cost long,
    price long,
    category_id long constraint CATEGORIES_ID_FK references categories(id)
);

insert into products (title, caption, cost, price, category_id) values ('FW23 PUFFER Iron', 'Пуховик сезона 22-23', 1000, 3000, 1);

create table features (
    id long auto_increment primary key,
    name varchar(255),
    description varchar(500),
    product_id long constraint PRODUCTS_FEATURES_ID_FK references products(id)
);

insert into features (product_id, name, description) values (1, 'Ткань верха', '100% полиэстер 73г/м2');
insert into features (product_id, name, description) values (1, 'Обработка', 'WR.CIRE (для удержания пуха и предотвращения миграции)');
insert into features (product_id, name, description) values (1, 'Подкладка', '100% полиэстер 60г/м2 + пуходержащие пакеты для дополнительного удержания пуха');
insert into features (product_id, name, description) values (1, 'Утеплитель', 'Биопух (Аналог DuPont Sorona) 700г;  производство Корея');
insert into features (product_id, name, description) values (1, 'Температурный режим', '-10C / -20C');

create table pictures (
    id long auto_increment primary key,
    identification varchar(255),
    product_id long constraint PRODUCTS_PICTURES_ID_FK references products(id)
);

insert into pictures (product_id, identification) values (1, 'jacket_01');
insert into pictures (product_id, identification) values (1, 'jacket_02');
insert into pictures (product_id, identification) values (1, 'jacket_03');
