/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import java.util.List;
import komunikacija.Poruka;

/**
 *
 * @author Ognjen
 */
public class DatabaseBroker {

    public void sacuvajPoruke(List<Poruka> poruke) throws SQLException {
        String sql = "INSERT INTO poruka (KorisnikOd,KorisnikZa,DatumVreme,TekstPoruke) VALUES (?,?,?,?)";
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
            for (Poruka poruka : poruke) {
                ps.setString(1, poruka.getKorisnikOd());
                ps.setString(2, poruka.getKorisnikZa());
                ps.setObject(3, poruka.getDatumVreme());
                ps.setString(4, poruka.getTekstPoruke());
                int odgovor = ps.executeUpdate();
                if (odgovor != 1) {
                    DatabaseConnection.getInstance().getConnection().rollback();
                    throw new SQLException("ne moze se dodati poruka");
                }
            }
            DatabaseConnection.getInstance().getConnection().commit();
        }
    }
}
