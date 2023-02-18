drop table if exists products_sizes;
-- drop table if exists warehouses;
drop table if exists sizes;
drop table if exists pictures;
drop table if exists features;
drop table if exists products;
drop table if exists categories;

create table categories (
    id long auto_increment primary key,
    name varchar(255)
);

insert into categories (name) values ('Куртки');
insert into categories (name) values ('Брюки');
insert into categories (name) values ('Флиски');
insert into categories (name) values ('Толстовки');
insert into categories (name) values ('Рубашки');
insert into categories (name) values ('Лонгсливы');
insert into categories (name) values ('Футболки');
insert into categories (name) values ('Варежки');
insert into categories (name) values ('Шарфы');
insert into categories (name) values ('Шопперы');
insert into categories (name) values ('Шорты');

create table products (
    id long auto_increment primary key,
    title varchar(500),
    caption varchar(2000),
    base_price long,
    sale_price long,
    category_id long constraint CATEGORIES_ID_FK references categories(id)
);

insert into products (title, caption, base_price, sale_price, category_id)values ('FW23 PUFFER Iron', 'Пуховик сезона 22-23', 7700, 8800, 1);

create table sizes (
    id long auto_increment primary key,
    size varchar(100)
);

insert into sizes (size) values ('S');
insert into sizes (size) values ('M');
insert into sizes (size) values ('L');
insert into sizes (size) values ('XS');
insert into sizes (size) values ('XL');
insert into sizes (size) values ('XXL');

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

create table products_sizes (
    id long auto_increment primary key,
    product_id long constraint PRODUCTS_SIZES_ID_FK references products(id),
    size_id long constraint SIZE_ID_FK references sizes(id)
);

insert into products_sizes (product_id, size_id) values (1, 2);
insert into products_sizes (product_id, size_id) values (1, 3);
insert into products_sizes (product_id, size_id) values (1, 4);

-- create table warehouses (
--     id long auto_increment primary key,
--     product_id long constraint PRODUCTS_WAREHOUSES_ID_FK references products(id),
--     size_id long constraint SIZES_WAREHOUSES_ID_FK references sizes(id),
--     stock enum('store', 'laboratory'),
--
-- );
--
-- insert into warehouses (product_id, size_id, stock) values (1, 1, 'store');
-- insert into warehouses (product_id, size_id, stock) values (1, 2, 'store');
-- insert into warehouses (product_id, size_id, stock) values (1, 3, 'store');
-- insert into warehouses (product_id, size_id, stock) values (1, 4, 'store');
-- insert into warehouses (product_id, size_id, stock) values (1, 1, 'laboratory');
-- insert into warehouses (product_id, size_id, stock) values (1, 2, 'laboratory');
-- insert into warehouses (product_id, size_id, stock) values (1, 3, 'laboratory');
-- insert into warehouses (product_id, size_id, stock) values (1, 4, 'laboratory');
