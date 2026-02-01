/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

/**
 *
 * @author Ognjen
 */
public class Request {
    private Object argument;
    private Operacija operacija;

    public Request(Object argument, Operacija operacija) {
        this.argument = argument;
        this.operacija = operacija;
    }

    public Request() {
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    public Operacija getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }
    
    
}
