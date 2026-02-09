/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import controller.ServerController;
import domen.Fakultet;
import domen.Kandidat;
import java.net.Socket;
import komunikacija.Operacije;
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

    private Socket socket;
    private Server server;
    private Receiver receiver;
    private Sender sender;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        this.receiver = new Receiver(socket);
        this.sender = new Sender(socket);
    }

    @Override
    public void run() {
        while (!isInterrupted() && !socket.isClosed()) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {
                    switch (request.getOperacija()) {
                        case LOGIN:
                            response.setResult(ServerController.getInstance().loginKorisnik((Kandidat) request.getArgument()));
                            break;
                        case GET_FAKULTETI:
                            response.setResult(ServerController.getInstance().getFakulteti());
                            break;
                        case GET_STUD_PROGRAM:
                            response.setResult(ServerController.getInstance().getStudijskiProgrami());

                            break;
                        default:
                            throw new AssertionError("N/A");
                    }
                } catch (Exception e) {
                    response.setException(e);
                }
                sender.send(response);
            } catch (Exception e) {
                System.out.println("Greska " + e.getMessage());
                break;
            }
        }
    }
}
