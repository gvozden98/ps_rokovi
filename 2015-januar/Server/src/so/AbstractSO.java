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

    public final void execute(Object object) throws Exception {
        try {
            validate(object);
            executeOperation(object);
            DatabaseConnection.getInstance().getConnection().commit();
        } catch (Exception e) {
            rollback();
        }

//        finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (Exception ignored) {
//                }
//            }
//
    }

    protected abstract void validate(Object object) throws Exception;

    protected abstract void executeOperation(Object object) throws Exception;

    private void rollback() throws Exception {
        DatabaseConnection.getInstance().rollback();
    }
}
