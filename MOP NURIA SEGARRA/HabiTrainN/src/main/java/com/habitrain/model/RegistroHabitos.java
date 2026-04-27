package com.habitrain.model;

import java.sql.Date;

public class RegistroHabitos {
    private int id_registro_habitos;
    private int id_habitos;
    private Date fecha;
    private String estado;

    public  RegistroHabitos(int id_registro_habitos, int id_habitos, Date fecha,String estado){
        this.id_registro_habitos=id_registro_habitos;
        this.id_habitos=id_habitos;
        this.fecha=fecha;
        this.estado=estado;
    }

    public int getId_registro_habitos(){
        return id_registro_habitos;
    }

    public int getIdHabito() {
        return id_habitos;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;

    }


    @Override
    public String toString() {
        return "ID: " + id_registro_habitos +
                " | Fecha: " + fecha +
                " | Estado: " + estado;

}
}

