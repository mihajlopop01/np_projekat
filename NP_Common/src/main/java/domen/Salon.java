/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.util.List;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mihajlo Popovic
 */
public class Salon extends OpstiDomenskiObjekat implements Serializable{
    
    private long pib; 
    private String ime;
    private String mesto;
    private int brojFrizera;
    private Vlasnik vlasnik;
    private int whereType;
    private List<Termin> termini;
    

    public Salon(long aLong) {
        this.pib = aLong;
    }

    public Salon(long pib, String ime, String mesto, int brojFrizera, Vlasnik vlasnik) {
        this.pib = pib;
        this.ime = ime;
        this.mesto = mesto;
        this.brojFrizera = brojFrizera;
        this.vlasnik = vlasnik;
        termini = new ArrayList<>();
    }

    public Salon(long pib, String ime, String mesto, int brojFrizera) {
        this.pib = pib;
        this.ime = ime;
        this.mesto = mesto;
        this.brojFrizera = brojFrizera;
    }
    
    public Salon() {
    
    }
    
    public Salon(long pib, int wheretype) {
        this.pib = pib;
        this.whereType = wheretype;
    }

    public long getPib() {
        return pib;
    }

    public void setPib(long pib) {
        this.pib = pib;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public int getBrojFrizera() {
        return brojFrizera;
    }

    public void setBrojFrizera(int brojFrizera) {
        this.brojFrizera = brojFrizera;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(Vlasnik vlasnik) {
        this.vlasnik = vlasnik;
    }
    
    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }

    @Override
    public String toString() {
        return "Salon: "+ pib;
    }
    
    public String toString1() {
        return "PIB: "+ pib + " Naziv salona: " +ime+ " Mesto: "+ mesto + " Broj frizera: " + brojFrizera;
    }

    

    @Override
    public String getClassName() {
        return "salon";
    }

    @Override
    public String getWhereCondition() {
        return "vlasnikid = "+'\''+vlasnik.getVlasnikid()+'\'';
        //return "ime = "+'\''+getIme()+'\'';
                

        
    }

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException{
        return new Salon(rs.getLong("PIB"),rs.getString("ime"),rs.getString("mesto"),rs.getInt("brojFrizera"),new Vlasnik(rs.getLong("vlasnikid")));
    }

    @Override
    public String getAtrValue() {
       return pib + ", " + "'" + ime + "'" + ", " + "'" + mesto + "'"  + ", "+ ", " + brojFrizera  + ", "  + vlasnik.getVlasnikid() ;
    }

    @Override
    public String getInsertData() {
        return "PIB,ime,mesto,ocena,brojFrizera,vlasnikid";
    }

    @Override
    public String getWhereCondition1() {
        return "mesto = "+'\''+mesto+'\'';
    }

    @Override
    public String getWhereCondition2() {
       return "ime = "+'\''+getIme()+'\'';
    }

    @Override
    public String setAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereCondition3() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String setAtrValue1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereCondition4() {
         return "PIB = "+'\''+pib+'\'';

    }

    @Override
    public int getWhereType() {
        return this.whereType;
    }

    @Override
    public void setWhereType(int whereType) {
        this.whereType = whereType;
    }

    @Override
    public String setAtrValue2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
