package org.example.practica.Serializacion;

import java.io.*;
import java.util.ArrayList;

public class GestionEjercicio5 {
    public static void main(String[] args) {

        ArrayList<Empleado> lista = new ArrayList<>();
        lista.add(new Empleado("Fabricio", 1500));
        lista.add(new Empleado("Renzo", 1800));
        lista.add(new Jefe("Manolito", 3000, "Informatix"));
        lista.add(new Jefe("Pedro", 3500, "Recursos Humanos"));

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/empleados.ser"));
            out.writeObject(lista);
            out.close();
            System.out.println("Lista serializada");
        } catch (IOException e) {
            System.out.println("Algo se rompio");
            e.printStackTrace();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/empleados.ser"));
            ArrayList<Empleado> listaRecuperada = (ArrayList<Empleado>) in.readObject();
            in.close();

            for (Empleado empleado : listaRecuperada) {
                System.out.println(empleado);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Como pudo pasar esto");
            e.printStackTrace();
        }
    }
}
