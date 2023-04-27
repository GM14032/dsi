
insert into roles (id, name, enable) values (1, 'ROLE_ADMIN', true);

insert into permissions (id, name, enable) values (1, 'READ_USER', true);
insert into permissions (id, name, enable) values (2, 'WRITE_USER', true);
insert into permissions (id, name, enable) values (3, 'DELETE_USER', true);

insert into permissions_roles (role_id, permission_id) values (1, 1);
insert into permissions_roles (role_id, permission_id) values (1, 2);
insert into permissions_roles (role_id, permission_id) values (1, 3);

insert into users (username, password, enable, role_id) values ('admin', '$2a$10$eGW9WJuDbUeEfAa060zptusUKtUWZIlra/SBBAG3hfR3Hfn1Y1Age', true, 1);

