/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sheepclient;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arces
 */
public class UDPSpawner extends Thread{

    private int nClients;
    private DatagramSocket soc;
    private ArrayList<udptest> tList;

    public UDPSpawner(int nClients) {
        this.nClients = nClients;
    }
    
    public void run(){
        tList = new ArrayList<>();
        try {
            for (int i = 0; i < nClients; i++) {
                soc = new DatagramSocket();
                udptest t = new udptest(soc);
                t.start();
                tList.add(t);
            }
            for (udptest t : tList) {
                t.join();
            }
        } catch (IOException ex) {
            Logger.getLogger(Spawner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Spawner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
