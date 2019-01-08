package MongoDB;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		//Constructor del objeto persona
		Datos persona = new Datos();
		//Recibe un booleando para comprobar si se han introducido los daots
		boolean ok = recibirDatos(persona);
		if (ok) {	//Si los datos estan introducidos llama al constructor de Conexion
			Conexion conection = new Conexion();
			conection.insertar(persona);
		}
	}
	
	public static boolean recibirDatos(Datos persona) {
		boolean ok = false; //Se inicializa un variable booleana para comprobar que los datos son válidos
		String nombre = "";
		String ap1 = "";
		String ap2 = "";
		String sexo = "";
		String edadRecibida = "";
		int edad = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(!ok) {
			System.out.println("Introduce tu nombre:");
			nombre = sc.nextLine();
			System.out.println("Introduce tu primer apellido:");
			ap1 = sc.nextLine();
			System.out.println("Introduce tu segundo apellido (opcional):");
			ap2 = sc.nextLine();
			System.out.println("żEres hombre o mujer?");
			sexo = sc.nextLine();
			System.out.println("żQué edad tienes?");
			edadRecibida = sc.nextLine();
			if (edadRecibida == "" || edadRecibida == " ") {
				edad = -1;
			}
			else {
				edad = Integer.parseInt(edadRecibida);
			}
			ok = comprobarDatos(ok, nombre, ap1, ap2, sexo, edad);
		}
		if (ok) {
			construirPerfil(nombre, ap1, ap2, sexo, edad, persona);
		}
		return ok;
	}
	
	public static boolean comprobarDatos (boolean resultado, String nombre, String ap1, String ap2, String sexo, int edad) {
		if (!resultado) {
			if ((nombre == "" || nombre == " ") || (ap1 == "" || ap1 == " ") || (sexo == "" || sexo == " ") || (edad <= 0)) {
				System.out.println("Valores inválidos, por favor vuelve a introducir tus datos");
			}
			else if(!sexo.equals("hombre") && !sexo.equals("mujer")) {
				System.out.println("Valores inválidos, por favor vuelve a introducir tus datos");
			}
			else {
				resultado = true;
				System.out.println("Datos válidos");
			}
		}
		return resultado;
	}
	
	public static void construirPerfil (String nombre, String ap1, String ap2, String sexo, int edad, Datos persona) {
		persona.setNombre(nombre);
		persona.setApellido1(ap1);
		persona.setApellido2(ap2);
		persona.setSexo(sexo);
		persona.setEdad(edad);
		persona.mostrarPersona(persona);
	}
}