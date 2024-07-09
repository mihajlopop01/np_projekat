/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.*;
import domen.Frizer;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Salon;
import domen.Termin;
import domen.Vlasnik;
import java.io.IOException;
import java.net.Socket;
import java.util.List;


/**
 *
 * @author Mihajlo Popovic
 */
public class UIController {
    
    private static UIController instance;
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    
    private UIController() {
        try {
            socket = new Socket("localhost",9000); //mozda mora iz konstanti da se cita broj porta
            sender = new Sender(socket);
            receiver = new Receiver(socket);
        } catch (IOException ex) {
            ex.printStackTrace();   
        }
}
    
    public static synchronized UIController getInstance() {
    if(instance == null)
        instance = new UIController();
    return instance;
    
    }

    public OpstiDomenskiObjekat login(OpstiDomenskiObjekat objekat) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(objekat,SO.LOGIN);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("LOGIN odgovor: "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
            return (OpstiDomenskiObjekat)odgovorServera.getRes();
       } else {
       throw odgovorServera.getE();
       }
    }
/*
    public OpstiDomenskiObjekat vratiJedan() throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(null,SO.VRATIJEDAN);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("U UIControlleru: "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
            return (OpstiDomenskiObjekat)odgovorServera.getRes();
       } else {
       throw odgovorServera.getE();
       }
    } */

    public OpstiDomenskiObjekat register(OpstiDomenskiObjekat odo) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(odo,SO.REGISTER);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("REGISTER odgovor: "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
           return (OpstiDomenskiObjekat)odgovorServera.getRes();
           
       } else {
       throw odgovorServera.getE();
       }
    }

    public OpstiDomenskiObjekat sacuvaj(OpstiDomenskiObjekat odo) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(odo,SO.INSERT);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("SACUVAJ odgovor "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
          return (OpstiDomenskiObjekat)odgovorServera.getRes();
           
       } else {
       throw odgovorServera.getE();
       }
    }

    public List<OpstiDomenskiObjekat> allTermini(OpstiDomenskiObjekat odo) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(odo,SO.ALLTERMINI);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("ALL_TERMINI odgovor: "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
          return (List<OpstiDomenskiObjekat>)odgovorServera.getRes();
           
       } else {
       throw odgovorServera.getE();
       }
    }

    public OpstiDomenskiObjekat getOneTermin(OpstiDomenskiObjekat odo) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(odo,SO.GETONETERMIN);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("GET_ONE_TERMIN odgovor: "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
            return (OpstiDomenskiObjekat)odgovorServera.getRes();
       } else {
       throw odgovorServera.getE();
       }
    }

    public List<OpstiDomenskiObjekat> allSaloni(OpstiDomenskiObjekat odo) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(odo,SO.ALLSALONI);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("ALL_SALONI odgovor: "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
          return (List<OpstiDomenskiObjekat>)odgovorServera.getRes();
           
       } else {
       throw odgovorServera.getE();
       }
    }

    public OpstiDomenskiObjekat zapamtiTermin(OpstiDomenskiObjekat odo) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(odo,SO.ZAPAMTITERMIN);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("ZAPAMTI_TERMIN odgovor: "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
           return (OpstiDomenskiObjekat)odgovorServera.getRes();
           
       } else {
       throw odgovorServera.getE();
       }
    }

    public OpstiDomenskiObjekat getOneSalon(OpstiDomenskiObjekat odo) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(odo,SO.GETONESALON);
       System.out.println("Odo u UICon pre slanja: "+odo.toString());
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("GET_ONE_SALON: "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
            return (OpstiDomenskiObjekat)odgovorServera.getRes();
       } else {
       throw odgovorServera.getE();
       }
    }
    
    public OpstiDomenskiObjekat updateTermin(OpstiDomenskiObjekat odo) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(odo,SO.UPDATETERMIN);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("UPDATE_TERMIN: "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
            return (OpstiDomenskiObjekat)odgovorServera.getRes();
       } else {
       throw odgovorServera.getE();
       }
    }
    
    public OpstiDomenskiObjekat vratiZakazivanje(OpstiDomenskiObjekat odo) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(odo,SO.GETONEZAKAZIVANJE);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("VRATI_ZAKAZIVANJE: "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
            return (OpstiDomenskiObjekat)odgovorServera.getRes();
       } else {
       throw odgovorServera.getE();
       }
    }



    public List<OpstiDomenskiObjekat> allTermini1(OpstiDomenskiObjekat odo) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(odo,SO.ALLTERMINI1);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("ALL_TERMINI odgovor: " + odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
          return (List<OpstiDomenskiObjekat>)odgovorServera.getRes();
           
       } else {
       throw odgovorServera.getE();
       }
    }

    public OpstiDomenskiObjekat updateTermin1(OpstiDomenskiObjekat odo) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(odo,SO.UPDATETERMIN1);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("UPDATE_TERMIN odgovor: "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
            return (OpstiDomenskiObjekat)odgovorServera.getRes();
       } else {
       throw odgovorServera.getE();
       }
    }

    public void ubaci_frizera(OpstiDomenskiObjekat odo) throws Exception {
       Zahtev zahtevKlijenta = new Zahtev(odo,SO.UBACIFRIZERA);
       sender.send(zahtevKlijenta);
       Odgovor odgovorServera = (Odgovor)receiver.receive();
       System.out.println("UBACI_FRIZERA odgovor: "+ odgovorServera.getRes());
       if(odgovorServera.getE() == null) {
            
       } else {
       throw odgovorServera.getE();
       }
    }

    
}
    

