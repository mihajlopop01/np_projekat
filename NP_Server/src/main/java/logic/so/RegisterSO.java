/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domen.OpstiDomenskiObjekat;

/**
 * Klasa koja predstavlja sistemsku operaciju registracije korisnika.
 * Nasledjuje apstraktnu klasu AbstractSO i implementira njene apstraktne metode.
 * 
 * @autor Mihajlo Popovic
 * @version 1.0
 */
public class RegisterSO extends AbstractSO {

    /**
     * Kreira novi objekat klase RegisterSO.
     * 
     * @throws Exception ako dodje do greske pri kreiranju objekta
     */
    public RegisterSO() throws Exception {
    }

    /**
     * Validira prosledjeni argument.
     * 
     * @param user objekat koji se validira
     * @throws Exception ako je argument null
     */
    @Override
    protected void validate(Object user) throws Exception {
        if (user == null) {
            throw new Exception("Argument je null");
        }
    }

    /**
     * Izvrsava sistemsku operaciju registracije korisnika.
     * 
     * @param user objekat klase OpstiDomenskiObjekat koji se koristi za registraciju korisnika
     * @throws Exception ako dodje do greske pri izvrsavanju operacije
     */
    @Override
    protected void executeOperation(OpstiDomenskiObjekat user) throws Exception {
        result = user;
        dbb.insert(user);
    }
}

