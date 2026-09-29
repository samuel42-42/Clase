package com.dam.demofile.example;
/*
 * Ejemplo 3: crear directorios (mkdir) y ficheros vacíos (createNewFile).
 *
 * createNewFile() puede lanzar IOException, así que la capturamos con try/catch.
 *
 * Si lo ejecutamos un par de veces: la primera crea la carpeta y el fichero;
 * la segunda vemos que detecta que ya existían.
 */
import java.io.File;
import java.io.IOException;

public class Ejemplo3 {

    public static void main(String [] args) {

        File carpeta = new File("demo");
        if (!carpeta.exists()) {
            boolean creada = carpeta.mkdir();
            System.out.println("¿Carpeta '" + carpeta.getPath() + "' creada? " + creada);
        } else {
            System.out.println("La carpeta '" + carpeta.getPath() + "' ya existía.");
        }

        File fichero = new File(carpeta, "ejemplo.txt");
        try {
            boolean creado = fichero.createNewFile();
            if (creado) {
                System.out.println("Fichero creado: " + fichero.getAbsolutePath());
            } else {
                System.out.println("El fichero '" + fichero.getName() + "' ya existía, no se ha vuelto a crear.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }
    }
}
