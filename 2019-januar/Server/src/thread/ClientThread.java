/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import controller.ServerController;
import domen.ScorePayload;
import domen.SledecePitanjeDTO;
import java.net.Socket;
import java.util.List;
import komunikacija.Operacije;
import static komunikacija.Operacije.LOGIN;
import komunikacija.Receiver;
import komunikacija.Request;
import komunikacija.Response;
import komunikacija.Sender;
import server.Server;

/**
 *
 * @author Ognjen
 */
public class ClientThread extends Thread {

    Socket clientSocket;
    Receiver receiver;
    Sender sender;
    Server server;

    boolean loggedIn = false;

    public ClientThread(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.receiver = new Receiver(clientSocket);
        this.sender = new Sender(clientSocket);
        this.server = server;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted() && !clientSocket.isClosed()) {

                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {

                    switch (request.getOperacija()) {
                        case LOGIN:
                            String korisnik = (String) request.getArgument();
                            sender.send(response);
                            loggedIn = true;
                            server.onPlayerLoggedIn(this);
                            break;
                        case ODGOVORI_NA_PITANJNE: {
                            String answer = (String) request.getArgument();

                            // 1) izračunaj poene (prvi klik pravilo je u session-u)
                            ScorePayload score = ServerController.getInstance().submitTeamAnswer(answer);
                            response.setResult(score);
                            // 2) pošalji svima SCORE_UPDATE
                            server.broadcast(response);

                            // 3) pošalji sledeće pitanje ili kraj
                            SledecePitanjeDTO next = ServerController.getInstance().sledecePitanje();
                            if (next == null) {
                                response.setResult(score);
                                response.setException(new Exception("Gotov kviz!"));
                                server.broadcast(response);
                            } else {
                                response.setResult(score);
                                server.broadcast(response);
                            }
                        }

                        break;
                        default:
                            throw new AssertionError("N/A");
                    }

                } catch (Exception e) {
                    response.setException(e);
                    e.printStackTrace();
                    System.out.println("Puce!");
                }

            }
        } catch (Exception e) {
            System.out.println("Greska u komunikaciji!" + e.getMessage());
        } finally {
            server.removeClient(this);
            close();
        }
    }

    public void send(Response res) {
        try {
            sender.send(res);
        } catch (Exception e) {
            // ako ne može da se pošalje, verovatno je klijent pukao
            close();
        }
    }

    public void close() {
        try {
            clientSocket.close();
        } catch (Exception ignored) {
        }
    }
}
