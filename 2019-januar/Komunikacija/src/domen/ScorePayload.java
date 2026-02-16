package domen;

import java.io.Serializable;

public class ScorePayload implements Serializable {

    private int timPoeni;
    private int serverPoeni;
    private String poruka;

    public ScorePayload() {
    }

    public ScorePayload(int timPoeni, int serverPoeni, String poruka) {
        this.timPoeni = timPoeni;
        this.serverPoeni = serverPoeni;
        this.poruka = poruka;
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

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
}
