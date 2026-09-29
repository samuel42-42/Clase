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
        System.out.println("0-Salir");
        System.out.println("1-Crear Directorio nuevo");
        System.out.println("2-Crear fichero nuevo");
        System.out.println("3-Listar contenido");
        System.out.println("4-Renombrar fichero");
        System.out.println("5-Eliminar fichero");
        System.out.println("6-Leer archivo");
        opciones();
    }

    private void opciones(){
        int option;
        while(true){
            option=pedirOpcion("Introduce la opción:");
            switch (option) {
                case 0-> controlador.actionPerformed(new ActionEvent(this, option, SALIR));
                case 1->
                    controlador.actionPerformed(new ActionEvent(this,option,CREARD));
                case 2->
                    controlador.actionPerformed(new ActionEvent(this,option,CREARF));
                case 3->
                    controlador.actionPerformed(new ActionEvent(this,option,LISTAR));
                case 4->
                    controlador.actionPerformed(new ActionEvent(this,option,RENAME));
                case 5->
                    controlador.actionPerformed(new ActionEvent(this,option,ELIMINAR));
                case 6->
                    controlador.actionPerformed(new ActionEvent(this,option,LECTURA));
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
