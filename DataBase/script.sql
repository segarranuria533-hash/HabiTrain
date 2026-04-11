CREATE DATABASE HabiTrain; 

CREATE TABLE Usuario(
    id_usuario int primary key auto_increment,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    email   VARCHAR(100) UNIQUE NOT NULL,
    fecha_registro  DATETIME  default current_timestamp
    );

CREATE TABLE Habitos(
    id_habitos int primary key auto_increment,
    id_usuario int not null,
    nombre VARCHAR(100) NOT NULL,
    meta_diaria int,
    foreign key(id_usuario) references Usuario(id_usuario) on delete cascade 
);

CREATE TABLE Registro_Habitos(
    id_registro_habitos int auto_increment primary key,
    id_habitos int not null,
    fecha DATE NOT NULL,
    estado ENUM ('COMPLETADO', 'PENDIENTE','FALLIDO') default 'COMPLETADO',
     foreign key (id_habitos) references Habitos (id_habitos) on delete cascade

);

CREATE TABLE Entrenamiento (
    id_entrenamiento int auto_increment primary key,
    id_usuario int not null,
    nombre_entreno VARCHAR(100) NOT null,
    foreign key (id_usuario) references Usuario (id_usuario) on delete cascade
);

CREATE TABLE Ejercicios(
    id_ejercicios int auto_increment primary key,
    nombre VARCHAR (100) not null,
    grupo_muscular VARCHAR(100)
);

CREATE TABLE Entrenamiento_Ejercicio(
    id_entrenamiento int not null,
    id_ejercicios  int not null,
    series int,
    repeticiones int,
    primary key (id_entrenamiento, id_ejercicios),
    foreign key (id_entrenamiento) references Entrenamiento(id_entrenamiento) on delete cascade,
    foreign key (id_ejercicios) references Ejercicios(id_ejercicios) on delete cascade
);




DATOS DE PRUEBAS (INSERTS)

INSERT INTO Usuario (nombre, apellido, contrasena, email) VALUES 
('Alex', 'García', '123', 'alex1@email.com'),
('Elena', 'Pérez', '456', 'elena@email.com'),
('Nuria', 'Segarra', '457', 'nuria@email.com'),
('Carol', 'Hernandez', '444', 'carol@email.com');


INSERT INTO Habitos (id_usuario, nombre, meta_diaria) VALUES
(1, 'Beber  2L de agua (Litros)', 3),
(2, 'Leer 20 páginas', 1), 
(3, 'Pasos diarios', 10000),
(4, 'Dormir 8 horas', 1); 

INSERT INTO Ejercicios (nombre, grupo_muscular)VALUES
('Sentadilla Búlgara', 'Pierna'),
('Press Militar', 'Hombro'),
('Peso muerto', 'Espalda/Pierna'),
('Dominadas', 'Espalda');


INSERT INTO Entrenamiento(id_usuario, nombre_entreno)VALUES
(3, 'Full body Nuria'),
(4, 'Torso-Pierna Carol');

INSERT INTO Entrenamiento_Ejercicio (id_entrenamiento,id_ejercicios, series,repeticiones)VALUES
(2,2,4,10),
(2,4,3,8);  
