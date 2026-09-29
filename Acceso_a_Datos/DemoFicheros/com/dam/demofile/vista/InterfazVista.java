package com.dam.demofile.vista;

import com.dam.demofile.controlador.Controlador;

public interface InterfazVista {

    static final String LECTURA="Lee el archivo";
    static final String CREARD="Crea el directorio";
    static final String CREARF="Crea el fichero";
    static final String LISTAR="Lista el contenido";
    static final String RENAME="Renombrar fichero o directorio";
    static final String ELIMINAR="Elimina el fichero o directorio";
    static final String SALIR="Salir de la app";
    public void menu();
    public void setControlador(Controlador controlador);
}
