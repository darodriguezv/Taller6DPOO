package modelo;

import java.io.File;
import java.util.ArrayList;

public class Pedido {
	//Atributos
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> productosPedido = new ArrayList<>();;
	private ArrayList<Ingrediente> adiciones = new ArrayList<>();;
	private int numeroPedidos;
	//Metodos
	public int getId() {
		return this.idPedido;
	}
	public void agregarProducto(Producto nuevoItem) throws PedidoLimiteException {
		int precioNuevo = this.getPrecioNetoPedido() + nuevoItem.getPrecio();
		if(precioNuevo > 150000) {
			throw new PedidoLimiteException("El pedido excede el monto permitido", precioNuevo);
		}else {
			productosPedido.add(nuevoItem);
		}
		
	}
	public void agregarIngrediente(Ingrediente nuevoIngrediente, ProductoMenu productoCambiar) {
		ProductoAjustado productoAdiciones = new ProductoAjustado(productoCambiar);
		for(Producto productos : this.productosPedido) {
			if (productos.getNombre() == productoCambiar.getNombre()) {
				productoAdiciones.ajustarPrecio(nuevoIngrediente.getCostoAdicional());
				productosPedido.remove(productos);
				productosPedido.add(productoAdiciones);
				adiciones.add(nuevoIngrediente);
				break;
			}
		}
		
		
		
	}
	
	public int getPrecioNetoPedido() {
		int precioNeto = 0;
		for (Producto producto: productosPedido) {
			precioNeto+= producto.getPrecio();
		}
		return 1;
	}
	
	public void guardarFactura(File archivo) {
	}
	public ArrayList<Producto> getProductosPedido(){
		return this.productosPedido;
	}
	//Constructor
	public Pedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.numeroPedidos = 1;
	}
	@Override
	public String toString() {
		String factura = "";
		double total = 0;
		for (Producto producto : productosPedido) {
			total += producto.getPrecio();
			factura += "\n" + producto.generarTextoFactura();
		}
		for (Ingrediente ingrediente : adiciones) {
			total += ingrediente.getCostoAdicional();
			factura += "\n" + ingrediente.getNombre() + "\t" + ingrediente.getCostoAdicional();
		}
		String resultado = factura + "\nTOTAL_________________" + total;
		return resultado;
	}
}
