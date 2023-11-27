package modelo;

public class ProductoAjustado implements Producto {
	//Constructor
	public ProductoAjustado(ProductoMenu base) {
		this.nombre = base.getNombre();
		this.precio = base.getPrecio();	
	}
	//Atributos
	private String nombre;
	private int precio;
	
	//Metodos
	public void ajustarPrecio(double precioAdicional) {
		this.precio += precioAdicional;
	}
	@Override
	public String getNombre(){
		return this.nombre;
	}
	@Override
	public int getPrecio() {
		return this.precio;
	}
	@Override
	public String generarTextoFactura() {
		return this.nombre + "-" + this.precio;
	}
	

}
