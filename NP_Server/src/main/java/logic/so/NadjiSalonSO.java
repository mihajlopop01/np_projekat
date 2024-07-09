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
public class NadjiSalonSO extends AbstractSO {

    public NadjiSalonSO() throws Exception {
    }
    
    

    @Override
    protected void validate(Object argument) throws Exception {
        if(argument == null)
            throw new Exception("Argument je null");
    }

    @Override
    protected void executeOperation(OpstiDomenskiObjekat argument) throws Exception {
        result = dbb.selectAll(argument);
    }
    
}
