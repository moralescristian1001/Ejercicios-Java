package ejercicios;

import java.util.Date;

public class Alumno extends Persona {
	
	private Persona persona;
	private Integer legajo;

	public Alumno() {
	}

	public Alumno(TipoDocumento tipoDocumento, Integer nroDocumento, String nombre, String apellido, Date fechaNacimiento, Persona persona, Integer legajo) {
		super(tipoDocumento, nroDocumento, nombre, apellido, fechaNacimiento);
		this.persona = persona;
		this.legajo = legajo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
}
