/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSONcurso;

import org.json.*;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) {

        UsuarioAvanzado usuario1 = new UsuarioAvanzado("1", "Acceso a datos", "6", "8.45");
        UsuarioAvanzado usuario2 = new UsuarioAvanzado("2", "Programacion", "3", "9.0");

        //crear proyecto con prtiipantes
        Curso proyecto = new Curso("DAM");

        proyecto.agregarModulo(usuario1);
        proyecto.agregarModulo(usuario2);

        //converitr el proycto a un jsonObject
        JSONObject jsonProyecto = new JSONObject();
        jsonProyecto.put("nombre", proyecto.getNombre());

        JSONArray jsonModulos = new JSONArray();
        for (UsuarioAvanzado mod : proyecto.getModulo()) {

            JSONObject jsonModulo = new JSONObject();
            jsonModulo.put("id", mod.getId());
            jsonModulo.put("nombre", mod.getNombre());
            jsonModulo.put("horas", mod.getHoras());
            jsonModulo.put("Nota", mod.getNota());

            jsonModulos.put(jsonModulo);

        }
        jsonProyecto.put("participantes", jsonModulos);
        
        //escribir en el archivo JSON
        try {
            java.nio.file.Files.write(
                    java.nio.file.Paths.get("modulo.json"), jsonProyecto.toString().getBytes());

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }

}
