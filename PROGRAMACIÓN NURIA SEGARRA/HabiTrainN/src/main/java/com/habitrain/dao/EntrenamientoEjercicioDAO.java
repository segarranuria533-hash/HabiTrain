package com.habitrain.dao;

import com.habitrain.database.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EntrenamientoEjercicioDAO {
    public static void agregarEjercicio(int id_entrenamiento, int id_ejercicios, int series,int repeticiones){
        String sql="INSERT INTO Entrenamiento_Ejercicio(id_entrenamiento,id_ejercicios,series,repeticiones) VALUES(?,?,?,?)" ;

        try (Connection connection= Conexion.getConectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1,id_entrenamiento);
        ps.setInt(2,id_ejercicios);
        ps.setInt(3,series);
        ps.setInt(4,repeticiones);

        ps.executeUpdate();
        System.out.println("Ejercicio añadido al entrenamiento");

    }catch (SQLException e){
            e.printStackTrace();

        }
}
}
