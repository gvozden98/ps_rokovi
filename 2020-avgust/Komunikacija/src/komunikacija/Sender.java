/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Ognjen
 */
public class Sender {

    private final ObjectOutputStream out;

    public Sender(Socket socket) throws Exception {
        this.out = new ObjectOutputStream(socket.getOutputStream());
    }

    public void send(Object obj) throws Exception {
        out.writeObject(obj);
        out.flush();
    }
}
