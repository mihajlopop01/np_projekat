/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Mihajlo Popovic
 */
public class Odgovor implements Serializable{
    
    private Object res;
    private Exception e;

    public Odgovor() {
    }

    public Odgovor(Object res, Exception e) {
        this.res = res;
        this.e = e;
    }

    public Object getRes() {
        return res;
    }

    public void setRes(Object res) {
        this.res = res;
    }

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }
    
    
    
}
