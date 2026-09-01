package com.example.registroproductos.model;

import java.time.LocalDate;

public class Producto {

    private int id;
    private String Nombre;
    private String Categoria;
    private double Precio;
    private LocalDate FechaRegistro;
    private String ImagePath;

    public Producto() {
    }

    public Producto(int id, String nombre, String categoria, double precio, LocalDate fechaRegistro, String imagePath) {
        this.id = id;
        Nombre = nombre;
        Categoria = categoria;
        Precio = precio;
        FechaRegistro = fechaRegistro;
        ImagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public double getPrecio() {
        return Precio;
    }

    public LocalDate getFechaRegistro() {
        return FechaRegistro;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        FechaRegistro = fechaRegistro;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }
}
