public class Main {
    public static void main(String[] args) {
        BinaryTree<Association<String, String>> arbol = new BinaryTree<>();
        lectorArchivo lector = new lectorArchivo();

        lector.Diccionario("diccionario.txt", arbol);
        System.out.println("Diccionario ordenado: ");
        arbol.inOrder();

        Traductor traductor = new Traductor(arbol);
        System.out.println("oracion traducida: ");
        lector.TraducirTexto("texto.txt", traductor);
    }
}
