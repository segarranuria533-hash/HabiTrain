package com.habitrain.dao;

import com.habitrain.database.Conexion;

import java.sql.*;

public class RegistroHabitos {
   public static void registrar(int idHabitos,String estado){
       String sql= "INSERT INTO registro_habitos(id_habitos,fecha,estado) VALUES(?,?,?)";
       try (Connection connection = Conexion.conectar();
            PreparedStatement ps = connection.prepareStatement(sql)) {
           Date fecha= new Date(System.currentTimeMillis());
           ps.setInt(1,idHabitos);
           ps.setDate(2, fecha);
           ps.setString(3,estado);
        ps.executeUpdate();
        System.out.println("Registro de hábito guardado como" +estado);

       }catch (SQLException e){
           e.printStackTrace();
           System.out.println("ERROR AL REGISTRAR PROGRESO:" +e.getMessage());

       }

    }
    public static void listar(){
       String sql="SELECT r.id_registro_habitos, h.nombre, r.fecha, r.estado " +
               "FROM Registro_Habitos r " +
               "JOIN Habitos h ON r.id_habitos = h.id_habitos";
        try (Connection connection = Conexion.conectar();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.println("\n---HISTORIAL DE PROGRESO");
            while (rs.next()){
                System.out.println(
                        "ID: " + rs.getInt("id_registro_habitos") +
                                " | Hábito: " + rs.getString("nombre") +
                                " | Fecha: " + rs.getDate("fecha") +
                                " | Estado: " + rs.getString("estado"));
            }

       }catch (SQLException e){
    e.printStackTrace();
    System.out.println("error al listar registrs"+ e.getMessage());
        }
    }
}
