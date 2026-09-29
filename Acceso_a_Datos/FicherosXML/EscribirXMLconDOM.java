import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Escribir un fichero XML con DOM. Genera Coches_generado.xml con
 * la misma estructura que Coches.xml.
 */
public class EscribirXMLconDOM {

    public static void main(String[] args) {
        try {
            // Creamos un documento nuevo y vacío.
            // Este paso, de nuevo, siempre se repite.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            doc.setXmlVersion("1.0");

            // Elemento raíz
            Element eRaiz = doc.createElement("concesionario");
            doc.appendChild(eRaiz);

            // Añadimos los coches, uno a uno
            crearElementoCoche(doc, eRaiz, "1", "Renault", "Megane", "1.5");
            crearElementoCoche(doc, eRaiz, "2", "Seat", "León", "1.5");
            crearElementoCoche(doc, eRaiz, "3", "Opel", "Astra", "2.0");
            crearElementoCoche(doc, eRaiz, "4", "Citroen", "C4", "2.5");

            // Convertimos el árbol en memoria en un fichero real.
            // Hasta ahora, no había ningún archivo físico guardado.
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Coches_generado.xml"));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(source, result);

            System.out.println("Fichero Coches_generado.xml creado correctamente.");

        } catch (ParserConfigurationException e) {
            System.out.println("Error al configurar el parser: " + e.getMessage());
        } catch (TransformerException e) {
            System.out.println("Error al transformar el árbol en fichero: " + e.getMessage());
        }
    }

    // Crea un elemento <coche id="..."> con sus tres hijos (marca, modelo,
    // cilindrada) y lo añade como hijo de eRaiz.
    private static void crearElementoCoche(Document doc, Element eRaiz, String id,
            String marca, String modelo, String cilindrada) {

        Element eCoche = doc.createElement("coche");
        eRaiz.appendChild(eCoche);

        Attr attr = doc.createAttribute("id");
        attr.setValue(id);
        eCoche.setAttributeNode(attr);

        Element eMarca = doc.createElement("marca");
        eMarca.appendChild(doc.createTextNode(marca));
        eCoche.appendChild(eMarca);

        Element eModelo = doc.createElement("modelo");
        eModelo.appendChild(doc.createTextNode(modelo));
        eCoche.appendChild(eModelo);

        Element eCilindrada = doc.createElement("cilindrada");
        eCilindrada.appendChild(doc.createTextNode(cilindrada));
        eCoche.appendChild(eCilindrada);
    }
}
