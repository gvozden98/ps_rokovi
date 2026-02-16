/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DatabaseBroker;

/**
 *
 * @author Ognjen
 */
public class LoginSO extends AbstractSO {

    String user;

    @Override
    public void executeOperation(Object object) throws Exception {
        dbbr.login((String) object);
    }

    @Override
    public void validate(Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
