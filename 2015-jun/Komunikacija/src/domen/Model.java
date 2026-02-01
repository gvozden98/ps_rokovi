/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.time.LocalDateTime;

/**
 *
 * @author Ognjen
 */
public class Model {

    private int modelID;
    private String ime;
    private String prezime;
    private LocalDateTime datumRodjenja;

    public Model() {
    }

    public int getModelID() {
        return modelID;
    }

    public void setModelID(int modelID) {
        this.modelID = modelID;
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

    public LocalDateTime getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDateTime datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }
    
    

}
