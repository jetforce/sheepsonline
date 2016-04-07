/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sheepclient;

import gui.GUI;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import model.Sheep;
import protocol.UDPProtocol;

/**
 *
 * @author Jet
 */
public class udptest extends Thread {
    
    private UDPProtocol protocol = null;
    private DatagramSocket socket;    
    private DatagramPacket packet;
    private final String address = "localhost";
    private final int port = 1108;
    private GUI ui;
    private static int my_id;
    
    public udptest() throws IOException{
        
        socket = new DatagramSocket();
        byte[] buffer = new byte[1024*1];
        ByteBuffer bf = ByteBuffer.wrap(buffer);
        bf.putLong(-1);
        InetAddress receiverAddress = InetAddress.getByName(address);
        this.packet = new DatagramPacket(buffer,buffer.length, receiverAddress, port);
        
    }
    
    public void run(){
       
            try{
                socket.setSoTimeout(20000);
                socket.send(packet);
                System.out.println("Sent");
                //receive ur stuff or u will never run.
                socket.receive(packet);
                System.out.println("Received!");
                byte[] initial = packet.getData();
                ByteBuffer bf = ByteBuffer.wrap(initial);
                my_id = bf.getInt();
                System.out.println("U received "+my_id);
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
            
                    while((sheep_id = inReader.getInt()) != -1 ){
                        x = inReader.getInt();
                        y = inReader.getInt();
                        System.out.println(mil+" "+x+" "+y);
                    }
                   
                    inReader.clear();
                
            }
            }catch(Exception e){
                System.out.println("Error");
            }

        
    
    }
    
}
