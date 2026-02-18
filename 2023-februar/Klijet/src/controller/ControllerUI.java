package controller;

import domen.RezultatPogadjanjaDTO;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import komunikacija.Operacije;
import komunikacija.Receiver;
import komunikacija.Request;
import komunikacija.Response;
import komunikacija.Sender;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Ognjen
 */
public class ControllerUI {

    private static ControllerUI instance;
    Socket socket;
    Receiver receiver;
    Sender sender;

    private ControllerUI() {
        try {
            socket = new Socket("127.0.0.1", 9000);
            sender = new Sender(socket);
            receiver = new Receiver(socket);
        } catch (Exception e) {
            System.out.println("Greska pri konekciji sa serverom!" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ControllerUI getInstance() {
        if (instance == null) {
            instance = new ControllerUI();
        }
        return instance;
    }

    public RezultatPogadjanjaDTO posaljiBrojeve(List<String> brojevi) throws Exception {
        Request request = new Request(brojevi, Operacije.POSALJI_BROJEVE);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
        return (RezultatPogadjanjaDTO) response.getResult();
    }
}
