/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheepclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jet
 */
public class testonly extends Thread {

    private Socket soc;
    private PrintWriter pw;
    private BufferedReader br;

    public testonly(Socket s) {
        this.soc = s;
        try {
            this.pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
            this.br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(testonly.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run() {
        //Scanner sc = new Scanner(System.in);
        String line = "";
        String temp;
        ServerReader sr = new ServerReader(soc);
        sr.start();
        while (true) {
            line = generateMove();//sc.nextLine();
            pw.println(line);
            try {
                sleep(500);
              //  System.out.println(line);
            } catch (InterruptedException ex) {
                Logger.getLogger(testonly.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String generateMove() {
        String move = "";
        Random rand = new Random();

        int num = rand.nextInt(5) + 1;

        switch (num) {
            case 1:
                move = "0,0";
                break;
            case 2:
                move = "0,1";
                break;
            case 3:
                move = "1,0";
                break;
            case 4:
                move = "-1,0";
                break;
            case 5:
                move = "0,-1";
                break;
        }
        //System.out.println(move);
        return move;
    }
}
