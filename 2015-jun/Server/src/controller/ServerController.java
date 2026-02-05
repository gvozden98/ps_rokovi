/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Angazovanje;
import domen.Dizajner;
import domen.Model;
import java.util.List;
import so.GetSviDizajeriSO;
import so.GetSviModeliSO;
import so.PutSvaAngazovanjaSO;

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

    public List<Dizajner> getSviDizajneri() throws Exception {
        GetSviDizajeriSO so = new GetSviDizajeriSO();
        so.execute(null);
        return so.getDizajneri();
    }

    public List<Model> getSviModeli() throws Exception {
        GetSviModeliSO so = new GetSviModeliSO();
        so.execute(null);
        return so.getModeli();
    }

    public void putSvaAngazovanja(Object argument) throws Exception {
        PutSvaAngazovanjaSO so = new PutSvaAngazovanjaSO();
        so.execute(argument);
    }

}
