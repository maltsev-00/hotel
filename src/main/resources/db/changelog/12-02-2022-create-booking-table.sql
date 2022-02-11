create table booking
(
    id                bigint not null primary key,
    begin_date        timestamp,
    end_date          timestamp,
    final_cost        numeric(19, 2),
    info_about_animal varchar(555),
    name_animal       varchar(255),
    telephone_number  varchar(255),
    type_animal       varchar(255)
);