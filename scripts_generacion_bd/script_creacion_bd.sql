drop database bot_java_coach;
create database if not exists bot_java_coach;
use bot_java_coach;

-- NIVELES --
CREATE TABLE if not exists Niveles (
    id_nivel int NOT null PRIMARY KEY,
    nombre_nivel varchar(255)
);

-- CAPITULOS --
create table if not exists Capitulos(
    id_capitulo int NOT null auto_increment primary key,
    numero_capitulo int not null unique,
    nombre_capitulo varchar(50) not null,
    id_nivel int,
    foreign key (id_nivel) references Niveles(id_nivel)
);

-- USUARIOS --
CREATE table if not exists Usuarios(
    id_usuario INT NOT null AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario varchar(50) UNIQUE,
    contrasenia varchar(10),
    nombre varchar(50),
    apellido varchar(50),
    fecha_nacimiento date,
    email varchar(100) UNIQUE,
    telefono varchar(30),
    id_nivel int,
    foreign key (id_nivel) references Niveles(id_nivel)
);

-- CONCEPTOS --
CREATE TABLE if not exists Conceptos (
    id_concepto int NOT null auto_increment PRIMARY key, 
    nombre_concepto varchar(50),
    id_capitulo int,
    FOREIGN KEY (id_capitulo) REFERENCES Capitulos(id_capitulo),
    numero_concepto int,
    contenido_concepto LONGTEXT
);

-- EJEMPLOS --
CREATE TABLE if not exists Ejemplos (
    id_ejemplos int NOT null PRIMARY key auto_increment,
    contenido_ejemplo varchar(255),
    descripcion_ejemplo varchar(255),
    id_concepto int,
    FOREIGN key (id_concepto) REFERENCES Conceptos(id_concepto)
);

-- PREGUNTAS --
CREATE TABLE if not exists Preguntas (
    id_pregunta int NOT null PRIMARY key auto_increment,
    contenido_pregunta varchar(255) not null,
    id_concepto int not null,
    FOREIGN KEY (id_concepto) REFERENCES Conceptos(id_concepto)
);

-- RESPUESTAS --
CREATE TABLE if not exists Respuestas (
    id_respuesta int NOT null PRIMARY key auto_increment,
    contenido_respuestas varchar(255) not null,
    id_pregunta int not null,
    FOREIGN KEY (id_pregunta) REFERENCES Preguntas(id_pregunta),
    es_correcta boolean not null    
);


