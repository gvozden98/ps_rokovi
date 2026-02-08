/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Ognjen
 */
public class Prijava implements Serializable {

    private int prijavaID;
    private int godinaUpisa;
    private int godinaDiplomiranja;
    private double prosecnaOcena;
    private LocalDate datumPrijave;
    private boolean oslobodjenPrijemnog;
    private Fakultet fakultet;
    private StudijskiProgram studijskiProgram;
    private Kandidat kandidat;

    public Prijava() {
    }

    public int getPrijavaID() {
        return prijavaID;
    }

    public void setPrijavaID(int prijavaID) {
        this.prijavaID = prijavaID;
    }

    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public int getGodinaDiplomiranja() {
        return godinaDiplomiranja;
    }

    public void setGodinaDiplomiranja(int godinaDiplomiranja) {
        this.godinaDiplomiranja = godinaDiplomiranja;
    }

    public double getProsecnaOcena() {
        return prosecnaOcena;
    }

    public void setProsecnaOcena(double prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }

    public LocalDate getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(LocalDate datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public boolean isOslobodjenPrijemnog() {
        return oslobodjenPrijemnog;
    }

    public void setOslobodjenPrijemnog(boolean oslobodjenPrijemnog) {
        this.oslobodjenPrijemnog = oslobodjenPrijemnog;
    }

    public Fakultet getFakultet() {
        return fakultet;
    }

    public void setFakultet(Fakultet fakultet) {
        this.fakultet = fakultet;
    }

    public StudijskiProgram getStudijskiProgram() {
        return studijskiProgram;
    }

    public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
        this.studijskiProgram = studijskiProgram;
    }

    public Kandidat getKandidat() {
        return kandidat;
    }

    public void setKandidat(Kandidat kandidat) {
        this.kandidat = kandidat;
    }

}
