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
values (1, 'Кормление и уборка от 2 раз в день.Массаж щечек, спинки, лапок, животика.Внимание, вычесывание, любовь – по умолчанию.', 'Уход', true);
insert into offers  (id, description, name, access)
values (2, 'Мы предоставляем вам возможность увидеть, как чувствует себя ваш питомец и чем он занят, когда вы о нем думаете. Спросить «Как он?» вы можете у нас в viber, telegram, facebook, Instagram, what’s up, e-mail, по телефону.', 'Видеонаблюдение', true);

insert into offers  (id, description, name, access)
values (3, 'Кормление и уборка от 2 раз в день.Массаж щечек, спинки, лапок, животика.Внимание, вычесывание, любовь – по умолчанию.', 'Уход после несложных операций', true);

insert into offers (id, description, name, access)
values (4, 'В MyRedCat можно и отдохнуть, и пофотографироваться.', 'Фотосессия в гостинице', true);


insert into type_offer
 (id, name )
values (1, 'Основные услуги');

insert into type_offer
 (id, name )
values (2, 'Дополнительные услуги');

insert into offers_type_offers(offer_id, offer_type_id)
values (1, 1);
insert into offers_type_offers(offer_id, offer_type_id)
values (2, 1);
insert into offers_type_offers(offer_id, offer_type_id)
values (3, 2);
insert into offers_type_offers(offer_id, offer_type_id)
values (4, 2);
