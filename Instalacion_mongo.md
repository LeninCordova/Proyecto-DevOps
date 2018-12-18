                  Instalación de Mongo Db
1.-
Autentificamos los paquetos de sofware que a sido firmada con llaves gpg.
- sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv EA312927

2.-
Este comando nos sirve para agregar los repositorios, para que apt sepa dónde tiene que descargar los paquetes.
- echo "deb http://repo.mongodb.org/apt/ubuntu xenial/mongodb-org/3.2 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.2.list

3.-
Para agregar los detalles de repositorio y actualizar la lista de paquetes.
- sudo apt-get update

4.-
Instalará los diversos paquetes, incluyendo la versión mas reciente, seguido de herramientas de iniciativas para el servidor.
- sudo apt-get install -y mongodb-org

5.-
Crear un archivo de unitario para administrar el servicio de mongoDB. Que le dice a system como administrar los servicios.
- sudo nano /etc/systemd/system/mongodb.service

6.-
Editamos el archivo que hemos creado.

**

[Unit]

Description=High-performance, schema-free document-oriented database
After=network.target

[Service]

User=mongodb
ExecStart=/usr/bin/mongod --quiet --config /etc/mongod.conf

[Install]

WantedBy=multi-user.target

**

- La sección UNIT contiene un resumen, y las dependencias que deben de existir antes de que el servicio inicie(en nuestro caso mongo DB depende de que la red este disponible).

- La sección SERVICE indica como deberia iniciar el servicio

-la directiva "user" significa que debe correr con el usuario "mongobd".

-Y "ExecStart" inicia el comando para arrancar el servidor mongodb.

- La sección INSTALL le dice a system cuando el servicio debe iniciar automaticamente, es un sistema de secuencia de arranque estándar.

7.-
sirve para iniciar la base de datos de mongoDB
- sudo systemctl start mongodb

8.-
para ver el estado de mongoDB
- sudo systemctl status mongodb

9.-
Esto sirve para habilitar automáticamente el arranque de mongo.
- sudo systemctl enable mongodb

