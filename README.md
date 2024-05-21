# examenLeo

# #####################################################################################################################
### Guia como realiar peticiones mediante Postman

                                      Leonel Sangolquiza 5to A Matutino:
Autor:                                      

* [Consultar todos los autores metodo GET](http://localhost:8010/apiLeo/autor)
* [Insertar autores metodo POST --->](http://localhost:8010/apiLeo/autor)
{
  "idAutor": 0,
  "nameAutor": "Julio ",
  "ageAutor": 55,
  "enable": true,
  "fnacimientoAutor": "2024-17-21T07:26:01.708Z"
}
* [Eliminar autores metodo DELETE ](http://localhost:8010/apiLeo/autor/id)

Libro:

* [Consultar todos los libros metodo GET](http://localhost:8010/apiLeo/autor)
* [Insertar autores metodo POST --->](http://localhost:8010/apiLeo/autor)
{
  "idLibro": 0,
  "titleLibro": "Viaje al Centro de la Tierra",
  "yearPubLibro": 2015,
  "fechaCreationDate": "2024-05-21T07:33:28.961Z",
  "categoria": {
    "idAutor": 0
  }
}
* [Eliminar autores metodo DELETE ](http://localhost:8010/apiLeo/autor/id)