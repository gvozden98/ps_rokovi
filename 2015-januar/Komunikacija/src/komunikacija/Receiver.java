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
public class Receiver {

    private final ObjectInputStream in;

    public Receiver(Socket socket) throws Exception {
        try {
            this.in = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            throw new Exception("Greska pri inicijalizaciji receivera!");
        }
    }

    public Object receive() throws Exception {
        try {
            return in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Greska pri primanju!");
        }
    }

}
