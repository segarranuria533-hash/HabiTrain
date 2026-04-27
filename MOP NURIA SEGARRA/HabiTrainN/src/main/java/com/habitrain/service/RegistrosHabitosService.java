package com.habitrain.service;

import com.habitrain.dao.RegistroHabitosDAO;

public class RegistrosHabitosService {
    public static void registrar(int id_habito,String estado,int id_usuario){
        if (id_habito<=0){
            System.out.println("ID inválido");
            return;
        }
        if (estado ==null || estado.isBlank()){
            System.out.println("Estado inválido");
            return;
        }
        if (id_usuario<=0){
            System.out.println("ID_usuario inválido");
            return;
        }
        RegistroHabitosDAO.registrar(id_habito,estado,id_usuario);
    }
    public static void listar(){
        RegistroHabitosDAO.listar();
    }
}
