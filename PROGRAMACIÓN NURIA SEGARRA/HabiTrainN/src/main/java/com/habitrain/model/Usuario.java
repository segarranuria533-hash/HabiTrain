package com.habitrain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Usuario {
    private  int id_usuario;
    private String nombre;
    private String apellido;
    public Usuario(){}

    public Usuario(int id, String nombre, String apellido){
        this.id_usuario=id_usuario;
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public int getId() {
        return id_usuario;
    }

    public void setId(int id) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Usuario(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }
    @Override
    public  String toString(){
        return  id_usuario +"-"+nombre+""+apellido;
    }

}
