/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import forms.KlijentForma;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import komunikacija.Poruka;
import komunikacija.Receiver;
import komunikacija.Response;
import komunikacija.Sender;
import komunikacija.TipOdgovora;

/**
 *
 * @author Ognjen
 */
public class ListenerThread extends Thread {

    Socket socket;
    Sender sender;
    Receiver receiver;
    KlijentForma klijentForma;

    public ListenerThread(Socket socket, Sender sender, Receiver receiver, KlijentForma frame) {
        this.socket = socket;
        this.sender = sender;
        this.receiver = receiver;
        this.klijentForma = frame;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Response response = (Response) receiver.receive();
                if (response.getException() != null) {
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(
                            klijentForma,
                            response.getException().getMessage(),
                            "Greska",
                            JOptionPane.ERROR_MESSAGE
                    ));
                    continue;
                }
                
                TipOdgovora tip = response.getTipOdgovora();
                if (tip == null) {
                    continue; // Stari format odgovora bez tipa - preskačemo
                }
                
                switch (tip) {
                    case NOVA_PORUKA:
                        Poruka p = (Poruka) response.getResult();
                        klijentForma.getMessage(p);
                        break;
                    case USPESNO:
                        // Uspešne operacije se obično obrađuju sinhrono u ControllerUI
                        // Ovde možemo dodati dodatnu logiku ako je potrebno
                        break;
                    default:
                        // Za buduće tipove odgovora
                        break;
                }
            } catch (Exception e) {
                break;
            }
        }
    }

}
