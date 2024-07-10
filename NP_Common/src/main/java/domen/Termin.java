/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.Date;

/**
 *
 * @author Mihajlo Popovic
 */
public class Termin extends OpstiDomenskiObjekat implements Serializable{
    
    private Salon salon;
    private Long terminid;
    private String vreme;
    private Date datum;
    private String frizer;
    private boolean slobodan;
    private Korisnik korisnik;
    private int whereType;
    private int ocena;

    public Termin() {
    }
    
    public Termin(Salon salon) {
        this.salon = salon;
    
    }
    
    

    public Termin(String vreme, Date datum, String frizer, boolean slobodan, Korisnik korisnik) {
        this.vreme = vreme;
        this.datum = datum;
        this.frizer = frizer;
        this.slobodan = slobodan;
        this.korisnik = korisnik;
    }

    public Termin(Salon salon, Long terminid, String vreme, Date datum, String frizer, boolean slobodan, Korisnik korisnik) {
        this.salon = salon;
        this.terminid = terminid;
        this.vreme = vreme;
        this.datum = datum;
        this.frizer = frizer;
        this.slobodan = slobodan;
        this.korisnik = korisnik;
    }

    public Termin(String vreme, Date datum, String frizer, boolean slobodan) {
        this.vreme = vreme;
        this.datum = datum;
        this.frizer = frizer;
        this.slobodan = slobodan;
    }
    
    public Termin(String vreme, Date datum, String frizer, boolean slobodan, Salon salon, long terminid, int ocena) {
        this.vreme = vreme;
        this.datum = datum;
        this.frizer = frizer;
        this.slobodan = slobodan;
        this.salon = salon;
        this.terminid = terminid;
        this.ocena = ocena;
        this.terminid = terminid;
    
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
    
    

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Long getTerminid() {
        return terminid;
    }

    public void setTerminid(Long terminid) {
        this.terminid = terminid;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public Date getDatum(Date datum) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        this.datum = java.sql.Date.valueOf(sm.format(datum));
        return this.datum;
    }

    public Date getDatum() {
        return datum;
    }
    

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getFrizer() {
        return frizer;
    }

    public void setFrizer(String frizer) {
        this.frizer = frizer;
    }

    public boolean isSlobodan() {
        return slobodan;
    }

    public void setSlobodan(boolean slobodan) {
        this.slobodan = slobodan;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public String getClassName() {
        return "termin";
    }

    @Override
    public String getWhereCondition() {
      //return "datum = "+'\''+getDatum(this.datum)+'\'';
      return "PIB = "+'\''+salon.getPib()+'\'';
    }

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new Termin(rs.getString("vreme"),rs.getDate("datum"),rs.getString("frizer"),rs.getBoolean("slobodan"), new Salon(rs.getLong("PIB")),rs.getLong("terminid"),rs.getInt("ocena"));
    }

    @Override
    public String getAtrValue() {
        return salon.getPib() + ", " + "'" + vreme + "'" + ", " + "'" + getDatum(this.datum) + "'" + ", " + "'" + frizer + "'" + ", " + slobodan + ", " + korisnik.getKorisnikid();
    }

    @Override
    public String toString() {
        return "Terminid: "+ terminid + " Vreme: " + vreme + " Datum: " + datum + " Frizer: "+frizer + " Slobodan: " + slobodan;
    }

    @Override
    public String getInsertData() {
        return "PIB,vreme,datum,frizer,slobodan,korisnikid";
    }

    @Override
    public String getWhereCondition1() {
       // return "terminid = "+'\''+terminid+'\'';
       return "PIB = "+'\''+salon.getPib()+'\'';
        
    }

    @Override
    public String getWhereCondition2() {
       //return "frizer = "+'\''+getFrizer()+'\''+ " AND " + "vreme = "+'\''+getVreme()+'\'' ;
       return "terminid = "+terminid;
    }

    @Override
    public String setAtrValue() {
        return "slobodan="+slobodan+ ", " + "korisnikid="+korisnik.getKorisnikid();
    }

    @Override
    public String getWhereCondition3() {
       return "korisnikid = "+korisnik.getKorisnikid();
    }

    @Override
    public String setAtrValue1() {
        return "vreme = "+'\''+getVreme()+'\''+ ", " +"datum = "+'\''+getDatum(this.datum)+'\'';
      
    }

    @Override
    public String getWhereCondition4() {
        return "terminid = "+terminid;
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
        return "ocena = "+ocena;
      
    }
    
    

   
    
    
    
}
