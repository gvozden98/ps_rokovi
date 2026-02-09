/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uicontroller;

import domen.Fakultet;
import domen.Kandidat;
import domen.StudijskiProgram;
import java.net.Socket;
import java.util.List;
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

    public Kandidat login(Kandidat k) throws Exception {
        Request request = new Request(Operacije.LOGIN, k);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
        return (Kandidat) response.getResult();
    }

    public List<StudijskiProgram> getStudijskiProgrami() throws Exception {
        Request request = new Request(Operacije.GET_STUD_PROGRAM, new StudijskiProgram());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<StudijskiProgram>) response.getResult();
    }

    public List<Fakultet> getFakulteti() throws Exception {
        Request request = new Request(Operacije.GET_FAKULTETI, new Fakultet());
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Fakultet>) response.getResult();
    }
}
