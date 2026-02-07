/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import domen.Model;
import domen.ModnaRevija;

/**
 *
 * @author Ognjen
 */
public class AngazovaniModeliDTO {

    private String model;
    private int brojRevija;
    private int ukupnaZarada;
    private int ukupanBrojSati;

    public AngazovaniModeliDTO() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBrojRevija() {
        return brojRevija;
    }

    public void setBrojRevija(int brojRevija) {
        this.brojRevija = brojRevija;
    }

    public int getUkupnaZarada() {
        return ukupnaZarada;
    }

    public void setUkupnaZarada(int ukupnaZarada) {
        this.ukupnaZarada = ukupnaZarada;
    }

    public int getUkupanBrojSati() {
        return ukupanBrojSati;
    }

    public void setUkupanBrojSati(int ukupanBrojSati) {
        this.ukupanBrojSati = ukupanBrojSati;
    }

    @Override
    public String toString() {
        return "AngazovaniModeliDTO{" + "model=" + model + ", brojRevija=" + brojRevija + ", ukupnaZarada=" + ukupnaZarada + ", ukupanBrojSati=" + ukupanBrojSati + '}';
    }

}
