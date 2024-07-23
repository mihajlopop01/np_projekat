/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domen.OpstiDomenskiObjekat;

/**
 * Klasa koja predstavlja sistemsku operaciju prijave korisnika.
 * Nasledjuje apstraktnu klasu AbstractSO i implementira njene apstraktne metode.
 * 
 * @autor Mihajlo Popovic
 * @version 1.0
 */
public class LoginSO extends AbstractSO {

    /**
     * Kreira novi objekat klase LoginSO.
     * 
     * @throws Exception ako dodje do greske pri kreiranju objekta
     */
    public LoginSO() throws Exception {
    }

    /**
     * Validira prosledjeni argument.
     * 
     * @param user objekat koji predstavlja korisnika koji se validira
     * @throws Exception ako je korisnik null
     */
    @Override
    protected void validate(Object user) throws Exception {
        if (user == null) {
            throw new Exception("Korisnik ne postoji");
        }
    }

    /**
     * Izvrsava sistemsku operaciju prijave korisnika.
     * 
     * @param user objekat klase OpstiDomenskiObjekat koji predstavlja korisnika koji se prijavljuje
     * @throws Exception ako dodje do greske pri izvršavanju operacije
     */
    @Override
    protected void executeOperation(OpstiDomenskiObjekat user) throws Exception {
        result = dbb.select(user);
    }
}

