create table cost_offers
(
    id   bigint not null primary key,
    cost numeric(19, 2),
    name varchar(255)
);

insert into cost_offers(id, cost, name)
values (1, 25, 'Residence');
insert
into cost_offers(id, cost, name)
values (2, 15, 'Second pet');

insert into cost_offers(id, cost, name)
values (3, 20, 'Delivery of a cat in Minsk');

insert into cost_offers(id, cost, name)
values (4, 55, 'Special care');

insert into cost_offers(id, cost, name)
values (5, 60, 'Call veterinary to hotel');


create table additionally_offers
(
    id             serial primary key,
    name           varchar(255),
    cost_offers_id bigint references cost_offers
);
INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (1, 'Daily walk', 1);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (2, 'Daily walk', 2);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (3, 'Daily walk', 3);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (4, 'Daily walk', 4);
INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (5, 'Daily walk', 5);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (6, 'Constant monitoring of the condition of the pet', 5);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (7, 'Constant monitoring of the condition of the pet', 1);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (8, 'Constant monitoring of the condition of the pet', 3);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (9, 'Ensuring the safety of the animal', 3);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (10, 'Ensuring the safety of the animal', 4);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (11, 'Ensuring the safety of the animal', 5);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (12, 'Ensuring the safety of the animal', 1);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (13, 'Ensuring the safety of the animal', 2);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (14, 'Comfortable living conditions', 2);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (15, 'Comfortable living conditions.', 1);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (16, 'Comfortable living conditions.', 3);


INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (17, 'Comfortable living conditions.', 4);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (18, 'Comfortable living conditions.', 5);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (19, 'Constant monitoring of the condition of the pet', 2);

INSERT INTO additionally_offers(id, name, cost_offers_id)
VALUES (20, 'Constant monitoring of the condition of the pet', 4);