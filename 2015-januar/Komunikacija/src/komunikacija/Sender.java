/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Ognjen
 */
public class Sender {

    private final ObjectOutputStream out;

    public Sender(Socket socket) throws Exception {
        try {
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.out.flush();
        } catch (Exception e) {
            throw new Exception("Greska pri inicijalizaciji sender-a");
        }
    }

    public void send(Object obj) throws Exception {
        try {
            out.reset();
            out.writeObject(obj);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska pri slanju objekta!");
        }
    }
}
