insert into role(id, name) VALUES (1,'ROLE_ADMIN');
insert into role(id, name) VALUES (2,'ROLE_USER');

insert into users (id, email, password, name)
VALUES (2, 'dima.maltsev666@gmail.com', '$2a$10$Kup5V8iU0Q2XyyhSUhPITON', 'Dima');

insert into users (id, email, password, name)
VALUES (1, 'dana.kirienko@gmail.com', '$2a$10$Kup5V8iU0Q2XyyhSUhPITON', 'Dana');

insert into users (id, email, password, name)
VALUES (3, 'vika.lizunova@gmail.com', '$2a$10$Kup5V8iU0Q2XyyhSUhPITON', 'Vika');

insert into users_roles (user_id, role_id)
values (2,1);

insert into users_roles (user_id, role_id)
values (1,2);

insert into users_roles (user_id, role_id)
values (3,2);



