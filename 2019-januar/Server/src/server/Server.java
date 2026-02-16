/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import com.mysql.cj.util.StringUtils;
import controller.ServerController;
import domen.Kviz;
import domen.SledecePitanjeDTO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import komunikacija.Response;
import thread.ClientThread;

/**
 *
 * @author Ognjen
 */
public class Server {

    private ServerSocket serverSocket;

    private volatile boolean running = false;

    private final String path = "C:/Users/Ognjen/Documents/Fakultet/PS/deveta_godina_faksa/PS_Vezbanje_Rokovi/2019-januar/Server/src/properties/settings.properties";

    private int port;
    private int broj_igraca;

    List<ClientThread> clients = new CopyOnWriteArrayList<>();
    private final List<ClientThread> loggedIn = new CopyOnWriteArrayList<>();

    private volatile boolean quizStarted = false;

    public void startServer() {
        readProps();
        running = true;
        try {
            serverSocket = new ServerSocket(getPort());
            System.out.println("pokrenut server na 9000");
            while (running) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("klijent konektovan!");
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clients.add(clientThread);
                clientThread.start();
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

            for (ClientThread ct : clients) {
                try {
                    ct.close();
                } catch (Exception ignored) {
                }
            }
            clients.clear();
        }
    }

    public void readProps() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(path)) {
            props.load(fis);
            setPort(Integer.parseInt(props.getProperty("port")));
            setBroj_igraca(Integer.parseInt(props.getProperty("broj_igraca")));
            System.out.println("port: " + getPort());
            System.out.println("broj igraca: " + getBroj_igraca());
        } catch (Exception e) {
            System.out.println("Ne moze da se procita fajl!");
        }
    }

    public void removeClient(ClientThread clientThread) {
        clients.remove(clientThread);
    }

    public void broadcast(Response res) {
        for (ClientThread ct : clients) {
            ct.send(res);
        }
    }

    public void onPlayerLoggedIn(ClientThread ct) {
        if (!loggedIn.contains(ct)) {
            loggedIn.add(ct);
        }

        // opcionalno: pošalji svima status koliko igrača je unutra
        System.out.println("Prijavljeno igrača: " + loggedIn.size() + "/" + getBroj_igraca());

        // kad se skupi N igrača -> pokreni kviz jednom
    }

    public synchronized void tryStartQuiz(Kviz kviz) throws Exception {
        if (quizStarted) {
            return;
        }
        if (loggedIn.size() < getBroj_igraca()) {
            return;
        }

        quizStarted = true;

        // 1) pripremi session (umesto demo kasnije ide DB)
        ServerController.getInstance().pokreniQuiz(kviz);
        SledecePitanjeDTO first = ServerController.getInstance().sledecePitanje();

        // 2) pošalji prvo pitanje svima
        if (first != null) {
            Response response = new Response();
            response.setResult(first);
            broadcast(response);
            System.out.println("Kviz pokrenut i poslato prvo pitanje!");
        } else {
            broadcast(new Response(null, null));
            System.out.println("Nema pitanja.");
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBroj_igraca() {
        return broj_igraca;
    }

    public void setBroj_igraca(int broj_igraca) {
        this.broj_igraca = broj_igraca;
    }

}
