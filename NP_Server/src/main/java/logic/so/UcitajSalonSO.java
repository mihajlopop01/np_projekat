/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domen.OpstiDomenskiObjekat;

/**
 * Klasa koja predstavlja sistemsku operaciju učitavanja salona.
 * Nasledjuje apstraktnu klasu AbstractSO i implementira njene apstraktne metode.
 * 
 * @autor Mihajlo Popovic
 * @version 1.0
 */
public class UcitajSalonSO extends AbstractSO {

    /**
     * Kreira novi objekat klase UcitajSalonSO.
     * 
     * @throws Exception ako dodje do greske pri kreiranju objekta
     */
    public UcitajSalonSO() throws Exception {
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
            throw new Exception("Greska");
        }
    }

    /**
     * Izvrsava sistemsku operaciju učitavanja salona.
     * 
     * @param argument objekat klase OpstiDomenskiObjekat koji se koristi za učitavanje salona
     * @throws Exception ako dodje do greske pri izvrsavanju operacije
     */
    @Override
    protected void executeOperation(OpstiDomenskiObjekat argument) throws Exception {
        System.out.println("Iz SO: " + argument.toString());
        result = dbb.select(argument);
    }
}

