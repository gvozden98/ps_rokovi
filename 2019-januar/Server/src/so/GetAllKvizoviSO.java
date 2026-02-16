/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.Kviz;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class GetAllKvizoviSO extends AbstractSO {

    private List<Kviz> kvizovi;

    @Override
    public void executeOperation(Object object) throws Exception {
        kvizovi = dbbr.getAllKvizovi();
    }

    @Override
    public void validate(Object object) throws Exception {
    }

    public List<Kviz> getKvizovi() {
        return kvizovi;
    }

}
