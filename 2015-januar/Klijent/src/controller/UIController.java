/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.Socket;
import komunikacija.Receiver;
import komunikacija.Sender;
import domen.Student;

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

    public static UIController getInstace() throws Exception {
        if (instance == null) {
            instance = new UIController();
        }
        return instance;
    }

}
