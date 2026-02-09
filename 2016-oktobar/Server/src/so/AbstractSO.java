/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DatabaseBroker;
import db.DatabaseConnection;
import java.sql.*;

/**
 *
 * @author Ognjen
 */
public abstract class AbstractSO {

    protected DatabaseBroker dbbr;

    public AbstractSO() {
        dbbr = new DatabaseBroker();
    }

    public void execute(Object object) throws Exception {
        try {
            validate(object);
            executeOperation(object);
            DatabaseConnection.getInstance().getConn().commit();
        } catch (Exception e) {
            DatabaseConnection.getInstance().getConn().rollback();
            System.out.println("Operacija nije uspesno izvrsena, rollback!");
            e.printStackTrace();
            throw e;
        }
    }

    public abstract void executeOperation(Object object) throws Exception;

    public abstract void validate(Object object) throws Exception;

}
