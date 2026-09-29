import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Consultar un XML con XPath. En vez de recorrer el árbol nosotros
 * mismos con bucles, le hacemos una pregunta directa con una
 * expresión XPath (parecida a una consulta SQL).
 */
public class ConsultaXPath {

    public static void main(String[] args) {
        File fichero = new File("FicherosXML/Coches.xml");

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fichero);

            // Preparamos XPath
            XPathFactory xpathfactory = XPathFactory.newInstance();
            XPath xpath = xpathfactory.newXPath();

            // Compilamos la expresión: "todos los <coche> cuya <marca> contiene 'Seat'"
            XPathExpression expr = xpath.compile("//coche[contains(marca,'Seat')]");

            // Evaluamos la expresión sobre el documento, pidiendo un conjunto de nodos
            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            NodeList coches = (NodeList) result;

            System.out.println("Coches encontrados con XPath: " + coches.getLength());
            for (int i = 0; i < coches.getLength(); i++) {
                Element coche = (Element) coches.item(i);
                System.out.println(" -> id " + coche.getAttribute("id") + ": "
                        + coche.getElementsByTagName("modelo").item(0).getTextContent());
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        } catch (XPathExpressionException e) {
            System.out.println("Error en la expresión XPath: " + e.getMessage());
        }
    }
}
