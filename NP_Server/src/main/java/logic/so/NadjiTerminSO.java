/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Termin;

/**
 * Klasa koja predstavlja sistemsku operaciju pronalaženja termina.
 * Nasledjuje apstraktnu klasu AbstractSO i implementira njene apstraktne metode.
 * 
 * @autor Mihajlo Popovic
 * @version 1.0
 */
public class NadjiTerminSO extends AbstractSO {

    /**
     * Kreira novi objekat klase NadjiTerminSO.
     * 
     * @throws Exception ako dodje do greske pri kreiranju objekta
     */
    public NadjiTerminSO() throws Exception {
    }

    /**
     * Validira prosledjeni argument.
     * 
     * @param argument objekat koji se validira
     * @throws Exception ako je argument null
     */
    @Override
    protected void validate(Object argument) throws Exception {
        if (argument == null) {
            throw new Exception("Korisnik nepostoji");
        }
    }

    /**
     * Izvrsava sistemsku operaciju pronalaženja termina.
     * 
     * @param argument objekat klase OpstiDomenskiObjekat koji se koristi za pronalaženje termina
     * @throws Exception ako dodje do greske pri izvrsavanju operacije
     */
    @Override
    protected void executeOperation(OpstiDomenskiObjekat argument) throws Exception {
        result = dbb.selectAll(argument);
    }
}

