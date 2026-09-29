package com.dam.demofile.modelo;

import com.dam.demofile.vista.Vista;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Modelo {
    public String crearCarpeta(String nombreCarpeta){
        File directorio= new File(nombreCarpeta);
        if(directorio.mkdir()){
            return "El directorio se ha creado con éxito";
        }
        else{
            return "El directorio ya existe";
        }
    }

    public String crearFichero(String nombreFichero){

        File ficheroVacio = new File(nombreFichero);
        try {
            boolean creado = ficheroVacio.createNewFile();
            if (creado) {
                return "Fichero creado: " + ficheroVacio.getAbsolutePath();
            } else {
                return "El fichero '" + ficheroVacio.getName() + "' ya existía, no se ha vuelto a crear.";
            }
        } catch (IOException e) {
            return "Error al crear el fichero: " + e.getMessage();
        }
    }

    /*public static void listarContenido(){

        File[] elementos= carpeta.listFiles();
        if (elementos != null) {
            int contador=0;
            for (File elemento : elementos) {
                String tipo = elemento.isDirectory() ? "[DIR] " : "[FICHERO] ";
                String escritura= elemento.canWrite()?"Permiso de escritura ": "";
                String lectura=elemento.canRead()?"Permiso de lectura":"";
                String nombre=elemento.getName();
                System.out.println(nombre +tipo + elemento.getName() + "  -  " + elemento.length() + " bytes\n"+"Permisos:"+escritura+lectura);
                contador++;
            }
            if(contador<=1){
                System.out.println("No hay ningún fichero ni archivo");
            }
        }
    }

    public static void renombrarFichero(){
        listarContenido();
        File[] elementos= carpeta.listFiles();
        System.out.println("Qué fichero quieres renombrar?");
        Scanner input = new Scanner(System.in);
        if(elementos!=null) {
            for (File elemento : elementos) {
                if (elemento.getName().equals(input.nextLine())) {
                    System.out.println("Dime qué nombre le quieres poner al fichero");
                    input = new Scanner(System.in);
                    File nuevoNombre = new File(carpeta,input.nextLine());
                    if(elemento.renameTo(nuevoNombre)){
                        System.out.println("Renombrado correctamente, compruebalo");
                        break;
                    }
                }
                else {
                    System.out.println("El elemento no existe, introduce otro nombre");
                    renombrarFichero();
                }
            }
        }
    }

    public static void eliminarFichero(){
        listarContenido();
        File[] elementos= carpeta.listFiles();
        System.out.println("Qué fichero quieres eliminar?");
        Scanner input = new Scanner(System.in);
        if(elementos!=null) {
            for (File elemento : elementos) {
                if (elemento.getName().equals(input.nextLine())) {
                    if(elemento.delete()){
                        System.out.println("Borrado correctamente, compruebalo");
                        break;
                    }
                }
                else {
                    System.out.println("El elemento no existe, introduce otro nombre");
                    eliminarFichero();
                }
            }
        }
    }

    public static void leerArchivo(){

    }
    public static String nombreFichero() {
        System.out.println("Introduce el nombre del fichero:");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }*/
}
