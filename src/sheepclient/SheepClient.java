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
 * @author Jet
 */
public class SheepClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
 
        try {
            Socket soc = new Socket("localhost",1108);
            BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String line;
            String[] list;
            new testonly(soc).start();
            try {
                while((line= reader.readLine()) != null){
                    /*
                    list = line.split(",");
                    for(String i: list){
                        System.out.print(i+" ,");
                    }
                    System.out.println();
                    //updateseep
                            */
                }            
            } catch (IOException ex) {
                Logger.getLogger(SheepClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        
    }   catch (IOException ex) {
            Logger.getLogger(SheepClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
