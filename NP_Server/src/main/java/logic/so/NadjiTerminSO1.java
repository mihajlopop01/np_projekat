/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domen.OpstiDomenskiObjekat;

/**
 * Klasa koja predstavlja sistemsku operaciju pronalaženja termina koristeći alternativnu metodu.
 * Nasledjuje apstraktnu klasu AbstractSO i implementira njene apstraktne metode.
 * 
 * @autor Mihajlo Popovic
 * @version 1.0
 */
public class NadjiTerminSO1 extends AbstractSO {

    /**
     * Kreira novi objekat klase NadjiTerminSO1.
     * 
     * @throws Exception ako dodje do greske pri kreiranju objekta
     */
    public NadjiTerminSO1() throws Exception {
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
            throw new Exception("Argument je null");
        }
    }

    /**
     * Izvrsava sistemsku operaciju pronalaženja termina koristeći alternativnu metodu.
     * 
     * @param argument objekat klase OpstiDomenskiObjekat koji se koristi za pronalaženje termina
     * @throws Exception ako dodje do greske pri izvrsavanju operacije
     */
    @Override
    protected void executeOperation(OpstiDomenskiObjekat argument) throws Exception {
        result = dbb.selectAll1(argument);
    }
}

