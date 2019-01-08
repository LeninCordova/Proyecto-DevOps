package MongoDB;

public class Datos {
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private int Edad;
	private String Sexo;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido1() {
		return Apellido1;
	}
	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}
	public String getApellido2() {
		return Apellido2;
	}
	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public void mostrarPersona(Datos persona) {
		String nombre = persona.getNombre();
		String ap1 = persona.getApellido1();
		String ap2 = persona.getApellido2();
		String sexo = persona.getSexo();
		int edad = persona.getEdad();
		System.out.println("Me llamo "+nombre+" "+ap1+" "+ap2+" soy "+sexo+" y tengo "+edad+" años.");
	}
	
}