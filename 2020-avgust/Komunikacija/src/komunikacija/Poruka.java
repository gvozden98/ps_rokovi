package komunikacija;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Poruka implements Serializable {

    private int PorukaID;
    private String korisnikOd;
    private String korisnikZa;
    private LocalDateTime DatumVreme;
    private String TekstPoruke;

    public Poruka() {
    }

    public Poruka(int PorukaID, String korisnikOd, String korisnikZa, LocalDateTime DatumVreme, String TekstPoruke) {
        this.PorukaID = PorukaID;
        this.korisnikOd = korisnikOd;
        this.korisnikZa = korisnikZa;
        this.DatumVreme = DatumVreme;
        this.TekstPoruke = TekstPoruke;
    }

    public int getPorukaID() {
        return PorukaID;
    }

    public void setPorukaID(int porukaID) {
        this.PorukaID = porukaID;
    }

    public String getKorisnikOd() {
        return korisnikOd;
    }

    public void setKorisnikOd(String korisnikOd) {
        this.korisnikOd = korisnikOd;
    }

    public String getKorisnikZa() {
        return korisnikZa;
    }

    public void setKorisnikZa(String korisnikZa) {
        this.korisnikZa = korisnikZa;
    }

    public LocalDateTime getDatumVreme() {
        return DatumVreme;
    }

    public void setDatumVreme(LocalDateTime datumVreme) {
        this.DatumVreme = datumVreme;
    }

    public String getTekstPoruke() {
        return TekstPoruke;
    }

    public void setTekstPoruke(String tekstPoruke) {
        this.TekstPoruke = tekstPoruke;
    }
}
