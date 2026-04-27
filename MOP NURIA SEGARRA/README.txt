HabiTrain---- Apartado de Programación


La aplicación permite gestionar usuarios, hábitos y entrenamientos con conexión a base de datos MySQL.


1. Programación


Funcionalidades
CRUD de usuarios
CRUD de hábitos
Registro de progreso
Gestión de entrenamientos
Asignación de ejercicios


Se utiliza MySQL con JDBC.


La APP permite:
 Gestión de usuarios
 -Crear usuarios
 -Listar usuarios
 -Eliminar usuarios

 Gestión de  hábitos
 - Crear hábitos asociados a un usuario 
 - Listar hábitos por usuario
 -Eliminar hábitos
 -registrar progreso( completado, pendiente, fallido )

Gestión de entrenamientos
-Crear entrenamientos por usuario
-Listar entrenamientos
-Añadir ejercicios  a un entrenamiento

Gestión de ejercicios
-crear ejercicios
-Listar ejercicios disponibles 
-Asignar ejercicios a entrenamientos con series y repeticiones


2. POO (MEJORAS)
Se ha realizado una mejora estructural en el proyecto mediante la incorporación  de una clase SERVICE, que actua como intermediaria entre el Main y el DAO
El objetivo de la mejora es separar la lógica del acceso a la base de datos para mejorar la organización del proyecto  
Estructura del Proyecto:

model--> Clases que representan las entidades del sistema (usuarios,hábitos,ejercicios, etc)
dao--> Clases encargadas del acceso a la base de datos (CRUD con SQL)
database--> Clase de conexión a MySQL
main--> Menú principal de la APP
service -->
