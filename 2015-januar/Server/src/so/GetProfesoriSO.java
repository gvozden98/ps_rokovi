/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.Profesor;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class GetProfesoriSO extends AbstractSO {

    private List<Profesor> profesori;

    @Override
    protected void validate(Object object) throws Exception {
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        profesori = dbbr.getSviProfesori();
    }

    public List<Profesor> getProfesori() {
        return profesori;
    }
    
    

}
