create table menu_item
(
    id   bigint not null primary key,
    cost numeric(19, 2),
    name varchar(255)
);

insert into menu_item (id, cost, name)
VALUES (1, 35, 'Dog food');

insert into menu_item (id, cost, name)
VALUES (2, 53, 'Cat food');

insert into menu_item (id, cost, name)
VALUES (3, 45, 'Premium dog food');

insert into menu_item (id, cost, name)
VALUES (4, 45, 'Premium cat food');