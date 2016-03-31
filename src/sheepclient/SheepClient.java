/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheepclient;

import gui.GUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import protocol.Protocol;

/**
 *
 * @author Jet
 */
public class SheepClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
 
        /*try {
            GUI ui = new GUI();
            ui.setVisible(true);
            Protocol p = new Protocol(ui);
            p.start();
            
        }catch (IOException ex) {
            Logger.getLogger(SheepClient.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
       // Protocol.getInstance().start();
        
        //comment out protocol then uncomment this to spawn dummy sheeps
        new Spawner(3).start();
    }    
    
}
