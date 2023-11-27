package modelo;

public class ProductoMenu implements Producto {
	//Constructor
	public ProductoMenu(String nombre, int precioBase){
		this.nombre = nombre;
		this.precioBase = precioBase;
	}
	//Atributos
	private String nombre;
	private int precioBase;
	
	//Metodos
	public void setPrecio(double precio) {
		this.precioBase += precio;
	}
	@Override
	public String getNombre(){
		return this.nombre;
	}
	@Override
	public int getPrecio() {
		return this.precioBase;
	}
	@Override
	public String generarTextoFactura() {
		return this.nombre + "\t$" + this.precioBase;
	}
	@Override
	public String toString() {
		return this.nombre + "\t$" + this.precioBase;
	}
	
}
