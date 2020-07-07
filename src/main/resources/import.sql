/* Populate Car table */

INSERT INTO regions(id, name) VALUES (1, 'Europe')
INSERT INTO regions(id, name) VALUES (2, 'Asia')
INSERT INTO regions(id, name) VALUES (3, 'Africa')
INSERT INTO regions(id, name) VALUES (4, 'Oceania')
INSERT INTO regions(id, name) VALUES (5, 'South America')
INSERT INTO regions(id, name) VALUES (6, 'Central America')
INSERT INTO regions(id, name) VALUES (7, 'North America')

INSERT INTO cars (name, brand, create_at, region_id) VALUES ('A1', 'Audi', '2020-02-02', 1);
INSERT INTO cars (name, brand, create_at, region_id) VALUES ('A2', 'Audi', '2020-02-05', 1);
INSERT INTO cars (name, brand, create_at, region_id) VALUES ('A3', 'Audi', '2020-02-03', 1);
INSERT INTO cars (name, brand, create_at, region_id) VALUES ('A4', 'Audi', '2020-02-06', 1);
INSERT INTO cars (name, brand, create_at, region_id) VALUES ('A5', 'Audi', '2020-02-01', 1);
INSERT INTO cars (name, brand, create_at, region_id) VALUES ('Serie 1', 'BMW', '2020-03-01', 2);
INSERT INTO cars (name, brand, create_at, region_id) VALUES ('Serie 2', 'BMW', '2020-03-05', 2);
INSERT INTO cars (name, brand, create_at, region_id) VALUES ('Serie 3', 'BMW', '2020-03-11', 3);
INSERT INTO cars (name, brand, create_at, region_id) VALUES ('Serie 4', 'BMW', '2020-03-21', 4);
INSERT INTO cars (name, brand, create_at, region_id) VALUES ('Clase C Coupé', 'Mercedes', '2020-01-17', 1);
INSERT INTO cars (name, brand, create_at, region_id) VALUES ('Leon', 'SEAT', '2020-04-12', 7);

INSERT INTO `users` (username, password, enabled, name, surname, email) VALUES ('carlos', '$2a$10$tZP9JpyvJ1IKSet/xz5O9.24jfk8m8UmGCJV2oejf66MKzf.ItTym', 1, 'Carlos', 'Martinez', 'carlos@carlos.es');
INSERT INTO `users` (username, password, enabled, name, surname, email) VALUES ('admin', '$2a$10$afgrsG2oo9KTeCHbIhD2ruobbtJ16hjXonhNrMztaCfaxTRkCEZSG', 1, 'admin', 'admin', 'admin@admin.es');

INSERT INTO `roles` (name) VALUES ('ROLE_USER');
INSERT INTO `roles` (name) VALUES ('ROLE_ADMIN');

INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 1);