/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sheep;
import gui.GUI;

/**
 *
 * @author Jet
 */
public class Protocol extends Thread {
    
    private Socket soc;
    private final int port =1108;
    private final String address ="localhost";
    private PrintWriter pw;
    private BufferedReader reader;
    private boolean life = true;
    private String id;
    private GUI ui;
    
    public Protocol(GUI ui) throws IOException{
        this.soc = new Socket(address,port);
        this.pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
        this.reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        this.ui = ui;
        String line = this.reader.readLine();
        String[] list;
        list = line.split(",");
        this.id = list[0];
        
    }
   
    public void run(){
        String line = "";
        ArrayList<Sheep> sheeps = new ArrayList<>();
        String list[];
        int id;
        
        try {
            while((line= this.reader.readLine()) != null){
               

                if(line.isEmpty()){
                    this.ui.update(sheeps);
                    sheeps = new ArrayList<>();//arren update UI here.
                }else{
                    list = line.split(",");
                    sheeps.add(new Sheep(Integer.parseInt(list[1]),Integer.parseInt(list[2]),Integer.parseInt(list[0])));
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Protocol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void send(String line){
        this.pw.println(line);
    }
}
