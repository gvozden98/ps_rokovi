/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.Fakultet;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class GetAllFakultetiSO extends AbstractSO {

    private List<Fakultet> fakulteti;

    @Override
    public void executeOperation(Object object) throws Exception {
        fakulteti = dbbr.getAllFakulteti();
    }

    @Override
    public void validate(Object object) throws Exception {
    }

    public List<Fakultet> getFakulteti() {
        return fakulteti;
    }

}
