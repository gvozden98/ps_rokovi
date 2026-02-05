/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.Dizajner;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class GetSviDizajeriSO extends AbstractSO {

    private List<Dizajner> dizajneri;

    @Override
    public void validate(Object object) throws Exception {
    }

    @Override
    public void executeOperation(Object object) throws Exception {
        dizajneri = dbbr.getAllDizajneri();
    }

    public List<Dizajner> getDizajneri() {
        return dizajneri;
    }

}
