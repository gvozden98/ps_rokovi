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

    protected DatabaseBroker dbbr;

    public AbstractSO() {
        this.dbbr = new DatabaseBroker();
    }

    public void execute(Object object) throws Exception {
        try {
            validate(object);
            executeOperation(object);
            DatabaseConnection.getInstance().getConnection().commit();
        } catch (Exception e) {
            DatabaseConnection.getInstance().getConnection().rollback();
            System.out.println("Rollback izvrsen, greska " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public abstract void executeOperation(Object object) throws Exception;

    public abstract void validate(Object object) throws Exception;
}
