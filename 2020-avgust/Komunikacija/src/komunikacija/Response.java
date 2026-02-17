/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author Ognjen
 */
public class Response implements Serializable {

    private Exception exception;
    private Object result;
    private TipOdgovora tipOdgovora;

    public Response() {
    }

    public Response(Exception exception, Object result) {
        this.exception = exception;
        this.result = result;
    }

    public Response(Exception exception, Object result, TipOdgovora tipOdgovora) {
        this.exception = exception;
        this.result = result;
        this.tipOdgovora = tipOdgovora;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public TipOdgovora getTipOdgovora() {
        return tipOdgovora;
    }

    public void setTipOdgovora(TipOdgovora tipOdgovora) {
        this.tipOdgovora = tipOdgovora;
    }

}
