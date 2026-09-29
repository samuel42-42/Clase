package com.dam.demofile;

import com.dam.demofile.example.Ejemplo1;
import com.dam.demofile.example.Ejemplo2;
import com.dam.demofile.example.Ejemplo3;
import com.dam.demofile.example.Ejemplo4;
import com.dam.demofile.example.Ejemplo5;

public class DemoFile {
    void main(String [] args) {
        System.out.println("Ejemplo 1");
        Ejemplo1.main(args);

        System.out.println();
        System.out.println("Ejemplo 2");
        Ejemplo2.main(args);

        System.out.println();
        System.out.println("Ejemplo 3");
        Ejemplo3.main(args);

        System.out.println();
        System.out.println("Ejemplo 4");
        Ejemplo4.main(args);

        System.out.println();
        System.out.println("Ejemplo 5");
        Ejemplo5.main(args);
    }
}
