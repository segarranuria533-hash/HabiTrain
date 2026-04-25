package com.habitrain.service;

import com.habitrain.dao.EntrenamientoEjercicioDAO;

public class EntrenamientoEjercicioService {
    public static void agregar(int id_entreno, int id_ejercicio, int series, int repeticiones){
        if (id_entreno<=0 || id_ejercicio <=0){
            System.out.println("IDs inválidos");
            return;
        }
        if (series <=0 || repeticiones <=0){
            System.out.println("Datos inválidos");
            return;
        }
        EntrenamientoEjercicioDAO.agregarEjercicio(id_entreno,id_ejercicio,series,repeticiones);
    }
}
