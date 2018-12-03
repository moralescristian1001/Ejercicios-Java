package ejercicios;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A. Crear una clase Persona con los siguientes campos
 * (con sus respectivos getters, setters y constructor)
 * 
 * TipoDocumento - enum (dni/libretacivica) 
 * NroDocumento - Integer
 * Nombre - String
 * Apellido - String
 * FechaNacimiento - Date
 * 
 * B. En el método main de la clase "Ejercicio2" crear una nueva instancia
 * de la clase persona y settearle valores reales con tus datos
 * 
 *  
 * C. En el método main de la clase "Ejercicio 2" imprimir los valores en 
 * consola 
 * (crear método main e imprimir valores) 
 *  
 * @author examen
 *
 */
public class Ejercicio2 {

	/**
	 * 
	 */
	public Ejercicio2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Persona persona = new Persona(TipoDocumento.DNI, 1017264978, "Cristian", "Morales", new Date(908896210000L));
		imprimir(persona);
	}
	
	public static void imprimir(Persona persona) {
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(persona.getTipoDocumento()+"\n"+
				persona.getNroDocumento()+"\n"+
				persona.getNombre()+"\n"+
				persona.getApellido()+"\n"+
				formateador.format(persona.getFechaNacimiento()));
	}

}
