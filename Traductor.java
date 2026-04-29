public class Traductor {
    private BinaryTree<Association<String, String>> tree;

    public Traductor(BinaryTree<Association<String, String>> tree) {
        this.tree = tree;
    }

    public void traducir(String texto) {
        String[] palabras = texto.split("\\s+");

        for (String palabraO : palabras) {
            String palabra = palabraO.toLowerCase().replaceAll("[^a-z]", "");

            if (palabra.isEmpty()) {
                continue;
            }

            Association<String, String> aBuscar = new Association<>(palabra, "");
            Association<String, String> resultado = tree.search(aBuscar);

            if (resultado != null) {
                System.out.print(resultado.getValue() + " ");
            } else {
                System.out.print("*" + palabraO + "* ");
            }
        }
        System.out.println();
    }
}
