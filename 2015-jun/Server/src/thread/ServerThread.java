/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import controller.ServerController;
import dto.AngazovaniModeliDTO;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;
import models.ServerTableModel;

/**
 *
 * @author Ognjen
 */
public class ServerThread extends Thread {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final ServerTableModel serverTableModel;

    public ServerThread(ServerTableModel serverTableModel) {
        this.serverTableModel = serverTableModel;
    }

    public void startit() throws Exception {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                List<AngazovaniModeliDTO> aModeli = ServerController.getInstance().getAngazovaniModeli();
                SwingUtilities.invokeLater(() -> {
                    serverTableModel.setAngModeli(aModeli);
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }, 0, 10, TimeUnit.SECONDS);

    }

}
