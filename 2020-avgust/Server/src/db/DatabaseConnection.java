/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;

/**
 *
 * @author Ognjen
 */
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/2020-avgust";
    private final String user = "root";
    private final String password = "";

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (Exception e) {
            System.out.println("Greska pri konekciji sa bazom");
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
}
