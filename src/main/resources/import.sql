
insert into role ( name, enable,create_at) values ( 'Admin', true,now());
insert into role (name, enable,create_at) values ('Chef', true,now());
insert into role (name, enable,create_at) values ('Mesero', true,now());

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
insert into permission (id, name,description,table_name, group_id) values (13, 'WRITE_INVENTARY','Este permiso permite al usuario gestionar la información de inventario','Inventary', 'WRITE');
insert into permission (id, name,description,table_name, group_id) values (14, 'WRITE_PRODUCT','Este permiso permite al usuario  editar de la tabla Producto','Products', 'WRITE');
insert into permission (id, name,description,table_name, group_id) values (15, 'READ_PRODUCT','Este permiso permite al usuario ver o leer información de la tabla permiso','Products', 'READ');

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
insert into permission_role (role_id, permission_id) values (1, 11);
insert into permission_role (role_id, permission_id) values (1, 12);
insert into permission_role (role_id, permission_id) values (1, 13);
insert into permission_role (role_id, permission_id) values (1, 14);
insert into permission_role (role_id, permission_id) values (1, 15);
insert into permission_role (role_id, permission_id) values (2, 8);
insert into permission_role (role_id, permission_id) values (2, 9);
insert into permission_role (role_id, permission_id) values (2, 14);
insert into permission_role (role_id, permission_id) values (2, 15);
insert into permission_role (role_id, permission_id) values (3, 8);
insert into permission_role (role_id, permission_id) values (3, 9);

insert into users(name,last_name,email,phone,username, password, enable, role_id,create_at) values ('Jenniffer','Granados','fiebre.libros@gmail.com','(503) 7714-8798','admin', '$2a$10$eGW9WJuDbUeEfAa060zptusUKtUWZIlra/SBBAG3hfR3Hfn1Y1Age', true, 1,now());
insert into users(name,last_name,email,phone,username, password, enable, role_id,create_at) values ('Ever','Bonilla','test2@gmail.com','(503) 7489-5478','Ever_Bonilla', '$2a$10$eGW9WJuDbUeEfAa060zptusUKtUWZIlra/SBBAG3hfR3Hfn1Y1Age', true, 2,now());
insert into users(name,last_name,email,phone,username, password, enable, role_id,create_at) values ('Fatima','Gomez','jenlisa@gmail.com','(503) 7489-5478','Fatima_Gomez', '$2a$10$eGW9WJuDbUeEfAa060zptusUKtUWZIlra/SBBAG3hfR3Hfn1Y1Age', true, 3,now());

INSERT INTO order_states (id, name, color_hex) VALUES (1, 'Pendiente', '#FF0000');
INSERT INTO order_states (id, name, color_hex) VALUES (2, 'Preparando', '#FFA500');
INSERT INTO order_states (id, name, color_hex) VALUES (3, 'Completado', '#008000');
INSERT INTO order_states (id, name, color_hex) VALUES (4, 'Entregado', '#0000FF');
INSERT INTO order_states (id, name, color_hex) VALUES (5, 'Cancelado', '#808080');
INSERT INTO order_states (id, name, color_hex) VALUES (6, 'Pagado', '#213487');

insert into Category (name) values ('Desayuno');
insert into Category (name) values ('Almuerzo');
insert into Category (name) values ('Cena');
insert into Category (name) values ('Bebidas');
insert into Category (name) values ('Postres');
insert into Category (name) values ('Entradas');

INSERT INTO products ( name, price,category_id) VALUES ( 'Huevos Revueltos', 5.00,1);
INSERT INTO products ( name, price,category_id) VALUES ( 'Huevos Rancheros', 5.00,1);
INSERT INTO products ( name, price,category_id) VALUES ( 'Huevos con Chorizo', 5.00,1);
INSERT INTO products ( name, price,category_id) VALUES ( 'Huevos con Jamon', 5.00,1);
INSERT INTO products ( name, price,category_id) VALUES ( 'Huevos con Tocino', 5.00,1);
INSERT INTO products ( name, price,category_id) VALUES ( 'Huevos con Salchicha', 5.00,1);
INSERT INTO products ( name, price,category_id) VALUES ( 'Pupusas de Queso', 0.50,1);

INSERT INTO tables ( capacity, description) VALUES (2, 'Mesa numero 2');
INSERT INTO tables ( capacity, description) VALUES (2, 'Mesa numero 2');

insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-05-02 23:18:09.354146','Orden 01 del mes 05',1,3,25.5,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-05-14 23:18:09.354146','Orden 02 del mes 05',2,3,24,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-05-21 23:18:09.354146','Orden 03 del mes 05',3,3,9.99,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-06-08 23:18:09.354146','Orden 01 del mes 06',1,3,25.5,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-07-09 23:18:09.354146','Orden 01 del mes 07',1,3,10.8,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-07-12 23:18:09.354146','Orden 02 del mes 07',2,3,48.2,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-07-15 23:18:09.354146','Orden 03 del mes 07',3,3,14.5,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-07-29 23:18:09.354146','Orden 04 del mes 07',4,3,23,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-08-15 23:18:09.354146','Orden 01 del mes 08',1,3,19.99,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-08-16 23:18:09.354146','Orden 02 del mes 08',2,3,35.18,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-09-03 23:18:09.354146','Orden  01 del mes 09',1,3,20.15,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-09-15 23:18:09.354146','Orden 02 del mes 09',2,3,26.48,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-09-26 23:18:09.354146','Orden 03 del mes 09',3,3,16.5,6,1);
insert into orders (create_at, description, number_order, quantity, total, state_id, table_id)values ('2023-10-01 23:18:09.354146','Orden 01 del mes 10',1,3,47.25,6,1);


INSERT INTO ingredient (min_stock,name, is_countable,create_at) VALUES (10,'Huevos', true,now());
INSERT INTO ingredient (min_stock,name, is_countable,create_at) VALUES (5,'Sal', false,now());
INSERT INTO ingredient (min_stock,name, is_countable,create_at) VALUES (5,'Pimienta', false,now());
INSERT INTO ingredient (min_stock,name, is_countable,create_at) VALUES (15,'Tortillas de Maíz', true,now());
INSERT INTO ingredient (min_stock,name, is_countable,create_at) VALUES (15,'Salsa de Tomate', true,now());
INSERT INTO ingredient (min_stock,name, is_countable,create_at) VALUES (5,'Frijoles Refritos', true,now());
INSERT INTO ingredient (min_stock,name, is_countable,create_at) VALUES (10,'Chorizo', true,now());
INSERT INTO ingredient (min_stock,name, is_countable,create_at) VALUES (10,'Jamón', true,now());
INSERT INTO ingredient (min_stock,name, is_countable,create_at) VALUES (10,'Tocino', true,now());
INSERT INTO ingredient (min_stock,name, is_countable,create_at) VALUES (10,'Salchicha', true,now());
INSERT INTO ingredient (min_stock,name, is_countable,create_at) VALUES (5,'Masa de Maíz', false,now());
INSERT INTO ingredient (min_stock,name, is_countable,create_at) VALUES (5,'Queso', true,now());

INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (2, 1, 1);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (1, 2, 1);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (1, 3, 1);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (2, 1, 2);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (2, 2, 2);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (1, 3, 2);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (1, 4, 2);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (1, 5, 2);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (1, 6, 2);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (2, 1, 3);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (1, 7, 3);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (2, 1, 4);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (1, 8, 4);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (2, 1, 5);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (1, 9, 5);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (2, 1, 6);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (1, 10, 6);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (2, 11, 7);
INSERT INTO ingredient_detail (quantity, ingredient_id, product_id) VALUES (1, 12, 7);

INSERT INTO inventory ( is_active,create_at) VALUES (true,now());
INSERT INTO inventory_detail (quantity, price, is_entry,create_at,ingredient_id, inventory_id) VALUES (100, 0.50, true,now(),1,1);
INSERT INTO inventory_detail (quantity, price, is_entry,create_at,ingredient_id, inventory_id) VALUES (10, 0.15, true,now(),2,1);
INSERT INTO inventory_detail (quantity, price, is_entry,create_at,ingredient_id, inventory_id) VALUES (10, 1.50, true,now(),3,1);
INSERT INTO inventory_detail (quantity, price, is_entry,create_at,ingredient_id, inventory_id) VALUES (100, 0.75, true,now(),4,1);
INSERT INTO inventory_detail (quantity, price, is_entry,create_at,ingredient_id, inventory_id) VALUES (25, 0.50, true,now(),5,1);
INSERT INTO inventory_detail (quantity, price, is_entry,create_at,ingredient_id, inventory_id) VALUES (20, 0.50, true,now(),6,1);
INSERT INTO inventory_detail (quantity, price, is_entry,create_at,ingredient_id, inventory_id) VALUES (100, 0.50, true,now(),7,1);
INSERT INTO inventory_detail (quantity, price, is_entry,create_at,ingredient_id, inventory_id) VALUES (40, 3, true,now(),8,1);
INSERT INTO inventory_detail (quantity, price, is_entry,create_at,ingredient_id, inventory_id) VALUES (50, 1.50, true,now(),9,1);
INSERT INTO inventory_detail (quantity, price, is_entry,create_at,ingredient_id, inventory_id) VALUES (30, 1.0, true,now(),10,1);
INSERT INTO inventory_detail (quantity, price, is_entry,create_at,ingredient_id, inventory_id) VALUES (40, 0.50, true,now(),11,1);
INSERT INTO inventory_detail (quantity, price, is_entry,create_at,ingredient_id, inventory_id) VALUES (10, 2.25, true,now(),12,1);

