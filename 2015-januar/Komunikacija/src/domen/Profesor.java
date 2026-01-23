
import java.io.Serializable;
import java.util.Objects;

public class Profesor implements Serializable {

    private Long profesorID;
    private String ime;
    private String prezime;
    private String zvanje;

    public Profesor() {
    }

    public Profesor(Long profesorID, String ime, String prezime, String zvanje) {
        this.profesorID = profesorID;
        this.ime = ime;
        this.prezime = prezime;
        this.zvanje = zvanje;
    }

    public Long getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(Long profesorID) {
        this.profesorID = profesorID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getZvanje() {
        return zvanje;
    }

    public void setZvanje(String zvanje) {
        this.zvanje = zvanje;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " (" + zvanje + ")";
    }

}
