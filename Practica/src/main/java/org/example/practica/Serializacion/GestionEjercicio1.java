package org.example.practica.Serializacion;

import java.io.*;
import java.util.ArrayList;

public class GestionEjercicio1 {
    private static final String RUTA = "src/main/resources/clase_prueba.ser";

    public static void main(String[] args) {

        ArrayList<Ejercicio1> lista = new ArrayList<>();
        lista.add(new Ejercicio1("Angel", 25, "ana@gmail.com"));
        lista.add(new Ejercicio1("Carlos", 30, "carlos@gmail.com"));
        lista.add(new Ejercicio1("Jacobo", 80, "jacobito@gmail.com"));

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(RUTA));
            out.writeObject(lista);
            out.close();
            System.out.println(RUTA);
            System.out.println("Lista antes de esterializarla");
            for (Ejercicio1 ejercicio1 : lista) {
                System.out.println(ejercicio1);
            }
        } catch (IOException e) {
            System.out.println("Algo paso.");
            e.printStackTrace();
        }
        System.out.println();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(RUTA));
            ArrayList<Ejercicio1> listaRecuperada = (ArrayList<Ejercicio1>) in.readObject();
            in.close();
            System.out.println("Lista despues de desearizarla");
            for (Ejercicio1 ejercicio1 : listaRecuperada) {
                System.out.println(ejercicio1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe creando datos por defecto");
            crearDatosPorDefecto();

        } catch (IOException e) {
            System.out.println("El archivo está dañado creando datos por defecto");
            crearDatosPorDefecto();

        } catch (ClassNotFoundException e) {
            System.out.println("Algo paso");
            e.printStackTrace();
        }


    }
    public static void crearDatosPorDefecto(){
        ArrayList<Ejercicio1> listaPorDefecto = new ArrayList<>();
        listaPorDefecto.add(new Ejercicio1("Usuario1", 20, "usuario1@gmail.com"));
        listaPorDefecto.add(new Ejercicio1("Usuario2", 21, "usuario2@gmail.com"));

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(RUTA));
            out.writeObject(listaPorDefecto);
            out.close();
            System.out.println("Archivo creado con datos por defecto.");
        } catch (IOException e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }
    }
}
