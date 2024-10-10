/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atualizarXML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("empleados.xml"));
        ArrayList<Empleado> informacion = new ArrayList<Empleado>();

        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();

        System.out.println(root.getNodeName());

        NodeList nList = document.getElementsByTagName("empleado");

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node node = nList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                String id = eElement.getAttribute("id");
                String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
                String apellidos = eElement.getElementsByTagName("apellidos").item(0).getTextContent();
                String ciudad = eElement.getElementsByTagName("ciudad").item(0).getTextContent();

                informacion.add(new Empleado(id, nombre, apellidos, ciudad));

            }

        }

        Empleado empleadoNuevo = new Empleado("444", "Rodrigo", "Fernandez", "Villa viciosa");
        informacion.add(empleadoNuevo);

        String nombreFichero = "empleadosConArrays";
        // crecion de la estructura recorriendo el array

        Document doc = builder.newDocument();

        Element rootElement = doc.createElement("empleados");
        doc.appendChild(rootElement);

        for (Empleado e : informacion) {
            Element empleado = doc.createElement("empleado");

            empleado.setAttribute("id", e.getId());

            rootElement.appendChild(empleado);
            
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(e.getNombre()));
            empleado.appendChild(nombre);
            
            Element apellido = doc.createElement("apellidos");
            apellido.appendChild(doc.createTextNode(e.getApellidos()));
            empleado.appendChild(apellido);
            
            Element ciudad = doc.createElement("ciudad");
            ciudad.appendChild(doc.createTextNode(e.getCiudad()));
            empleado.appendChild(ciudad);
           
        }

        for (Empleado e : informacion) {
            System.out.println(e.toString());
        }
        // Escritura del fichero 
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream(nombreFichero + ".xml"));
        transformer.transform(source, result);
        System.out.println("datos actualizamos en el xml ");

    }
}
