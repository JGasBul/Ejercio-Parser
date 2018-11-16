package parser_persona;

import java.io.Serializable;

public class Persona implements Serializable {

	private String nombre = null;
	private int edad = 0;

	public Persona() {
	}

	public Persona(String n, int e) {
		nombre = n;
		edad = e;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setNombre(String n) {
		nombre = n;
	}

	public void setEdad(int e) {
		edad = e;
	}

	public void print() {
		System.out.println("Nombre: " + nombre + " y edad " + edad);
	}

}
