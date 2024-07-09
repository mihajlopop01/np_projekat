/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;



import domen.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihajlo Popovic
 */
public class DBBroker {

   private Connection connection;
    public DBBroker(Connection connection) {
        this.connection=connection;
    }

    public Connection getConnection(){
        return connection;
    }
   
    public void disconnect() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Konekcija sa bazom uspesno raskinuta!");
            }
        } catch (SQLException ex) {
            System.out.println("Greska! Konekcija sa bazom nije uspesno raskinuta!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public void commit() throws SQLException {
        try {
            connection.commit();
            System.out.println("Transakcija uspesno potvrdjena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije potvrdjena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public void rollback() throws SQLException {
        try {
            connection.rollback();
            System.out.println("Transakcija uspesno ponistena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije ponistena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public OpstiDomenskiObjekat select(OpstiDomenskiObjekat odo) throws SQLException {
        ResultSet rs = null;
        Statement st = null;
        String upit = null;
        System.out.println("ODO wheretype: " + odo.toString());

        if (odo.getWhereType() == 3) {
            upit = "SELECT * FROM " + odo.getClassName() + " WHERE " + odo.getWhereCondition4();
        } else {
            upit = "SELECT * FROM " + odo.getClassName() + " WHERE " + odo.getWhereCondition(); }
        System.out.println("Upit: "+upit);
        boolean signal;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(upit);
            signal = rs.next();
            if (signal == true) {
                odo = odo.getNewRecord(rs);
                System.out.println("ODO: "+ odo);
                
            } else {
                odo = null;
            }
        } catch (SQLException ex) {
            System.out.println("Greska u dbb: "+ex.getMessage());
        } finally {
            rs.close(); st.close();
        }
        return odo;
    }
    
    public OpstiDomenskiObjekat select1(OpstiDomenskiObjekat odo) throws SQLException {  //mozda treba promeniti
        ResultSet rs = null;
        Statement st = null;
        
        String upit = "SELECT * FROM " + odo.getClassName() + " WHERE " + odo.getWhereCondition1();
        System.out.println("Upit: "+upit);
        boolean signal;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(upit);
            signal = rs.next();
            if (signal == true) {
                odo = odo.getNewRecord(rs);
                //System.out.println("ODO: "+ odo);
            } else {
                odo = null;
            }
        } catch (SQLException ex) {
            System.out.println("Greska u dbb: "+ex.getMessage());
        } finally {
            rs.close(); st.close();
        }
        return odo;
    }
    
   
    
    public List<OpstiDomenskiObjekat> selectAll(OpstiDomenskiObjekat odo) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        ResultSet rs = null;
        Statement st = null;
        String upit = "SELECT * FROM " + odo.getClassName() + " WHERE " + odo.getWhereCondition1();
        System.out.println("Upit: "+upit);
        boolean signal;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(upit);
            while (rs.next()) {
                OpstiDomenskiObjekat odo1 = odo.getNewRecord(rs);
                lista.add(odo1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close(); st.close();
        }
        return lista;
    
    
    }
    
 

    public void insert(OpstiDomenskiObjekat odo) {
       String upit = "INSERT INTO " + odo.getClassName() + " ("+odo.getInsertData()+" )"+" VALUES (" + odo.getAtrValue() + ")";
       System.out.print("Upit: "+ upit);
       boolean signal = executeUpdate(upit);
       if(signal == true) {
       System.out.println("Uspesno sacuvan objekat u bazi!"); }
       
       
    }
    
    public void update(OpstiDomenskiObjekat odo) {
       String upit = null;
       if (odo.getWhereType() == 2) {
           upit = "UPDATE " + odo.getClassName() + " SET " + odo.setAtrValue2() + " WHERE " + odo.getWhereCondition2();
       } else {
       upit = "UPDATE " + odo.getClassName() + " SET " + odo.setAtrValue() + " WHERE " + odo.getWhereCondition2(); }
       System.out.print("Upit: "+ upit);
       boolean signal = executeUpdate(upit);
       if(signal == true) {
       System.out.println("Uspesno sacuvan objekat u bazi!"); }
    
    }

    public boolean executeUpdate(String upit) {
        Statement st = null;
        boolean signal = false;
        try {
            st = connection.createStatement();
            int rowcount = st.executeUpdate(upit);
            if (rowcount > 0) {
                signal = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            signal = false;
        } finally {
            try {
                st.close();
            } catch (Exception e) {
            }
        }
        return signal;
    }

    public Object selectAll1(OpstiDomenskiObjekat odo) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        ResultSet rs = null;
        Statement st = null;
        String upit = "SELECT * FROM " + odo.getClassName() + " WHERE " + odo.getWhereCondition3();
        System.out.println("Upit: "+upit);
        boolean signal;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(upit);
            while (rs.next()) {
                OpstiDomenskiObjekat odo1 = odo.getNewRecord(rs);
                lista.add(odo1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close(); st.close();
        }
        return lista;
    }

    public void update1(OpstiDomenskiObjekat odo) {
       String upit = "UPDATE " + odo.getClassName() + " SET " + odo.setAtrValue1() + " WHERE " + odo.getWhereCondition4();
       System.out.print("Upit: "+ upit);
       boolean signal = executeUpdate(upit);
       if(signal == true) {
       System.out.println("Uspesno sacuvan objekat u bazi!"); 
      }
    }  
  
}

    
