/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.IstorijaStatusaRada;
import domen.Rad;
import domen.StatusRada;
import java.util.List;
import komunikacija.SacuvajRadRequest;

/**
 *
 * @author Ognjen
 */
public class SetRadSO extends AbstractSO {

    private static final String PRIJAVLJEN = "Prijavljen";
    private static final String ODOBREN = "Odobren";
    private static final String ODBRANJEN = "Odbranjen";

    private static final List<String> FLOW = List.of(PRIJAVLJEN, ODOBREN, ODBRANJEN);

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof SacuvajRadRequest dto)) {
            throw new Exception("Neispravan zahtev.");
        }

        List<IstorijaStatusaRada> statusi = dto.getStatusi();
        if (statusi == null || statusi.isEmpty()) {
            throw new Exception("Morate uneti bar jedan status rada.");
        }

        if (statusi.size() > FLOW.size()) {
            throw new Exception("Neispravan broj statusa. Dozvoljeno je najviše 3: Prijavljen, Odobren, Odbranjen.");
        }

        for (int i = 0; i < statusi.size(); i++) {
            IstorijaStatusaRada isr = statusi.get(i);
            if (isr == null || isr.getStatusRada() == null) {
                throw new Exception("Svaki unos istorije mora imati izabran status.");
            }

            String naziv = isr.getStatusRada().getNazivStatusa(); // prilagodi ako drugačije
            String expected = FLOW.get(i);

            if (!expected.equals(naziv)) {
                throw new Exception("Neispravan redosled statusa. Očekivan status na poziciji "
                        + (i + 1) + " je '" + expected + "', a dobio sam '" + naziv + "'.");
            }
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        SacuvajRadRequest dto = (SacuvajRadRequest) object;

        Rad rad = dto.getRad();
        List<IstorijaStatusaRada> statusi = dto.getStatusi();

        rad.setRadID(dbbr.insertRad(dto.getRad()));

        for (IstorijaStatusaRada isr : statusi) {
            isr.setRad(rad);
            dbbr.insertIstorijaStatusaRada(isr);
        }
    }

}
