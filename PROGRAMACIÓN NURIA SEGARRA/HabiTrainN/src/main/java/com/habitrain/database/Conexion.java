package com.habitrain.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3307/HabiTrain";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos HabiTrain", e);
        }
    }
}