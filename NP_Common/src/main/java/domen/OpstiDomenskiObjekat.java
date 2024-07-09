/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.*;

/**
 *
 * @author Mihajlo Popovic
 */
public abstract class OpstiDomenskiObjekat {
    
    public abstract int getWhereType();
    
    public abstract void setWhereType(int whereType);

    public abstract String getClassName();

    public abstract String getWhereCondition();

    public abstract OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException;

    public abstract String getAtrValue();

    public abstract String getInsertData();

    public abstract String getWhereCondition1();
    
    public abstract String getWhereCondition2();

    public abstract String setAtrValue();

    public abstract String getWhereCondition3();

    public abstract String setAtrValue1();
    
    public abstract String setAtrValue2();
    
    public abstract String getWhereCondition4();

   
    
}
