/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jet
 */
public class Timer {
    

    
    private Date start;
    private Date end;
    private String lastx="";
    private String lasty="";
    private int every;
    private ArrayList<Long> nlist = new ArrayList<>();
    private boolean s = false;
    
    public void endTime(String x,String y){
        if(s)
        if(!lastx.isEmpty() && !lasty.isEmpty())
            if(!lastx.equals(x)||!lasty.equals(y)){
                end = new Date();
                //System.out.println("End Time "+ new Timestamp(end.getTime()));
                long diffInMilliseconds = Math.abs(end.getTime() - start.getTime());
                nlist.add(diffInMilliseconds);
                System.out.println("Millisecs: "+ diffInMilliseconds);
                if(nlist.size() %every == 0){
                    this.getAverage();
                }
                s = false;
            }
           
    }    
    
     public void getAverage(){
         float ave=0;
         int size = this.nlist.size();
         for(int i=0; i<size ;i++){
             ave += this.nlist.get(i);
         } 
         ave = ave/ size;
         System.out.println("Average of "+size+" numbers = "+ ave);
         
     }
    
    
    public void startTime(String x,String y,int average){
        
        s = true;
        this.start = new Date();
        this.every = average;
        System.out.println("Timer Started!");
        
        
        this.lastx= x;
        this.lasty = y;
    }
    
    
    
}
