/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import forms.FrmServer;
import server.Server;

/**
 *
 * @author Ognjen
 */
public class Main {

    public static void main(String[] args) {
        FrmServer frmServer = new FrmServer();
        frmServer.setVisible(true);
        try {
            Server server = new Server();
            server.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
