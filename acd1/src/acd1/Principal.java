/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package acd1;

import java.io.File;

/**
 *
 * @author FP
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File("escritorio\\mbappe.xml");

        System.out.println("Nombre: " + f.getName());
        System.out.println("Ruta absoluta: " + f.getAbsolutePath());
        System.out.println("Diretrio padre:" + f.getParent());
        System.out.println("Directorio padre: " + f.getPath());

        if (f.exists() == true) {
            System.out.println("El fihero existe");
        } else {
            System.out.println("No existe el fichero");
        }

        if (f.isDirectory() == true) {
            System.out.println("Es directorio");
        } else {
            System.out.println("No es directorio");
        }
        if (f.isFile() == true) {
            System.out.println("Es fichero");
        } else {
            System.out.println("No es fichero");
        }
    }

}
