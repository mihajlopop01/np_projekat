
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Predstavlja salon.
 *
 * Salon ima svoj PIB, ime, mesto, broj frizera, vlasnika i listu termina.
 *
 * @autor Mihajlo Popovic
 * @verzija 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Salon extends OpstiDomenskiObjekat implements Serializable {

    /**
     * PIB salona kao long.
     */
    private long pib;
    /**
     * Ime salona kao String.
     */
    private String ime;
    /**
     * Mesto gde se salon nalazi kao String.
     */
    private String mesto;
    /**
     * Broj frizera u salonu kao int.
     */
    private int brojFrizera;
    /**
     * Vlasnik salona kao objekat klase Vlasnik.
     */
    private Vlasnik vlasnik;
    /**
     * Tip WHERE uslova za selektovanje salona iz baze podataka kao int.
     */
    private int whereType;
    /**
     * Lista termina salona kao List<Termin>.
     */
    private List<Termin> termini;

    /**
     * Pravi nov objekat klase Salon.
     *
     * @param aLong PIB salona kao long.
     */
    public Salon(long aLong) {
        this.pib = aLong;
    }

    /**
     * Pravi nov objekat klase Salon i postavlja PIB, ime, mesto, broj frizera i
     * vlasnika na unete vrednosti.
     *
     * @param pib PIB salona kao long.
     * @param ime Ime salona kao String.
     * @param mesto Mesto salona kao String.
     * @param brojFrizera Broj frizera u salonu kao int.
     * @param vlasnik Vlasnik salona kao objekat klase Vlasnik.
     */
    public Salon(long pib, String ime, String mesto, int brojFrizera, Vlasnik vlasnik) {
        this.pib = pib;
        this.ime = ime;
        this.mesto = mesto;
        this.brojFrizera = brojFrizera;
        this.vlasnik = vlasnik;
        termini = new ArrayList<>();
    }

    /**
     * Pravi nov objekat klase Salon i postavlja PIB, ime, mesto i broj frizera
     * na unete vrednosti.
     *
     * @param pib PIB salona kao long.
     * @param ime Ime salona kao String.
     * @param mesto Mesto salona kao String.
     * @param brojFrizera Broj frizera u salonu kao int.
     */
    public Salon(long pib, String ime, String mesto, int brojFrizera) {
        this.pib = pib;
        this.ime = ime;
        this.mesto = mesto;
        this.brojFrizera = brojFrizera;
    }

    /**
     * Pravi nov objekat klase Salon.
     */
    public Salon() {
    }

    /**
     * Pravi nov objekat klase Salon i postavlja PIB i tip WHERE uslova na unete
     * vrednosti.
     *
     * @param pib PIB salona kao long.
     * @param whereType Tip WHERE uslova kao int.
     */
    public Salon(long pib, int whereType) {
        this.pib = pib;
        this.whereType = whereType;
    }

    /**
     * Vraća PIB salona.
     *
     * @return trenutni PIB salona kao long.
     */
    public long getPib() {
        return pib;
    }

    /**
     * Postavlja PIB salona na unetu vrednost. PIB mora biti pozitivan broj.
     *
     * @param pib PIB salona kao long
     * @throws IllegalArgumentException ako je PIB manji ili jednak nuli
     */
    public void setPib(long pib) {
        if (pib <= 0) {
            throw new IllegalArgumentException("PIB salona mora biti veći od nule.");
        }
        this.pib = pib;
    }

    /**
     * Vraća ime salona.
     *
     * @return trenutno ime salona kao String.
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime salona na unetu vrednost. Ime ne sme biti null ili prazan
     * string.
     *
     * @param ime Ime salona kao String
     * @throws IllegalArgumentException ako je ime null ili prazan string
     */
    public void setIme(String ime) {
        if (ime == null || ime.trim().isEmpty()) {
            throw new IllegalArgumentException("Ime salona ne sme biti null ili prazan.");
        }
        this.ime = ime;
    }

    /**
     * Vraća mesto gde se salon nalazi.
     *
     * @return trenutno mesto salona kao String.
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Postavlja mesto salona na unetu vrednost. Mesto ne sme biti null ili
     * prazan string.
     *
     * @param mesto Mesto salona kao String
     * @throws IllegalArgumentException ako je mesto null ili prazan string
     */
    public void setMesto(String mesto) {
        if (mesto == null || mesto.trim().isEmpty()) {
            throw new IllegalArgumentException("Mesto salona ne sme biti null ili prazan.");
        }
        this.mesto = mesto;
    }

    /**
     * Vraća broj frizera u salonu.
     *
     * @return trenutni broj frizera u salonu kao int.
     */
    public int getBrojFrizera() {
        return brojFrizera;
    }

    /**
     * Postavlja broj frizera u salonu na unetu vrednost. Broj frizera mora biti
     * nenegativan broj.
     *
     * @param brojFrizera Broj frizera kao int
     * @throws IllegalArgumentException ako je broj frizera negativan
     */
    public void setBrojFrizera(int brojFrizera) {
        if (brojFrizera < 0) {
            throw new IllegalArgumentException("Broj frizera ne sme biti negativan.");
        }
        this.brojFrizera = brojFrizera;
    }

    /**
     * Vraća vlasnika salona.
     *
     * @return trenutni vlasnik salona kao objekat klase Vlasnik.
     */
    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    /**
     * Postavlja vlasnika salona na unetu vrednost. Vlasnik ne sme biti null.
     *
     * @param vlasnik Vlasnik salona kao objekat klase Vlasnik
     * @throws IllegalArgumentException ako je vlasnik null
     */
    public void setVlasnik(Vlasnik vlasnik) {
        if (vlasnik == null) {
            throw new IllegalArgumentException("Vlasnik salona ne sme biti null.");
        }
        this.vlasnik = vlasnik;
    }

    /**
     * Postavlja listu termina salona na unetu vrednost. Lista termina može biti
     * null, ali ne sme sadržati null vrednosti.
     *
     * @param termini Lista termina kao List<Termin>
     * @throws IllegalArgumentException ako lista sadrži null vrednosti
     */
    public void setTermini(List<Termin> termini) {
        if (termini != null && termini.contains(null)) {
            throw new IllegalArgumentException("Lista termina ne sme sadržati null vrednosti.");
        }
        this.termini = termini;
    }

    /**
     * Vraća PIB salona kao string.
     *
     * @return PIB salona kao String.
     *
     */
    @Override
    public String toString() {
        return "Salon: " + pib;
    }

    /**
     * Vraća informacije o salonu (PIB, ime, mesto, broj frizera).
     *
     * @return informacije o salonu kao String.
     */
    public String toString1() {
        return "PIB: " + pib + " Naziv salona: " + ime + " Mesto: " + mesto + " Broj frizera: " + brojFrizera;
    }

    /**
     * Vraća naziv klase (tabele u bazi podataka) za salon.
     *
     * @return naziv klase (tabele u bazi podataka) kao String.
     */
    @Override
    public String getClassName() {
        return "salon";
    }

    /**
     * Vraća WHERE uslov za selektovanje salona iz baze podataka na osnovu
     * vlasnika.
     *
     * @return WHERE uslov kao String.
     */
    @Override
    public String getWhereCondition() {
        return "vlasnikid = " + '\'' + vlasnik.getVlasnikid() + '\'';
    }

    /**
     * Pravi i vraća novi objekat klase Salon na osnovu podataka iz ResultSet-a.
     *
     * @param rs objekat klase ResultSet koji sadrži podatke iz baze.
     * @return novi objekat klase Salon.
     * @throws SQLException ako dođe do greške prilikom čitanja podataka iz
     * ResultSet-a.
     */
    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new Salon(rs.getLong("PIB"), rs.getString("ime"), rs.getString("mesto"), rs.getInt("brojFrizera"), new Vlasnik(rs.getLong("vlasnikid")));
    }

    /**
     * Vraća vrednosti atributa salona koje ubacujemo u bazu podataka.
     *
     * @return vrednosti atributa salona kao String.
     */
    @Override
    public String getAtrValue() {
        return pib + ", " + "'" + ime + "'" + ", " + "'" + mesto + "'" + ", " + brojFrizera + ", " + vlasnik.getVlasnikid();
    }

    /**
     * Vraća nazive atributa salona koje ubacujemo u bazu podataka.
     *
     * @return nazive atributa salona kao String.
     */
    @Override
    public String getInsertData() {
        return "PIB, ime, mesto, brojFrizera, vlasnikid";
    }

    /**
     * Vraća WHERE uslov za selektovanje salona iz baze podataka na osnovu
     * mesta.
     *
     * @return WHERE uslov kao String.
     */
    @Override
    public String getWhereCondition1() {
        return "mesto = " + '\'' + mesto + '\'';
    }

    /**
     * Vraća WHERE uslov za selektovanje salona iz baze podataka na osnovu
     * imena.
     *
     * @return WHERE uslov kao String.
     */
    @Override
    public String getWhereCondition2() {
        return "ime = " + '\'' + getIme() + '\'';
    }

    /**
     * Vraća WHERE uslov za selektovanje salona iz baze podataka na osnovu
     * PIB-a.
     *
     * @return WHERE uslov kao String.
     */
    @Override
    public String getWhereCondition4() {
        return "PIB = " + '\'' + pib + '\'';
    }

    /**
     * Vraća trenutni tip WHERE uslova za selektovanje salona iz baze podataka.
     *
     * @return trenutni tip WHERE uslova kao int.
     */
    @Override
    public int getWhereType() {
        return this.whereType;
    }

    /**
     * Postavlja tip WHERE uslova za selektovanje salona iz baze podataka na
     * unetu vrednost.
     *
     * @param whereType tip WHERE uslova kao int.
     */
    @Override
    public void setWhereType(int whereType) {
        this.whereType = whereType;
    }

    /**
     * Metoda nije podržana.
     *
     * @throws UnsupportedOperationException uvek.
     */
    @JsonIgnore
    @Override
    public String setAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Metoda nije podržana.
     *
     * @throws UnsupportedOperationException uvek.
     */
    @JsonIgnore
    @Override

    public String getWhereCondition3() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Metoda nije podržana.
     *
     * @throws UnsupportedOperationException uvek.
     */
    @JsonIgnore
    @Override
    public String setAtrValue1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Metoda nije podržana.
     *
     * @throws UnsupportedOperationException uvek.
     */
    @JsonIgnore
    @Override
    public String setAtrValue2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Vraća listu termina salona.
     *
     * @return lista salona termina.
     */
    public List<Termin> getTermini() {
        return termini;
    }

/**
 * Proverava da li su dva objekta klase Salon jednaka.
 * Objekti se smatraju jednakima ako imaju isti PIB.
 *
 * @param obj Objekat koji se poredi sa trenutnim objektom
 * @return true ako je prosleđeni objekat instance klase Salon i ima isti PIB, u suprotnom false
 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salon other = (Salon) obj;
        return this.pib == other.pib;
    }
    
    
    

}
