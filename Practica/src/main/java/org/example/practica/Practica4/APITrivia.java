package org.example.practica.Practica4;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APITrivia {
    public static void main(String[] args) {

            try {
                String apiUrl = "https://opentdb.com/api.php?amount=3&category=18&type=multiple";

                URL url = new URL(apiUrl);
                HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                conexion.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                StringBuilder json = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    json.append(line);
                }
                in.close();

                Gson gson = new Gson();
                RespuestaTrivia respuesta = gson.fromJson(json.toString(), RespuestaTrivia.class);

                for (Pregunta p : respuesta.results) {
                    System.out.println("Categoría: " + p.category);
                    System.out.println("Dificultad: " + p.difficulty);
                    System.out.println("Pregunta: " + p.question);
                    System.out.println("Respuesta correcta: " + p.correct_answer);
                    System.out.println("Respuestas incorrectas: " + p.incorrect_answers);
                    System.out.println();
                }

            } catch (Exception e) {
                System.out.println("Algo ha ido mal.");
                e.printStackTrace();
            }
    }
}
