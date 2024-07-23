/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import db.*;
import domen.OpstiDomenskiObjekat;


/**
 * Apstraktna klasa koja predstavlja opstu servisnu operaciju.
 * Ova klasa definise osnovne metode koje moraju biti implementirane u svim konkretnim servisnim operacijama.
 * Omogucava validaciju, izvrsavanje operacija, commit i rollback transakcija.
 * 
 * @autor Mihajlo Popovic
 * @version 1.0
 */
public abstract class AbstractSO {

    /**
     * Broker za rad sa bazom podataka.
     */
    protected DBBroker dbb;

    /**
     * Rezultat operacije.
     */
    protected Object result;

    /**
     * Kreira novi objekat klase AbstractSO i inicijalizuje broker baze podataka.
     * 
     * @throws Exception ako dodje do greske pri kreiranju konekcije sa bazom podataka
     */
    public AbstractSO() throws Exception {
        dbb = new DBBroker(DatabaseConnection.getInstance().pop());
    }

    /**
     * Izvrsava servisnu operaciju sa prosledjenim argumentom.
     * 
     * @param argument objekat klase OpstiDomenskiObjekat koji predstavlja argument operacije
     * @throws Exception ako dodje do greske pri validaciji, izvrsavanju operacije ili transakciji
     */
    public void execute(OpstiDomenskiObjekat argument) throws Exception {
        try {
            validate(argument);
            executeOperation(argument);
            commit();
        } catch (Exception ex) {
            rollback();
            throw ex;
        } finally {
            DatabaseConnection.getInstance().push(dbb.getConnection());
        }
    }

    /**
     * Apstraktna metoda za validaciju argumenta.
     * 
     * @param argument objekat koji se validira
     * @throws Exception ako argument nije validan
     */
    protected abstract void validate(Object argument) throws Exception;

    /**
     * Apstraktna metoda za izvrsavanje konkretne operacije.
     * 
     * @param argument objekat klase OpstiDomenskiObjekat koji predstavlja argument operacije
     * @throws Exception ako dodje do greske pri izvrsavanju operacije
     */
    protected abstract void executeOperation(OpstiDomenskiObjekat argument) throws Exception;

    /**
     * Potvrdjuje transakciju.
     * 
     * @throws Exception ako dodje do greske pri potvrdjivanju transakcije
     */
    protected void commit() throws Exception {
        dbb.getConnection().commit();
    }

    /**
     * Otkazuje transakciju.
     * 
     * @throws Exception ako dodje do greske pri otkazivanju transakcije
     */
    protected void rollback() throws Exception {
        dbb.getConnection().rollback();
    }

    /**
     * Vraca rezultat operacije.
     * 
     * @return rezultat operacije kao objekat klase Object
     */
    public Object getResult() {
        return result;
    }
}

    

