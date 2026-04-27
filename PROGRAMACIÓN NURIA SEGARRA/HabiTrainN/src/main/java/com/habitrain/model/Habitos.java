package com.habitrain.model;

public class Habitos {
    private int id_habitos;
    private int id_usuario;
    private  String nombre;
    private int meta_diaria;

    public Habitos(int id_habitos, int id_usuario, String nombre, int meta_diaria){
        this.id_habitos=id_habitos;
        this.id_usuario=id_usuario;
        this.nombre=nombre;
        this.meta_diaria=meta_diaria;

    }

    public int getId_habitos() {
        return id_habitos;
    }

    public int getId_usuario(){
        return id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMeta_diaria() {
        return meta_diaria;
    }
}
