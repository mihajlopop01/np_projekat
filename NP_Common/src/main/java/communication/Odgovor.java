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

    /**
     *
     */
    public Odgovor() {
    }

    /**
     *
     * @param res
     * @param e
     */
    public Odgovor(Object res, Exception e) {
        this.res = res;
        this.e = e;
    }

    /**
     *
     * @return
     */
    public Object getRes() {
        return res;
    }

    /**
     *
     * @param res
     */
    public void setRes(Object res) {
        this.res = res;
    }

    /**
     *
     * @return
     */
    public Exception getE() {
        return e;
    }

    /**
     *
     * @param e
     */
    public void setE(Exception e) {
        this.e = e;
    }
    
    
    
}
