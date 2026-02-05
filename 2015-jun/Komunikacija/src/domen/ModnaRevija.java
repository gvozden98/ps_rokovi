/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Ognjen
 */
public class ModnaRevija implements Serializable {

    private int modnaRevijaID;
    private String naziv;
    private LocalDate datumOdrzavanja;
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

    public LocalDate getDatumOdrzavanja() {
        return datumOdrzavanja;
    }

    public void setDatumOdrzavanja(LocalDate datumOdrzavanja) {
        this.datumOdrzavanja = datumOdrzavanja;
    }

    public Dizajner getDizajner() {
        return dizajner;
    }

    public void setDizajner(Dizajner dizajner) {
        this.dizajner = dizajner;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ModnaRevija{");
        sb.append("modnaRevijaID=").append(modnaRevijaID);
        sb.append(", naziv=").append(naziv);
        sb.append(", datumOdrzavanja=").append(datumOdrzavanja);
        sb.append(", dizajner=").append(dizajner);
        sb.append('}');
        return sb.toString();
    }

}
