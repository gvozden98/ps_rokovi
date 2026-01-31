/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Profesor;
import domen.StatusRada;
import domen.Student;

/**
 *
 * @author Ognjen
 */
public class PrikazRadovaDTO {

    private String imeProfesora;
    private String imeStudenta;
    private String brojIndeksa;
    private int godinaUpisa;
    private String statusRada;

    public PrikazRadovaDTO(String imeProfesora, String imeStudenta, String brojIndeksa, int godinaUpisa, String statusRada) {
        this.imeProfesora = imeProfesora;
        this.imeStudenta = imeStudenta;
        this.brojIndeksa = brojIndeksa;
        this.godinaUpisa = godinaUpisa;
        this.statusRada = statusRada;
    }

    public String getStatusRada() {
        return statusRada;
    }

    public void setStatusRada(String statusRada) {
        this.statusRada = statusRada;
    }

    public String getImeProfesora() {
        return imeProfesora;
    }

    public void setImeProfesora(String imeProfesora) {
        this.imeProfesora = imeProfesora;
    }

    public String getImeStudenta() {
        return imeStudenta;
    }

    public void setImeStudenta(String imeStudenta) {
        this.imeStudenta = imeStudenta;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }
    
     
}
