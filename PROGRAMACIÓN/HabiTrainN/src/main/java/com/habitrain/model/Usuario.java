package com.habitrain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

class Usuario {
    private  int id;
    private String nombre;
    private String apellido;
    public Usuario(){}

    public Usuario(int id, String nombre, String apellido){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return  id +"-"+nombre+""+apellido;
    }

}
