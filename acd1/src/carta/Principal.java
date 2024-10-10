/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner teclado = new Scanner(System.in);

        File fichero = new File("C:\\Users\\FP\\Desktop\\plantilla.txt");
        File ficheroEscritura = new File("C:\\Users\\FP\\Desktop\\carta.txt");
        FileReader leer = new FileReader(fichero);
        FileWriter escribir = new FileWriter(ficheroEscritura);
        BufferedReader texto = new BufferedReader(leer);

        String linea;

        System.out.println("Intoduce el nombre, apellido, jefe y departamento");
        String nombre = teclado.next();
        String apellido = teclado.next();
        String jefe = teclado.next();
        String departamento = teclado.next();

        while ((linea = texto.readLine()) != null) {

            linea = linea.replace("$nombre", nombre);

            linea = linea.replace("$apellido", apellido);

            linea = linea.replace("$jefe", jefe);

            linea = linea.replace("$departamento", departamento);

            escribir.write(linea + "\n");

        }

        leer.close();
        escribir.close();
        texto.close();

    }

}
