/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import logic.so.*;

/**
 *
 * @author Mihajlo Popovic
 */
public class Controller {
    

    public Controller() {
    }
    
    public OpstiDomenskiObjekat login(OpstiDomenskiObjekat user) throws Exception{

        LoginSO so=new LoginSO();
        so.execute(user);
        System.out.println("U Controlleru: "+ so.getResult().toString());
        return (OpstiDomenskiObjekat)so.getResult();
        
    }

    public OpstiDomenskiObjekat register(OpstiDomenskiObjekat v) throws Exception {
        RegisterSO so = new RegisterSO();
        so.execute((OpstiDomenskiObjekat)v);
        System.out.println("U Controlleru: "+ so.getResult().toString());
        return (OpstiDomenskiObjekat)so.getResult();
    }

    public OpstiDomenskiObjekat insert(OpstiDomenskiObjekat odo) throws Exception {
        ZapamtiSalonSO so = new ZapamtiSalonSO();
        so.execute(odo);
        return (OpstiDomenskiObjekat)so.getResult();
        
       
    }

    public List<OpstiDomenskiObjekat> allTermini(OpstiDomenskiObjekat odo1) throws Exception {
        NadjiTerminSO so = new NadjiTerminSO();
        so.execute(odo1);
        return (List<OpstiDomenskiObjekat>)so.getResult();
    }
    
    public List<OpstiDomenskiObjekat> allSaloni(OpstiDomenskiObjekat odo1) throws Exception {
        NadjiSalonSO so = new NadjiSalonSO();
        so.execute(odo1);
        return (List<OpstiDomenskiObjekat>)so.getResult();
    }

    public OpstiDomenskiObjekat getOneTermin(OpstiDomenskiObjekat odo2) throws Exception {
        UcitajTerminSO so = new UcitajTerminSO();
        so.execute(odo2);
        return (OpstiDomenskiObjekat) so.getResult();
    }

    public OpstiDomenskiObjekat zapamtiTermin(OpstiDomenskiObjekat v2) throws Exception {
        ZapamtiTerminSO so = new ZapamtiTerminSO();
        so.execute(v2);
        return (OpstiDomenskiObjekat)so.getResult();
    }

    public OpstiDomenskiObjekat getOneSalon(OpstiDomenskiObjekat odo5) throws Exception {
        UcitajSalonSO so = new UcitajSalonSO();
        so.execute(odo5);
        return (OpstiDomenskiObjekat)so.getResult();
    }

    public OpstiDomenskiObjekat updateTermin(OpstiDomenskiObjekat odo7) throws Exception {
        AzurirajTerminSO so = new AzurirajTerminSO();
        so.execute(odo7);
        return (OpstiDomenskiObjekat)so.getResult();
    }

    public OpstiDomenskiObjekat getOneZakazivanje(OpstiDomenskiObjekat odo9) throws Exception {
        ZapamtiZakazivanjeSO so = new ZapamtiZakazivanjeSO();
        so.execute(odo9);
        return (OpstiDomenskiObjekat)so.getResult();
    }

    public List<OpstiDomenskiObjekat> allTermini1(OpstiDomenskiObjekat odo11) throws Exception {
       NadjiTerminSO1 so = new NadjiTerminSO1();
       so.execute(odo11);
        return (List<OpstiDomenskiObjekat>)so.getResult();
    }

    public OpstiDomenskiObjekat updateTermin1(OpstiDomenskiObjekat odo12) throws Exception {
        AzurirajTerminSO1 so = new AzurirajTerminSO1();
        so.execute(odo12);
        return (OpstiDomenskiObjekat)so.getResult();
    }

    public OpstiDomenskiObjekat zapamtiFrizera(OpstiDomenskiObjekat v14) throws Exception {
        ZapamtiFrizeraSO so = new ZapamtiFrizeraSO();
        so.execute(v14);
        return (OpstiDomenskiObjekat)so.getResult();
    }

   
    
}
