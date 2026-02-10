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

    private final String url = "jdbc:mysql://localhost:3300/2019-januar";
    private final String user = "root";
    private final String password = "";

    private DatabaseConnection() throws Exception {
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            System.out.println("Povezan sa bazom!");
        } catch (Exception e) {
            System.out.println("Greska pri povezivanju sa bazom! " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public static DatabaseConnection getInstance() throws Exception {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
