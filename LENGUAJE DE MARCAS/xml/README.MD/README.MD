GESTIÓN DE DATOS XML- HABITRAIN

1. Datos Representados
El archivo habitrain.xml contiene la estructura completa de los usurios: 
- datos personales
- hábitos personalizados
- registro de entrenamientos
 
 permite la exportación de perfiles y la consolidación de la app.

2. Validación (xsd)
El habitrain.xsd garantiza la integridad de los datos mediante:
- Tipos: Control de datos númericos (int), fechas (date), y texto (String)
- Restricciones: El campo <estado> solo permite: COMPLETADO, PENDIENTE O FALLIDO 
- Cardinalidad: Estructura obligatoria de usuarios con sus respectivos bloques de datos 

3. Evidencia de funcionamiento 
En la carpeta /xml se incluyen evidencias de validación en VSC:
1. Validación OK: cumpliendo el panel limpio de "Problems"
2. Validación error: Captura demostrando que el XSD detecta datos erroneos 
