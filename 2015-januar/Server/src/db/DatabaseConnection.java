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

    private final String url = "jdbc:mysql://localhost:3306/2015-januar";
    private final String user = "root";
    private final String password = "";
    private Connection connection;

    private DatabaseConnection() throws Exception {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Konekcija uspesno uspostavljena");
            connection.setAutoCommit(false);
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

    public Connection getConnection() throws Exception {
        return connection;
    }

    public void rollback() throws Exception {
        try {
            connection.rollback();
            System.out.println("Transakcija uspesno ponistena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije ponistena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

}
