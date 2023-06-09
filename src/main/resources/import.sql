
insert into role ( name, enable) values ( 'Admin', true);
insert into role (name, enable) values ('Chef', true);
insert into role (name, enable) values ('Mesero', true);

insert into permission (id, name,description,table_name, group_id) values (1, 'READ_USER','Este permiso permite al usuario ver o leer información de la tabla usuario','Usuarios', 'READ');
insert into permission (id, name,description,table_name, group_id) values (2, 'WRITE_USER','Este permiso permite al usuario crear o modificar información en la tabla usuario','Usuarios', 'WRITE');
insert into permission (id, name,description,table_name, group_id) values (3, 'DELETE_USER','Este permiso permite al usuario eliminar información de la tabla usuario','Usuarios', 'DELETE');
insert into permission (id, name,description,table_name, group_id) values (4, 'READ_ROLE','Este permiso permite al usuario ver o leer información de la tabla rol','Roles','READ');
insert into permission (id, name,description,table_name, group_id) values (5, 'WRITE_ROLE','Este permiso permite al usuario crear o modificar información en la tabla rol','Roles', 'WRITE');
insert into permission (id, name,description,table_name, group_id) values (6, 'DELETE_ROLE','Este permiso permite al usuario eliminar información de la tabla rol','Roles', 'DELETE');
insert into permission (id, name,description,table_name, group_id) values (7, 'READ_PERMISSION','Este permiso permite al usuario ver o leer información de la tabla permiso','Permisos', 'READ');
insert into permission (id, name,description,table_name, group_id) values (8, 'WRITE_ORDER','Este permiso permite al usuario  editar de la tabla Orden','Orden', 'WRITE');
insert into permission (id, name,description,table_name, group_id) values (9, 'READ_ORDER','Este permiso permite al usuario ver o leer información de la tabla permiso','Permisos', 'READ');
insert into permission (id, name,description,table_name, group_id) values (10, 'DELETE_ORDER','Este permiso permite al usuario eliminar información de la tabla permiso','Permisos', 'DELETE');
insert into permission (id, name,description,table_name, group_id) values (11, 'READ_TABLE','Este permiso permite al usuario ver o leer información de la tabla mesa','Mesas', 'READ');
insert into permission (id, name,description,table_name, group_id) values (12, 'WRITE_TABLE','Este permiso permite al usuario crear y eliminar información de la tabla mesa','Mesas', 'WRITE');

insert into permission_role (role_id, permission_id) values (1, 1);
insert into permission_role (role_id, permission_id) values (1, 2);
insert into permission_role (role_id, permission_id) values (1, 3);
insert into permission_role (role_id, permission_id) values (1, 4);
insert into permission_role (role_id, permission_id) values (1, 5);
insert into permission_role (role_id, permission_id) values (1, 6);
insert into permission_role (role_id, permission_id) values (1, 7);
insert into permission_role (role_id, permission_id) values (1, 8);
insert into permission_role (role_id, permission_id) values (1, 9);
insert into permission_role (role_id, permission_id) values (1, 10);
insert into permission_role (role_id, permission_id) values (2, 8);
insert into permission_role (role_id, permission_id) values (2, 9);
insert into permission_role (role_id, permission_id) values (3, 8);
insert into permission_role (role_id, permission_id) values (3, 9);

insert into permission_role (role_id, permission_id) values (1, 11);

insert into permission_role (role_id, permission_id) values (1, 12);
insert into users(name,last_name,email,phone,username, password, enable, role_id) values ('Jenniffer','Granados','fiebre.libros@gmail.com','(503) 7714-8798','admin', '$2a$10$eGW9WJuDbUeEfAa060zptusUKtUWZIlra/SBBAG3hfR3Hfn1Y1Age', true, 1);
insert into users(name,last_name,email,phone,username, password, enable, role_id) values ('Jericho','Barrons','test2@gmail.com','(503) 7489-5478','DSIJerichoBarrons', '$2a$10$eGW9WJuDbUeEfAa060zptusUKtUWZIlra/SBBAG3hfR3Hfn1Y1Age', true, 1);
insert into users(name,last_name,email,phone,username, password, enable, role_id) values ('Jen','Lisa','jenlisa@gmail.com','(503) 7489-5478','DSIJenLisa', '$2a$10$eGW9WJuDbUeEfAa060zptusUKtUWZIlra/SBBAG3hfR3Hfn1Y1Age', true, 1);

INSERT INTO order_states (id, name, color_hex) VALUES (1, 'pendiente', '#FF0000');
INSERT INTO order_states (id, name, color_hex) VALUES (2, 'preparando', '#FFA500');
INSERT INTO order_states (id, name, color_hex) VALUES (3, 'completado', '#008000');
INSERT INTO order_states (id, name, color_hex) VALUES (4, 'entregado', '#0000FF');
INSERT INTO order_states (id, name, color_hex) VALUES (5, 'cancelado', '#808080');

INSERT INTO products (id, name, price) VALUES (1, 'Huevos Revueltos', 5.00);
INSERT INTO products (id, name, price) VALUES (2, 'Huevos Rancheros', 5.00);
INSERT INTO products (id, name, price) VALUES (3, 'Huevos con Chorizo', 5.00);
INSERT INTO products (id, name, price) VALUES (4, 'Huevos con Jamon', 5.00);
INSERT INTO products (id, name, price) VALUES (5, 'Huevos con Tocino', 5.00);
INSERT INTO products (id, name, price) VALUES (6, 'Huevos con Salchicha', 5.00);
INSERT INTO products (id, name, price) VALUES (7, 'Pupusas de Queso', 0.50);

INSERT INTO tables ( capacity, description) VALUES (2, 'Mesa numero 2');