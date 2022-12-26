# demo-repository
Demo project

Crear una aplicación web para el control de accesos a una entidad empresarial. 
Al llegar el visitante a la entidad se le solicita los documentos de identificación y de estos se toman los siguientes datos:

1-	Nombre completo y apellidos.

2-	Número de carnet de identidad o pasaporte según corresponda.

3-	Dirección particular.

Al visitante se le solicita además que informe a que departamento va dirigido, persona a la que visita y el motivo de la visita. 

Al visitante se le toma una foto para completar el registro y el sistema guarda automáticamente la fecha y la hora de la entrada del visitante.

Al visitante se le entrega una credencial con un número único.

Al retirarse de la entidad el visitante debe devolver la credencial y el sistema registra la fecha y la hora de la salida.

El sistema debe ser capaz de crear reportes sobre el control de visitantes, estos reportes son:

1-	Listado de todos los visitantes. Nombres y apellidos, departamento a visitar, nombre de la persona a visitar, fecha y hora de ingreso a la entidad, fecha y hora de salida de la entidad.

2-	Cantidad de visitantes en un rango de fechas o de horas o una combinación de ambas.

3-	Listado de visitantes con todos los datos del reporte uno, pero por un rango de fechas o de horas o una combinación de ambas.

4-	Listado de todos los visitantes con los datos del reporte 1 pero por departamentos visitados, persona visitada perteneciente a ese departamento y por un rango de fechas o de horas o una combinación de ambas.
El sistema persiste toda la información en base de datos relacional.

