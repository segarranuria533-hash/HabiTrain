package com.habitrain.dao;

import com.habitrain.database.Conexion;

import java.sql.*;

public class UsuarioDAO {
    public static void listar(){
        String sql= "SELECT * FROM Usuario";
        try (Connection connection = Conexion.conectar();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()){
                System.out.println(
                        rs.getInt("id_usuario")+"-"+
                                rs.getString("nombre")+""+
                                rs.getString("apellido")
                );
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void insertar(String nombre, String apellido,String contrasena,String email){
        try{
            Connection connection= Conexion.conectar();
            String sql="INSERT INTO Usuario(nombre,apellido,contrasena,email)VALUES(?,?,?,?)";
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1,nombre);
            ps.setString(2,apellido);
            ps.setString(3,contrasena);
            ps.setString(4,email);
            ps.executeUpdate();
            System.out.println("Usuario insertado");

        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public static void eliminar (int id){
        try {
            Connection connection=Conexion.conectar();
            String sql="DELETE FROM Usuario WHERE id_usuario=?";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, id);

            int filas=ps.executeUpdate();
            if (filas>0){
                System.out.println("Usuario eliminado");
            }else{
                System.out.print("no existe usuario con ese ID");
            }


        }catch (SQLException e){
            e.printStackTrace();

        }
    }
}
