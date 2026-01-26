/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import controller.ServerController;
import java.io.EOFException;
import java.net.Socket;
import java.net.SocketException;
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

    private Server server;
    private Socket socket;
    private Sender sender;
    private Receiver receiver;

    public ClientThread(Socket socket, Server server) throws Exception {
        this.server = server;
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while (!isInterrupted() && !socket.isClosed()) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();

                try {
                    switch (request.getOperacija()) {
                        case GetALLStudenti:
                            response.setResult(ServerController.getInstance().getStudenti());
                            break;
                        case GetALLProfesori:

                            break;
                        default:
                            throw new AssertionError("N/A");
                    }
                } catch (Exception e) {
                    response.setException(e);
                }

                sender.send(response);
            } catch (EOFException | SocketException e) {
                System.out.println("Klijent diskonektovan");
                break;
            } catch (Exception e) {
                System.out.println("Greska u komunikaciji" + e.getMessage());
                break;
            } finally {
                closeQuietly();
            }
        }
    }

    private void closeQuietly() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception ignored) {
        }
    }

}
