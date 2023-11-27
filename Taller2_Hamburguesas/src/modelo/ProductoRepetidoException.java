package modelo;

public class ProductoRepetidoException extends HamburguesaException{
	private String productoRepetido;

    public ProductoRepetidoException(String mensaje, String productoRepetido) {
        super(mensaje);
        this.productoRepetido = productoRepetido;
    }

    public String getProductoRepetido() {
        return productoRepetido;
    }
}
