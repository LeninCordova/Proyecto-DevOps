package MongoDB;

import com.mongodb.client.MongoClients;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.connection.Connection;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;


import java.util.logging.Level;

@SuppressWarnings("deprecation")
public class Conexion {
	MongoDatabase DB;
	MongoCollection<Document> collection;
	Document datos = new Document();
	
	public Conexion() {
		try {
			MongoClient cliente = MongoClients.create();
			DB = cliente.getDatabase("proyecto");
			collection = DB.getCollection("usuarios");
			System.out.println("Conectado a la base de datos");
		}catch(Exception ex) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public void insertar(Datos persona) {
		datos = datos.append("Nombre", persona.getNombre())
				.append("Apellido1", persona.getApellido1())
				.append("Apellido2", persona.getApellido2())
				.append("Sexo", persona.getSexo())
				.append("Edad", persona.getEdad());
		collection.insertOne(datos);
		comprobar(persona, datos, collection);
	}
	public static void comprobar(Datos persona, Document datos, MongoCollection<Document> coleccion) {
		String nombre = persona.getNombre();
		String ap1 = persona.getApellido1();
		List<Document> query = (List<Document>) coleccion.find(and(eq("Nombre", nombre), eq("Apellido1",ap1))).into(new ArrayList<Document>());
		System.out.println(query.toString());
		System.out.println("Usuario insertado");
	}
}
