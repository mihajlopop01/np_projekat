/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mihajlo Popovic
 */
public class Zakazivanje extends OpstiDomenskiObjekat implements Serializable{
    
    private int zakazivanjeid;
    private Salon salon;
    private Korisnik korisnik;
    private Placanje placanje;
    private int cena;
    private int trajanje;
    private int whereType;

    public Zakazivanje() {
    }

    public Zakazivanje(Salon salon, Korisnik korisnik, int cena, int trajanje, Placanje placanje) {
        this.salon = salon;
        this.korisnik = korisnik;
        this.cena = cena;
        this.trajanje = trajanje;
        this.placanje = placanje;
    }

    public Placanje getPlacanje() {
        return placanje;
    }

    public void setPlacanje(Placanje placanje) {
        this.placanje = placanje;
    }

    public Zakazivanje(int cena,int trajanje) {
        this.cena = cena;
        this.trajanje = trajanje;
       
    }

    public int getZakazivanjeid() {
        return zakazivanjeid;
    }

    public void setZakazivanjeid(int zakazivanjeid) {
        this.zakazivanjeid = zakazivanjeid;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    @Override
    public String getClassName() {
        return "zakazivanje";
    }

    @Override
    public String getWhereCondition() {
        return "PIB = "+'\''+salon.getPib()+'\''; 
    }

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException{
        return new Zakazivanje(rs.getInt("cena"),rs.getInt("trajanje"));
    }

    @Override
    public String getAtrValue() {
       return salon.getPib() + ", " + korisnik.getKorisnikid() + ", " + cena + ", " + trajanje;
    }

    @Override
    public String getInsertData() {
        return "PIB,korisnikid,cena,trajanje";
    }

    @Override
    public String getWhereCondition1() {
        return "PIB = "+'\''+salon.getPib()+'\''; //
    }

    @Override
    public String getWhereCondition2() {
        return "PIB = "+'\''+salon.getPib()+'\''; //
    }

    @Override
    public String toString() {
        return "Zakazivanje: "+ cena + trajanje; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    public String toString1() {
        return "Zakazivanje: "+ cena + trajanje + salon.getPib() + korisnik.getKorisnikid(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String setAtrValue() {
        return "korisnikid=" + korisnik.getKorisnikid();
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
