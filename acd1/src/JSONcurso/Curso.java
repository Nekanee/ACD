/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSONcurso;

import java.util.ArrayList;

/**
 *
 * @author FP
 */
public class Curso {

    private String nombre;
    private ArrayList<UsuarioAvanzado> modulo;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.modulo = new ArrayList<UsuarioAvanzado>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<UsuarioAvanzado> getModulo() {
        return modulo;
    }

    public void setModulo(ArrayList<UsuarioAvanzado> modulo) {
        this.modulo = modulo;
    }

    public boolean agregarModulo(UsuarioAvanzado e) {
        return modulo.add(e);
    }
}
