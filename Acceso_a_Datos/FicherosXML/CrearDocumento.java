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

public class CrearDocumento {
    public static void main(String[] args) {
        try {
            // Creamos un documento nuevo y vacío.
            // Este paso, de nuevo, siempre se repite.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            doc.setXmlVersion("1.0");

            // Elemento raíz
            Element eRaiz = doc.createElement("productos");
            doc.appendChild(eRaiz);

            // Añadimos los coches, uno a uno
            crearElementoProducto(doc, eRaiz, "P05", "Nvidia rtx 5090", "8000", "1");
            crearElementoProducto(doc, eRaiz, "P06", "Amd Ryzen 9 9950X3D", "750", "50");
            crearElementoProducto(doc, eRaiz, "P07", "Ventilador rgb", "20", "100");
            crearElementoProducto(doc, eRaiz, "P08", "ram ddr5", "700", "0");

            // Convertimos el árbol en memoria en un fichero real.
            // Hasta ahora, no había ningún archivo físico guardado.
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("productos.xml"));
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
    private static void crearElementoProducto(Document doc, Element eRaiz, String codigo,
            String nombre, String precio, String stock) {

        Element eCoche = doc.createElement("producto");
        eRaiz.appendChild(eCoche);

        Attr attr = doc.createAttribute("codigo");
        attr.setValue(codigo);
        eCoche.setAttributeNode(attr);

        Element eMarca = doc.createElement("nombre");
        eMarca.appendChild(doc.createTextNode(nombre));
        eCoche.appendChild(eMarca);

        Element ePrecio = doc.createElement("precio");
        ePrecio.appendChild(doc.createTextNode(precio));
        eCoche.appendChild(ePrecio);

        Element eCilindrada = doc.createElement("stock");
        eCilindrada.appendChild(doc.createTextNode(stock));
        eCoche.appendChild(eCilindrada);
    }
}
