/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import dto.AngazovaniModeliDTO;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class GetAngazovaniModeliSO extends AbstractSO {

    private List<AngazovaniModeliDTO> AngazovaniModeli;

    @Override
    public void validate(Object object) throws Exception {
    }

    @Override
    public void executeOperation(Object object) throws Exception {
        AngazovaniModeli = dbbr.getAngazovaniModeli((String) object);
    }

    public List<AngazovaniModeliDTO> getAngazovaniModeli() {
        return AngazovaniModeli;
    }

}
