create table cost_offers
(
    id           bigint not null primary key,
    additionally varchar(255),
    cost         numeric(19, 2),
    name         varchar(255)
);

insert into cost_offers(id, additionally, cost, name)
values (1, '', 25, 'Residence');
    insert
into cost_offers(id, additionally, cost, name)
values (2, 'Second cat of the same owner in the same room', 15, 'Second pet');

insert into cost_offers(id, additionally, cost, name)
values (3, 'To the hotel, to the hotel and home, home', 20, 'Delivery of a cat in Minsk');

insert into cost_offers(id, additionally, cost, name)
values (4, 'Chronic non-viral diseases, light postoperative care, medication prescribed by a veterinarian', 55, 'Special care');

insert into cost_offers(id, additionally, cost, name)
values (5, 'Provision of PVP, without additional medicines', 60, 'Call veterinary to hotel');


