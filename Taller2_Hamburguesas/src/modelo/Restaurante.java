package modelo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import procesamiento.LoaderHamburguesas;


public class Restaurante {
	//Atributos
	private Pedido pedidoEnCurso;
	private ArrayList<ProductoMenu> productos;
	private ArrayList<Combo> combos;
	private ArrayList<Ingrediente> ingredientes;

	//Constructor
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		Pedido pedido = new Pedido(nombreCliente, direccionCliente);	
		this.pedidoEnCurso = pedido;
	}
	//Metodos
	public void cerrarPedido() {
		this.pedidoEnCurso = null;
	}
	public Pedido getPedidoEnCurso() {
		return this.pedidoEnCurso;
	}
	public ArrayList<ProductoMenu> getMenuBase(){
		return this.productos;
	}
	public ArrayList<Ingrediente> getIngredientes(){
		return this.ingredientes;
	}
	public ArrayList<Combo> getCombos(){
		return this.combos;
	}
	public int getPrecioByName(String nombreProducto) {
		int precio = 0;
		for(ProductoMenu producto: this.getMenuBase()) {
			String nombre = producto.getNombre();
			if (nombre.equalsIgnoreCase(nombreProducto)){
				precio = producto.getPrecio();
				return precio;
			}
		}
		return precio;
	}
	public void cargarInformacionRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos) throws FileNotFoundException, IOException, IngredienteRepetidoException, ProductoRepetidoException {
		this.ingredientes = LoaderHamburguesas.leerInfoArchivoIngredientes(archivoIngredientes);
		this.productos = LoaderHamburguesas.leerInfoArchivoProductosMenu(archivoMenu);
		this.combos = LoaderHamburguesas.leerInfoArchivoCombos(archivoCombos, this.productos);
		

	}
	
}
