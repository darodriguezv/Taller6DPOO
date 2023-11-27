package modelo;

public class IngredienteRepetidoException extends HamburguesaException {
	private String ingredienteRepetido;
	
	public IngredienteRepetidoException(String mensaje, String ingredienteRepetido) {
		super(mensaje);
		this.ingredienteRepetido = ingredienteRepetido;
	}
	
	public String getIngredienteRepetido() {
		return ingredienteRepetido;
	}
}
