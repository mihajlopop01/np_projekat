/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domen.OpstiDomenskiObjekat;

/**
 *
 * @author Mihajlo Popovic
 */
public class ZapamtiZakazivanjeSO extends AbstractSO {
    
    public ZapamtiZakazivanjeSO() throws Exception {}

    @Override
    protected void validate(Object argument) throws Exception {
         if(argument==null){
            throw new Exception("Korisnik nepostoji");
        }
    }

    @Override
    protected void executeOperation(OpstiDomenskiObjekat argument) throws Exception {
        result = dbb.select(argument);
    }
    
}
