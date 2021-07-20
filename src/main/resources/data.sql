INSERT INTO DISTRICT(id, name, value_m2) VALUES(1, 'Aruã', '2000.0');
INSERT INTO DISTRICT(id, name, value_m2) VALUES(2, 'Brasilândia ', '1500.0');
INSERT INTO DISTRICT(id, name, value_m2) VALUES(3, 'Cachoeirinha', '1600.0');
INSERT INTO DISTRICT(id, name, value_m2) VALUES(4, 'Dom Pedro 2', '1900.0');
INSERT INTO DISTRICT(id, name, value_m2) VALUES(5, 'Eliza Maria', '1400.0');
INSERT INTO DISTRICT(id, name, value_m2) VALUES(6, 'Faria Lima', '12000.0');
INSERT INTO DISTRICT(id, name, value_m2) VALUES(7, 'Guaianazes', '1900.0');
INSERT INTO DISTRICT(id, name, value_m2) VALUES(8, 'Heliópolis', '1800.0');
INSERT INTO DISTRICT(id, name, value_m2) VALUES(9, 'Indianápolis', '1900.0');
INSERT INTO DISTRICT(id, name, value_m2) VALUES(10, 'Jardim Europa', '9366.0');

INSERT INTO PROPERTY(id, name, district_id) VALUES(1, 'Apartamento Duplex', '6');
INSERT INTO PROPERTY(id, name, district_id) VALUES(2, 'Casa', '2');
INSERT INTO PROPERTY(id, name, district_id) VALUES(3, 'Apartamento Triplex', '1');
INSERT INTO PROPERTY(id, name, district_id) VALUES(4, 'Apartamento Duplex', '9');
INSERT INTO PROPERTY(id, name, district_id) VALUES(5, 'Apartamento', '5');
INSERT INTO PROPERTY(id, name, district_id) VALUES(6, 'Apartamento Studio', '8');
INSERT INTO PROPERTY(id, name, district_id) VALUES(7, 'Apartamento Loft', '3');
INSERT INTO PROPERTY(id, name, district_id) VALUES(8, 'Apartamento República', '7');
INSERT INTO PROPERTY(id, name, district_id) VALUES(9, 'Cobertura', '6');
INSERT INTO PROPERTY(id, name, district_id) VALUES(10, 'Cobertura Duplex', '10');

INSERT INTO ROOM(id, name, length, width, property_id) VALUES(1, 'Banheiro', 5, 5, 1);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(2, 'Quarto', 15, 1, 1);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(3, 'Sala',20, 15, 1);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(4, 'Cozinha',25, 20, 1);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(5, 'Suite', 30, 25, 1);

INSERT INTO ROOM(id, name, length, width, property_id) VALUES(6, 'Banheiro', 5, 5, 2);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(7, 'Quarta', 15, 1, 2);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(8, 'Sala', 20, 15, 2);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(9, 'Cozinha', 25, 20, 2);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(10, 'Suite Master', 30, 25, 2);

INSERT INTO ROOM(id, name, length, width, property_id) VALUES(11, 'Banheiro', 5, 5, 3);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(12, 'Quarto', 15, 1, 3);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(13, 'Sala', 20, 15, 3);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(14, 'Cozinha', 25, 20, 3);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(15, 'Quarto Casal', 30, 25, 3);

INSERT INTO ROOM(id, name, length, width, property_id) VALUES(16, 'Banheiro', 5, 5, 4);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(17, 'Quarto', 15, 1, 4);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(18, 'Sala', 20, 15, 4);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(19, 'Cozinha', 25, 20, 4);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(20, 'Sala Jantar', 30, 25, 4);

INSERT INTO ROOM(id, name, length, width, property_id) VALUES(21, 'Banheiro', 5, 5, 5);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(22, 'Quarto', 15, 1, 5);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(23, 'Sala', 20, 15, 5);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(24, 'Academia', 25, 20, 5);
INSERT INTO ROOM(id, name, length, width, property_id) VALUES(25, 'Escritório', 30, 25, 5);