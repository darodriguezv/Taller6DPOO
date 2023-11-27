package modelo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PedidoTest {

    @Test
    public void testAgregarProducto() throws PedidoLimiteException {
        Pedido pedido = new Pedido("Cliente Test", "Dirección Test");
        Producto producto = new ProductoMenu("Producto Test", 100);

        pedido.agregarProducto(producto);

        assertTrue(pedido.getProductosPedido().contains(producto));
    }

    @Test(expected = PedidoLimiteException.class)
    public void testAgregarProductoExcedeLimite() throws PedidoLimiteException {
        Pedido pedido = new Pedido("Cliente Test", "Dirección Test");
        Producto productoCaro = new ProductoMenu("Producto Caro", 200000);

        pedido.agregarProducto(productoCaro);
    }

    @Test
    public void testAgregarIngrediente() throws PedidoLimiteException {
        Pedido pedido = new Pedido("Cliente Test", "Dirección Test");
        ProductoMenu productoMenu = new ProductoMenu("Producto Menú", 150);
        Ingrediente ingrediente = new Ingrediente("Ingrediente Test", 20);

        pedido.agregarProducto(productoMenu);
        pedido.agregarIngrediente(ingrediente, productoMenu);

        assertTrue(pedido.getProductosPedido().stream().anyMatch(p -> p instanceof ProductoAjustado));
    }

    @Test
    public void testGetPrecioNetoPedido() throws PedidoLimiteException {
        Pedido pedido = new Pedido("Cliente Test", "Dirección Test");
        Producto producto1 = new ProductoMenu("Producto 1", 50);
        Producto producto2 = new ProductoMenu("Producto 2", 30);

        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        int precioNeto = pedido.getPrecioNetoPedido();

        assertEquals(80, precioNeto);
    }

}
