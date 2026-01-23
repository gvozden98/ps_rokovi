
import java.io.Serializable;
import java.util.Objects;

public class StatusRada implements Serializable {

    private Long statusID;
    private String nazivStatusa;

    public StatusRada() {
    }

    public StatusRada(Long statusID, String nazivStatusa) {
        this.statusID = statusID;
        this.nazivStatusa = nazivStatusa;
    }

    public Long getStatusID() {
        return statusID;
    }

    public void setStatusID(Long statusID) {
        this.statusID = statusID;
    }

    public String getNazivStatusa() {
        return nazivStatusa;
    }

    public void setNazivStatusa(String nazivStatusa) {
        this.nazivStatusa = nazivStatusa;
    }

    @Override
    public String toString() {
        return nazivStatusa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StatusRada)) {
            return false;
        }
        StatusRada statusRada = (StatusRada) o;
        return Objects.equals(statusID, statusRada.statusID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusID);
    }
}
