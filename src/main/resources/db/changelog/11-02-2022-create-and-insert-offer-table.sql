create table offers
(
    id          bigint not null primary key,
    description varchar(255),
    access      boolean,
    name        varchar(255)
);

create table type_offer
(
    id   bigserial primary key,
    name varchar(255)
);

create table offers_type_offers
(
    offer_id      bigint not null references offers,
    offer_type_id bigint not null references type_offer
);

insert into offers (id,description,name,access)
values (1, 'Feeding and cleaning from 2 times a day. Massage of the cheeks, back, legs, tummy. Attention, combing, love - by default.', 'Care', true);
insert into offers  (id, description, name, access)
values (2, 'We give you the opportunity to see how your pet feels and what he is doing when you think about him. Ask "How is he?" you can contact us in viber, telegram, facebook, Instagram, what''s up, e-mail, by phone.', 'Video monitoring', true);

insert into offers  (id, description, name, access)
values (3, 'Feeding and cleaning from 2 times a day. Massage of the cheeks, back, legs, tummy. Attention, combing, love - by default.', 'Care after minor surgeries', true);

insert into offers (id, description, name, access)
values (4, 'In MyRedCat you can relax and take pictures.', 'Photo session in the hotel', true);

insert into offers (id, description, name, access)
values (5, 'Are you tired of wool in the house? You do not have time to go with the cat to the salon? ', 'Escort to the grummer', true);

insert into type_offer
 (id, name )
values (1, 'Basic services');

insert into type_offer
 (id, name )
values (2, 'Additional services');

insert into type_offer
(id, name )
values (3, 'Extra services');

insert into offers_type_offers(offer_id, offer_type_id)
values (1, 1);
insert into offers_type_offers(offer_id, offer_type_id)
values (2, 1);
insert into offers_type_offers(offer_id, offer_type_id)
values (3, 2);
insert into offers_type_offers(offer_id, offer_type_id)
values (4, 2);

insert into offers_type_offers(offer_id, offer_type_id)
values (5, 3);
