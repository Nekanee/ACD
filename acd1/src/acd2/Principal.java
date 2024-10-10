/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acd2;

import java.io.File;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) {

        File f = new File("C:\\Program Files\\Java\\jdk-21");
        File f2 = new File("C:\\Program Files\\Java\\jdk-22");

        if (f.exists()) {
            System.out.println("Tienes instalado el jdk 21");

        } else {
            System.out.println("No tienes el jdk 21");
        }

        if (f2.exists()) {
            System.out.println("Tienes instalado el jdk 22");

        } else {
            System.out.println("No tienes el jdk 22");
        }

    }

}
