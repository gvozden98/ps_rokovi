/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.net.ServerSocket;
import java.net.Socket;
import thread.ClientThread;

/**
 *
 * @author Ognjen
 */
public class Server {

    private volatile boolean running = false;
    private ServerSocket ss;

    public void startServer() {
        running = true;
        try {
            ss = new ServerSocket(9000);
            System.out.println("Server pokrenut na portu 9000!");

            while (running) {
                Socket clientSocket = ss.accept();
                System.out.println("klijent konektovan!");
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.run();

            }
        } catch (Exception e) {
            if (running) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } finally {
            stopServer();
        }
    }

    public void stopServer() {
        running = false;
        if (ss != null && !ss.isClosed()) {
            try {
                ss.close();
            } catch (Exception e) {
            }
        }
    }
}
