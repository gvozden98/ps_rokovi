/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package controller;

import domen.Student;
import java.util.List;
import so.GetProfesoriSO;
import so.GetStatusiRadaSO;
import so.GetStudentiSO;

/**
 *
 * @author Ognjen
 */
public class ServerController {

    private static ServerController instance;

    private ServerController() {

    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public List<Student> getStudenti() throws Exception {
        GetStudentiSO so = new GetStudentiSO();
        so.execute(null);
        return so.getStudenti();
    }

    public Object getProfesori() throws Exception {
        GetProfesoriSO so = new GetProfesoriSO();
        so.execute(null);
        return so.getProfesori();
    }

    public Object getStatusiRada() throws Exception {
        GetStatusiRadaSO so = new GetStatusiRadaSO();
        so.execute(null);
        return so.getStatusiRada();
    }

    public void setRad() {
        SetRadSO so = new SetRadSO();
    }
}
