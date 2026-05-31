package org.example.practica.Serializacion;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GestionEjercicio4 {
    static void main(String[] args) {
        Map<String, Ejercicio1> mapa = new HashMap<>();

        mapa.put("ID1", new Ejercicio1("Raul",20,"raul@gmail.com"));
        mapa.put("ID2", new Ejercicio1("David",25,"david@gmail.com"));
        mapa.put("ID3", new Ejercicio1("Carlos", 30, "carlos@gmail.com"));

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/mapa.ser"));
            out.writeObject(mapa);
            out.close();
            System.out.println("HashMap serializado");
        } catch (IOException e) {
            System.out.println("Algo paso");
            e.printStackTrace();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/mapa.ser"));
            HashMap<String, Ejercicio1> mapaRecuperado = (HashMap<String, Ejercicio1>) in.readObject();
            in.close();
            TreeMap<String, Ejercicio1> mapaOrdenado = new TreeMap<>(mapaRecuperado);
            for (String clave : mapaOrdenado.keySet()) {
                System.out.println(clave + " " + mapaOrdenado.get(clave));
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Algo paso");
            e.printStackTrace();
        }

    }
}
