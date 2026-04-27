package com.habitrain.model;

public class Ejercicios {
    private int id_ejercicios;
    private String nombre;
    private String grupo_muscular;

    public Ejercicios() {
    }
    public Ejercicios(int id_ejercicios, String nombre, String grupo_muscular){
        this.id_ejercicios=id_ejercicios;
        this.nombre=nombre;
        this.grupo_muscular=grupo_muscular;
    }

    public int getId_ejercicios() {
        return id_ejercicios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGrupo_muscular() {
        return grupo_muscular;
    }
    @Override
    public String toString() {
        return "ID: " + id_ejercicios +
                " | Nombre: " + nombre +
                " | Grupo muscular: " + grupo_muscular;
    }
}
