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
public class StudijskiProgram implements Serializable {

    private int studijskiProgramID;
    private String naziv;

    public StudijskiProgram() {
    }

    public int getStudijskiProgramID() {
        return studijskiProgramID;
    }

    public void setStudijskiProgramID(int studijskiProgramID) {
        this.studijskiProgramID = studijskiProgramID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
