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
public class SledecePitanjeDTO implements Serializable {

    private Pitanje pitanje;
    private int timPoeni;
    private int serverPoeni;

    public SledecePitanjeDTO() {
    }

    public SledecePitanjeDTO(Pitanje pitanje, int timPoeni, int serverPoeni) {
        this.pitanje = pitanje;
        this.timPoeni = timPoeni;
        this.serverPoeni = serverPoeni;
    }

    public Pitanje getPitanje() {
        return pitanje;
    }

    public void setPitanje(Pitanje pitanje) {
        this.pitanje = pitanje;
    }

    public int getTimPoeni() {
        return timPoeni;
    }

    public void setTimPoeni(int timPoeni) {
        this.timPoeni = timPoeni;
    }

    public int getServerPoeni() {
        return serverPoeni;
    }

    public void setServerPoeni(int serverPoeni) {
        this.serverPoeni = serverPoeni;
    }
    
}
