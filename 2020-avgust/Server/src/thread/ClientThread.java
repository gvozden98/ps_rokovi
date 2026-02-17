/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import db.DatabaseBroker;
import komunikacija.Poruka;
import java.net.Socket;
import java.util.List;
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

    private final Socket clientSocket;
    private final Server server;
    private final Receiver receiver;
    private final Sender sender;
    private String trenutniKorisnik;

    public ClientThread(Socket clientSocket, Server server) throws Exception {
        this.clientSocket = clientSocket;
        this.server = server;
        this.receiver = new Receiver(clientSocket);
        this.sender = new Sender(clientSocket);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted() && !clientSocket.isClosed()) {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {
                    switch (request.getOperacija()) {
                        case LOGIN: {
                            login(request);
                            response.setResult(true);
                        }
                        break;
                        case POSALJI_PORUKU: {
                            posaljiPoruku(request);
                            response.setResult(true);
                        }
                        break;
                        case SACUVAJ_PORUKE: {
                            List<Poruka> poruke = (List<Poruka>) request.getArgument();
                            DatabaseBroker dbbr = new DatabaseBroker();
                            dbbr.sacuvajPoruke(poruke);
                            server.removeClient(this);
                            response.setResult(true);
                        }
                        break;
                        default:
                            throw new AssertionError("N/A");
                    }
                } catch (Exception e) {
                    response.setException(e);
                }
                sender.send(response);
            }
        } catch (Exception e) {
            // Ocekivano kada klijent prekine konekciju.
        } finally {
            closeAndCleanup();
        }
    }

    public void send(Object o) {
        try {
            sender.send(o);
        } catch (Exception ignored) {

        }
    }

    public String getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(String trenutniKorisnik) {
        this.trenutniKorisnik = trenutniKorisnik;
    }

    private void login(Request request) throws Exception {
        server.handleLogin(this, (String) request.getArgument());
    }

    private void posaljiPoruku(Request request) throws Exception {
        server.posaljiPoruku(this, (Poruka) request.getArgument());
    }

    private void closeAndCleanup() {
        try {
            if (!clientSocket.isClosed()) {
                clientSocket.close();
            }
        } catch (Exception ignored) {
        } finally {
            server.removeClient(this);
        }
    }

}
