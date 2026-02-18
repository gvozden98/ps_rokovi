/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import domen.RezultatPogadjanjaDTO;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import komunikacija.Receiver;
import komunikacija.Request;
import komunikacija.Response;
import komunikacija.Sender;

/**
 *
 * @author Ognjen
 */
public class Server {

    ServerSocket ss;
    boolean running = false;
    String n1;
    String n2;
    String n3;
    String n4;
    List<String> brojeviServera = new ArrayList<>();

    public void startServer() {
        running = true;
        try {
            System.out.println("Server je pokrenut");
            ss = new ServerSocket(9000);
            while (running) {
                try {
                    Socket socket = ss.accept();
                    System.out.println("Klijent je konektovan!");
                    Receiver receiver = new Receiver(socket);
                    Sender sender = new Sender(socket);
                    Request request = (Request) receiver.receive();
                    Response response = new Response();
                    try {
                        switch (request.getOperacija()) {
                            case POSALJI_BROJEVE:
                                response.setResult(proveriRezultat((List<String>) request.getArgument()));
                                break;
                            default:
                                throw new AssertionError();
                        }
                    } catch (Exception e) {
                        response.setException(e);
                    }
                    sender.send(response);
                } catch (Exception e) {
                    if (running) {
                        e.printStackTrace();
                    }
                } finally {
                    closeServer();
                }
            }
        } catch (Exception e) {
            System.out.println("Server ne moze da se pokrene");
        }
    }

    private void closeServer() {
        running = false;
        if (ss != null && !ss.isClosed()) {
            try {
                ss.close();
            } catch (Exception e) {
            }
        }
    }

    public void setNumbers(String n1, String n2, String n3, String n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        brojeviServera.add(n1);
        brojeviServera.add(n2);
        brojeviServera.add(n3);
        brojeviServera.add(n4);

    }

    private RezultatPogadjanjaDTO proveriRezultat(List<String> brojevi) {
        RezultatPogadjanjaDTO rezultat = new RezultatPogadjanjaDTO();
        int pogodjeni = 0;
        int pogodjeniNisuNaMestu = 0;
        List<String> klijent = new ArrayList<>();
        List<String> serverList = new ArrayList<>();

        for (int i = 0; i < brojevi.size(); i++) {
            String x = brojevi.get(i);
            String y = brojeviServera.get(i);
            if (Objects.equals(x, y)) {
                pogodjeni++;
            } else {
                klijent.add(x);
                serverList.add(y);
            }
        }
// server: 0 3 3 5
// klijent 0 5 5 3

        for (String x : klijent) {
            int idx = serverList.indexOf(x);
            if (idx != -1) {
                pogodjeniNisuNaMestu++;
                serverList.remove(idx);
            }
        }
        rezultat.setPogodjeni(pogodjeni);
        rezultat.setPogodjeniNisuNaMestu(pogodjeniNisuNaMestu);
        return rezultat;
    }
}
