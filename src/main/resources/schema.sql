CREATE TABLE IF NOT EXISTS
personaje(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR2(100),
    roles VARCHAR2(80),
    dificultad VARCHAR2(60),
    PRIMARY KEY (id));