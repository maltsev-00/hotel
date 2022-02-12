create table booking
(
    id                bigint  not null  primary key,
    count_day         integer not null,
    final_cost        numeric(19, 2),
    info_about_animal varchar(255),
    name_animal       varchar(255),
    telephone_number  varchar(255),
    type_animal       varchar(255)
);

create table users_booking
(
    user_id    bigint not null
        references users,
    booking_id bigint not null
        references booking,
    primary key (user_id, booking_id)
);