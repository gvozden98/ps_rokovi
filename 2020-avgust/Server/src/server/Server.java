/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import komunikacija.Poruka;
import komunikacija.Response;
import komunikacija.TipOdgovora;
import thread.ClientThread;

/**
 *
 * @author Ognjen
 */
public class Server {

    private ServerSocket ss;
    private boolean running = false;
    private List<ClientThread> klijenti = new CopyOnWriteArrayList<>();
    private List<ClientThread> onlineKlijenti = new CopyOnWriteArrayList<>();

    public Server() {
    }

    public void startServer() {
        running = true;
        try {
            ss = new ServerSocket(9000);
            System.out.println("Server pokrenut na 9000");
            startServerConsoleBroadcast();
            while (running) {

                Socket clientSocket = ss.accept();
                System.out.println("Klijent povezan!");
                ClientThread client = new ClientThread(clientSocket, this);
                klijenti.add(client);
                client.start();
            }
        } catch (Exception e) {
            if (running) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void broadcast(Response response) {
        for (ClientThread ct : onlineKlijenti) {
            ct.send(response);
        }
    }

    public List<ClientThread> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(List<ClientThread> klijenti) {
        this.klijenti = klijenti;
    }

    public void removeClient(ClientThread clientThread) {
        klijenti.remove(clientThread);
        onlineKlijenti.remove(clientThread);
        if (clientThread.getTrenutniKorisnik() != null) {
            System.out.println("Klijent odjavljen: " + clientThread.getTrenutniKorisnik());
        }
    }

    public void handleLogin(ClientThread ct, String korisnik) throws Exception {
        if (!userLoggedIn(korisnik)) {
            onlineKlijenti.add(ct);
            ct.setTrenutniKorisnik(korisnik);
        }
    }

    private boolean userLoggedIn(String korisnik) throws Exception {
        for (ClientThread clientThread : onlineKlijenti) {
            if (clientThread.getTrenutniKorisnik().equals(korisnik)) {
                throw new Exception("Korisnik je ulogovan!");
            }
        }
        return false;
    }

    public void posaljiPoruku(ClientThread senderClient, Poruka poruka) throws Exception {
        for (ClientThread ct : onlineKlijenti) {
            if (ct.getTrenutniKorisnik().equals(poruka.getKorisnikZa())) {
                Response response = new Response(null, poruka, TipOdgovora.NOVA_PORUKA);
                ct.send(response);
                return;
            }
        }
        throw new Exception("Klijent nije prisutan!");
    }

    private void startServerConsoleBroadcast() {
        Thread consoleThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Unesi serversku poruku za broadcast (prazno = preskoci):");
            while (running) {
                try {
                    String tekst = scanner.nextLine();
                    if (tekst == null || tekst.trim().isEmpty()) {
                        continue;
                    }
                    sendServerMessage(tekst.trim());
                } catch (Exception ignored) {
                    break;
                }
            }
        });
        consoleThread.setDaemon(true);
        consoleThread.start();
    }

    public void sendServerMessage(String tekst) {
        Poruka poruka = new Poruka();
        poruka.setDatumVreme(LocalDateTime.now());
        poruka.setKorisnikOd("SERVER");
        poruka.setKorisnikZa("SVI");
        poruka.setTekstPoruke("[SERVER] " + tekst);
        broadcast(new Response(null, poruka, TipOdgovora.NOVA_PORUKA));
    }

}
