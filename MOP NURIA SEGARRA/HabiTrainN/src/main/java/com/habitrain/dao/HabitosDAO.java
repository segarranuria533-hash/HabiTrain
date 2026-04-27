package com.habitrain.dao;

import com.habitrain.database.Conexion;
import com.habitrain.model.Habitos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HabitosDAO {
    public static void insertar(int id_usuario, String nombre,int meta_diaria){
        String sql="INSERT INTO habitos(id_usuario, nombre,meta_diaria)VALUES (?,?,?)";
        try (Connection connection = Conexion.getConectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1,id_usuario);
            ps.setString(2,nombre);
            ps.setInt(3,meta_diaria);

            ps.executeUpdate();
            System.out.println("Hábito"+ nombre +"'insertado correctamente'");


        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error al insertar" +e.getMessage() );

        }
    }
    public static void listarPorUsuario(int id_usuario) {
        String sql = "SELECT * FROM Habitos WHERE id_usuario = ?";
        try (Connection connection = Conexion.getConectar();
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,id_usuario);
            ResultSet rs= ps.executeQuery();
System.out.println("\n--- HÁBITOS DEL USUARIO");
            while (rs.next()){
                System.out.println(
                        "ID: " + rs.getInt("id_habitos") +
                                " | Nombre: " + rs.getString("nombre") +
                                " | Meta diaria: " + rs.getInt("meta_diaria")
                );
            }

         }catch (SQLException e){
            e.printStackTrace();

        }
    }
    public  static void eliminar(int idHabitos){
        String sql= "DELETE FROM Habitos WHERE id_habitos=?";
        try (Connection connection = Conexion.getConectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1,idHabitos);
            int filas=ps.executeUpdate();
            if (filas>0) {
                System.out.println("Habito eliminado");
            }else {
                System.out.println("No SE ENCONTRO NINGÚN HÁBITO CON ESE ID");
            }

    }catch (SQLException e){
            System.out.println("Error al eliminar" +e.getMessage()) ;

        }

        }

}
