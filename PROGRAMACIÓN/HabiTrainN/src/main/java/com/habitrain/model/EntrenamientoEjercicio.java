package com.habitrain.model;

public class EntrenamientoEjercicio {
    private int idEntrenamiento;
    private int idEjercicio;
    private int series;
    private int repeticiones;

    public EntrenamientoEjercicio(int idEntrenamiento,int idEjercicio,int series,int repeticiones){
        this.idEjercicio=idEjercicio;
        this.idEntrenamiento=idEntrenamiento;
        this.series=series;
        this.repeticiones=repeticiones;
    }

    public int getIdEntrenamiento() {
        return idEntrenamiento;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public int getSeries() {
        return series;
    }

    public int getRepeticiones() {
        return repeticiones;
    }
}
