/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DatabaseBroker;
import db.DatabaseConnection;

/**
 *
 * @author Ognjen
 */
public abstract class AbstractSO {

    DatabaseBroker dbbr;

    public AbstractSO() {
        dbbr = new DatabaseBroker();
    }

    public void execute(Object object) throws Exception {
        try {
            validate(object);
            executeOperation(object);
            DatabaseConnection.getInstance().getConnection().commit();

        } catch (Exception e) {
            DatabaseConnection.getInstance().getConnection().rollback();
            throw e;
        }
    }

    public abstract void validate(Object object) throws Exception;

    public abstract void executeOperation(Object object) throws Exception;

}
