package com.habitrain.service;

import com.habitrain.dao.HabitosDAO;
import com.habitrain.utils.Validator;

public class HabitosService {

    public static void crearHabito(int id_usuario, String nombre, int meta_diaria) {

        if (!Validator.isValidId(id_usuario)) {
            System.out.println("ID usuario inválido");
            return;
        }

        if (!Validator.isNotEmpty(nombre)) {
            System.out.println("Nombre vacío");
            return;
        }

        if (meta_diaria <= 0) {
            System.out.println("Meta inválida");
            return;
        }

        HabitosDAO.insertar(id_usuario, nombre, meta_diaria);
    }

    public static void listarPorUsuario(int idUsuario) {

        if (!Validator.isValidId(idUsuario)) {
            System.out.println("ID inválido");
            return;
        }

        HabitosDAO.listarPorUsuario(idUsuario);
    }

    public static void eliminar(int idHabito) {

        if (!Validator.isValidId(idHabito)) {
            System.out.println("ID inválido");
            return;
        }

        HabitosDAO.eliminar(idHabito);
    }
}
