package consola;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Restaurante;
import modelo.ProductoMenu;
import modelo.ProductoRepetidoException;
import modelo.Combo;
import modelo.Ingrediente;
import modelo.IngredienteRepetidoException;
import modelo.Pedido;
import modelo.PedidoLimiteException;
import modelo.Ingrediente;
public class ConsolaHamburguesas {
	//Creación del Scanner
	Scanner leer = new Scanner(System.in);
	
	public void ejecutarAplicacion() throws FileNotFoundException, IOException, IngredienteRepetidoException, ProductoRepetidoException, PedidoLimiteException {
		boolean ejecucion = true;
		Restaurante restaurante = new Restaurante();
		restaurante.cargarInformacionRestaurante("./data/ingredientes.txt", "./data/menu.txt", "./data/combos.txt");
		while (ejecucion){
			System.out.println("BIENVENIDO!");
			int idContador = 0;
			mostrarOpciones();
			
			int seleccion = leer.nextInt();
			
			switch (seleccion) {
			case 1:
				ejecutarMostrarOpciones(restaurante);
				break;
			
			case 2:
				ejecutarInicioPedido(restaurante);
				break;
			
			case 3: 
				ejecutarAgregarElemento(restaurante);
				break;
				
			case 4:
				ejecutarCerrarPedido(restaurante, idContador);
				break;
//				
//			case 5:
//				consultarInfoPedido();
//				break;
//				
			case 6:
				System.out.println("Gracias por su compra!");
				System.out.println("Cerrando aplicacion...");
				ejecucion = false;
				break;
				
			default:
				System.out.println("Lo sentimos algo ha salido mal, vuelva a intentarlo.");
				break;
			}
		
		}
	}
	//Metodo para mostrar el menú
	public void mostrarOpciones() {
		System.out.println("Seleccione una opción a continuación:");
		System.out.println("1. Mostrar el menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento nuevo al pedido");
		System.out.println("4. Cerrar pedido y guardar factura");
		System.out.println("5. Consultar informacion del pedido");
		System.out.println("6. Salir");
	}
	//Metodos ejecución
	public void ejecutarMostrarOpciones(Restaurante restaurante) {
		System.out.println("Cargando el menu...");
		System.out.println("PRODUCTOS");
		int contador = 0;
		for (ProductoMenu producto: restaurante.getMenuBase()) {
			System.out.println(contador + ". " + producto);
			contador++;
		}
		System.out.println("COMBOS");
		for (Combo combo: restaurante.getCombos()) {
			combo.setPrecio(restaurante);
			System.out.println(contador + ". " + combo);
			contador++;
		}
		System.out.println("ADICIONES");
		for (Ingrediente ingrediente : restaurante.getIngredientes()) {
			System.out.println(contador + ". " + ingrediente);
			contador++;
		}
	}
	public void ejecutarInicioPedido(Restaurante restaurante) {
		if (restaurante.getPedidoEnCurso() == null){
			System.out.println("Iniciando pedido...");
			System.out.println("Ingrese su nombre");
			String nombreCliente = leer.next();
			System.out.println("Ingrese su direccion");
			String direccionCliente = leer.next();
			restaurante.iniciarPedido(nombreCliente, direccionCliente);
			System.out.println("Pedido iniciado exitosamente!");
		}else {
			System.out.println("Actualmente hay un pedido en curso...");
		}
	}
	public void ejecutarAgregarElemento(Restaurante restaurante) throws PedidoLimiteException {
		Pedido pedido = restaurante.getPedidoEnCurso();
		System.out.println("Que tipo de producto desea agregar?");
		System.out.println("1. Productos\n2. Combos\n3. Adiciones");
		int contador = 0;
		int seleccion = 0;
		int indice = leer.nextInt();
		switch (indice) {
		case 1:
			ArrayList<ProductoMenu> menu = restaurante.getMenuBase();
			System.out.println("Productos");
			contador = 0;
			for (ProductoMenu producto: menu) {
				System.out.println(contador + ". " + producto);
				contador++;
			}
			seleccion = leer.nextInt();
			ProductoMenu producto = menu.get(seleccion);
			pedido.agregarProducto(producto);
			
			System.out.println("Desea alguna adicion?");
			System.out.println("1. Si \n 2. No");
			int agregar = leer.nextInt();
			if(agregar == 1) {
				
				ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
				contador = 0;
				
				System.out.println("Ingredientes");
				for (Ingrediente ingrediente : ingredientes) {
					System.out.println(contador + ". " + ingrediente);
					contador++;
				}
				
				seleccion = leer.nextInt();
				Ingrediente ingredienteAgregado = ingredientes.get(seleccion); 
				pedido.agregarIngrediente(ingredienteAgregado, producto);
				System.out.println("Se ha agregado la adicion: " + ingredienteAgregado.getNombre());
			}
			System.out.println("Se ha agregado el producto: " + producto.getNombre());
			break;
		case 2:
			ArrayList<Combo> combos = restaurante.getCombos();
			contador = 0;
			System.out.println("Combos");
			for (Combo combo: combos) {
				System.out.println(contador + ". " + combo);
				contador++;
			}
			seleccion = leer.nextInt();
			Combo combo = combos.get(seleccion);
			pedido.agregarProducto(combo);
			System.out.println("Se ha agregado el combo: " + combo.getNombre());			
		
		default:
			System.out.println("Seleccione una opcion valida.");
			break;
		}
	}
	
public void ejecutarCerrarPedido(Restaurante restaurante, int idContador) {
	System.out.println(restaurante.getPedidoEnCurso());
	
	restaurante.cerrarPedido();
	System.out.println("Pedido cerrado, guardando factura...");
	System.out.println("Factura guardada con el id: " + idContador);
	idContador++;
	
}
	public static void main(String[] args) throws FileNotFoundException, IOException, IngredienteRepetidoException, ProductoRepetidoException, PedidoLimiteException {
		ConsolaHamburguesas consolaRestaurante = new ConsolaHamburguesas(); 
		consolaRestaurante.ejecutarAplicacion();
	}

}
