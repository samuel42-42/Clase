import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EscribirXML {
    public static void main(String[] args) {
        String nombreFichero = (args.length > 0) ? args[0] : "FicherosXML/productos.xml";
        File fichero = new File(nombreFichero);

        if (!fichero.exists()) {
            System.out.println("No existe " + fichero.getPath() + ".");
            return;
        }

        try {
            // Creamos factory y constructor; estos pasos siempre son iguales
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Analizamos el fichero y obtenemos el árbol en memoria
            Document doc = dBuilder.parse(fichero);
            doc.getDocumentElement().normalize();

            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

            // Recorremos el árbol
            NodeList nList = doc.getElementsByTagName("producto");
            System.out.println("Número de productos: " + nList.getLength());
            double valor=0;
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    int stock=0;
                    Element eElement = (Element) nNode;
                    System.out.println("\nProductos id: " + eElement.getAttribute("codigo"));
                    System.out.println("nombre: " + textoDe(eElement, "nombre"));
                    System.out.println("precio: " + textoDe(eElement, "precio")+"€");
                    System.out.println("stock: " + textoDe(eElement, "stock"));
                    if(( stock=Integer.parseInt(textoDe(eElement, "stock")))<5){
                        System.out.printf("El producto %s, se está quedando sin stock (unidades restantes: %s)\n"
                        ,textoDe(eElement, "nombre"),textoDe(eElement, "stock"));
                    }
                    valor = valor + Double.parseDouble(textoDe(eElement, "precio"));
                }   
            }
            System.out.printf("La suma del precio de todos los productos es: %.2f€",valor);


        } catch (ParserConfigurationException e) {
            System.out.println("Error al configurar el parser: " + e.getMessage());
        } catch (SAXException e) {
            // Se lanza cuando el XML está MAL FORMADO (etiquetas sin cerrar, etc.)
            System.out.println("El fichero XML está mal formado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("No se pudo leer el fichero: " + e.getMessage());
        }
    }

    // Devuelve el texto de la primera etiqueta con ese nombre dentro de un
    // elemento. Ej.: <marca>Seat</marca> -> "Seat"
    private static String textoDe(Element padre, String etiqueta) {
        NodeList lista = padre.getElementsByTagName(etiqueta);
        if (lista.getLength() == 0) {
            return "(sin " + etiqueta + ")";
        }
        return lista.item(0).getTextContent();
    }
}

