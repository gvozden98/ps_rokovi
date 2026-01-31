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
import komunikacija.PrikazRadovaDTO;
import models.RadoviStatusiTableModel;
import server.Server;

/**
 *
 * @author Ognjen
 */
public class ServerThread extends Thread {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final RadoviStatusiTableModel tableModel;

    public ServerThread(RadoviStatusiTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void start() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                List<PrikazRadovaDTO> podaci = ServerController.ucitajPregledRadova();
            } catch (Exception e) {
            }
        }, 0, 10, TimeUnit.SECONDS);
    }

}
