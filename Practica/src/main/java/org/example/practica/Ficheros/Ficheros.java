package org.example.practica.Ficheros;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ficheros {
    static Scanner teclado = new Scanner(System.in);

    static void main(String[] args) {
        ejercicio10();
    }

    public static void actividad1() {
        File carpeta = new File("src/main/resources/pruebas");
        if (carpeta.mkdir()) {
            System.out.println("Carpeta " + carpeta.getName() + " creada");
        } else {
            System.out.println("La carpeta no se ha creado o ya existe.");
        }
    }

    public static void actividad2() {
        File archivo = new File("src/main/resources/pruebas/ejemplo1.txt");
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo " + archivo.getName() + " ya existe, por eso ahora lo encuentra.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void actividad3() {
        File archivo = new File("src/main/resources/pruebas/ejemplo1.txt");
        System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
        System.out.println("Tamaño actual en caracteres: " + archivo.length());
    }

    public static void actividad4() {
        System.out.println("Cuantos archivos quieres crear: ");
        int num = teclado.nextInt();

        System.out.println("En que carpeta los quieres guardar? (ej: pruebas): ");
        String nombre_carpeta = teclado.next();

        for (int i = 1; i <= num; i++) {
            File archivo = new File("src/main/resources/" + nombre_carpeta + "/nombre(" + i + ").txt");
            try {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado correctamente: " + archivo.getName());
                } else {
                    System.out.println("Archivo no creado o ya existente: " + archivo.getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void actividad5() {
        File carpeta = new File("src/main/resources/pruebas");

        listarCarpeta(carpeta);

        System.out.println("\n--- Lista usando la sobrecarga para archivos .pdf ---");
        listarCarpeta(carpeta, ".pdf");
    }

    public static void listarCarpeta(File carpeta) {
        File[] ficheros = carpeta.listFiles();
        if (ficheros != null) {
            for (File nombre : ficheros) {
                if (nombre.isFile() && nombre.getName().endsWith(".txt")) {
                    System.out.println(nombre.getName() + " tamaño: " + nombre.length());
                }
            }
        }
    }

    public static void listarCarpeta(File carpeta, String extension) {
        File[] ficheros = carpeta.listFiles();
        if (ficheros != null) {
            for (File nombre : ficheros) {
                if (nombre.isFile() && nombre.getName().endsWith(extension)) {
                    System.out.println(nombre.getName() + " tamaño: " + nombre.length());
                }
            }
        }
    }

    public static void actividad6() {
        System.out.println("Introduce la palabra a buscar: ");
        String palabra = teclado.next();

        int contador = 0;

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/main/resources/pruebas/ejemplo1.txt")
            );

            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (String p : palabras) {
                    if (p.equalsIgnoreCase(palabra)) {
                        contador++;
                    }
                }
            }

            reader.close();
            System.out.println("La palabra '" + palabra + "' aparece " + contador + " veces.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void actividad7() {
        System.out.println("Introduce la palabra a buscar: ");
        String palabra = teclado.next();

        int contador = 0;

        try {
            Scanner lector = new Scanner(
                    new File("src/main/resources/pruebas/ejemplo1.txt")
            );

            while (lector.hasNext()) {
                String palabraLeida = lector.next();
                if (palabraLeida.equalsIgnoreCase(palabra)) {
                    contador++;
                }
            }

            lector.close();
            System.out.println("La palabra '" + palabra + "' aparece " + contador + " veces.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void actividad8() {
        System.out.println("Cuantos archivos quieres crear: ");
        int num = teclado.nextInt();

        System.out.println("En que carpeta los quieres guardar? (ej: pruebas): ");
        String nombre_carpeta = teclado.next();

        for (int i = 1; i <= num; i++) {
            File archivo = new File(
                    "src/main/resources/" + nombre_carpeta + "/nombre(" + i + ").txt"
            );
            try {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado correctamente: " + archivo.getName());

                    // Escribimos la frase dentro del archivo recién creado
                    BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
                    writer.write("Este es el fichero nombre(" + i + ").txt");
                    writer.close();

                } else {
                    System.out.println("Archivo no creado o ya existente: " + archivo.getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    public static void ejercicio9(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\2smrb\\Documents\\FX_Xampp\\Practica\\src\\main\\resources\\actividad9"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\2smrb\\Documents\\FX_Xampp\\Practica\\src\\main\\resources\\actividad9"));
            String linea = " ";
            while ((linea = reader.readLine()) != null){
                String vectorLine[] = linea.split(" ");
                for (String palabra : vectorLine){
                    palabra = palabra.substring(0,1).toLowerCase() + palabra.substring(1);
                    System.out.println(palabra+"");
                    writer.write(" " + palabra + " ");
                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ejercicio10( ){
        try {
            BufferedReader archivo1 = new BufferedReader(new FileReader("src/main/resources/actividad9"));
            BufferedReader archivo2 = new BufferedReader(new FileReader("src/main/resources/actividad9"));
            BufferedWriter resultado = new BufferedWriter(new FileWriter("src/main/resources/actividad9"));

            String linea;
            Queue<String> cola1 = new LinkedList<>();
            while ((linea = archivo1.readLine()) != null){
                String palabritas[] = linea.split(" ");
                for (String palabra : palabritas){
                    cola1.offer(palabra);
                }
            }
            Queue<String> cola2 = new LinkedList<>();
            while ((linea = archivo1.readLine()) != null){
                String palabritas[] = linea.split(" ");
                for (String palabra : palabritas){
                    cola2.offer(palabra);
                }
            }
            while (cola1.isEmpty() || cola2.isEmpty()){
                resultado.write(cola1.poll() + " " + cola2.poll() + " ");
            }

            if (cola1.isEmpty()) {
                while (!cola2.isEmpty()) {
                    resultado.write(" " + cola2.poll());
                }
            }else {
                while (!cola1.isEmpty()){
                    resultado.write(" " + cola1.poll());
                }
            }

            archivo1.close();
            archivo2.close();
            resultado.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}