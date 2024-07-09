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
public class UcitajSalonSO extends AbstractSO {
    
    public UcitajSalonSO() throws Exception {}

    @Override
    protected void validate(Object argument) throws Exception {
        if(argument == null)
            throw new Exception("Greska");
    }

    @Override
    protected void executeOperation(OpstiDomenskiObjekat argument) throws Exception {
        System.out.println("Iz SO: "+argument.toString());
        result = dbb.select(argument);
    }
    
}
