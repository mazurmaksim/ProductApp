create table orders
(
    id int auto_increment
        primary key,
    user_id int not null,
    status varchar(15) not null,
    created_at varchar(30) not null
);

create table products
(
    id int auto_increment
        primary key,
    name varchar(30) null,
    price int not null,
    status enum('out_of_stock', 'in_stock', 'running_low') null,
    created_at timestamp(6)
);

create table order_items
(
    order_id int null,
    product_id int null,
    quantity int null,
    constraint order_items__fk
        foreign key (order_id) references orders (id)
            on update cascade on delete cascade,
    constraint order_items_products_id_fk
        foreign key (product_id) references products (id)
            on update cascade on delete cascade
);
