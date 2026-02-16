/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.Kviz;
import domen.Pitanje;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class GetAllPitanjaSO extends AbstractSO {

    private List<Pitanje> pitanja;

    @Override
    public void executeOperation(Object object) throws Exception {
        pitanja = dbbr.getAllPitanja((Kviz) object);
    }

    @Override
    public void validate(Object object) throws Exception {
    }

    public List<Pitanje> getPitanja() {
        return pitanja;
    }

}
