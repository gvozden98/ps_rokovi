/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import domen.Angazovanje;
import domen.ModnaRevija;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class ModnaRevijaAngazovanjeDTO implements Serializable {

    private ModnaRevija modnaRevija;
    private List<Angazovanje> a;

    public ModnaRevijaAngazovanjeDTO() {
    }

    public ModnaRevijaAngazovanjeDTO(ModnaRevija modnaRevija, List<Angazovanje> a) {
        this.modnaRevija = modnaRevija;
        this.a = a;
    }

    public ModnaRevija getModnaRevija() {
        return modnaRevija;
    }

    public void setModnaRevija(ModnaRevija modnaRevija) {
        this.modnaRevija = modnaRevija;
    }

    public List<Angazovanje> getA() {
        return a;
    }

    public void setA(List<Angazovanje> a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "modnaRevijaAngazovanjeDTO{" + "modnaRevija=" + modnaRevija + ", a=" + a + '}';
    }
}
