/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domen.Kandidat;

/**
 *
 * @author Ognjen
 */
public class LoginSO extends AbstractSO {

    private Kandidat kandidat;

    @Override
    public void executeOperation(Object object) throws Exception {
        kandidat = dbbr.loginKandidat((Kandidat) object);
    }

    @Override
    public void validate(Object object) throws Exception {
        if (!(object instanceof Kandidat)) {
            throw new Exception("Nije poslat kandidat!");
        }

    }

    public Kandidat getKandidat() {
        return kandidat;
    }

}
