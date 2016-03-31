/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheepclient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jet
 */
public class testonly extends Thread{
    
    private Socket soc;
    private PrintWriter pw;
    public testonly(Socket s){
        this.soc =s;
        try {
            this.pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
            
        } catch (IOException ex) {
            Logger.getLogger(testonly.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void run(){
        Scanner sc = new Scanner(System.in);
        String line="";
        while(true){
            line = sc.nextLine();
            pw.println(line);
        }
        
    }
}
