/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.IstorijaStatusaRada;
import domen.Rad;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class SacuvajRadRequest implements Serializable {

    private Rad rad;
    private List<IstorijaStatusaRada> statusi;

    public SacuvajRadRequest(Rad rad, List<IstorijaStatusaRada> statusi) {
        this.rad = rad;
        this.statusi = statusi;
    }

    public Rad getRad() {
        return rad;
    }

    public List<IstorijaStatusaRada> getStatusi() {
        return statusi;
    }

    public void setRad(Rad rad) {
        this.rad = rad;
    }

    public void setStatusi(List<IstorijaStatusaRada> statusi) {
        this.statusi = statusi;
    }
    
    
}
