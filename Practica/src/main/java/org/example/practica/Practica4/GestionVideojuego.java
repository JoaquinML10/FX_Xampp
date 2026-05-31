package org.example.practica.Practica4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionVideojuego {
    private static final String RUTA_ARCHIVO = "src/main/resources/videojuegos.json";
    static Scanner teclado = new Scanner(System.in);
    static void main(String[] args) {
    ArrayList<VideoJuegos> listaJuegos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listaJuegos.add(pedirJuego());
        }
        guardarJson(listaJuegos);

        System.out.println("Contenido del archivo JSON");
        leerJson();

        ArrayList<VideoJuegos> listaReconstruida = cargarDesdeJson();
        System.out.println("Colección reconstruida desde JSON");
        for (VideoJuegos v : listaReconstruida) {
            System.out.println(v);
        }

        System.out.println("Añadir nuevo videojuego");
        listaReconstruida.add(pedirJuego());

        System.out.println("Videojuegos con precio menor a 30€");
        mostrarBaratos(listaReconstruida, 30);

        guardarJson(listaReconstruida);
        System.out.println("Lista actualizada guardada en " + RUTA_ARCHIVO);
    }
    static public VideoJuegos pedirJuego() {
        boolean disponible = true;
        System.out.println("Nonbre del juego: ");
        String nombre = teclado.nextLine();
        System.out.println("Plataforma: ");
        String plataforma = teclado.nextLine();
        System.out.println("Precio: ");
        double precio = teclado.nextDouble();
        System.out.println("Esta disponible?: ");
        String sino = teclado.next().toLowerCase();
        teclado.nextLine();
        if (sino.equals("no")) {
            disponible = false;
        }
        System.out.println("Generos");
        String generos = teclado.nextLine();
        String[] vectorGenero = generos.split(",");

        ArrayList<String> generoLista = new ArrayList<>();


        VideoJuegos videoJuegos = new VideoJuegos(nombre, plataforma, precio, disponible);
        for (String verGenero : vectorGenero) {
            videoJuegos.setGenero(verGenero);
        }
        return videoJuegos;
    }

    static public void guardarJson(ArrayList<VideoJuegos> listaJuegos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(listaJuegos);

        File guardarJuego = new File(RUTA_ARCHIVO);
        try {
            guardarJuego.getParentFile().mkdirs();
            FileWriter escritor = new FileWriter(guardarJuego);
            escritor.write(json);
            escritor.close();
            System.out.println("Archivo guardado correctamente: " + guardarJuego.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public void leerJson() {
        File archivo = new File(RUTA_ARCHIVO);
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public ArrayList<VideoJuegos> cargarDesdeJson() {
        Gson gson = new Gson();
        ArrayList<VideoJuegos> lista = new ArrayList<>();
        File archivo = new File(RUTA_ARCHIVO);
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            Type tipoLista = new TypeToken<ArrayList<VideoJuegos>>(){}.getType();
            lista = gson.fromJson(lector, tipoLista);
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
    static public void mostrarBaratos(ArrayList<VideoJuegos> listaJuegos, double limite) {
        for (VideoJuegos v : listaJuegos) {
            if (v.getPrecio() < limite) {
                System.out.println(v);
            }
        }
    }
}
