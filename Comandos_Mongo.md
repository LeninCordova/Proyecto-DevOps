    COMANDOS PARA CREAR UNA BASE DE DATOS MONGO DB
Que es mongo?
Mongodb es un tipo de base de datos NoSQL, orientada a documentos.

Comandos de creación de una base de datos en mongodb:

Para crear una base de datos con Mongodb, primero hay que levantar el servidor y despues hay que abrir el cliente para poder realizar los comandos para la creación de la base de datos.

| Descripción | Comando | Ejemplo|
|-------------|----------|----------|
| Como crear una bd | use [nombre bd]|use appjava|
| Como crear un documento | db.[nombre coleccion].insert({ })|db.usuarios.insert({[aqui se ponen los datos que se quieren insertar]	})|
|Como añadir una coleccion|db.createCollection("nombre coleccion")|db.createCollection("productos")|
|Como ver las colecciones que tenemos|show collections||
|Como eliminar una colección|db.[nombre coleccion].drop()|db.productos.drop()|
|Como elminiar una base de datos*|db.dropDatabase()||
|Como ver los datos que contiene una colección|db.[nombre colección].find().pretty()*|db.usuarios.find().pretty()|
|Como editar un documento|db.[nombre colección].update({},{})|db.produto.update({ "id": "1"},{$set: {'valor' :20.45} })*|
|Como eliminar un parametro de un documento|db.[nombre colección].deleteOne({[parametro del documento que se va a borrar]})|db.producto.deleteOne({id: "1"})|

Para eliminar una base de datos, primero hay que asegurarse que estamos en esa base de datos, porque sino podemos borrar otra base de datos que no queremos borrar. Por eso antes de ejecutar el comando de la tabla, es aconsejable ejecutar el comando use [nombrebd] para asegurarse de que estamos en la base de datos que queremos borrar.Para comprobar que se ha borrado correctamente, se ejecuta el comando show dbs.

El parametro pretty()sirve para que los datos de la colección salgan ordenados y sea mas facil reconocer los datos. También se puede ejecutar la orden sin el parametro.

Entre los primeros cocrhetes se identifica que id se quiere modificar, en este caso el 1. Entre los segundos valores se especifica que parametro se quiere modificar, en este caso es el parametro 'valor', que se cambia el dato a 20.45.

- - -

**Comandos de consultas de una base de datos en mongodb**

| Descripción | Comando | Ejemplo |
|-------------|----------|----------|
|Consulta general|db.[nombre colección].find().pretty()|db.producto.find().pretty()|
|Consulta de valor específico|db.[nombre colección].findOne().pretty()|db.producto.findOne().pretty()|

**Dentro del propio comando find() podemos añadir condiciones para afinar la busqueda dentro de nuestras colecciones. De esta forma la consulta puede ser más rápida y selectiva**

| Descripción | Comando | Ejemplo |
|-------------|----------|----------|
|Valor especificado|db.[nombre colección].find({[valor]})|db.producto.find({"valor": 15.0})|
|Igualdad|db.[nombre colección].find({[valor]})|db.producto.find({"valor": 0})|
|Menor Que|db.[nombre colección].find({[valor]})|db.producto.find({"valor": {$lt: 15.0}})|
|Menor o Igual Que|db.[nombre colección].find({[valor]})|db.producto.find({"valor": {$lte: 16.0}})|
|Mayor Que|db.[nombre colección].find({[valor]})|db.producto.find({"valor": {$gt: 18.0}})|
|Mayor o Igual Que|db.[nombre colección].find({[valor]})|db.producto.find({"valor": {$gte: 16.0}})|
|No es Igual|db.[nombre colección].find({[valor]})|db.producto.find({"valor": {$ne: 0}})|
|AND|db.[nombre colección].find({[valor]})|db.producto.find({{key1: valor1, key2: valor2}})|
|OR|db.[nombre colección].find({[valor]})|db.producto.find({{$or: [{key1: valor1}, {key2: valor2}]}})|
|AND + OR|db.[nombre colección].find({[valor]})|db.producto.find({key1: valor1, $or: [{key2: {$lt: valor2},{key3: valor3}}]})|
