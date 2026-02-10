/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Ognjen
 */
public class Pitanje implements Serializable {

    private int pitanjeID;
    private String pitanje;
    private String tacanOdgovor;
    private int brojPoena;
    private Kviz kviz;

    public Pitanje() {
    }

    public int getPitanjeID() {
        return pitanjeID;
    }

    public void setPitanjeID(int pitanjeID) {
        this.pitanjeID = pitanjeID;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public String getTacanOdgovor() {
        return tacanOdgovor;
    }

    public void setTacanOdgovor(String tacanOdgovor) {
        this.tacanOdgovor = tacanOdgovor;
    }

    public int getBrojPoena() {
        return brojPoena;
    }

    public void setBrojPoena(int brojPoena) {
        this.brojPoena = brojPoena;
    }

    public Kviz getKviz() {
        return kviz;
    }

    public void setKviz(Kviz kviz) {
        this.kviz = kviz;
    }

    @Override
    public String toString() {
        return pitanje;
    }

}
