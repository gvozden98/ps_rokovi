/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.util.Random;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ognjen
 */
public class GenerateNumberThread extends Thread {

    JLabel label;
    private volatile boolean generating = false;

    public GenerateNumberThread(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        while (generating) {
            Random random = new Random();
            int broj = random.nextInt(5) + 1;
            SwingUtilities.invokeLater(() -> {
                label.setText(String.valueOf(broj));
            });
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public boolean isGenerating() {
        return generating;
    }

    public void setGenerating(boolean generating) {
        this.generating = generating;
    }

}
