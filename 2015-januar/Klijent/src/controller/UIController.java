/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.IstorijaStatusaRada;
import domen.Profesor;
import domen.Rad;
import domen.StatusRada;
import java.net.Socket;
import komunikacija.Receiver;
import komunikacija.Sender;
import domen.Student;
import java.util.List;
import komunikacija.Operacija;
import komunikacija.Request;
import komunikacija.Response;
import komunikacija.SacuvajRadRequest;

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
        socket = new Socket("127.0.0.1", 9000);
        receiver = new Receiver(socket);
        sender = new Sender(socket);
    }

    public static UIController getInstance() throws Exception {
        if (instance == null) {
            instance = new UIController();
        }
        return instance;
    }

    public List<Student> getSviStudenti() throws Exception {
        Request request = new Request(new Student(), Operacija.GetALLStudenti);
        sender.send(request);
        Response response = new Response();
        response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Student>) response.getResult();
    }

    public List<Profesor> getSviProfesori() throws Exception {
        Request request = new Request(new Profesor(), Operacija.GetALLProfesori);
        sender.send(request);
        Response response = new Response();
        response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Profesor>) response.getResult();
    }

    public List<StatusRada> getSviStatusiRada() throws Exception {
        Request request = new Request(new StatusRada(), Operacija.GetAllStatusiRada);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<StatusRada>) response.getResult();
    }

    public void sacuvajRadIIstorijuStatusaRada(Rad r, List<IstorijaStatusaRada> svaIstorijaStatusa) throws Exception {
        SacuvajRadRequest dto = new SacuvajRadRequest(r, svaIstorijaStatusa);
        Request request = new Request(dto, Operacija.SacuvajRad);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

}
