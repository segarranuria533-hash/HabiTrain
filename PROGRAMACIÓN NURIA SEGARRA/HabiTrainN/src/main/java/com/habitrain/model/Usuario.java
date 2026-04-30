package com.habitrain.model;

public class Usuario {
    private  int id_usuario;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String email;
    private String rol;

    public Usuario(){}

    public Usuario(int id_usuario, String nombre, String apellido,String email,String contrasena,String rol){
        this.id_usuario=id_usuario;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.contrasena=contrasena;
        this.rol=rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public  String toString(){
        return  "ID: " + id_usuario +
                " | Nombre: " + nombre + " " + apellido +
                " | Email: " + email +
                " | Rol: " + rol;
    }

    }


