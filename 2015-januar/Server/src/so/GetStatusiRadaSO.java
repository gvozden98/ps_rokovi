/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.StatusRada;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class GetStatusiRadaSO extends AbstractSO {

    private List<StatusRada> statusiRada;

    @Override
    protected void validate(Object object) throws Exception {
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        statusiRada = dbbr.getSviStatusiRada();
    }

    public List<StatusRada> getStatusiRada() {
        return statusiRada;
    }

}
