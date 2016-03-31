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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public Protocol() throws IOException{
        this.soc = new Socket(address,port);
        this.pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
        this.reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));    
    }
   
    public void run(){
        String line = "";
        try {
            while((line= this.reader.readLine()) != null){
                
                if(line.isEmpty()){
                    //arren update UI here.
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Protocol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
