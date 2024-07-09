/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import db.*;
import domen.OpstiDomenskiObjekat;


/**
 *
 * @author Mihajlo Popovic
 */
public abstract class AbstractSO {
    
    protected DBBroker dbb;
    protected Object result;
    
    public AbstractSO() throws Exception{
        dbb=new DBBroker(DatabaseConnection.getInstance().pop());  
    }
    
    public void execute(OpstiDomenskiObjekat argument) throws Exception{
        try {
            validate(argument);
            executeOperation(argument);
            commit();
        } catch (Exception ex) {
            rollback();
            throw ex;
        }finally{
            DatabaseConnection.getInstance().push(dbb.getConnection());
        }
    }

    protected abstract void validate(Object argument) throws Exception;

    protected abstract void executeOperation(OpstiDomenskiObjekat argument) throws Exception;

    protected void commit() throws Exception {
       dbb.getConnection().commit();
    }

    protected void rollback() throws Exception {
        dbb.getConnection().rollback();
    }
    
    public Object getResult(){
        return result;
    }
}
    

