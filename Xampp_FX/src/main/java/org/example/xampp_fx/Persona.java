package org.example.xampp_fx;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private Integer nia;
    private LocalDate fecha_nacimiento;

    public Persona(String nombre, Integer nia, LocalDate fecha_nacimiento) {
        this.nombre = nombre;
        this.nia = nia;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNia() {
        return nia;
    }

    public void setNia(Integer nia) {
        this.nia = nia;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", nia=" + nia +
                ", fecha_nacimiento=" + fecha_nacimiento +
                '}';
    }
}
