package modelo;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ComboTest {
    private Combo combo;
    private Restaurante restaurante;

    @Before
    public void setUp() {
        restaurante = new Restaurante(); 

        combo = new Combo("ComboTest", 15.0);
        combo.agregarItemACombo("Producto1");
        combo.agregarItemACombo("Producto2");
    }

    @Test
    public void testAgregarItemACombo() {
        assertEquals("Producto1, Producto2", combo.getProductos());
    }

    @Test
    public void testSetPrecio() {
        combo.setPrecio(restaurante);
        assertEquals(27, combo.getPrecio());
    }

    @Test
    public void testGenerarTextoFactura() {
        combo.setPrecio(restaurante);
        assertEquals("ComboTest\t27", combo.generarTextoFactura());
    }
}
