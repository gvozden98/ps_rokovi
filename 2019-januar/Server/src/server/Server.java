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

    private ServerSocket serverSocket;

    private volatile boolean running = false;

    public void startServer() {
        running = true;
        try {
            serverSocket = new ServerSocket(9000);
            System.out.println("pokrenut server na 9000");
            while (running) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("klijent konektovan!");
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.run();
            }
        } catch (Exception e) {
            if (running) {
                e.printStackTrace();
            }
        } finally {
            try {
                running = false;
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (Exception ignored) {
            }
        }
    }
}
