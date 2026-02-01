/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.net.Socket;
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
    private Sender sender;
    private Receiver receiver;

    public ClientThread(Socket clientSocket, Server aThis) {
        this.socket = clientSocket;
        this.server = server;
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while (!isInterrupted() && !socket.isClosed()) {
            try {
                Request request = (Request) receiver.recieve();
                Response response = new Response();
                try {
                    switch (request.getOperacija()) {
                        case GET_ALL_DIZAJNERI:

                            break;
                        default:
                            throw new AssertionError("N/A");
                    }

                } catch (Exception e) {
                    response.setException(e);
                    e.printStackTrace();
                }
                sender.send(response);
            } catch (Exception e) {
                System.out.println("Greska u komunikaciji" + e.getMessage());
                break;
            }
        }
    }

}
