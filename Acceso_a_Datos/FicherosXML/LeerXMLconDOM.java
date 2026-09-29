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

/**
 * Leer un fichero XML con el parser DOM. Usa Coches.xml y Coches_roto.xml
 * para provocar un error a propósito.
 *
 * DOM carga TODO el documento en memoria como un árbol de nodos, y luego
 * podemos movernos por él como queramos.
 */
public class LeerXMLconDOM {

    public static void main(String[] args) {
        String nombreFichero = (args.length > 0) ? args[0] : "FicherosXML/Coches.xml";
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
            NodeList nList = doc.getElementsByTagName("coche");
            System.out.println("Número de coches: " + nList.getLength());

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("\nCoche id: " + eElement.getAttribute("id"));
                    System.out.println("Marca: " + textoDe(eElement, "marca"));
                    System.out.println("Modelo: " + textoDe(eElement, "modelo"));
                    System.out.println("Cilindrada: " + textoDe(eElement, "cilindrada"));
                }
            }

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
