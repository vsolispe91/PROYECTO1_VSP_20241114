# PROYECTO1
PROYECTO1 ENTREGABLE DIA 14 11 2024

Proyecto (Trantando de ser breve y directo, pero dado la embergadura del proyecto se ha hecho un poco largo).

Descripcion: Consta basicamente de cuatro microservicios o unidades de negocio (accountservice, creditservice, customer, transactionservice). 

Objetos:

UML:
-DiagramaSecuenciaAPPBanco_GENERALSISTEMA.drawio
-DiagramaSecuenciaAPPBanco_PORMICROSERVICIO.drawio  
-UMLAPPBanco.drawio 
-DIAGRAMADESECUENCIAAPPBANCARIO_GENERALSISTEMA.png 
-DIAGRAMASECUENCIAAPPBANCARIO_PORMICROSERVICIO.png 

contratos (open api diseño de app a nivel de interface rest):
-accounts.yml
-credits.yml
-customers.yml
-transactions.yml

App (codigo fuente):
-accountservice
-creditservice
-customer
-transactionservice

Avances por dia:

Primer avance (Dia 11-11-2024) -Diagrama UML -Diagrama de Secuencia

Segundo avance (Dia 12-11-2024) - Unidades de servicio accountservice, creditservice, customer. -Mejoras Diagramas UML y Secuencia. -Contratos no integrados de Open Api para las unidades de negocio.

Tercer avance (Dia 13-11-2024) - Se agrega la Unidad de servicio transactionservice, se agregan las funcionalidades obligatorias requeridas, se finalizan el diagrama UML y los diagramas de secuencia, se agrega LockBack y comentarios a uno de los proyectos.

Cuarto dia avance (Dia 14-11-2024) - Se generan los contraton open api en limpio y se hacen ultimos ajustes a los proyectos.

Otras consideraciones adicionales:

NO hay orquestacion de servicios, deberia realizarse con Kafka o con algun sistema de orquestacion. 
Para las funcionalidades requeridas se presentan metodos que se van a ir desarrollando.
CRUD completo por microservicio.
Consideradas las reglas de negocio.
Considerados metodos adicionales como retiro, pago, consulta de movimientos etc.
Queeda pendiente la integracion de Open api con las capas de servicio de cada microservicio, se integrara para la siguiente presentacion.
Se usa mongodb, database perservice LockBack log (acccuntservice) y otras caracteristicas.
