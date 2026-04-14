package com.habitrain.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection conectar(){
      try {
          String url ="jdbc:mysql://localhost:3307/HabiTrain";
          String user="root";
          String password="";
          Connection connection= DriverManager.getConnection(url,user,password);
          System.out.println("Conectado correctamente");
          return  connection;
      }catch (Exception e){
          System.out.println("error de conexión");
          e.printStackTrace();
          return  null;
      }
    }
}
