import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class lectorArchivo {
    
    public void Diccionario(String archivo, BinaryTree<Association<String, String>> arbol) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (linea.startsWith("(") && linea.endsWith(")")) {
                    linea = linea.substring(1, linea.length() - 1);
                    String[] partes = linea.split(",");

                    if (partes.length == 2) {
                        String ingles = partes[0].trim().toLowerCase();
                        String espanol = partes[1].trim().toLowerCase();

                        arbol.insert(new Association<>(ingles, espanol));
                    }

                }
            }
        } catch (IOException e) {
            System.err.println("error al leer el archivo" + e.getMessage());
        }
    }

    public void traductor(String archivo, BinaryTree<Association<String, String>> arbol) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                StringBuilder lineaTraducida = new StringBuilder();

                for (String palabraOriginal : palabras) {
                    String palabraLimpia = palabraOriginal.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    if (palabraLimpia.isEmpty()) {
                        continue;
                    }

                    Association<String, String> aBuscar = new Association<>(palabraLimpia, "");
                    Association<String, String> resultado = arbol.search(aBuscar);

                    if (resultado != null) {
                        lineaTraducida.append(resultado.getValue()).append(" ");
                    } else {
                        lineaTraducida.append("*").append(palabraOriginal).append("* ");
                    }
                }
                System.out.println(lineaTraducida.toString().trim());
            }
        } catch (IOException e) {
            System.err.println("error al leer el archivo" + e.getMessage());
        }
    }

}
