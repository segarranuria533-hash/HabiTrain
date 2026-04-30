package com.habitrain.service;

import com.habitrain.dao.RegistroHabitosDAO;

public class RegistrosHabitosService {

    public static void registrar(int id_habito, String estado) {


        if (id_habito <= 0) {
            System.out.println("ID inválido");
            return;
        }


        if (estado == null || estado.isBlank()) {
            System.out.println("Estado inválido");
            return;
        }


        RegistroHabitosDAO.registrar(id_habito, estado);
    }

    public static void listar() {
        RegistroHabitosDAO.listar();
    }
}