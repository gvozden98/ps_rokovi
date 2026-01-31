/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.IstorijaStatusaRada;
import domen.Rad;
import java.util.List;
import komunikacija.SacuvajRadRequest;

/**
 *
 * @author Ognjen
 */
public class SetRadSO extends AbstractSO {

    @Override
    protected void validate(Object object) throws Exception {
//        TODO:
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        SacuvajRadRequest dto = (SacuvajRadRequest) object;

        Rad rad = dto.getRad();
        List<IstorijaStatusaRada> statusi = dto.getStatusi();

        Long radId = dbbr.insertRad(dto.getRad());

        for (IstorijaStatusaRada isr : dto.getStatusi()) {
            isr.setRad(rad);
            dbbr.insertIstorijaStatusaRada();
        }
    }

}
