/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSON;

import org.json.*;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) {
        //crear usuarios
        UsuarioAvanzado usuario1 = new UsuarioAvanzado("Jude Bellingam", 21);
        UsuarioAvanzado usuario2 = new UsuarioAvanzado("Kylian Mbappe", 25);

        //crear proyecto con prtiipantes
        Proyecto proyecto = new Proyecto("Copa de Europa 24/25");
        proyecto.agregarParticipante(usuario1);
        proyecto.agregarParticipante(usuario2);

        //converitr el proycto a un jsonObject
        JSONObject jsonProyecto = new JSONObject();
        jsonProyecto.put("nombre", proyecto.getNombre());

        JSONArray jsonParticipantes = new JSONArray();
        for (UsuarioAvanzado participante : proyecto.getParticipantes()) {

            JSONObject jsonParticipante = new JSONObject();
            jsonParticipante.put("nombre", participante.getNombre());
            jsonParticipante.put("edad", participante.getEdad());
            jsonParticipantes.put(jsonParticipante);

        }
        jsonProyecto.put("participantes", jsonParticipantes);

        //escribir en el archivo JSON
        try {
            java.nio.file.Files.write(
                    java.nio.file.Paths.get("proyecto.json"), jsonProyecto.toString().getBytes());

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        // lectura de un archico JSON
        try {
            String contenido = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("proyecto.json")));
            JSONObject jsonLeido = new JSONObject(contenido);

            // recuperar los datos del pryecto 
            String nombreProyecto = jsonLeido.getString("nombre");
            JSONArray jsonParticipantesLeidos = jsonLeido.getJSONArray("participantes");

            // crear un proyecto con los datos leidos 
            Proyecto proyectoLeido = new Proyecto(nombreProyecto);

            //agregar los participantes 
            for (int i = 0; i < jsonParticipantesLeidos.length(); i++) {
                JSONObject jsonParticipante = jsonParticipantesLeidos.getJSONObject(i);
                String nombreParticipante = jsonParticipante.getString("nombre");
                int edadParticipante = jsonParticipante.getInt("edad");

                UsuarioAvanzado participanteLeido = new UsuarioAvanzado(nombreParticipante, edadParticipante);

                //agrego al ArrayList 
                proyectoLeido.agregarParticipante(participanteLeido);
            }
            System.out.println("Proyecto: "+proyectoLeido.getNombre());
            System.out.println("Participantes: ");
            
            //muestro el array 
            for(UsuarioAvanzado participante : proyectoLeido.getParticipantes()){
                System.out.println("- "+participante.getNombre()+" Edad: "+participante.getEdad());
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
