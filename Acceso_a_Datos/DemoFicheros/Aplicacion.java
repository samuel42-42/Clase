import com.dam.demofile.controlador.Controlador;
import com.dam.demofile.modelo.Modelo;
import com.dam.demofile.vista.Vista;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;

public class Aplicacion{
    public static void main(String [] args){
        Modelo modelo= new Modelo();
        Vista vista = new Vista();
        Controlador controlador= new Controlador(modelo,vista);
        vista.menu();
    }
}