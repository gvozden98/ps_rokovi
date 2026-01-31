/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domen.IstorijaStatusaRada;
import domen.Profesor;
import domen.Rad;
import domen.StatusRada;
import domen.Student;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class DatabaseBroker {

    public List<Student> getSviStudenti() throws Exception {
        List<Student> studenti = new LinkedList<>();
        String sql = "SELECT * from student";

        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setStudentID(rs.getInt("StudentID"));
                s.setBrojIndeksa(rs.getString("BrojIndeksa"));
                s.setGodinaUpisa(rs.getInt("GodinaUpisa"));
                s.setIme(rs.getString("Ime"));
                s.setPrezime(rs.getString("Prezime"));
                studenti.add(s);
            }

//      Ne treba da zatvaras u try-with-resources
//            ps.close();
//            rs.close();
        }
        return studenti;
    }

    public List<Profesor> getSviProfesori() throws Exception {
        List<Profesor> profesori = new LinkedList<>();
        String sql = "SELECT * from profesor";

        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Profesor p = new Profesor();
                p.setProfesorID(rs.getInt("ProfesorID"));
                p.setIme(rs.getString("Ime"));
                p.setPrezime(rs.getString("Prezime"));
                p.setZvanje(rs.getString("Zvanje"));
                profesori.add(p);
            }
        }
        return profesori;
    }

    public List<StatusRada> getSviStatusiRada() throws Exception {
        List<StatusRada> statusiRada = new LinkedList<>();
        String sql = "SELECT * from statusrada";

        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StatusRada sr = new StatusRada();
                sr.setStatusID(rs.getInt("StatusID"));
                sr.setNazivStatusa(rs.getString("NazivStatusa"));
                statusiRada.add(sr);
            }
        }
        return statusiRada;
    }

    public Integer insertRad(Rad rad) throws Exception {
        String sql = "INSERT INTO rad (Tema, StudentID, ProfesorID) VALUES(?,?,?)";
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, rad.getTema());
            ps.setInt(2, rad.getStudent().getStudentID());
            ps.setInt(3, rad.getProfesor().getProfesorID());
            int dodato = ps.executeUpdate();
            if (dodato != 1) {
                throw new Exception("Greska pri dodavanju rada u bazu!");
            }
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
                throw new Exception("Nije vracen id rada!");
            }
        }
    }

    public void insertIstorijaStatusaRada(IstorijaStatusaRada isr) throws Exception {
        String sql = "INSERT INTO istorijastatusarada(RadID, RB, Datum, StatusRadaID) VALUES(?,?,?,?)";
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, isr.getRad().getRadID());
            ps.setInt(2, isr.getRb());
            ps.setObject(3, isr.getDatum());
            ps.setInt(4, isr.getStatusRada().getStatusID());
            ps.executeUpdate();
        }

    }

}
