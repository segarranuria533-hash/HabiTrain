package com.habitrain.model;

public class Entrenamiento {
    private int id_entrenamiento;
    private int id_usuario;
    private String nombre_entreno;

    public Entrenamiento(int id_entrenamiento, int id_usuario, String nommbre_entreno){
        this.id_entrenamiento=id_entrenamiento;
        this.id_usuario=id_usuario;
        this.nombre_entreno=nommbre_entreno;
    }

    public int getId_entrenamiento() {
        return id_entrenamiento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNommbre_enntreno() {
        return nombre_entreno;
    }
    @Override
    public String toString() {
        return "ID: " + id_entrenamiento +
                " | Usuario: " + id_usuario +
                " | Nombre: " + nombre_entreno;
    }
}
