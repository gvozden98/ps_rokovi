/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.Angazovanje;
import dto.ModnaRevijaAngazovanjeDTO;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class PutSvaAngazovanjaSO extends AbstractSO {

    @Override
    public void validate(Object object) throws Exception {
        ModnaRevijaAngazovanjeDTO madto = (ModnaRevijaAngazovanjeDTO) object;
        dbbr.proveriDizajnera(madto.getModnaRevija());
        dbbr.proveriModele(madto.getA());
    }

    @Override
    public void executeOperation(Object object) throws Exception {
        ModnaRevijaAngazovanjeDTO madto = (ModnaRevijaAngazovanjeDTO) object;
        Integer idModneRevije = dbbr.insertModnaRevija(madto);

        for (Angazovanje angazovanje : madto.getA()) {
            angazovanje.getModnaRevija().setModnaRevijaID(idModneRevije);
            dbbr.insertSvaAngazovanja(angazovanje);
        }
    }

}
