package org.example.practica.Practica4;

import java.util.ArrayList;

public class VideoJuegos {
    private String nombre;
    private String plataforma;
    private double precio;
    private boolean disponible;
    private ArrayList<String> genero;

    public VideoJuegos(String nombre, String plataforma, double precio, boolean disponible) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.precio = precio;
        this.disponible = disponible;
        this.genero = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public ArrayList<String> getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero.add(genero);
    }

    @Override
    public String toString() {
        return "VideoJuegos{" +
                "nombre='" + nombre + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", precio=" + precio +
                ", disponible=" + disponible +
                ", genero=" + genero +
                '}';
    }
}
