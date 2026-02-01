/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import java.util.LinkedList;
import java.util.List;
import komunikacija.PregledRadovaKriterijum;
import komunikacija.PrikazRadovaDTO;

/**
 *
 * @author Ognjen
 */
public class GetPrikazRadovaSO extends AbstractSO {

    private List<PrikazRadovaDTO> prikazRadova = new LinkedList<>();

    @Override
    protected void validate(Object object) throws Exception {

    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        prikazRadova = dbbr.getPrikazRadova(((PregledRadovaKriterijum) object));
    }

    public List<PrikazRadovaDTO> getPrikazRadova() {
        return prikazRadova;
    }

}
