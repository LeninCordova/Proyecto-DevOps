**_DOCKER_**

**Que es DOCKER?**

Docker es un programa de código abierto que permite que una aplicación Linux y sus dependencias se empaqueten como un contenedor.

La virtualización basada en contenedores aísla las aplicaciones entre sí en un sistema operativo (OS) compartido. Este enfoque estandariza la entrega del programa de la aplicación, permitiendo que las aplicaciones se ejecuten en cualquier entorno Linux, ya sea físico o virtual. Dado que comparten el mismo sistema operativo, los contenedores son portátiles entre diferentes distribuciones de Linux, y son significativamente más pequeños que las imágenes de máquinas virtuales (VM).

Docker compite con contenedores de aplicaciones propietarias, como VMware vApp y herramientas de abstracción de infraestructura, como Chef.

**_Instalacion de Docker_**

**1.	Vamos hacer una instalacion en Centos7(64bits).**

-	Primero, vamos a actualizar la base de datos del paquete:

        sudo yum check-update

-	Ahora ejecuta este comando. Agregará el repositorio oficial de Docker, descargará la última versión de Docker e instalará:

        curl -fsSL https://get.docker.com/ | sh

- Una vez completada la instalación, inicie el demonio Docker:

        sudo systemctl start docker

-	Verifique que se está ejecutando:

        sudo systemctl status docker

-	La salida debe ser similar a la siguiente, mostrando que el servicio está activo y en ejecución:

        docker.service - Docker Application Container Engine
        Loaded: loaded (/lib/systemd/system/docker.service; enabled; vendor preset: enabled)
        Active: active (running) since Sun 2016-05-01 06:53:52 CDT; 1 weeks 3 days ago
            Docs: https://docs.docker.com
        Main PID: 749 (docker)

-	Por último, asegúrese de que se inicie en cada reinicio del servidor:

        sudo systemctl enable docker

**2. Ejecutar el comando Docker sin Sudo (opcional)**

- De forma predeterminada, la ejecución del dockercomando requiere privilegios de raíz, es decir, tiene que prefijar el comando con sudo. También puede ser ejecutado por un usuario en el grupo de ventana acoplable , que se crea automáticamente durante la instalación de Docker.

        Output
        docker: Cannot connect to the Docker daemon. Is the docker daemon running on this host?.
        See 'docker run --help'.


	
- Si desea evitar escribir sudocuando ejecuta el dockercomando, agregue su nombre de usuario al grupo de docker:

        sudo usermod -aG docker $(whoami)

- Deberá cerrar la sesión de Droplet y volver a iniciarla como el mismo usuario para habilitar este cambio.
Si necesita agregar un usuario al dockergrupo en el que no ha iniciado sesión, declare ese nombre de usuario explícitamente mediante

        sudo usermod -aG docker username

**3. Uso del comando Docker**

- El uso dockerconsiste en pasarle una cadena de opciones y subcomandos seguidos de argumentos. La sintaxis toma esta forma:

        docker [option] [command] [arguments]

- Para ver todos los subcomandos disponibles, escriba:

        docker

- Para ver los interruptores disponibles para un comando específico, escriba:

        docker docker-subcommand --help

- Para ver información de todo el sistema, use:

        docker info

**4. Trabajar con imágenes Docker**

Los contenedores Docker se ejecutan desde imágenes Docker. De manera predeterminada, extrae estas imágenes de Docker Hub, un registro de Docker administrado por Docker, la compañía detrás del proyecto Docker. Cualquiera puede construir y alojar sus imágenes de Docker en Docker Hub, por lo que la mayoría de las aplicaciones y distribuciones de Linux que necesitará para ejecutar los contenedores de Docker tienen imágenes que están alojadas en Docker Hub.

- Para comprobar si puede acceder y descargar imágenes desde Docker Hub, escriba:

        docker run hello-world

- La salida, que debe incluir lo siguiente, debe indicar que Docker funciona correctamente:

        Output
        Hello from Docker.
        This message shows that your installation appears to be working correctly.
        ...

           

- Puede buscar imágenes disponibles en Docker Hub usando el dockercomando con el searchsubcomando. Por ejemplo, para buscar la imagen de CentOS, escriba:

        docker search centos

- La secuencia de comandos rastreará Docker Hub y devolverá una lista de todas las imágenes cuyo nombre coincida con la cadena de búsqueda. En este caso, la salida será similar a esta:

        Output
        NAME                            DESCRIPTION                                     STARS     OFFICIAL   AUTOMATED
        centos                          The official build of CentOS.                   2224      [OK]       
        jdeathe/centos-ssh              CentOS-6 6.7 x86_64 / CentOS-7 7.2.1511 x8...   22                   [OK]
        jdeathe/centos-ssh-apache-php   CentOS-6 6.7 x86_64 / Apache / PHP / PHP M...   17                   [OK]
        million12/centos-supervisor     Base CentOS-7 with supervisord launcher, h...   11                   [OK]
        nimmis/java-centos              This is docker images of CentOS 7 with dif...   10                   [OK]
        torusware/speedus-centos        Always updated official CentOS docker imag...   8                    [OK]
        nickistre/centos-lamp           LAMP on centos setup                            3                    [OK]

        ...

- En la columna OFICIAL , OK indica una imagen construida y respaldada por la compañía detrás del proyecto. Una vez que haya identificado la imagen que le gustaría usar, puede descargarla en su computadora usando el pullsubcomando, así:

        docker pull centos

- Después de descargar una imagen, puede ejecutar un contenedor utilizando la imagen descargada con el runsubcomando. Si no se ha descargado una imagen cuando dockerse ejecuta con el runsubcomando, el cliente Docker primero descargará la imagen y luego ejecutará un contenedor usándola:

        docker run centos

- Para ver las imágenes que se han descargado en su computadora, escriba:

        docker images

- La salida debe ser similar a la siguiente:

        [secondary_lable Output]
        REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
        centos              latest              778a53015523        5 weeks ago         196.7 MB
        hello-world         latest              94df4f0ce8a4        2 weeks ago         967 B

**5. Ejecutar un contenedor Docker**

El hello-worldcontenedor que ejecutó en el paso anterior es un ejemplo de un contenedor que se ejecuta y sale, después de emitir un mensaje de prueba. Los contenedores, sin embargo, pueden ser mucho más útiles que eso, y pueden ser interactivos. Después de todo, son similares a las máquinas virtuales, pero son más amigables con los recursos.
- Como ejemplo, ejecutemos un contenedor utilizando la última imagen de CentOS. La combinación de los conmutadores -i y -t le da acceso de shell interactivo al contenedor:

        docker run -it centos

- Su línea de comandos debe cambiar para reflejar el hecho de que ahora está trabajando dentro del contenedor y debe tomar esta forma:

        Output
        [root@59839a1b7de2 /]#

Importante: tenga en cuenta la identificación del contenedor en el símbolo del sistema. En el ejemplo anterior, es 59839a1b7de2.

- Ahora puedes ejecutar cualquier comando dentro del contenedor. Por ejemplo, instalemos el servidor MariaDB en el contenedor en ejecución. No es necesario prefijar ningún comando con sudo, porque está operando dentro del contenedor con privilegios de root:

        yum install mariadb-server

 **6. Confirmación de cambios en un contenedor a una imagen de Docker**

Cuando inicia una imagen de Docker, puede crear, modificar y eliminar archivos de la misma manera que con una máquina virtual. Los cambios que realice solo se aplicarán a ese contenedor. Puede iniciarlo y detenerlo, pero una vez que lo destruya con el docker rmcomando, los cambios se perderán para siempre.

Esta sección le muestra cómo guardar el estado de un contenedor como una nueva imagen de Docker.

Después de instalar el servidor MariaDB dentro del contenedor CentOS, ahora tiene un contenedor que se ejecuta en una imagen, pero el contenedor es diferente de la imagen que usó para crearla.

- Para guardar el estado del contenedor como una nueva imagen, primero salga de él:

        exit
- Luego confirme los cambios en una nueva instancia de imagen de Docker usando el siguiente comando. El modificador -m es para el mensaje de confirmación que le ayuda a usted y a otros a saber qué cambios realizó, mientras que -a se usa para especificar el autor. El ID del contenedor es el que anotó anteriormente en el tutorial cuando inició la sesión de docker interactiva. A menos que haya creado repositorios adicionales en Docker Hub, el repositorio suele ser su nombre de usuario de Docker Hub:

        docker commit -m "What did you do to the image" -a "Author Name" container-id repository/new_image_name

        Por ejemplo:

        docker commit -m "added mariadb-server" -a "Sunday Ogwu-Chinuwa" 59839a1b7de2 finid/centos-mariadb
Nota: Cuando confirma una imagen, la nueva imagen se guarda localmente, es decir, en su computadora. Más adelante en este tutorial, aprenderá cómo incluir una imagen en un registro de Docker como Docker Hub para que usted y otros puedan evaluarla y utilizarla.

- Una vez que se haya completado esa operación, la lista de las imágenes de Docker ahora en su computadora debe mostrar la nueva imagen, así como la anterior de la que se derivó:

        docker images
La salida debe ser de este tipo:

        Output
        REPOSITORY             TAG                 IMAGE ID            CREATED             SIZE
        finid/centos-mariadb   latest              23390430ec73        6 seconds ago       424.6 MB
        centos                 latest              778a53015523        5 weeks ago         196.7 MB
        hello-world            latest              94df4f0ce8a4        2 weeks ago         967 B
- En el ejemplo anterior, centos-mariadb es la nueva imagen, que se derivó de la imagen existente de CentOS de Docker Hub. La diferencia de tamaño refleja los cambios que se hicieron. Y en este ejemplo, el cambio fue que se instaló el servidor MariaDB. Entonces, la próxima vez que necesite ejecutar un contenedor con CentOS con el servidor MariaDB preinstalado, puede usar la nueva imagen. Las imágenes también se pueden construir a partir de lo que se llama un Dockerfile. Pero ese es un proceso muy complejo que está fuera del alcance de este artículo. Lo exploraremos en un futuro artículo.

**7. Listado de contenedores Docker**

Después de usar Docker por un tiempo, tendrás muchos contenedores activos (en ejecución) e inactivos en tu computadora. Para ver los activos, usa:

        docker ps
Verá una salida similar a la siguiente:

        Output
        CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS              PORTS               NAMES
        f7c79cc556dd        centos              "/bin/bash"         3 hours ago         Up 3 hours                              silly_spence
- Para ver todos los contenedores, activos e inactivos, pásale el -ainterruptor:

        docker ps -a
- Para ver el último contenedor que creó, pásele el -linterruptor:

        docker ps -l
- Detener un contenedor activo o en ejecución es tan simple como escribir:

        docker stop container-id
        El container-idse puede encontrar en la salida del docker pscomando.

**8. Empujar imágenes de Docker a un repositorio de Docker**

El siguiente paso lógico después de crear una nueva imagen a partir de una imagen existente es compartirla con algunos de sus amigos, todo el mundo en Docker Hub u otro registro de Docker al que tenga acceso. Para enviar una imagen a Docker Hub o cualquier otro registro de Docker, debe tener una cuenta allí.

Esta sección le muestra cómo empujar una imagen de Docker a Docker Hub.

- Para crear una cuenta en Docker Hub, regístrese en Docker Hub . Luego, para empujar su imagen, primero inicie sesión en Docker Hub. Se le pedirá que se autentique:

        docker login -u docker-registry-username
- Si ha especificado la contraseña correcta, la autenticación debería tener éxito. Luego puedes empujar tu propia imagen usando:

        docker push docker-registry-username/docker-image-name
- Tardará un tiempo en completarse, y cuando se complete, la salida será de este tipo:

        Output
        The push refers to a repository [docker.io/finid/centos-mariadb]
        670194edfaf5: Pushed 
        5f70bf18a086: Mounted from library/centos 
        6a6c96337be1: Mounted from library/centos

        ...

- Después de insertar una imagen en un registro, debe aparecer en el tablero de su cuenta, como se muestra en la imagen a continuación.