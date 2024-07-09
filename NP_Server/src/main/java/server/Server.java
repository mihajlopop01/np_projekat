/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.KlijentskaNit;

/**
 *
 * @author Mihajlo Popovic
 */
public class Server extends Thread{
    
    private List<KlijentskaNit> klijenti;

    public Server() {
        klijenti = new ArrayList<>();
    }
    
    
    

    @Override
    public void run() {
       startServer();
    }

    private void startServer() {
        try {
            ServerSocket ss = new ServerSocket(9000); //ispisati broj porta
            System.out.println("Server je spreman za rad");
            while(true) {  //mozda postoji limitiran broj klijeneta
                Socket s = ss.accept();
                KlijentskaNit klijent = new KlijentskaNit(s);
                klijenti.add(klijent);
                System.out.println("Dodat je novi klijent");
                klijent.start();
                
            
            
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
