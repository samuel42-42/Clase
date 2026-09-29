package com.dam.demofile.example;
/*
 * Ejemplo 4: renombrar (renameTo) y borrar (delete) ficheros.
 *
 * Requiere haber ejecutado antes el ejemplo 3,
 * que es quien crea demo/ejemplo.txt. Si no lo has ejecutado,
 * el programa te avisa.
 */
import java.io.File;

public class Ejemplo4 {

    public static void main(String [] args) {

        File carpeta = new File("demo");
        File original = new File(carpeta, "ejemplo.txt");
        File nuevoNombre = new File(carpeta, "estoy_renombrado.txt");

        if (!original.exists()) {
            System.out.println("No existe " + original.getPath()
                    + ". Ejecuta antes Ejemplo3.");
            return;
        }

        boolean renombrado = original.renameTo(nuevoNombre);
        System.out.println("¿Renombrado correctamente a '" + nuevoNombre.getName() + "'? " + renombrado);

        if (nuevoNombre.exists()) {
            boolean borrado = nuevoNombre.delete();
            System.out.println("¿Borrado correctamente? " + borrado);
        }
    }
}
