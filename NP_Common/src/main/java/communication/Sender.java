/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Mihajlo Popovic
 */
public class Sender {
    
    private Socket socket;

    /**
     *
     * @param socket
     */
    public Sender(Socket socket) {
        this.socket = socket;
    }
    
    /**
     *
     * @param o
     */
    public void send(Object o) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(o);
            out.flush();
        } catch (IOException e) {
            System.out.println("Greska u senderu: "+e.getMessage());
        }
    
    }
    
}
