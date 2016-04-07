/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;

import gui.GUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sheep;

/**
 *
 * @author Jet
 */
public class UDPProtocol extends Thread{
    
    private static UDPProtocol protocol = null;
    private static DatagramSocket socket;    
    private static DatagramPacket packet;
    private final String address = "localhost";
    private final int port = 1108;
    private GUI ui;
    private static int my_id;
    private static Timer timer;
    
    private UDPProtocol(GUI ui) throws IOException{
        timer = new Timer();
        this.ui = ui;
        UDPProtocol.socket = new DatagramSocket();
        byte[] buffer = new byte[1024*1];
        ByteBuffer bf = ByteBuffer.wrap(buffer);
        bf.putLong(-1);
        InetAddress receiverAddress = InetAddress.getByName(address);
        UDPProtocol.packet = new DatagramPacket(buffer,buffer.length, receiverAddress, port);
        
    }
    
    public static UDPProtocol getInstance(){
        if(protocol == null){
            try {
                protocol = new UDPProtocol(new GUI());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return protocol;
    }
    
    
    public void run(){
        ArrayList<Sheep> sheeps = new ArrayList<>();
        
        try {
                       
            UDPProtocol.socket.setSoTimeout(20000);
            UDPProtocol.socket.send(UDPProtocol.packet);
            //receive ur stuff or u will never run.
            UDPProtocol.socket.receive(UDPProtocol.packet);
            
            byte[] initial = UDPProtocol.packet.getData();
            ByteBuffer bf = ByteBuffer.wrap(initial);
            UDPProtocol.my_id = bf.getInt();
            //Now listen to multicast port hehehe
            
             MulticastSocket Listen = new MulticastSocket(8889);
             InetAddress iaddress = InetAddress.getByName("224.2.2.3");
             Listen.joinGroup(iaddress);
             DatagramPacket inPacket;
             byte[] inBuf = new byte[1024*5];
             long lastmil=0, mil;
             int sheep_id,x,y;
             ByteBuffer inReader = ByteBuffer.wrap(inBuf); 
             ArrayList<Sheep> sheep_list;
             
             
            while(true) {
                inPacket = new DatagramPacket(inBuf, inBuf.length);
                Listen.receive(inPacket);
                mil = inReader.getLong();
                sheep_list = new ArrayList<>();
                if(lastmil < mil){
                    lastmil = mil;
                    while((sheep_id = inReader.getInt()) != -1 ){
                     
                        x = inReader.getInt();
                        y = inReader.getInt();
                        if(sheep_id == UDPProtocol.my_id){
                            UDPProtocol.timer.endTime(x+"", y+"");
                        }
                        
                        sheep_list.add(new Sheep(x,y,sheep_id));
                    }
                    ui.update(sheep_list);
                }
                inReader.clear();
                
            }
            
        } catch (IOException ex) {
            System.out.println("Unable to connect did not receive server in 20 seconds");
            Logger.getLogger(UDPProtocol.class.getName()).log(Level.SEVERE, null, ex);
           
        }    
    }
    
    public static void send(int x,int y) throws IOException{
        ByteBuffer bf = ByteBuffer.allocate(200);
        bf.putInt(UDPProtocol.my_id);
        bf.putInt(x);
        bf.putInt(y);
        UDPProtocol.packet.setData(bf.array()); 
        UDPProtocol.socket.send(UDPProtocol.packet);
        UDPProtocol.timer.startTime(x+"", y+"", 10);
    }
    
}
