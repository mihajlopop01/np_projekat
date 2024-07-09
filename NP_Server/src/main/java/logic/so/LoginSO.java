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
public class LoginSO extends AbstractSO {
    
    public LoginSO() throws Exception {
    }

    protected void validate(Object user) throws Exception {
        if(user==null){
            throw new Exception("Korisnik ne postoji");
        }
    }
    @Override
    protected void executeOperation(OpstiDomenskiObjekat user) throws Exception {
        result=dbb.select((OpstiDomenskiObjekat)user);
    }
    
    

    
    

    
}
