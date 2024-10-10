/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioprueba;

import java.io.File;
import java.io.FileWriter;
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
 *
 * @author FP
 */
public class EjercicioPrueba {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File fichero = new File("C:\\Users\\FP\\Desktop\\contenidoCamaras.txt");
        FileWriter escribir = new FileWriter(fichero);

        Document document = builder.parse(new File("camaras.xml"));
        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();

        NodeList nList = document.getElementsByTagName("camara");

        escribir.write("Lo ULTIMO de las camaras web \n");
        escribir.write(" \n");
        escribir.write("=================== \n");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println(" ");

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                escribir.write("Nombre y Modelo ¡¡: " + eElement.getElementsByTagName("nombre").item(0).getTextContent() + "\n");
                escribir.write("Marca ¡¡: " + eElement.getElementsByTagName("marca").item(0).getTextContent() + "\n");
                escribir.write("DIMENSIONES Altura #: " + eElement.getElementsByTagName("altura").item(0).getTextContent() + "\n");
                escribir.write("DIMENSIONES Anchura @: " + eElement.getElementsByTagName("anchura").item(0).getTextContent() + "\n");
                escribir.write("DIMENSIONES Profundidad #: " + eElement.getElementsByTagName("profundidad").item(0).getTextContent() + "\n");
                escribir.write("DIMENSIONES Peso @: " + eElement.getElementsByTagName("peso").item(0).getTextContent() + "\n");
                escribir.write("RESOLUCION megapixeles #: " + eElement.getElementsByTagName("megapixeles").item(0).getTextContent() + "\n");
                escribir.write("Comentarios: " + eElement.getElementsByTagName("comentarios").item(0).getTextContent() + "\n");

            }

            if (temp >= nList.getLength() - 1) {
                escribir.write("+++++++++++++++++++++\n");
                escribir.write("FIN DEL DOCUEMENTO XML");
            } else {
                escribir.write("*********************\n");
            }

        }
        
        escribir.close();

    }

}
