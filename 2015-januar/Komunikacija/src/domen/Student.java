package domen;

import java.io.Serializable;

public class Student implements Serializable {

    private Integer studentID;
    private String brojIndeksa;
    private Integer godinaUpisa;
    private String ime;
    private String prezime;

    public Student() {
    }

    public Student(Integer studentID, String brojIndeksa, Integer godinaUpisa, String ime, String prezime) {
        this.studentID = studentID;
        this.brojIndeksa = brojIndeksa;
        this.godinaUpisa = godinaUpisa;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public Integer getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(Integer godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return brojIndeksa + " - " + ime + " " + prezime;
    }

}
