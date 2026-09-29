package com.dam.demofile.vista;

import com.dam.demofile.controlador.Controlador;

import java.awt.event.ActionEvent;
import java.util.Scanner;

public class Vista implements InterfazVista{

    private Controlador controlador;
    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }
    public void menu(){
        System.out.println("Menu");
        System.out.println("0-Leer archivo");
        System.out.println("1-Crear Directorio nuevo");
        System.out.println("2-Crear fichero nuevo");
        System.out.println("3-Listar contenido");
        System.out.println("4-Renombrar fichero");
        System.out.println("5-Eliminar fichero");
        System.out.println("6-Salir");
        opciones();
    }

    private void opciones(){
        int option;
        while(true){
            option=pedirOpcion("Introduce la opción:");
            switch (option) {
                case 0-> controlador.actionPerformed(new ActionEvent(this, option, LECTURA));
                case 1->
                    controlador.actionPerformed(new ActionEvent(this,option,CREARD));

                /*
                case 2:
                    crearFichero();
                    break;
                case 3:
                    listarContenido();
                    break;
                case 4:
                    renombrarFichero();
                    break;
                case 5:
                    eliminarFichero();
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    System.exit(0);
                case 7:
                    break;

                case 8:
                    break;
                case 9:
                    break;*/
            }
            menu();
        }
    }

    private int pedirOpcion(String entrada){
        System.out.println(entrada);
        Scanner input= new Scanner(System.in);
        return input.nextInt();
    }

    public String pedirString(String entrada){
        System.out.println(entrada);
        Scanner input= new Scanner(System.in);
        return input.nextLine();
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}
