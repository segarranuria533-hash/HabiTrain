package com.habitrain.dao;

import com.habitrain.database.Conexion;
import com.habitrain.model.Entrenamiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntrenamientoDAO {
public static void insertar(int id_usuario, String nombre_entreno){
    String sql="INSERT INTO Entrenamiento(id_usuario,nombre_entreno)VALUES(?,?)";
    try (Connection conn = Conexion.getConectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1,id_usuario);
        ps.setString(2,nombre_entreno);

        ps.executeUpdate();
        System.out.println("Entrenamiento Creado");
    }catch (SQLException e){
        System.out.println(" error de entrenamiento,  no creado");

        e.printStackTrace();

    }

}
public static List<Entrenamiento>listarPorUsuario(int id_usuario){
    List<Entrenamiento>lista=new ArrayList<>();
    String sql="SELECT * FROM Entrenamiento WHERE id_usuario =?";
    try (Connection connection= Conexion.getConectar();
    PreparedStatement ps= connection.prepareStatement(sql)){
        ps.setInt(1,id_usuario);
        ResultSet rs= ps.executeQuery();

        while (rs.next()){
            Entrenamiento entrenamientos=new Entrenamiento(
                    rs.getInt("id_entrenamiento"),
                    rs.getInt("id_usuario"),
                    rs.getString("nombre_entreno")
            );
            lista.add(entrenamientos);
        }
    }catch (SQLException e){
        e.printStackTrace();

    }
    return lista;
}
}
