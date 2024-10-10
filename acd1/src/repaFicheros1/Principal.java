/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaFicheros1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f = new File("C:\\Users\\FP\\Desktop\\fichero.txt");
        FileReader leer = new FileReader(f);
        BufferedReader texto = new BufferedReader(leer);

        String linea;

        int parrafos = 0;
        int palabras = 0;
        int caracteres = 0;
        int contLineas = 0;

        while ((linea = texto.readLine()) != null) {
            parrafos++;
            caracteres = caracteres + linea.length();

            for (int i = 0; i < linea.length(); i++) {
                if (linea.charAt(i) == ' ') {
                    palabras++;
                }
            }

            if (contLineas == 95) {
                contLineas = (caracteres / 95);
            } else {
                contLineas = (caracteres / 95 + 1);
            }

        }

        System.out.println("parrafos: " + parrafos);
        System.out.println("palabras: " + (palabras + parrafos));
        System.out.println("caracteres: " + caracteres);
        System.out.println("caracteres sin espacios: " + (caracteres - palabras));
        System.out.println("lineas: " + contLineas);

        leer.close();
        texto.close();

    }
}
