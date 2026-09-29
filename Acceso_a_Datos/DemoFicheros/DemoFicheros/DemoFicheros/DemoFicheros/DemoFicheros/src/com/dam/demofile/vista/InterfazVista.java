package com.dam.demofile.vista;

import com.dam.demofile.controlador.Controlador;

public interface InterfazVista {

    static final String LECTURA="Lee el archivo";
    static final String CREARD="Crea el directorio";
    public void menu();
    public void setControlador(Controlador controlador);
}
