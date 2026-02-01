/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

/**
 *
 * @author Ognjen
 */
public class PregledRadovaKriterijum {

    private Integer godinaUpisa;
    private String statusRada;

    public PregledRadovaKriterijum() {
    }

    public PregledRadovaKriterijum(Integer godinaUpisa, String statusRada) {
        this.godinaUpisa = godinaUpisa;
        this.statusRada = statusRada;
    }

    public Integer getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(Integer godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public String getStatusRada() {
        return statusRada;
    }

    public void setStatusRada(String statusRada) {
        this.statusRada = statusRada;
    }
    
}
