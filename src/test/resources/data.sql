INSERT INTO criaturas VALUES
(NULL, 'Griffin', 'humanoide'),
(NULL, 'Jessie', 'humanoide'),
(NULL, 'Choncc', 'monstro'),
(NULL, 'Kleber', 'humanoide'),
(NULL, 'Guaxi', 'besta');

INSERT INTO usuarios VALUES
(NULL, 'user', '$2a$10$MZYOt.MJWagXfhtytOlOVOXYetA7fQnyWQjidHW.qgbTfTHdyBe52'),
(NULL, 'dungeonmaster', '$2a$10$ZI4nLiDut1vk8K.Qug22yOH.F5pzpvXLSKIVrNXRYMsZSBDK3S7WC');

INSERT INTO roles VALUES
(NULL, 'ROLE_USER'),
(NULL, 'ROLE_ADMIN');

INSERT INTO usuarios_roles VALUES
(1, 1),
(2, 1),
(2, 2);