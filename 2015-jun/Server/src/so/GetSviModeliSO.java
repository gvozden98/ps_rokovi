/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.Model;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class GetSviModeliSO extends AbstractSO {

    private List<Model> modeli;

    @Override

    public void validate(Object object) throws Exception {
    }

    @Override
    public void executeOperation(Object object) throws Exception {
        modeli = dbbr.getAllModeli();
    }

    public List<Model> getModeli() {
        return modeli;
    }

}
