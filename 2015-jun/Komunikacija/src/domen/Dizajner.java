/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

/**
 *
 * @author Ognjen
 */
public class Dizajner {

    private int dizajnerID;
    private String ime;
    private String prezime;

    public Dizajner(int dizajnerID, String ime, String prezime) {
        this.dizajnerID = dizajnerID;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Dizajner() {
    }

    public int getDizajnerID() {
        return dizajnerID;
    }

    public void setDizajnerID(int dizajnerID) {
        this.dizajnerID = dizajnerID;
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
    
}
