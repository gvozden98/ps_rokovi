/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uicontroller;

import domen.Angazovanje;
import domen.Dizajner;
import domen.Model;
import dto.ModnaRevijaAngazovanjeDTO;
import java.net.Socket;
import java.util.List;
import komunikacija.Operacija;
import komunikacija.Receiver;
import komunikacija.Request;
import komunikacija.Response;
import komunikacija.Sender;

/**
 *
 * @author Ognjen
 */
public class Controller {

    private Socket socket;
    private Sender sender;
    private Receiver receiver;

    private static Controller instance;

    private Controller() throws Exception {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Controller getInstance() throws Exception {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public List<Dizajner> getAllDizajneri() throws Exception {
        Request request = new Request(new Dizajner(), Operacija.GET_ALL_DIZAJNERI);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Dizajner>) response.getResult();
    }

    public List<Model> getAllModeli() throws Exception {
        Request request = new Request(new Model(), Operacija.GET_ALL_MODELI);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getException() != null) {
            throw response.getException();
        }
        return (List<Model>) response.getResult();
    }

    public void dodajAngazovanje(Angazovanje a) throws Exception {
        Request request = new Request(a, Operacija.DODAJ_ANGAZOVANJE);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

    public void dodajAngazovanjaIModnuReviju(ModnaRevijaAngazovanjeDTO madto) throws Exception {
        Request request = new Request(madto, Operacija.PUT_ANGAZOVANJA);
        sender.send(request);
        Response response = (Response) receiver.recieve();
        if (response.getException() != null) {
            throw response.getException();
        }
    }

}
