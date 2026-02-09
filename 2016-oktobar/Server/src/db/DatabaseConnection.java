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
    private Connection conn;
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/2016-oktobar";
    private String user = "root";

    public DatabaseConnection() throws Exception {
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
        } catch (Exception e) {
            System.out.println("Greska, konekcija sa bazom nije usposavljena!");
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

    public Connection getConn() {
        return conn;
    }

}
