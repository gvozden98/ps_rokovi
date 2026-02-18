/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Ognjen
 */
public class Receiver implements Serializable {

    ObjectInputStream in;

    public Receiver(Socket socket) throws Exception {
        in = new ObjectInputStream(socket.getInputStream());
    }

    public Object receive() throws Exception {
        return in.readObject();
    }

}
