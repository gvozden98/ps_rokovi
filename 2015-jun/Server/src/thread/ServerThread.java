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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import models.ServerTableModel;

/**
 *
 * @author Ognjen
 */
public class ServerThread extends Thread {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final ServerTableModel serverTableModel;
    private AtomicReference<String> filter;

    public ServerThread(ServerTableModel serverTableModel, boolean selected, AtomicReference<String> filter) {
        this.serverTableModel = serverTableModel;
        this.filter = filter;
    }

    public void startit() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                String yearText = filter.get();
                Integer year = null;

                if (yearText != null && !yearText.isBlank()) {
                    try {
                        year = Integer.parseInt(yearText.trim());
                    } catch (NumberFormatException ex) {
                        year = null; // nevalidno -> nema filtera (ili možeš prikazati poruku)
                    }
                }

                List<AngazovaniModeliDTO> aModeli
                        = ServerController.getInstance().getAngazovaniModeli(yearText);

                SwingUtilities.invokeLater(() -> serverTableModel.setAngModeli(aModeli));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 10, TimeUnit.SECONDS);
    }

}
