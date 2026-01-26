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

    public final void execute(Object object) throws Exception {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            dbbr = new DatabaseBroker(conn);

            validate(object);
            executeOperation(object);
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (Exception ignored) {
                }
                throw new Exception("Greska pri izvrsavanju operacije!", e);

            }
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception ignored) {
                }
            }
        }
    }

    protected abstract void validate(Object object) throws Exception;

    protected abstract void executeOperation(Object object) throws Exception;
}
