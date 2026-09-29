import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Aplicacion{
     public static File carpeta= new File("./documentos");
     public static void main(String[] args){
        System.out.println(carpeta.getAbsolutePath());
        System.out.println(Arrays.toString(carpeta.listFiles()));
        menu();
    }

    public static void menu(){
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

    public static void opciones(){
         int option;
         while(true){
             option=pedirOpcion("Introduce la opción:");
             switch (option) {
                 case 0:
                     leerArchivo(carpeta);
                 case 1:
                     crearCarpeta(carpeta);
                     break;
                 case 2:
                     crearFichero(carpeta);
                     break;
                 case 3:
                     listarContenido(carpeta);
                     break;
                 case 4:
                     renombrarFichero(carpeta);
                     break;
                 case 5:
                     eliminarFichero(carpeta);
                     break;
                 case 6:
                     System.out.println("Saliendo...");
                     System.exit(0);
             }
             menu();
         }
    }
    public static int pedirOpcion(String entrada){
         System.out.println(entrada);
         Scanner input= new Scanner(System.in);
         return input.nextInt();
    }

    public static void crearCarpeta(File carpeta){
        File directorio= new File(carpeta,nombreFichero());
        if(directorio.mkdir()){
            System.out.println("El directorio ha sido creado con éxito");
        }
        else{
            System.out.println("El directorio ya existe");
        }
    }

    public static void crearFichero(File carpeta){

        File ficheroVacio = new File(carpeta , nombreFichero());
        try {
            boolean creado = ficheroVacio.createNewFile();
            if (creado) {
                System.out.println("Fichero creado: " + ficheroVacio.getAbsolutePath());
            } else {
                System.out.println("El fichero '" + ficheroVacio.getName() + "' ya existía, no se ha vuelto a crear.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }
    }

    public static void listarContenido(File carpeta){

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

    public static void renombrarFichero(File carpeta){
         listarContenido(carpeta);
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
                     renombrarFichero(carpeta);
                 }
             }
         }
    }

    public static void eliminarFichero(File carpeta){
        listarContenido(carpeta);
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
                    eliminarFichero(carpeta);
                }
            }
        }
    }

    public static void leerArchivo(File carpeta){

    }
    public static String nombreFichero() {
        System.out.println("Introduce el nombre del fichero:");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}