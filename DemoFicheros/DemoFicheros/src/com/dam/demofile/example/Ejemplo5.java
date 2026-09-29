package com.dam.demofile.example;
/*
 * Ejemplo 5: listar el contenido de una carpeta con listFiles().
 *
 * Este ejemplo es autosuficiente: crea la carpeta y un par de ficheros
 * de prueba si no existen todavía, para que siempre haya algo que listar.
 */
import java.io.File;
import java.io.IOException;

public class Ejemplo5 {

    public static void main(String [] args) {

        File carpeta = new File("demo");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        crearSiNoExiste(new File(carpeta, "notas_importantes.txt"));
        crearSiNoExiste(new File(carpeta, "datos_increibles.dat"));

        System.out.println("Contenido de " + carpeta.getAbsolutePath() + ":");
        System.out.println();

        File[] elementos = carpeta.listFiles();
        if (elementos != null) {
            for (File elemento : elementos) {
                String tipo = elemento.isDirectory() ? "[DIR]     " : "[FICHERO] ";
                System.out.println(tipo + elemento.getName() + "  -  " + elemento.length() + " bytes");
            }
        }

        System.out.println();
        System.out.println("Con list() en vez de listFiles() vemos solo los nombres (String[]):");
        String[] nombres = carpeta.list();
        if (nombres != null) {
            for (String nombre : nombres) {
                System.out.println(" - " + nombre);
            }
        }
    }

    private static void crearSiNoExiste(File f) {
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("No se pudo crear " + f.getName() + ": " + e.getMessage());
        }
    }
}
