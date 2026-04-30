package com.habitrain.dao;

import com.habitrain.database.Conexion;

import java.sql.*;

public class RegistroHabitosDAO {
   public static void registrar(int id_habitos,String estado){

       String sql = "INSERT INTO Registro_Habitos(id_habitos,fecha, estado) VALUES(?,?,?)";
       try (Connection connection = Conexion.getConectar();
            PreparedStatement ps = connection.prepareStatement(sql)) {
           java.sql.Date fecha= new java.sql.Date(System.currentTimeMillis());
           ps.setInt(1,id_habitos);
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
        try (Connection connection = Conexion.getConectar();
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
    System.out.println("error al listar registros: "+ e.getMessage());
        }
    }
}
