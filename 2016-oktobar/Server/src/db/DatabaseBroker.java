/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domen.Fakultet;
import domen.Kandidat;
import domen.StudijskiProgram;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class DatabaseBroker {

    public Kandidat loginKandidat(Kandidat kandidat) throws Exception {
        String sql = "SELECT * FROM kandidat WHERE KorisnickoIme=? AND Lozinka=?";
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConn().prepareStatement(sql)) {
            ps.setString(1, kandidat.getKorisnickoIme());
            ps.setString(2, kandidat.getLozinka());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                kandidat.setIme(rs.getString("Ime"));
                kandidat.setKandidatID(rs.getInt("KandidatID"));
                kandidat.setPrezime(rs.getString("Prezime"));
                return kandidat;
            }
            throw new Exception("Kandidat ne postoji!");
        }
    }

    public List<Fakultet> getAllFakulteti() throws Exception {
        List<Fakultet> fakulteti = new ArrayList<>();
        String sql = "SELECT * from fakultet";
        try (Statement st = DatabaseConnection.getInstance().getConn().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Fakultet f = new Fakultet();
                f.setFakultetID(rs.getInt("FakultetID"));
                f.setAdresa(rs.getString("Adresa"));
                f.setNaziv(rs.getString("Naziv"));
                f.setTelefon(rs.getString("Telefon"));
                fakulteti.add(f);
            }
        }
        return fakulteti;
    }

    public List<StudijskiProgram> getAllStudijskiProgrami() throws Exception {
        List<StudijskiProgram> studijskiProgrami = new ArrayList<>();
        String sql = "SELECT * from studijskiprogram";
        try (Statement st = DatabaseConnection.getInstance().getConn().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                StudijskiProgram s = new StudijskiProgram();
                s.setStudijskiProgramID(rs.getInt("StudijskiProgramID"));
                s.setNaziv(rs.getString("Naziv"));
                studijskiProgrami.add(s);
            }
        }
        return studijskiProgrami;
    }

}
