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
public class ModnaRevija {

    private int modnaRevijaID;
    private String naziv;
    private LocalDateTime datumOdrzavanja;
    private Dizajner dizajner;

    public ModnaRevija() {
    }

    public int getModnaRevijaID() {
        return modnaRevijaID;
    }

    public void setModnaRevijaID(int modnaRevijaID) {
        this.modnaRevijaID = modnaRevijaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public LocalDateTime getDatumOdrzavanja() {
        return datumOdrzavanja;
    }

    public void setDatumOdrzavanja(LocalDateTime datumOdrzavanja) {
        this.datumOdrzavanja = datumOdrzavanja;
    }

    public Dizajner getDizajner() {
        return dizajner;
    }

    public void setDizajner(Dizajner dizajner) {
        this.dizajner = dizajner;
    }
    
    
}
