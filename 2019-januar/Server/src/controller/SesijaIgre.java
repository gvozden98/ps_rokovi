/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Pitanje;
import domen.ScorePayload;
import domen.SledecePitanjeDTO;
import java.util.List;

/**
 *
 * @author Ognjen
 */
public class SesijaIgre {

    private List<Pitanje> pitanja;
    private Pitanje trenutnoPitanje;
    private int index = -1;

    private boolean teamAnswered = false;
    private int teamScore = 0;
    private int serverScore = 0;

    public SesijaIgre(List<Pitanje> pitanja) {
        this.pitanja = pitanja;
    }

    public synchronized SledecePitanjeDTO sledecePitanje() {
        index++;
        if (index >= pitanja.size()) {
            return null;
        }
        trenutnoPitanje = pitanja.get(index);
        return new SledecePitanjeDTO(trenutnoPitanje, teamScore, serverScore);
    }

    public synchronized ScorePayload submitTeamAnswer(String answer) {
        if (trenutnoPitanje == null) {
            return new ScorePayload(teamScore, serverScore, "Kviz nije pokrenut.");
        }

        if (teamAnswered) {
            return new ScorePayload(teamScore, serverScore, "Tim je već odgovorio (računa se prvi klik).");
        }

        teamAnswered = true;

        boolean teamCorrect = norm(answer).equals(norm(trenutnoPitanje.getTacanOdgovor()));
        teamScore += points(teamCorrect, trenutnoPitanje.getBrojPoena());

        // DEMO: server odgovara nasumično (ti kasnije možeš da staviš logiku kakvu hoćeš)
        boolean serverCorrect = Math.random() < 0.5;
        serverScore += points(serverCorrect, trenutnoPitanje.getBrojPoena());

        String msg = "Tim: " + (teamCorrect ? "TAČNO" : "NETAČNO")
                + " | Server: " + (serverCorrect ? "TAČNO" : "NETAČNO");

        return new ScorePayload(teamScore, serverScore, msg);
    }

    private int points(boolean correct, int brojPoena) {
        if (correct) {
            return brojPoena;
        }
        int penalty = (int) Math.round(brojPoena * 0.2); // -20% poena za pogrešan
        return -penalty;
    }

    private String norm(String s) {
        return s == null ? "" : s.trim().toLowerCase();
    }
}
