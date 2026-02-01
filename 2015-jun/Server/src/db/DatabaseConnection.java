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

    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://127.0.0.1/2015-jun";

    private final Connection conn;

    private DatabaseConnection() throws Exception {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Konekcija sa bazom uspostavljena!");
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

    public Connection getConnection() {
        return conn;
    }

    public void rollback() throws Exception {
        try {
            conn.rollback();
            System.out.println("Transakcija uspesno ponistena!");

        } catch (Exception e) {
            System.out.println("Tranzakcija nije ponistena! " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void commit() throws Exception {
        try {
            conn.commit();
            System.out.println("Tranzakcija izvrsena!");
        } catch (Exception e) {
            System.out.println("Tranzakcija nije izvrsena pri commitu!" + e.getMessage());
            e.printStackTrace();
            throw e;
        }

    }

}
