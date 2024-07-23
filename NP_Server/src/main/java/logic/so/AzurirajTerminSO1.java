/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domen.OpstiDomenskiObjekat;

/**
 * Klasa koja predstavlja servisnu operaciju azuriranja termina.
 * Nasledjuje apstraktnu klasu AbstractSO i implementira njene apstraktne metode.
 * Ova klasa koristi metodu update1 iz DBBroker klase za azuriranje podataka.
 * 
 * @autor Mihajlo Popovic
 * @version 1.0
 */
public class AzurirajTerminSO1 extends AbstractSO {

    /**
     * Kreira novi objekat klase AzurirajTerminSO1.
     * 
     * @throws Exception ako dodje do greske pri kreiranju objekta
     */
    public AzurirajTerminSO1() throws Exception {}

    /**
     * Validira prosledjeni argument.
     * 
     * @param argument objekat koji se validira
     * @throws Exception ako je argument null
     */
    @Override
    protected void validate(Object argument) throws Exception {
        if (argument == null) {
            throw new Exception("Korisnik ne postoji");
        }
    }

    /**
     * Izvrsava operaciju azuriranja termina koristeci metodu update1 iz DBBroker klase.
     * 
     * @param argument objekat klase OpstiDomenskiObjekat koji predstavlja termin koji treba azurirati
     * @throws Exception ako dodje do greske pri azuriranju termina
     */
    @Override
    protected void executeOperation(OpstiDomenskiObjekat argument) throws Exception {
        result = argument;
        dbb.update1(argument);
    }
}

