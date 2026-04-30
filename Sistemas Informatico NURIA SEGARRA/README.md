Informe Técnico de ENTORNO DE EJECUCIÓN HabiTrain

1. Tipo de Sistema:

Tipo de equipo : PC de Usuario 

* Justificación: Como es una APP de gestión personal de hábitos y entrenamientos con interfaz de consola y conexión local, un PC es lo ideal.
Se recomienda un servidor local de base de datos, como por ejemplo XAMPP/MYSQL, para centralizar la información si hubiera varios usuarios en una sola red local.

2. Requisitos de HARDWARE
______________________________________________________________________
|Componente    |  Requisito Minimo    |  Recomendado                  |
|              |                      |                               |
|   CPU        |   Dual Core 2.0 GHz  |Quad Core 2.5 GHz o superior   |
|   RAM        |       4GB            | 8 GB para fluidez             |
|ALMACENAMIENTO|    500 MG LIBRES     | 2GB para crecimiento de la BD |
|ARQUITECTURA  |    64BITS            | 64BITS                        |
______________________________________________________________________|

3. SISTEMA OPERATIVO :
* Sistema:
- Windows 10/11 
- Distribuciones Linux (Ubutu)

Se elige Windows por ser el entorno de desarrollo principal y por la facilidad de uso de herramientas como XAMPP para la base de datos.Pero al ser JAVA multiplataforma, funcionará en cualquier sistema con la JVM instalada 

4. Instalación del entorno : 

1. Instalar Java JDK 17 o superior: Necesario para jcutar el código compilado. 
2. Instalar MySQL (o XAMPP): para gestionar la base de datos HabiTrain.

3. Configurar la base de datos: 
 * Importar archivo script_habitrain.sql proporcionado en el proyecto 
 * Asegurar que el puerto 3307 esté abierto. 
 4. Ejecutar el JAR 

 5. Usuarios, permisos y estructura:

- Usuarios del Sistema:

* Administrador
Acceso total a la aplicación
gestiona usuarios, datos y configuración
Puede ver y restaurar copias de seguridad
*  Usuario 
Puede crear, editar y consultar sus propios datos
No puede acceder a configuración del sistema
No puede gestionar otros usuarios

- Estructura de Carpetas 

src: Contiene el código fuente organizado en paquetes (DAO, Model, Controller, Main, Service ).

xml: Ubicación de los archivos de intercambio de datos (habitrain.xml y habitrain.xsd).

database : Almacena el script de creación de la base de datos para despliegue inicial.

readme.md: Carpeta donde reside este informe técnico y manuales de usuario.

Copias de Seguridad: 

He establecido un protocolo de copias de seguridad lógicas mediante SQL. El administrador realiza exportaciones manuales semanales utilizando la herramienta phpMyAdmin. (Evidencia en el archivo habitrain.sql)

6. Mantenimiento 
Que se debe actualizar: 

- Código fuente: mejoras, corrección de errores y optimización del rendimiento
- Base de datos: actualización de estructuras, índices y limpieza de datos obsoletos
- Dependencias/librerías: actualización de frameworks y bibliotecas para mantener la compatibilidad y seguridad
- Archivos de configuración: ajustes en entornos (producción, desarrollo, pruebas)
- Sistema de copias de seguridad: verificación de su correcto funcionamiento
 
 Cada cuanto se debe actualizar: 

1. Correcciones de errores: inmediatamente tras su detección
2. Pequeñas mejoras: de forma mensual o continua
3. Actualizaciones del sistema o librerías: cada 3–6 meses
4. Copias de seguridad de la base de datos: semanalmente (mínimo)
5. Revisión general del sistema: cada 2–3 meses
 
Que se deberia revisar: 

* Funcionamiento correcto de la aplicación web (pantallas y formularios)
* Estado de la conexión con la base de datos
* Errores registrados en logs del servidor
* Integridad de los datos almacenados
* Correcta validación de archivos XML (habitrain.xml y habitrain.xsd)
* Seguridad de usuarios y permisos (roles)
* Rendimiento de consultas SQL y carga de páginas

Qué hacer si falla el sistema:

En caso de fallo o error en la aplicación, se deben seguir estos pasos:

1. Detectar el problema
- Revisar mensajes de error del navegador o del servidor
- Identificar si el fallo es de base de datos, código o servidor
2. Consultar logs del sistema
- Analizar los registros del servidor web para localizar el error
3. Comprobar la base de datos
- Verificar conexión y estado del servicio
- Revisar posibles errores en consultas SQL
4. Restaurar copia de seguridad
- Importar el último archivo .sql disponible
- Comprobar que los datos se recuperan correctamente
5. Corregir el error
- Aplicar cambios en código, configuración o base de datos
6. Verificar funcionamiento
- Comprobar que la aplicación vuelve a funcionar correctamente
7. Registrar la incidencia
Documentar el fallo y la solución aplicada para futuras referencias