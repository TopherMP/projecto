package com.example.projecto;

public class list_Elements {
    public int imagen;
    public String name;
    public String ingredientes;
    public String precio;

    public list_Elements(int imagen,String name, String ingredientes, String precio) {
        this.imagen = imagen;
        this.name = name;
        this.ingredientes = ingredientes;
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
