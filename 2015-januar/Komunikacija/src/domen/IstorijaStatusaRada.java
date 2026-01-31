package domen;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class IstorijaStatusaRada implements Serializable {

    private Rad rad;                 // FK RadID
    private Integer rb;              // redni broj promene statusa (deo PK)
    private LocalDateTime datum;
    private StatusRada statusRada;   // FK StatusRadaID

    public IstorijaStatusaRada() {
    }

    public IstorijaStatusaRada(Rad rad, Integer rb, LocalDateTime datum, StatusRada statusRada) {
        this.rad = rad;
        this.rb = rb;
        this.datum = datum;
        this.statusRada = statusRada;
    }

    public Rad getRad() {
        return rad;
    }

    public void setRad(Rad rad) {
        this.rad = rad;
    }

    public Integer getRb() {
        return rb;
    }

    public void setRb(Integer rb) {
        this.rb = rb;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public StatusRada getStatusRada() {
        return statusRada;
    }

    public void setStatusRada(StatusRada statusRada) {
        this.statusRada = statusRada;
    }

    @Override
    public String toString() {
        String radInfo = (rad != null ? String.valueOf(rad.getRadID()) : "N/A");
        String statusInfo = (statusRada != null ? statusRada.getNazivStatusa() : "N/A");
        return "IstorijaStatusaRada{radID=" + radInfo + ", rb=" + rb + ", datum=" + datum + ", status=" + statusInfo + "}";
    }

}
