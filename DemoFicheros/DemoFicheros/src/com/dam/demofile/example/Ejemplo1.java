package com.dam.demofile.example;
/*
 * Ejemplo 1: distintas formas de crear objetos File.
 *
 * OJO: crear un objeto File NO crea nada en el disco.
 * Sólo representa una ruta; el fichero o directorio puede existir o no.
 */
import java.io.File;

public class Ejemplo1 {

    public static void main(String [] args) {

        // 1) A partir de una ruta relativa (relativa a la carpeta desde la que se ejecuta)
        File f1 = new File("demo/ejemplo1.txt");

        // 2) A partir de una ruta absoluta (aquí, dentro del propio proyecto)
        File f2 = new File(new File("demo").getAbsolutePath() + File.separator + "ejemplo2.txt");

        // 3) Indicando por separado la carpeta (String) y el nombre del fichero
        String carpeta = "demo";
        File f3 = new File(carpeta, "ejemplo3.txt");

        // 4) Indicando la carpeta como objeto File y el nombre del fichero
        File dir = new File(carpeta);
        File f4 = new File(dir, "ejemplo4.txt");

        System.out.println("Comprobamos que NINGUNO existe todavía en disco:");
        System.out.println();

        for (File f : new File[]{f1, f2, f3, f4}) {
            System.out.println(f.getPath() + "  ->  ¿existe? " + f.exists());
        }

        System.out.println();
        System.out.println("En los ficheros anteriores se ve la diferencia entre getPath() y getAbsolutePath():");
        System.out.println("getPath()         : " + f1.getPath());
        System.out.println("getAbsolutePath() : " + f1.getAbsolutePath());
    }
}
