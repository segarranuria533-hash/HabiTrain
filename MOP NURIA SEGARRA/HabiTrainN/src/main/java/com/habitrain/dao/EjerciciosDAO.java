package com.habitrain.dao;

import com.habitrain.database.Conexion;
import com.habitrain.model.Ejercicios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EjerciciosDAO {
    public static void insertar(String nombre, String grupo_muscular){
        String sql="INSERT INTO Ejercicios(nombre,grupo_muscular) VALUES (?,?)";

        try (Connection connection = Conexion.getConectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1,nombre);
            ps.setString(2,grupo_muscular);

            ps.executeUpdate();
            System.out.println("Ejercicio Creado");
        }catch(SQLException e){
            System.out.println(" ERROR No se pudo realizar la operación");
        e.printStackTrace();
        }
    }
    public static List<Ejercicios>listar(){
        List<Ejercicios>lista= new ArrayList<>();
        String sql="SELECT * FROM Ejercicios";

        try (Connection connection= Conexion.getConectar();
             Statement st= connection.createStatement();
             ResultSet rs= st.executeQuery(sql)){

            while (rs.next()){
                Ejercicios ejercicio=new Ejercicios(
                        rs.getInt("id_ejercicios"),
                        rs.getString("nombre"),
                        rs.getString("grupo_muscular")
                );
                lista.add(ejercicio);
            }
    } catch (SQLException e){
            System.out.println("error al acceder a la Base de datos del ejercicio");
            e.printStackTrace();

        }
        return lista;
}
}