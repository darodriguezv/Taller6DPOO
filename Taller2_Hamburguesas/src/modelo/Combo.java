package modelo;

import java.util.ArrayList;

public class Combo implements Producto{
	//Constructor
	public Combo(String nombre, double descuento) {
		this.nombreCombo = nombre;
		this.descuento = descuento;
	}
	//Atributos
	private double descuento;
	private String nombreCombo;
	private String productos;
	private double precio;
	//Metodos
	public void agregarItemACombo(String itemCombo) {
		if (this.productos == null) {		
		this.productos = itemCombo;
		} else {
			this.productos+= ", " + itemCombo;
		}
	}
	@Override
	public String toString() {
		return this.nombreCombo + ":"  + this.productos + "\t$" + this.getPrecio();
	}
	public void setPrecio(Restaurante restaurante) {
		String[] productosSeparados = this.productos.split(",");
		for(String productoComparar : productosSeparados){
			double priceProducto = restaurante.getPrecioByName(productoComparar);
			this.precio += priceProducto;
		}
		this.precio = ((precio * this.descuento)/100) + precio;
	}
	public String getProductos() {
		return this.productos;
	}
	@Override
	public String getNombre() {
		return this.nombreCombo;
	}
	@Override
	public int getPrecio() {
		return (int)this.precio;
	}
	@Override
	public String generarTextoFactura() {
		return this.nombreCombo + "\t" + this.precio;
	}
	
	
}
