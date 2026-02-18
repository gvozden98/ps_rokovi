/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Ognjen
 */
public class Sender implements Serializable {

    ObjectOutputStream out;

    public Sender(Socket socket) throws IOException {
        out = new ObjectOutputStream(socket.getOutputStream());
    }

    public void send(Object obj) throws IOException {
        out.writeObject(obj);
        out.flush();
    }

}
