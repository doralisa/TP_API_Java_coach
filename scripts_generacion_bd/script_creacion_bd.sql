create table niveles
(
    id_nivel     int          not null
        primary key,
    nombre_nivel varchar(255) null
);

create table capitulos
(
    id_capitulo     int auto_increment
        primary key,
    numero_capitulo int         not null,
    nombre_capitulo varchar(50) not null,
    id_nivel        int         null,
    constraint numero_capitulo
        unique (numero_capitulo),
    constraint capitulos_ibfk_1
        foreign key (id_nivel) references niveles (id_nivel)
);

create index id_nivel
    on capitulos (id_nivel);

create table conceptos
(
    id_concepto        int auto_increment
        primary key,
    nombre_concepto    varchar(50) null,
    id_capitulo        int         null,
    numero_concepto    int         null,
    contenido_concepto longtext    null,
    id_pregunta        bigint      null,
    constraint conceptos_ibfk_1
        foreign key (id_capitulo) references capitulos (id_capitulo)
);

create index id_capitulo
    on conceptos (id_capitulo);

create table ejemplos
(
    id_ejemplos         int auto_increment
        primary key,
    contenido_ejemplo   varchar(255) null,
    descripcion_ejemplo varchar(255) null,
    id_concepto         int          null,
    constraint ejemplos_ibfk_1
        foreign key (id_concepto) references conceptos (id_concepto),
    constraint FKcep9ko130cqpf7r94qkea7s4r
        foreign key (id_concepto) references ejemplos (id_ejemplos)
);

create table preguntas
(
    id_pregunta        int auto_increment
        primary key,
    contenido_pregunta varchar(255) not null,
    id_concepto        int          not null,
    constraint preguntas_ibfk_1
        foreign key (id_concepto) references conceptos (id_concepto),
    constraint fk_preguntas_conceptos
        foreign key (id_concepto) references capitulos (id_capitulo)
);

create table respuestas
(
    id_respuesta         int auto_increment
        primary key,
    contenido_respuestas varchar(255) not null,
    id_pregunta          int          not null,
    es_correcta          tinyint      not null,
    constraint respuestas_ibfk_1
        foreign key (id_pregunta) references preguntas (id_pregunta)
);

alter table preguntas
    add constraint FKqn31cakafd7t34yord3pt8qne
        foreign key (id_pregunta) references respuestas (id_respuesta);

create index id_pregunta
    on respuestas (id_pregunta);

create table usuarios
(
    id_usuario       int auto_increment
        primary key,
    nombre_usuario   varchar(50)  null,
    contrasenia      varchar(10)  null,
    nombre           varchar(50)  null,
    apellido         varchar(50)  null,
    fecha_nacimiento date         null,
    email            varchar(100) null,
    telefono         varchar(30)  null,
    id_nivel         int          null,
    constraint email
        unique (email),
    constraint nombre_usuario
        unique (nombre_usuario),
    constraint usuarios_ibfk_1
        foreign key (id_nivel) references niveles (id_nivel)
);

create index id_nivel
    on usuarios (id_nivel);


