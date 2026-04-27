package com.habitrain.service;

import com.habitrain.dao.EjerciciosDAO;
import com.habitrain.model.Ejercicios;

import java.util.List;

public class EjerciciosService {
    public static void insertar(String nombre, String grupo_muscular){
        if (nombre == null || nombre.isBlank()) {

            System.out.println("Nombre inválido");
            return;
        }
        if (grupo_muscular==null|| grupo_muscular.isBlank()){
            System.out.println("Grupo muscular inválido");
            return;
        }
        EjerciciosDAO.insertar(nombre,grupo_muscular);
    }
    public static List<Ejercicios> listar() {
        var lista = EjerciciosDAO.listar();

        if (lista.isEmpty()) {
            System.out.println("No hay ejercicios");
            return List.of();
        }
        return lista;
    }

}
