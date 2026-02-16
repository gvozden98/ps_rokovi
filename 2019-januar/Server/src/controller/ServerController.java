/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Kviz;
import domen.Pitanje;
import domen.ScorePayload;
import domen.SledecePitanjeDTO;
import java.net.Socket;
import java.util.List;
import komunikacija.Sender;
import so.GetAllKvizoviSO;
import so.GetAllPitanjaSO;

/**
 *
 * @author Ognjen
 */
public class ServerController {

    private SesijaIgre session;

    private static ServerController instance;

    private ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public List<Kviz> getAllKvizovi() throws Exception {
        GetAllKvizoviSO so = new GetAllKvizoviSO();
        so.execute(null);
        return so.getKvizovi();
    }

    public List<Pitanje> getAllPitanja(Kviz kviz) throws Exception {
        GetAllPitanjaSO so = new GetAllPitanjaSO();
        so.execute(kviz);
        return so.getPitanja();
    }

    public synchronized void pokreniQuiz(Kviz kviz) throws Exception {
        List<Pitanje> pitanja = getAllPitanja(kviz);
        session = new SesijaIgre(pitanja);
    }

    public synchronized SledecePitanjeDTO sledecePitanje() {
        return session.sledecePitanje();
    }

    public synchronized ScorePayload submitTeamAnswer(String answer) {
        if (session == null) {
            throw new IllegalStateException("Kviz nije pokrenut.");
        }
        return session.submitTeamAnswer(answer);
    }
}
