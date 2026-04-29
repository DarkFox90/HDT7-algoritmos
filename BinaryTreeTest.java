import org.junit.*;

public class BinaryTreeTest {
    @Test
    public void testInsertarYbuscar() {
        BinaryTree<Association<String, String>> arbol = new BinaryTree<>();

        arbol.insert(new Association<>("house", "casa"));
        arbol.insert(new Association<>("dog", "perro"));
        arbol.insert(new Association<>("apple", "manzana"));

        Association<String, String> aBuscar = new Association<>("house", "");
        Association<String, String> resultado = arbol.search(aBuscar);

        Assert.assertEquals("house es casa", "casa", resultado.getValue());
    }

    @Test
    public void testBuscarFallido() {
        BinaryTree<Association<String, String>> arbol = new BinaryTree<>();

        arbol.insert(new Association<>("ghost", "fantasma"));
        arbol.insert(new Association<>("book", "libro"));

        Association<String, String> aBuscar = new Association<>("fruit", "");
        Association<String, String> resultado = arbol.search(aBuscar);

        Assert.assertNull("resultado no encontrado", resultado);
    }
}
