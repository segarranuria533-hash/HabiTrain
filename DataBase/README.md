
HABITRAIN

 Análisis de Datos: Plataforma de Hábitos Saludables y Entrenamiento


1.1. Descripción del Problema
La aplicación busca ayudar a los usuarios a mejorar su calidad de vida mediante el seguimiento de hábitos diarios (beber agua, dormir, meditar) y la creación de rutinas de entrenamiento personalizadas. El sistema debe permitir que cada usuario gestione su propio progreso y organice sus ejercicios de forma estructurada.

1.2. Entidades Identificadas

Usuario:


Representa a la persona que utiliza la aplicación.
Es la entidad central del sistema, ya que toda la información está asociada a un usuario.

Hábito:

Define una acción que el usuario desea repetir de forma periódica (ej. beber agua, meditar, hacer ejercicio).

Cada hábito pertenece a un usuario y puede ser evaluado diariamente.

Registro_Hábitos:

Entidad que almacena el historial de cumplimiento de los hábitos.
Permite saber si un hábito ha sido realizado en una fecha concreta.
No basta con definir el hábito, es necesario registrar su seguimiento en el tiempo.

Entrenamiento:

Representa un conjunto de ejercicios organizados por el usuario (ej. “Rutina de Pierna”, “Entrenamiento Full Body”).
Cada entrenamiento es creado y gestionado por un usuario.

Ejercicio:

Elemento básico de un entrenamiento.
Contiene la información de cada actividad física (ej. flexiones, sentadillas, correr).
Un ejercicio puede formar parte de varios entrenamientos. 


1.3. Relaciones y Reglas de Negocio

El diseño se basa en las siguientes reglas:
Un Usuario tiene muchos Hábitos (1:N)

Cada usuario puede crear múltiples hábitos personalizados.
Si un usuario se elimina, sus hábitos también deben eliminarse (borrado en cascada).

Un Hábito tiene muchos Registros_Hábitos (1:N)


Un hábito genera múltiples registros a lo largo del tiempo.
Cada registro representa si el hábito fue completado en una fecha concreta.


Un Usuario tiene muchos Entrenamientos (1:N)
Cada usuario puede crear y gestionar sus propios entrenamientos.
Relación Muchos a Muchos (N:M) entre Entrenamiento y Ejercicio
Un entrenamiento puede contener varios ejercicios, y un mismo ejercicio puede pertenecer a distintos entrenamientos.

Para resolver esta relación se utilizará una tabla intermedia (por ejemplo: entrenamiento_ejercicio) que permitirá almacenar información adicional como:

Número de series 
Número de repeticiones      
