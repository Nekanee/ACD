/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciojsonsw;

import java.util.ArrayList;

/**
 *
 * @author FP
 */
public class Personaje {

    private String name;
    private String height;
    private ArrayList<Pelicula> pelicula;
    private ArrayList<Especies> especie;

    public Personaje(String name, String height) {
        this.name = name;
        this.height = height;
        this.pelicula = new ArrayList < Pelicula > ();
        this.especie = new ArrayList < Especies > ();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public ArrayList<Pelicula> getPelicula() {
        return pelicula;
    }

    public void setPelicula(ArrayList<Pelicula> pelicula) {
        this.pelicula = pelicula;
    }

    public ArrayList<Especies> getEspecie() {
        return especie;
    }

    public void setEspecie(ArrayList<Especies> especie) {
        this.especie = especie;
    }

    
    public boolean agregarPelicula(Pelicula e ){
        return pelicula.add(e);
    }
    public boolean agregarEspecie(Especies e ){
        return especie.add(e);
    }
}
