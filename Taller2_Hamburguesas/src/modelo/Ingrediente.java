package modelo;

public class Ingrediente {
	//Constructor
	public Ingrediente(String nombre, int costoAdicional) {
		this.nombre = nombre;
		this.costoAdicional = costoAdicional;
	}
	//Atributos
	private String nombre;
	private int costoAdicional;
	
	//Metodos
	public String getNombre() {
		return this.nombre;
	}
	public int getCostoAdicional() {
		return this.costoAdicional;
	}
	public String toString() {
		return this.nombre + "\t$" + costoAdicional;
	}
}
