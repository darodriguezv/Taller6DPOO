package modelo;

public class PedidoLimiteException extends Exception{
	private double montoExcedido;
	
	public PedidoLimiteException(String mensaje, double montoExcedido) {
		super(mensaje);
		this.montoExcedido = montoExcedido;
	}
	
	public double getMontoExcedido() {
		return this.montoExcedido;
	}
}
