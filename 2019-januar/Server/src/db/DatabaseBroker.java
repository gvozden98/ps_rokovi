/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domen.Kviz;
import domen.Pitanje;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Ognjen
 */
public class DatabaseBroker {

    public void login(String string) {

    }

    public static List<Kviz> getAllKvizovi() throws Exception {
        String sql = "SELECT * FROM kviz";
        List<Kviz> kvizovi = new ArrayList<>();
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Kviz k = new Kviz();
                k.setKvizID(rs.getInt("KvizID"));
                k.setNaziv(rs.getString("Naziv"));
                kvizovi.add(k);
            }
        }
        return kvizovi;
    }

    public List<Pitanje> getAllPitanja(Kviz kviz) throws Exception {
        String sql = "SELECT * FROM pitanje WHERE KvizID=?";
        List<Pitanje> pitanja = new ArrayList<>();
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, kviz.getKvizID());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pitanje p = new Pitanje();
                p.setKviz(kviz);
                p.setBrojPoena(rs.getInt("BrojPoena"));
                p.setPitanje(rs.getString("Pitanje"));
                p.setPitanjeID(rs.getInt("PitanjeID"));
                p.setTacanOdgovor(rs.getString("TacanOdgovor"));
                pitanja.add(p);
            }
            return pitanja;
        }
    }
}
