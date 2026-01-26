/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.Student;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class GetStudentiSO extends AbstractSO {

    private List<Student> studenti;

    @Override
    protected void validate(Object object) throws Exception {

    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        studenti = dbbr.getSviStudenti();
    }

    public List<Student> getStudenti() {
        return studenti;
    }
    
    

}
