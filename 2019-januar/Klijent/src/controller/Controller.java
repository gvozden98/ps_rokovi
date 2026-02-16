/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.Socket;
import komunikacija.Operacije;
import komunikacija.Receiver;
import komunikacija.Sender;
import komunikacija.Request;
import komunikacija.Response;

/**
 *
 * @author Ognjen
 */
public class Controller {

    private static Controller instance;

    private Socket socket;
    private Sender sender;
    private Receiver receiver;

    private Controller() {
        try {
            socket = new Socket("127.0.0.1", 9000);
            sender = new Sender(socket);
            receiver = new Receiver(socket);
        } catch (Exception e) {
            System.out.println("Greska prilikom povezivanja sa serverom!" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void login(String igrac) throws Exception {
        Request request = new Request(Operacije.LOGIN, igrac);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

}
