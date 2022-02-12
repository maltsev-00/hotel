create table role
(
    id   serial primary key,
    name varchar(255)
);

create table users
(
    id       bigint not null  primary key,
    email    varchar(255)
        unique,
    name     varchar(255),
    password varchar(255)
);



create table users_roles
(
    user_id bigint  not null
        references users,
    role_id integer not null
        references role
);