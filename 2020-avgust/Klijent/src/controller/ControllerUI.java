/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forms.KlijentForma;
import java.net.Socket;
import java.util.List;
import komunikacija.Operacije;
import komunikacija.Poruka;
import komunikacija.Receiver;
import komunikacija.Request;
import komunikacija.Sender;
import thread.ListenerThread;

/**
 *
 * @author Ognjen
 */
public class ControllerUI {

    private static ControllerUI instance;

    private final int port = 9000;
    private final String address = "127.0.0.1";
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private KlijentForma klijentForma;
    private ListenerThread listenerThread;

    private ControllerUI() {
        try {
            socket = new Socket(address, port);
            sender = new Sender(socket);
            receiver = new Receiver(socket);
        } catch (Exception e) {
            System.out.println("Greska prilikom povezivanja sa serverom!" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ControllerUI getInstance() {
        if (instance == null) {
            instance = new ControllerUI();
        }
        return instance;
    }

    public void startListening() {
        if (listenerThread != null && listenerThread.isAlive()) {
            return;
        }
        listenerThread = new ListenerThread(socket, sender, receiver, klijentForma);
        listenerThread.start();
    }

    public void login(String korisnik) throws Exception {
        Request request = new Request(Operacije.LOGIN, korisnik);
        sender.send(request);
    }

    public void sendMessage(Poruka poruka) throws Exception {
        Request request = new Request(Operacije.POSALJI_PORUKU, poruka);
        sender.send(request);
    }

    public void disconnect() {
        try {
            if (listenerThread != null) {
                listenerThread.interrupt();
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (Exception ignored) {
        }
    }

    public KlijentForma getKlijentForma() {
        return klijentForma;
    }

    public void setKlijentForma(KlijentForma klijentForma) {
        this.klijentForma = klijentForma;
    }

    public void logout(List<Poruka> poruke) throws Exception {
        Request request = new Request(Operacije.SACUVAJ_PORUKE, poruke);
        sender.send(request);
    }

}
