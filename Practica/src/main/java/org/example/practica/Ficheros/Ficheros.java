package org.example.practica.Ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ficheros {
   static Scanner teclado = new Scanner(System.in);
    static void main(String[] args) {



        System.out.println("Cuantos archivos queres crear: ");
        int num = teclado.nextInt();
        crearFicheros(num);

        File carpeta = new File("src/main/resources/pruebas");
        String nombre_ficheros[] = carpeta.list();

        for (String nombre : nombre_ficheros){
            System.out.println(nombre);
        }

        File ficheros[] = carpeta.listFiles();
        for (File nombre : ficheros){
            if (nombre.isFile()) {
                System.out.println(nombre.getName() + " tamaño " + nombre.length());
            }
        }
//        try {
//            if (archivo.createNewFile()){
//                System.out.println("Archivo creado.");
//            }else{
//                System.out.println("el archivo no se ha creado.");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("ruta absoluta " + archivo.getAbsolutePath());
//        System.out.println("Tamñano " + archivo.length());
//       if (archivo.exists()) {
//            if (archivo.delete()) {
//                System.out.println("Eliminado el archivo " + archivo.getName());
//
//            } else {
//                System.out.println("El archivo " + archivo.getName() + " no se ha eliminado");
//            }
//        }
//
//        File carpeta = new File("src/main/resources/pruebas");
//        if (carpeta.mkdir()){
//            System.out.println("Carpeta " + carpeta.getName() + " creada");
//        }else {
//            System.out.println("La carpeta no se ha creado.");
//        }
    }
    public static void crearFicheros(int num){
        System.out.println("En que carpeta lo quieres?");
        String nombre_carpeta = teclado.next();

        for (int i = 0; i < num; i++) {
            File archivo = new File("src/main/resources/" + nombre_carpeta + "/prueba" + i + ".txt");
            try {
                if (archivo.createNewFile()){
                    System.out.println("Archivo creado correctamente");
                    System.out.println("Ruta " + archivo.getAbsolutePath());
                }else {
                    System.out.println("Archivo no creado");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
