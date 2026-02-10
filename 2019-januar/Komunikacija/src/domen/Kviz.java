/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Ognjen
 */
public class Kviz implements Serializable {

    private int kvizID;
    private String naziv;
    private LocalDateTime datumVremePocetka;
    private LocalDateTime datumVremeKraja;

    public Kviz() {
    }

    public int getKvizID() {
        return kvizID;
    }

    public void setKvizID(int kvizID) {
        this.kvizID = kvizID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public LocalDateTime getDatumVremePocetka() {
        return datumVremePocetka;
    }

    public void setDatumVremePocetka(LocalDateTime datumVremePocetka) {
        this.datumVremePocetka = datumVremePocetka;
    }

    public LocalDateTime getDatumVremeKraja() {
        return datumVremeKraja;
    }

    public void setDatumVremeKraja(LocalDateTime datumVremeKraja) {
        this.datumVremeKraja = datumVremeKraja;
    }

    @Override
    public String toString() {
        return naziv;
    }

}
