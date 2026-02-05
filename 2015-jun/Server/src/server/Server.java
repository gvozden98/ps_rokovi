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

    ServerSocket serverSocket;
    private volatile boolean running;

    public void startServer() {
        running = true;
        try {
            serverSocket = new ServerSocket(9000);
            System.out.println("Server pokrenut na 9000!");
            while (running) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Klijent konektovan!");
                ClientThread client = new ClientThread(clientSocket, this);
                client.start();
            }
        } catch (Exception e) {
            if (running) {
                e.printStackTrace();
            }
        } finally {
            stopServer();
        }
    }

    private void stopServer() {
        running = false;
        if (serverSocket != null && !serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (Exception ignored) {

            }
        }
    }
}
