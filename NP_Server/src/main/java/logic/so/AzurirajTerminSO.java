/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domen.OpstiDomenskiObjekat;

/**
 * Klasa koja predstavlja servisnu operaciju azuriranja termina.
 * Nasledjuje apstraktnu klasu AbstractSO i implementira njene apstraktne metode.
 * 
 * @autor Mihajlo Popovic
 * @version 1.0
 */
public class AzurirajTerminSO extends AbstractSO {

    /**
     * Kreira novi objekat klase AzurirajTerminSO.
     * 
     * @throws Exception ako dodje do greske pri kreiranju objekta
     */
    public AzurirajTerminSO() throws Exception {}

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
     * Izvrsava operaciju azuriranja termina.
     * 
     * @param argument objekat klase OpstiDomenskiObjekat koji predstavlja termin koji treba azurirati
     * @throws Exception ako dodje do greske pri azuriranju termina
     */
    @Override
    protected void executeOperation(OpstiDomenskiObjekat argument) throws Exception {
        dbb.update(argument);
        result = argument;
    }
}

