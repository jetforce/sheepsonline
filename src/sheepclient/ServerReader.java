/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheepclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arces
 */
public class ServerReader extends Thread {

    private Socket soc;
    private BufferedReader br;

    public ServerReader(Socket soc) {
        this.soc = soc;
        try {
            this.br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ServerReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        while (true) {
            try {
                while (br.readLine() != null) {
                    //do nothing
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
