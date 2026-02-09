/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Fakultet;
import domen.Kandidat;
import so.GetAllFakultetiSO;
import so.GetAllStudijskiProgramiSO;
import so.LoginSO;

/**
 *
 * @author Ognjen
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public static Object loginKorisnik(Kandidat kandidat) throws Exception {
        LoginSO so = new LoginSO();
        so.execute(kandidat);
        return so.getKandidat();
    }

    public Object getFakulteti() throws Exception {
        GetAllFakultetiSO so = new GetAllFakultetiSO();
        so.execute(null);
        return so.getFakulteti();
    }

    public Object getStudijskiProgrami() throws Exception {
        GetAllStudijskiProgramiSO so = new GetAllStudijskiProgramiSO();
        so.execute(null);
        return so.getStudijskiProgrami();
    }

}
