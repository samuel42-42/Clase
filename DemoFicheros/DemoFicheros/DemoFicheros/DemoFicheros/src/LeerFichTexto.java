import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichTexto {
    public static void main(String[] args) throws IOException {
        File fichero = new File("Fichero1.txt"); //declarar fichero
        fichero.createNewFile();
        System.out.println(fichero.getAbsolutePath());
        FileReader fic = new FileReader(fichero); //flujo de entrada
        //FileReader fic = new FileReader("C:/Fichero1.txt");
        int i;
        while ((i = fic.read()) != -1) //se va leyendo un carácter
            System.out.println( (char) i + "==>"+ i);
        fic.close(); //cerrar fichero
    }
}
