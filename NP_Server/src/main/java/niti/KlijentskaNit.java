/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import communication.*;
import static communication.SO.ALLTERMINI;
import static communication.SO.GETONESALON;
import static communication.SO.UBACIFRIZERA;
import static communication.SO.UPDATETERMIN;
import domen.OpstiDomenskiObjekat;
import java.net.Socket;
import java.util.List;
import logic.Controller;

/**
 *
 * @author Mihajlo Popovic
 */
public class KlijentskaNit extends Thread{
    
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private OpstiDomenskiObjekat domen;
    private Controller controller;
    private int greske = 0;

    public KlijentskaNit(Socket s) {
        this.socket = s;
        controller = new Controller();  //mozda je singleton
    }

    @Override
    public void run() {
        sender = new Sender(socket);
        receiver = new Receiver(socket);
        
        while(true) {
        
            try {
                Zahtev zahtevKlijenta = (Zahtev)receiver.receive();
                Odgovor odgovorServera = new Odgovor();
                try {
                    switch (zahtevKlijenta.getO()) {
                        case LOGIN:
                            OpstiDomenskiObjekat user = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            //System.out.println("ODO iz klijentske niti: "+ user.toString());
                            OpstiDomenskiObjekat ulogovan = controller.login(user);
                            System.out.println("CASE: LOGIN "+ ulogovan);
                            this.domen = ulogovan;
                            odgovorServera.setRes(ulogovan);
                            break;
                            
                        case REGISTER:
                            OpstiDomenskiObjekat v = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            OpstiDomenskiObjekat vl = controller.register(v);
                            System.out.println("CASE: REGISTER: "+ vl);
                            odgovorServera.setRes(vl);
                            break;
                            
                            
                        case ZAPAMTISALON:
                            OpstiDomenskiObjekat odo = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            System.out.println("CASE: INSERT "+ odo);
                            OpstiDomenskiObjekat obj = controller.zapamti_salon(odo);
                            odgovorServera.setRes(obj);
                            break;
                            
                        case ALLTERMINI:
                            OpstiDomenskiObjekat odo1 = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            List<OpstiDomenskiObjekat> lista = controller.allTermini(odo1);
                            System.out.println("CASE: ALLTERMINI: "+ lista);
                            odgovorServera.setRes(lista);
                            break;
                            
                        case GETONETERMIN:
                            OpstiDomenskiObjekat odo2 = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            //System.out.println("ODO iz klijentske niti: "+odo2.toString());
                            OpstiDomenskiObjekat odo3 = controller.getOneTermin(odo2);
                            System.out.println("CASE: GETONETERMIN: "+ odo3);
                            odgovorServera.setRes(odo3);
                            break;
                            
                        case ALLSALONI:
                            OpstiDomenskiObjekat odo4 = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            List<OpstiDomenskiObjekat> lista1 = controller.allSaloni(odo4);
                            System.out.println("CASE: ALLSALONI: "+ lista1);
                            odgovorServera.setRes(lista1);
                            break;
                            
                        case ZAPAMTITERMIN:
                            OpstiDomenskiObjekat v2 = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            OpstiDomenskiObjekat v3 = controller.zapamtiTermin(v2);
                            System.out.println("CASE: ZAPAMTITERMIN: "+ v3);
                            odgovorServera.setRes(v3);
                            break;
                            
                        case GETONESALON:
                            OpstiDomenskiObjekat odo5 = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            System.out.println("Salon pre SO iz klijentske niti: "+odo5.toString());
                            OpstiDomenskiObjekat odo6 = controller.getOneSalon(odo5);
                            System.out.println("CASE: GETONESALON: "+ odo6);
                            odgovorServera.setRes(odo6);
                            break;
                            
                        case UPDATETERMIN:
                            OpstiDomenskiObjekat odo7 = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            System.out.println("Termin pre SO iz klijentske niti: "+odo7.toString());
                            OpstiDomenskiObjekat odo8 = controller.updateTermin(odo7);
                            System.out.println("Termin posle SO iz klijenstke niti: "+ odo8);
                            odgovorServera.setRes(odo8);
                            break;
                            
                         case GETONEZAKAZIVANJE:
                            OpstiDomenskiObjekat odo9 = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            //System.out.println("Zakazivanje pre SO iz klijentske niti: "+odo9.toString());
                            OpstiDomenskiObjekat odo10 = controller.getOneZakazivanje(odo9);
                            System.out.println("CASE: GETONEZAKAZIVANJE: "+ odo10);
                            odgovorServera.setRes(odo10);
                            break;
                            
                         case ALLTERMINI1:
                            OpstiDomenskiObjekat odo11 = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            List<OpstiDomenskiObjekat> lista11 = controller.allTermini1(odo11);
                            odgovorServera.setRes(lista11);
                            break;
                         case UBACIFRIZERA:
                            OpstiDomenskiObjekat v14 = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            System.out.println("CASE: UBACI_FRIZERA: "+v14);
                            OpstiDomenskiObjekat v15 = controller.zapamtiFrizera(v14);
                             
                             break;
                            
                         case UPDATETERMIN1:
                            OpstiDomenskiObjekat odo12 = (OpstiDomenskiObjekat)zahtevKlijenta.getArg();
                            //System.out.println("Termin pre SO iz klijentske niti: "+odo12.toString());
                            OpstiDomenskiObjekat odo13 = controller.updateTermin1(odo12);
                            System.out.println("CASE: UPDATETERMINI: "+ odo13);
                            odgovorServera.setRes(odo13);
                            break;

                    }
                } catch (Exception e) {
                    odgovorServera.setE(e);
                    System.out.println("Greska u switchu "+ e.getMessage());
                    greske++;
                    if(greske > 20)
                        this.stop();
                } 
                
                sender.send(odgovorServera);
                
            } catch (Exception e) {
                System.out.println("Greska pri zahtevu");
                this.stop();
               
            }
        
        }
        
    }
    
    
    
}
