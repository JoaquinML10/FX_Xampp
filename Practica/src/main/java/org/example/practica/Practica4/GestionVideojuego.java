package org.example.practica.Practica4;

import java.io.File;
import java.io.IOException;
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

    static public void GuardaeJson(){
        File guardarJuego = new File(RUTA_ARCHIVO);
        try {
            if (guardarJuego.createNewFile()){
                System.out.println("El archivo " + guardarJuego.getName() + "se creo correctamente");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
