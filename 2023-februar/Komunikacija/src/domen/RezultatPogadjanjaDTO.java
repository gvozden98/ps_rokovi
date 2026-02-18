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
public class RezultatPogadjanjaDTO implements Serializable {

    private int pogodjeni;
    private int pogodjeniNisuNaMestu;

    public RezultatPogadjanjaDTO() {
    }

    public RezultatPogadjanjaDTO(int pogodjeni, int pogodjeniNisuNaMestu) {
        this.pogodjeni = pogodjeni;
        this.pogodjeniNisuNaMestu = pogodjeniNisuNaMestu;
    }

    public int getPogodjeniNisuNaMestu() {
        return pogodjeniNisuNaMestu;
    }

    public void setPogodjeniNisuNaMestu(int pogodjeniNisuNaMestu) {
        this.pogodjeniNisuNaMestu = pogodjeniNisuNaMestu;
    }

    public int getPogodjeni() {
        return pogodjeni;
    }

    public void setPogodjeni(int pogodjeni) {
        this.pogodjeni = pogodjeni;
    }

}
