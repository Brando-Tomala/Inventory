# API REST INVENTORY

### Logica:
Este servicio permitira la administracion de los empleados vacunados como no vacunados de la empresa **KRUGER**
------------------------------------------------------------------------------------------------------------

## Desplegar Servicio
Antes de desplegar el servicio se debe considerar la instalaccion de las siguientes herramientas:
* [JDK11] (https://adoptopenjdk.net/)
* [Maven] (https://maven.apache.org/download.cgi)
* [Docker] (https://docs.docker.com/desktop/windows/install/)

Una vez instaladas las herramientas se procede a:
1. Crear una carpeta vacia
1. Descargar del repositorio [GitHub]() en la carpeta
2. Una vez descargado abrir una terminal en la direccion de la carpeta
3. Ejecutar los siguientes comandos
    * mvn clean install
4. En la raiz del proyecto de encuentran dos archivos:
    * Dockerfile
    * docker-compose.yml
5. En la terminal se debe ejecutar el siguiente comando
    **docker-compose up -d**, el cual levantara el servicio en modo background
6. Para comprobar que el servicio se levanto, ejecutar el siguiente comando:
    * docker ps, el cual le mostrara dos contenedores:
        1. Base de datos
        2. Servicio de Spring Boot
7. Para poder visualizar la documentacion de Swagger, se debe dirigir a la siguente [ruta](http://localhost:8090/api/v1/swagger-ui.html)
8. Le pedira un usuario y contraseña:
    * *usuario*: kruger
    * *contraseña*: kruger
9. Podra ejecutar los servicios.

