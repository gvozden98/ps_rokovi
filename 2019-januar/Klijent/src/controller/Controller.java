/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.sun.net.httpserver.Request;
import java.net.Socket;
import komunikacija.Receiver;
import komunikacija.Sender;

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
}
