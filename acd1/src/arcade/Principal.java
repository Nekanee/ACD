/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arcade;

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
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("InfoMaquinas.xml"));

        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();

        System.out.println(root.getNodeName());

        NodeList nList = document.getElementsByTagName("taburete");

        System.out.println(
                "===================");
        System.out.println("-.-");
        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node node = nList.item(temp);
            System.out.println(" ");

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println("Taburete " + (temp + 1));
                System.out.println("Taburete nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Taburete caracteristicas: " + eElement.getElementsByTagName("caracteristicas").item(0).getTextContent());
                System.out.println("Taburete proteccion: " + eElement.getElementsByTagName("proteccion").item(0).getTextContent());
                System.out.println("Taburete acabado: " + eElement.getElementsByTagName("acabado").item(0).getTextContent());
                System.out.println("Taburete altura total: " + eElement.getElementsByTagName("alturaTotal").item(0).getTextContent());
                System.out.println("Taburete asiento: " + eElement.getElementsByTagName("asiento").item(0).getTextContent());
                System.out.println("Taburete base: " + eElement.getElementsByTagName("base").item(0).getTextContent());
                System.out.println("Distancia reposapies al asiento : " + eElement.getElementsByTagName("disRepoAsi").item(0).getTextContent());
                System.out.println("Pie : " + eElement.getElementsByTagName("pie").item(0).getTextContent());
                System.out.println("Peso : " + eElement.getElementsByTagName("peso").item(0).getTextContent());
                System.out.println("Material : " + eElement.getElementsByTagName("material").item(0).getTextContent());
            }

            if (temp >= nList.getLength() - 1) {
                System.out.println(";;;;");
            } else {
                System.out.println(";;");
            }

        }

    }

}
