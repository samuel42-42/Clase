package com.dam.demofile.example;
/*
 * Ejemplo 2: consultar información de un fichero o directorio con File.
 */
import java.io.File;

public class Ejemplo2 {

    public static void main(String [] args) {
        File carpetaActual = new File(".");
        mostrarInfo(carpetaActual);

        File esteFichero = new File("Ejemplo2.java");
        mostrarInfo(esteFichero);
    }

    private static void mostrarInfo(File f) {
        System.out.println("----------------------------------------");
        if (f.exists()) {
            System.out.println("Nombre            : " + f.getName());
            System.out.println("Ruta              : " + f.getPath());
            System.out.println("Ruta absoluta     : " + f.getAbsolutePath());
            System.out.println("Se puede leer     : " + f.canRead());
            System.out.println("Se puede escribir : " + f.canWrite());
            System.out.println("Tamaño (bytes)    : " + f.length());
            System.out.println("¿Es directorio?   : " + f.isDirectory());
            System.out.println("¿Es fichero?      : " + f.isFile());
            System.out.println("Directorio padre  : " + f.getParent());
        } else {
            System.out.println(f.getPath() + " no existe.");
        }
    }
}
