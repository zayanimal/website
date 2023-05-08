--liquibase formatted sql

--changeset mech:54 labels:release-0.0.1
create table products (
    id serial primary key,
    title varchar(500),
    caption varchar(2000),
    cost integer,
    price integer,
    category_id integer constraint CATEGORIES_ID_FK references categories(id)
);

--changeset mech:55 labels:release-0.0.1
insert into products (title, caption, cost, price, category_id) values ('FW23 PUFFER Iron', 'Пуховик сезона 22-23', 1000, 3000, 1);

--changeset mech:56 labels:release-0.0.1
create table features (
    id serial primary key,
    name varchar(255),
    description varchar(500),
    product_id integer constraint PRODUCTS_FEATURES_ID_FK references products(id)
);

--changeset mech:57 labels:release-0.0.1
insert into features (product_id, name, description) values (1, 'Ткань верха', '100% полиэстер 73г/м2');
insert into features (product_id, name, description) values (1, 'Обработка', 'WR.CIRE (для удержания пуха и предотвращения миграции)');
insert into features (product_id, name, description) values (1, 'Подкладка', '100% полиэстер 60г/м2 + пуходержащие пакеты для дополнительного удержания пуха');
insert into features (product_id, name, description) values (1, 'Утеплитель', 'Биопух (Аналог DuPont Sorona) 700г;  производство Корея');
insert into features (product_id, name, description) values (1, 'Температурный режим', '-10C / -20C');

--changeset mech:58 labels:release-0.0.1
create table pictures (
    id serial primary key,
    identification varchar(255),
    product_id integer constraint PRODUCTS_PICTURES_ID_FK references products(id)
);

--changeset mech:59 labels:release-0.0.1
insert into pictures (product_id, identification) values (1, 'jacket_01');

--changeset mech:60 labels:release-0.0.1
insert into pictures (product_id, identification) values (1, 'jacket_02');

--changeset mech:61 labels:release-0.0.1
insert into pictures (product_id, identification) values (1, 'jacket_03');
