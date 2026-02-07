/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domen.Angazovanje;
import domen.Dizajner;
import domen.Model;
import domen.ModnaRevija;
import dto.AngazovaniModeliDTO;
import dto.ModnaRevijaAngazovanjeDTO;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Ognjen
 */
public class DatabaseBroker {

    public List<Dizajner> getAllDizajneri() throws Exception {
        List<Dizajner> dizajneri = new ArrayList<>();
        String sql = "SELECT * FROM dizajner";
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dizajner d = new Dizajner();
                d.setDizajnerID(rs.getInt("DizajnerID"));
                d.setIme(rs.getString("Ime"));
                d.setPrezime(rs.getString("Prezime"));
                dizajneri.add(d);
            }
        }
        return dizajneri;
    }

    public List<Model> getAllModeli() throws Exception {
        List<Model> modeli = new ArrayList<>();
        String sql = "SELECT * FROM model";
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Model m = new Model();
                m.setModelID(rs.getInt("ModelID"));
                m.setIme(rs.getString("Ime"));
                m.setPrezime(rs.getString("Prezime"));
                modeli.add(m);
            }
        }
        return modeli;
    }

    public Integer insertModnaRevija(ModnaRevijaAngazovanjeDTO madto) throws Exception {
        String sql = "INSERT INTO modnarevija (Naziv,DatumOdrzavanja,DizajnerID) VALUES (?,?,?)";
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, madto.getModnaRevija().getNaziv());
            ps.setObject(2, madto.getModnaRevija().getDatumOdrzavanja());
            ps.setInt(3, madto.getModnaRevija().getDizajner().getDizajnerID());

            int dodato = ps.executeUpdate();

            if (dodato != 1) {
                throw new Exception("Greska pri dodavanju modne revije!");
            }

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
                throw new Exception("Nije vracen id modne revije!");
            }
        }
    }

    public void insertSvaAngazovanja(Angazovanje a) throws Exception {
        String sql = "INSERT INTO angazovanje (BrojSati,Zarada,Komentar,ModnaRevijaID,ModelID) VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, a.getBrojSati());
            ps.setInt(2, a.getZarada());
            ps.setString(3, a.getKomentar());
            ps.setInt(4, a.getModnaRevija().getModnaRevijaID());
            ps.setInt(5, a.getModel().getModelID());
            ps.executeUpdate();
        }
    }

    public void proveriDizajnera(ModnaRevija modnaRevija) throws Exception {
        String sql = """
                     SELECT * FROM modnarevija WHERE DizajnerID = ? AND DatumOdrzavanja=?;
                     """;
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, modnaRevija.getDizajner().getDizajnerID());
            ps.setObject(2, modnaRevija.getDatumOdrzavanja().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                throw new Exception("Postoji angazovan Dizajner " + modnaRevija.getDizajner().toString() + " datuma"
                        + modnaRevija.getDatumOdrzavanja());
            }
        }
    }

    public void proveriModele(List<Angazovanje> a) throws Exception {
        String sql = """
                        SELECT a.ModelID,COUNT(*) AS cnt FROM angazovanje a
                         JOIN modnarevija m ON m.ModnaRevijaID=a.ModnaRevijaID
                         WHERE DatumOdrzavanja=? AND a.ModelID IN (?) GROUP BY a.ModelID
                         HAVING COUNT(*) > 0;
                     """;
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {

            for (Angazovanje angazovanje : a) {
                ps.setObject(1, angazovanje.getModnaRevija().getDatumOdrzavanja());
                ps.setInt(2, angazovanje.getModel().getModelID());

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    throw new Exception("Model " + angazovanje.getModel().toString() + " je zauzet toga dana");
                }
            }

        }

    }

    public List<AngazovaniModeliDTO> getAngazovaniModeli() throws Exception {
        List<AngazovaniModeliDTO> angazovani = new ArrayList<>();
        String sql = """
                     SELECT CONCAT(m.Ime,' ',m.Prezime) AS "Model", COUNT(mr.ModnaRevijaID) AS "Broj revija",
                      SUM(a.Zarada) AS "Ukupna zarada", SUM(a.BrojSati) AS "Ukupan broj Sati"
                     FROM angazovanje a
                     INNER JOIN modnarevija mr ON a.ModnaRevijaID=mr.ModnaRevijaID
                     INNER JOIN model m ON a.ModelID=m.ModelID GROUP BY m.ModelID;
                     """;
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AngazovaniModeliDTO amdto = new AngazovaniModeliDTO();
                amdto.setModel(rs.getString("Model"));
                amdto.setBrojRevija(rs.getInt("Broj revija"));
                amdto.setUkupnaZarada(rs.getInt("Ukupna zarada"));
                amdto.setUkupanBrojSati(rs.getInt("Ukupan broj sati"));
                angazovani.add(amdto);
            }
        }
        return angazovani;
    }
}
