package com.habitrain.dao;

import com.habitrain.database.Conexion;
import com.habitrain.model.Usuario;

import java.sql.*;

public class UsuarioDAO {
    public static void listar(){
        String sql= "SELECT * FROM Usuario";
        try (Connection connection = Conexion.getConectar();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

        System.out.println("\n---LISTA DE USUARIOS---");
            while (rs.next()){
                System.out.println(
                        "ID: " + rs.getInt("id_usuario") +
                                " | Nombre: " + rs.getString("nombre") +
                                " " + rs.getString("apellido") +
                                " | Email: " + rs.getString("email") +
                                " | Rol: " + rs.getString("rol")
                );
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void insertar(String nombre, String apellido,String contrasena,String email){
        String sql="INSERT INTO Usuario(nombre,apellido,contrasena,email,rol)VALUES(?,?,?,?,'USER')";

        try{
            Connection connection= Conexion.getConectar();
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setString(1,nombre);
            ps.setString(2,apellido);
            ps.setString(3,contrasena);
            ps.setString(4,email);
            ps.executeUpdate();
            System.out.println("Usuario insertado");

        }catch (SQLException e){
            System.out.println("error no insertado");

            e.printStackTrace();

        }
    }
    public static void eliminar (int id){
        try {
            Connection connection=Conexion.getConectar();
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
    public static Usuario login(String email,String contrasena){
        String sql ="SELECT * FROM Usuario WHERE email=? AND contrasena=?";

        try (Connection connection = Conexion.getConectar();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1,email);
            ps.setString(2,contrasena);

            ResultSet rs=ps.executeQuery();
             if (rs.next()){
                 Usuario u=new Usuario();
                 u.setId_usuario(rs.getInt("id_usuario"));
                 u.setNombre(rs.getString("nombre"));
                 u.setApellido(rs.getString("apellido"));
                 u.setEmail(rs.getString("email"));
                 u.setContrasena(rs.getString("contrasena"));
                 u.setRol(rs.getString("rol"));                 return u;
             }

        }catch (SQLException e){
            e.printStackTrace();

        }
        return null;
}
}


