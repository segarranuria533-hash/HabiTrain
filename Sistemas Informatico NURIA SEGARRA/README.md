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
* Admin: acceso total a la base de datos y archivos
* Usuario: Solo puede ejecutar la APP

- Estructura de Carpetas 

src: Contiene el código fuente organizado en paquetes (DAO, Model, Controller).

xml: Ubicación de los archivos de intercambio de datos (habitrain.xml y habitrain.xsd).

database o sql: Almacena el script de creación de la base de datos para despliegue inicial.

readme.md: Carpeta donde reside este informe técnico y manuales de usuario.

He establecido un protocolo de copias de seguridad lógicas mediante SQL. El administrador realiza exportaciones manuales semanales utulizando la herramienta phpMyAdmin. (Evidencia en el archivo habitrain.sql)