/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.net.Socket;
import static komunikacija.Operacije.LOGIN;
import komunikacija.Receiver;
import komunikacija.Request;
import komunikacija.Response;
import komunikacija.Sender;

/**
 *
 * @author Ognjen
 */
public class ClientThread extends Thread {

    Socket clientSocket;
    Receiver receiver;
    Sender sender;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.receiver = new Receiver(clientSocket);
        this.sender = new Sender(clientSocket);
    }

    @Override
    public void run() {
        while (!isInterrupted() && !clientSocket.isClosed()) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {

                    switch (request.getOperacija()) {
                        case LOGIN:
                            //response.setResult();
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
                System.out.println("Greska u komunikaciji!" + e.getMessage());
                break;
            }
        }
    }

}
