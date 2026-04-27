package com.habitrain.service;

import com.habitrain.dao.EntrenamientoDAO;
import com.habitrain.model.Entrenamiento;
import com.habitrain.utils.Validator;

import java.util.List;

public class EntrenamientosService {

    public static void crearEntrenamiento(int id_usuario, String nombre) {

        if (id_usuario <= 0 || nombre == null || nombre.isBlank()) {
            System.out.println("Datos inválidos");
            return;
        }

        EntrenamientoDAO.insertar(id_usuario, nombre);
    }

    public static List<Entrenamiento> listarPorUsuario(int id_usuario) {

        if (!Validator.isValidId(id_usuario)) {
            System.out.println("ID de usuario inválido");
            return List.of();
        }

        return EntrenamientoDAO.listarPorUsuario(id_usuario);
    }
}
