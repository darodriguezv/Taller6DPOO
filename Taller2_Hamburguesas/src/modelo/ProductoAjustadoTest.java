package modelo;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProductoAjustadoTest {

    @Test
    public void testGetNombre() {
        ProductoMenu base = new ProductoMenu("Hamburguesa", 10);
        ProductoAjustado productoAjustado = new ProductoAjustado(base);
        assertEquals("Hamburguesa", productoAjustado.getNombre());
    }

    @Test
    public void testGetPrecio() {
        ProductoMenu base = new ProductoMenu("Pizza", 15);
        ProductoAjustado productoAjustado = new ProductoAjustado(base);
        assertEquals(15, productoAjustado.getPrecio());
    }

    @Test
    public void testAjustarPrecio() {
        ProductoMenu base = new ProductoMenu("Ensalada", 8);
        ProductoAjustado productoAjustado = new ProductoAjustado(base);
        productoAjustado.ajustarPrecio(3);
        assertEquals(11, productoAjustado.getPrecio());
    }

    @Test
    public void testGenerarTextoFactura() {
        ProductoMenu base = new ProductoMenu("Gaseosa", 5);
        ProductoAjustado productoAjustado = new ProductoAjustado(base);
        assertEquals("Gaseosa-5", productoAjustado.generarTextoFactura());
    }
}
