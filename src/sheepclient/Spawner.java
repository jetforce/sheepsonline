/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheepclient;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arces
 */
public class Spawner {

    private int nClients;
    private Socket soc;
    private final int port = 1108;
    private final String address = "localhost";
    private ArrayList<testonly> tList;

    public Spawner(int nClients) {
        tList = new ArrayList<>();
        try {
            for (int i = 0; i < nClients; i++) {
                System.out.println("helloooo");
                soc = new Socket(address, port);
                testonly t = new testonly(soc);
                t.start();
                tList.add(t);
            }
            for (testonly t : tList) {
                t.join();
            }
        } catch (IOException ex) {
            Logger.getLogger(Spawner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Spawner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
