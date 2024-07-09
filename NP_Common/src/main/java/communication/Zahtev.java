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
public class Zahtev implements Serializable{
    
    private Object arg;
    private SO o;

    public Zahtev() {
    }

    public Zahtev(Object arg, SO o) {
        this.arg = arg;
        this.o = o;
    }

    public Object getArg() {
        return arg;
    }

    public void setArg(Object arg) {
        this.arg = arg;
    }

    public SO getO() {
        return o;
    }

    public void setO(SO o) {
        this.o = o;
    }
    
    
    
}
