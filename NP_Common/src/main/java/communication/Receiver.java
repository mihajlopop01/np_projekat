/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihajlo Popovic
 */
public class Receiver {
    
    private Socket socket;

    /**
     *
     * @param socket
     */
    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    /**
     *
     * @return
     */
    public Object receive() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (IOException e) {
             System.out.println("Greska u receiveru: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Greska u receiveru: "+ex.getMessage());
        }
        return null;
    }
    
}
