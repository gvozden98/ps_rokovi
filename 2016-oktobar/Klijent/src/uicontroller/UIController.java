/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uicontroller;

import domen.Kandidat;
import java.net.Socket;
import komunikacija.Operacije;
import komunikacija.Receiver;
import komunikacija.Request;
import komunikacija.Response;
import komunikacija.Sender;

/**
 *
 * @author Ognjen
 */
public class UIController {

    private Socket socket;
    private Receiver receiver;
    private Sender sender;

    private static UIController instance;

    private UIController() throws Exception {
        try {
            socket = new Socket("127.0.0.1", 9000);
            sender = new Sender(socket);
            receiver = new Receiver(socket);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska pri povezivanju sa hostom!" + e.getMessage());
        }
    }

    public static UIController getInstance() throws Exception {
        if (instance == null) {
            instance = new UIController();
        }
        return instance;
    }

    public void login(Kandidat k) throws Exception {
        Request request = new Request(Operacije.LOGIN, k);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }
}
