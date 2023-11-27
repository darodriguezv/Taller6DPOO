package modelo;
import org.junit.Assert;
import org.junit.Test;
public class ProductoMenuTest {
	
	@Test
	public void testGetNombre() {
		ProductoMenu producto = new ProductoMenu("Hamburguesa", 10);
		Assert.assertEquals("Hamburguesa", producto.getNombre());
	}
	@Test
    public void testGetPrecio() {
        ProductoMenu producto = new ProductoMenu("Pizza", 15);
        Assert.assertEquals(15, producto.getPrecio());
    }

    @Test
    public void testSetPrecio() {
        ProductoMenu producto = new ProductoMenu("Ensalada", 8);
        producto.setPrecio(3);
        Assert.assertEquals(11, producto.getPrecio());
    }

    @Test
    public void testGenerarTextoFactura() {
        ProductoMenu producto = new ProductoMenu("Gaseosa", 5);
        Assert.assertEquals("Gaseosa\t$5", producto.generarTextoFactura());
    }

}
