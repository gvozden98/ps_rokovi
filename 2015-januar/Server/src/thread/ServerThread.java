/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import controller.ServerController;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.SwingUtilities;
import komunikacija.PregledRadovaKriterijum;
import komunikacija.PrikazRadovaDTO;
import models.RadoviStatusiTableModel;
import server.Server;

/**
 *
 * @author Ognjen
 */
public class ServerThread extends Thread {

    private final AtomicReference<PregledRadovaKriterijum> kriterijumRef;

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final RadoviStatusiTableModel tableModel;

    public ServerThread(RadoviStatusiTableModel tableModel, AtomicReference<PregledRadovaKriterijum> kriterijumRef) {
        this.tableModel = tableModel;
        this.kriterijumRef = kriterijumRef;
    }

    public void start() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                PregledRadovaKriterijum k = kriterijumRef.get();
                List<PrikazRadovaDTO> podaci = ServerController.getInstance().ucitajPregledRadova(k);
                SwingUtilities.invokeLater(() -> {
                    tableModel.setData(podaci);
                });
                System.out.println("tabela popunjena!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 10, TimeUnit.SECONDS);
    }

}
