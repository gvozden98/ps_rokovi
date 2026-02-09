/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.StudijskiProgram;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class GetAllStudijskiProgramiSO extends AbstractSO {

    private List<StudijskiProgram> studijskiProgrami;

    @Override
    public void executeOperation(Object object) throws Exception {
        studijskiProgrami = dbbr.getAllStudijskiProgrami();
    }

    @Override
    public void validate(Object object) throws Exception {
    }

    public List<StudijskiProgram> getStudijskiProgrami() {
        return studijskiProgrami;
    }

}
