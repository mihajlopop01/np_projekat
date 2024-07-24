/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Predstavlja zakazivanje u salonu.
 * Klasa Zakazivanje nasleđuje klasu OpstiDomenskiObjekat i implementira interfejs Serializable.
 * Zakazivanje sadrži informacije o salonu, korisniku, plačanju, ceni i trajanju zakazivanja.
 *
 * @autor Mihajlo Popović
 * @verzija 1.0
 */
public class Zakazivanje extends OpstiDomenskiObjekat implements Serializable {

    /**
     * ID zakazivanja kao int
     */
    private int zakazivanjeid;

    /**
     * Salon u kojem je zakazivanje obavljeno kao objekat klase Salon
     */
    private Salon salon;

    /**
     * Korisnik koji je napravio zakazivanje kao objekat klase Korisnik
     */
    private Korisnik korisnik;

    /**
     * Plačanje povezano sa zakazivanjem kao objekat klase Placanje
     */
    private Placanje placanje;

    /**
     * Cena zakazivanja kao int
     */
    private int cena;

    /**
     * Trajanje zakazivanja u minutima kao int
     */
    private int trajanje;

    /**
     * Tip gde se koristi kao int (nije korišćen u ovoj klasi)
     */
    private int whereType;

    /**
     * Kreira novi objekat klase Zakazivanje sa neinicijalizovanim atributima.
     */
    public Zakazivanje() {
    }

    /**
     * Kreira novi objekat klase Zakazivanje i postavlja salon, korisnika, cenu, trajanje i plačanje na zadate vrednosti.
     *
     * @param salon Salon u kojem je zakazivanje obavljeno kao objekat klase Salon
     * @param korisnik Korisnik koji je napravio zakazivanje kao objekat klase Korisnik
     * @param cena Cena zakazivanja kao int
     * @param trajanje Trajanje zakazivanja u minutima kao int
     * @param placanje Plačanje povezano sa zakazivanjem kao objekat klase Placanje
     */
    public Zakazivanje(Salon salon, Korisnik korisnik, int cena, int trajanje, Placanje placanje) {
        this.salon = salon;
        this.korisnik = korisnik;
        this.cena = cena;
        this.trajanje = trajanje;
        this.placanje = placanje;
    }

    /**
     * Kreira novi objekat klase Zakazivanje sa cenom i trajanjem.
     *
     * @param cena Cena zakazivanja kao int
     * @param trajanje Trajanje zakazivanja u minutima kao int
     */
    public Zakazivanje(int cena, int trajanje) {
        this.cena = cena;
        this.trajanje = trajanje;
    }

    /**
     * Vraća ID zakazivanja.
     *
     * @return trenutni ID zakazivanja kao int
     */
    public int getZakazivanjeid() {
        return zakazivanjeid;
    }

    /**
     * Postavlja ID zakazivanja na zadatu vrednost.
     *
     * @param zakazivanjeid ID zakazivanja kao int
     */
    public void setZakazivanjeid(int zakazivanjeid) {
        this.zakazivanjeid = zakazivanjeid;
    }

    /**
     * Vraća salon u kojem je zakazivanje obavljeno.
     *
     * @return trenutni salon kao objekat klase Salon
     */
    public Salon getSalon() {
        return salon;
    }

    /**
     * Postavlja salon za zakazivanje na zadatu vrednost.
     *
     * @param salon Salon u kojem je zakazivanje obavljeno kao objekat klase Salon
     */
    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    /**
     * Vraća korisnika koji je napravio zakazivanje.
     *
     * @return trenutni korisnik kao objekat klase Korisnik
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Postavlja korisnika za zakazivanje na zadatu vrednost.
     *
     * @param korisnik Korisnik koji je napravio zakazivanje kao objekat klase Korisnik
     */
    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    /**
     * Vraća cenu zakazivanja.
     *
     * @return trenutna cena zakazivanja kao int
     */
    public int getCena() {
        return cena;
    }

    /**
     * Postavlja cenu zakazivanja na zadatu vrednost.
     *
     * @param cena Cena zakazivanja kao int
     */
    public void setCena(int cena) {
        this.cena = cena;
    }

    /**
     * Vraća trajanje zakazivanja u minutima.
     *
     * @return trenutno trajanje zakazivanja u minutima kao int
     */
    public int getTrajanje() {
        return trajanje;
    }

    /**
     * Postavlja trajanje zakazivanja na zadatu vrednost.
     *
     * @param trajanje Trajanje zakazivanja u minutima kao int
     */
    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    @Override
    public String getClassName() {
        return "zakazivanje";
    }

    @Override
    public String getWhereCondition() {
        return "PIB = " + '\'' + salon.getPib() + '\''; 
    }

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new Zakazivanje(rs.getInt("cena"), rs.getInt("trajanje"));
    }

    @Override
    public String getAtrValue() {
        return salon.getPib() + ", " + korisnik.getKorisnikid() + ", " + cena + ", " + trajanje;
    }

    @Override
    public String getInsertData() {
        return "PIB, korisnikid, cena, trajanje";
    }

    @Override
    public String getWhereCondition1() {
        return "PIB = " + '\'' + salon.getPib() + '\''; 
    }

    @Override
    public String getWhereCondition2() {
        return "PIB = " + '\'' + salon.getPib() + '\''; 
    }

    @Override
    public String toString() {
        return "Zakazivanje: " + cena + " " + trajanje; 
    }

    /**
     * Vraća detaljne informacije o zakazivanju.
     *
     * @return detaljan opis zakazivanja kao String
     */
    public String toString1() {
        return "Zakazivanje: " + cena + " " + trajanje + " " + salon.getPib() + " " + korisnik.getKorisnikid(); 
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

    public void setPlacanje(Placanje placanje) {
        this.placanje = placanje;
    }

   
        
    
    
    
    
    
}
