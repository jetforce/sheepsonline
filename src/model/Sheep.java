/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.PrintWriter;

/**
 *
 * @author Arces
 */
public class Sheep{
    private int x, y, id;
    private PrintWriter pw;
    public long mil;

    public Sheep() {

    }
    
    public Sheep(int x, int y, int id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    public Sheep(int x, int y, int id,long mil){
        this.x = x;
        this.y = y;
        this.id = id;
        this.mil=mil;
    }
    
    public Sheep(int x, int y, int id, PrintWriter pw) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.pw = pw;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the pw
     */
    public PrintWriter getPw() {
        return pw;
    }

    /**
     * @param pw the pw to set
     */
    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }
}
