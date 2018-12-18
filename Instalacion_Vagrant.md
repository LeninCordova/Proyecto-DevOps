**INSTALACION DE VAGRANT**

Que es vagrant?

Vagrant es una herramienta gratuita de línea de comandos, disponible para Windows, MacOS X y GNU/Linux, que permite generar entornos de desarrollo reproducibles y compartibles de forma muy sencilla. Para ello, Vagrant crea y configura máquinas virtuales a partir de simples ficheros de configuración.

Basta con compartir el fichero de configuración de Vagrant (llamado “Vagrantfile”) con otro desarrollador para que, con un simple comando, pueda reproducir el mismo entorno de desarrollo. Esto es especialmente útil en equipos formados por varias personas, ya que asegura que todos los desarrolladores tienen el mismo entorno, con las mismas dependencias y configuración.

Además, dado que la configuración de la máquina virtual es un simple fichero de texto plano, podemos incluir este fichero en nuestro repositorio en el control de versiones, junto con el resto del código del proyecto. De esta manera, un nuevo desarrollador que se incorpore al equipo simplemente tendrá que clonar el repositorio del proyecto y ejecutar Vagrant para tener el entorno de desarrollo montado y funcionando en cuestión de minutos.

Por defecto, Vagrant utiliza VirtualBox como motor de máquinas virtuales, aunque existe la opción de utilizar VMWare Workstation (Windows) o VMWare Fusion (MacOS X) con un plugin de pago.

**_Instalacion de vagrant y proeevedor de maquinas virtuales_**

1.	Primero necesitamos un proveedor de máquinas virtuales, ya que vagrant no es una máquina virtual, por eso necesita un proveedor de máquinas virtuales.
Se puede hacer con Hyper-V (para Windows), Docker, VMWare, Virtual box(en mi caso).

•	Para eso vamos a la página de virtual box.

(https://www.virtualbox.org/wiki/Downloads)

•	Y descargamos el paquete de la plataforma que estemos trabajando ya sea para Windows, Linux, OS X, Solaris.

2.	Después vamos a instalar Vagrant para tu SO.

•	Elegimos el SO que estemos utilizando y muy importante saber si es de 32 o 64 bits.

(https://www.vagrantup.com/downloads.html)

3.	Después vamos a crear  una máquina virtual con Vagrant.

•	Creamos una carpeta en el escritorio (en mi caso), ya que vagrant crea archivos.

•	Abrimos un cmd, terminal (para Linux), o PowerShell (para Windows).

•	Para ver la versión de vagrant escribimos en tu terminal:

-vagrant –v        
-vagrant versión.

•	Luego escribimos en el terminal (dentro de la carpeta que hemos creado):

-vagrant init

•	Se va a crear un archivo

-VAGRANTFILE.

•	Vamos a editar ese archivo para levantar nuestra maquina:

-nano vagrantfile.

•	Después de estar dentro del archivo vamos a la línea.

-Config.vm.box=”Ubuntu/trusty64” (en mi caso voy a instalar ubuntu14).

-en este link se puede ver todas las box que hay :
(https://app.vagrantup.com/boxes/search)

•	Después utilizamos el comando para interactuar con nuestro proveedor (en mi caso virtual box):

-Vagrant up

•	Luego para entrar en la máquina y nos dé una Shell lo hacemos mediante:

-Vagrant ssh

•	Estamos dentro de la máquina y ya podemos interactuar con ella, instalaciones, configuraciones, etc.

•	Para salir de la maquina:

-Exit o logout

•	Para detener nuestra maquina:

-Vagrant halt

•	Para borrar o ‘matar’ la maquina:

-Vagrant destroy


