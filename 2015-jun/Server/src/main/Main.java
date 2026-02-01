/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import forms.ServerForma;
import server.Server;

/**
 *
 * @author Ognjen
 */
public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
        ServerForma forma = new ServerForma();
        forma.setVisible(true);
        forma.setLocationRelativeTo(null);
    }
}
