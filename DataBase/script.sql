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
('Alex', 'García', '123', 'ale1@emaiL.com'),
('Elena', 'Pérez', '456', 'elen@email.com'),
('Nuria', 'Segarra', '457', 'nuri@email.com'),
('Carol', 'Hernández', '444', 'caro2@email.com'),
('David', 'López', '789', 'david3@email.com'),
('Laura', 'Martín', '321', 'lauri@email.com');


INSERT INTO Habitos (id_usuario, nombre, meta_diaria) VALUES
(1, 'Beber agua (2L)', 2),
(1, 'Caminar pasos', 10000),
(2, 'Leer páginas', 20),
(2, 'Meditación', 1),
(3, 'Pasos diarios', 10000),
(3, 'Entrenar', 1),
(4, 'Dormir 8h', 1),
(4, 'Sin azúcar', 1),
(5, 'Entrenamiento', 1),
(5, 'Proteína diaria', 120),
(6, 'Cardio', 1),
(6, 'Agua', 2);

INSERT INTO Registro_Habitos (id_habitos, fecha, estado) VALUES
(1, '2026-04-01', 'COMPLETADO'),
(1, '2026-04-02', 'COMPLETADO'),
(1, '2026-04-03', 'FALLIDO'),

(2, '2026-04-01', 'PENDIENTE'),
(2, '2026-04-02', 'COMPLETADO'),

(3, '2026-04-01', 'COMPLETADO'),
(3, '2026-04-02', 'COMPLETADO'),
(3, '2026-04-03', 'COMPLETADO'),

(4, '2026-04-01', 'FALLIDO'),
(4, '2026-04-02', 'COMPLETADO'),

(5, '2026-04-01', 'COMPLETADO'),
(5, '2026-04-02', 'FALLIDO'),

(6, '2026-04-01', 'COMPLETADO'),
(6, '2026-04-02', 'COMPLETADO');

INSERT INTO Ejercicios (nombre, grupo_muscular) VALUES
('Sentadilla Búlgara', 'Pierna'),
('Press Militar', 'Hombro'),
('Peso muerto', 'Espalda/Pierna'),
('Dominadas', 'Espalda'),
('Press banca', 'Pecho'),
('Curl bíceps', 'Bíceps'),
('Fondos', 'Tríceps'),
('Plancha', 'Core');


INSERT INTO Entrenamiento (id_usuario, nombre_entreno) VALUES
(1, 'Full Body - Alex'),
(2, 'Abdomen + Cardio - Elena'),
(3, 'Pierna intensa - Nuria'),
(4, 'Torso - Carol'),
(5, 'Push Day - David'),
(6, 'Cardio + Core - Laura');

INSERT INTO Entrenamiento_Ejercicio 
(id_entrenamiento, id_ejercicios, series, repeticiones) 
VALUES

(1, 1, 4, 12),
(1, 3, 4, 8),
(1, 4, 3, 10),

(2, 8, 3, 60),
(2, 5, 4, 12),

(3, 1, 5, 10),
(3, 3, 4, 6),

(4, 2, 4, 10),
(4, 7, 3, 12);

--CONSULTAS

SELECT * 
FROM Habitos
WHERE id_usuario = 1;


SELECT * FROM Entrenamiento_Ejercicio;


SELECT u.nombre, u.apellido, h.nombre AS habito
FROM Usuario u
JOIN Habitos h ON u.id_usuario = h.id_usuario;

SELECT h.nombre, r.fecha, r.estado
FROM Registro_Habitos r
JOIN Habitos h ON r.id_habitos = h.id_habitos;

SELECT *
FROM Habitos
WHERE nombre LIKE '%agua%';

SELECT *
FROM Ejercicios
WHERE grupo_muscular LIKE '%pierna%';

SELECT 
    e.nombre_entreno,
    ej.nombre AS ejercicio,
    te.series,
    te.repeticiones
FROM Entrenamiento_Ejercicio te
JOIN Entrenamiento e 
    ON te.id_entrenamiento = e.id_entrenamiento
JOIN Ejercicios ej 
    ON te.id_ejercicios = ej.id_ejercicios;

SELECT u.nombre, u.apellido, COUNT(h.id_habitos) AS total_habitos
FROM Usuario u
JOIN Habitos h ON u.id_usuario = h.id_usuario
GROUP BY u.id_usuario;

SELECT estado, COUNT(*) AS total
FROM Registro_Habitos
GROUP BY estado;


SELECT u.nombre, u.apellido, COUNT(*) AS completados
FROM Usuario u
JOIN Habitos h ON u.id_usuario = h.id_usuario
JOIN Registro_Habitos r ON h.id_habitos = r.id_habitos
WHERE r.estado = 'COMPLETADO'
GROUP BY u.id_usuario
ORDER BY completados DESC;

SELECT u.nombre, e.nombre_entreno
FROM Usuario u
JOIN Entrenamiento e ON u.id_usuario = e.id_usuario
WHERE u.id_usuario = 1;


SELECT h.nombre
FROM Habitos h
LEFT JOIN Registro_Habitos r ON h.id_habitos = r.id_habitos
WHERE r.estado IS NULL;

SELECT 
    u.nombre,
    h.nombre AS habito,
    r.estado,
    r.fecha
FROM Usuario u
JOIN Habitos h ON u.id_usuario = h.id_usuario
JOIN Registro_Habitos r ON h.id_habitos = r.id_habitos;

SELECT *
FROM Registro_Habitos
ORDER BY fecha DESC;

SELECT u.nombre, h.nombre
FROM Usuario u
RIGHT JOIN Habitos h ON u.id_usuario = h.id_usuario;


SELECT u.nombre, h.nombre AS habito
FROM Usuario u
INNER JOIN Habitos h ON u.id_usuario = h.id_usuario;

SELECT h.nombre, r.fecha, r.estado
FROM Habitos h
INNER JOIN Registro_Habitos r 
    ON h.id_habitos = r.id_habitos;