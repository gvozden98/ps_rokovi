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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import komunikacija.PregledRadovaKriterijum;
import komunikacija.PrikazRadovaDTO;

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

    public List<PrikazRadovaDTO> getPrikazRadova(PregledRadovaKriterijum k) throws Exception {
        List<PrikazRadovaDTO> prikazRadova = new LinkedList<>();
        StringBuilder sql = new StringBuilder();

        sql.append("""
                     SELECT p.Ime AS Profesor, s.Ime AS Student, s.BrojIndeksa, s.GodinaUpisa, sr.NazivStatusa
                     FROM rad r JOIN student s ON s.StudentID=r.StudentID
                      JOIN profesor p ON r.ProfesorID=p.ProfesorID
                      JOIN istorijastatusarada isr ON r.RadID=isr.RadID
                      JOIN statusrada sr ON isr.StatusRadaID=sr.StatusID
                      JOIN (SELECT RadID,MAX(Datum) AS maxDat FROM istorijastatusarada isr GROUP BY RadID) poslednji
                      ON poslednji.RadID=isr.RadID AND poslednji.maxDat=isr.Datum WHERE 1=1
                     """);

        boolean godinaUpisa = false;
        boolean statusRada = false;
        int i = 1;
        if (k != null && k.getGodinaUpisa() != null) {
            sql.append(" AND s.godinaUpisa = ? ");
            godinaUpisa = true;
        }
        if (k != null && k.getStatusRada() != null) {
            sql.append(" AND sr.statusID = ? ");
            statusRada = true;
        }

        sql.append("ORDER BY s.GodinaUpisa ASC, isr.Datum ASC");

        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql.toString())) {

            if (godinaUpisa) {
                ps.setInt(i, k.getGodinaUpisa());
                i++;
            }
            if (statusRada) {
                ps.setString(i, k.getStatusRada());
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PrikazRadovaDTO prikaz = new PrikazRadovaDTO();
                prikaz.setImeProfesora(rs.getString("Profesor"));
                prikaz.setImeStudenta(rs.getString("Student"));
                prikaz.setBrojIndeksa(rs.getString("BrojIndeksa"));
                prikaz.setGodinaUpisa(rs.getInt("GodinaUpisa"));
                prikaz.setStatusRada(rs.getString("NazivStatusa"));
                prikazRadova.add(prikaz);
            }
        }
        return prikazRadova;
    }

}
