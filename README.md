# MÍNIMO 1 - QT23 - Andrei Piposi

Este ejercicio trata sobre la construcción de una prueba piloto del motor de juego. Cada versión del proyecto se centra en agregar nuevas características y mejoras. A continuación, se describen las versiones y lo que se ha realizado en cada una.

## Versión 1

En esta versión inicial, el proyecto se ha intentado hacer lo siguiente:

Parte 1:
- Estrucutra de clases básicas.
- Implementación de la fachada.
- Manager con los métodos básicos.

Parte 2:
- Nada.

## Versión 2

En la versión 2, se agregaron las siguientes mejoras y que sean funcionales:

Parte 1:
- Se ha implementado el método `Creación de un juego` en la clase ManagerImpl.


- Se ha implementado el método `Inicio de una partida de un juego por parte de un usuario` en la clase ManagerImpl.


- Se ha implementado el método `Consulta del nivel actual` en la clase ManagerImpl.


- Se ha implementado el método `Consulta de la puntuación actual` en la clase ManagerImpl.


- Se ha implementado el método `Pasar el nivel` en la clase ManagerImpl.


- Se ha implementado el método `Finalizar la partida` en la clase ManagerImpl.


- Se ha implementado el método `Consulta de usuarios que han participado en un juego ordenado por puntuación` en la clase ManagerImpl.


- Se ha implementado el método `Consulta de las partidas en las que ha participado un usuario` en la clase ManagerImpl.


- Todos los métodos deberán tener una TRAZA (a nivel de INFO) de LOG4J que muestre el valor de los parámetros al inicio de los métodos y
  al final. También debe contemplarse trazas de otros niveles (ERROR o FATAL) se ha REALIZADO.


- Implementación de los testos de las clases ManagerImpl y ManagerImplTest. Cuatro operaciones han sido testeadas.



Parte 2:

- Se ha conseguido que se pueda acceder a la documentación de la API REST a través de la URL: http://localhost:8080/swagger/.

- Se ha creado una clase Services para poder implementar los métodos de la API REST. Como POST, GET, PUT.



## Errores encontrados y observaciones sobre el ejercicio

- Hay alguna método que no se ha implementado correctamente, como por ejemplo el método `Consulta de usuarios que han participado en un juego ordenado por puntuación'. No se ha probado ordenar los usuarios por puntuación.


- El Swagger da un error en cuando queremos hacer un Try it out! en todos los métodos. El error es el siguiente: `500 Internal Server Error`. No se ha conseguido solucionar este error.


- Observaciones que se han visto, por ejemplo, que se podria hacer el ejercicio con HashMaps en vez de con ArrayLists. Pero se ha decidido hacerlo con ArrayLists porque no daba tantos errores.
  Pero se que podria ser una mejor implementación utilizar HashMaps porque es más eficiente y más rápido.


- Respecto a la Versión 1 a la 2 hay muchos cambios porque se ha intentado hacer de diferentes maneras, como por ejemplo, con HashMaps que se ha comentado anteriormente.
  Pero se ha optado al final por esta manera porque no daba tantos errores y se veia de una manera más sencilla de hacer (aunque no sea la mejor manera de hacerlo).

