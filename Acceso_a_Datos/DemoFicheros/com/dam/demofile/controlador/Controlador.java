package com.dam.demofile.controlador;

import com.dam.demofile.modelo.Modelo;
import com.dam.demofile.vista.InterfazVista;
import com.dam.demofile.vista.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private final Modelo modelo;
    private final Vista vista;

    public Controlador(Modelo modelo, Vista vista){
        this.modelo=modelo;
        this.vista=vista;
        this.vista.setControlador(this);
    }

    public void actionPerformed(ActionEvent e){
        String s="";
        switch (e.getActionCommand()){
            case InterfazVista.CREARD -> {
                s=vista.pedirString("Dime, cuál es el nombre del directorio?");
                String respuesta=modelo.crearCarpeta(s);
                vista.mostrarMensaje(respuesta);
            }
            case InterfazVista.LECTURA -> {
                s = vista.pedirString("Dime, qué fichero quieres ver?");
                vista.mostrarMensaje(modelo.leerFichero(s));
            }
            case InterfazVista.CREARF -> {
                s=vista.pedirString("Dime, cuál es el nombre del fichero?");
                vista.mostrarMensaje(modelo.crearFichero(s));
            }
            case InterfazVista.LISTAR -> {
                s=vista.pedirString("Dime, cuál es el nombre de la carpeta?");
                
                vista.mostrarMensaje(modelo.listarContenido(s));
            }
        }
    }
}
