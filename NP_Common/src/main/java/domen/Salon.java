
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
     * Postavlja PIB salona na unetu vrednost.
     *
     * @param pib PIB salona kao long.
     */
    public void setPib(long pib) {
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
     * Postavlja ime salona na unetu vrednost.
     *
     * @param ime Ime salona kao String.
     */
    public void setIme(String ime) {
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
     * Postavlja mesto salona na unetu vrednost.
     *
     * @param mesto Mesto salona kao String.
     */
    public void setMesto(String mesto) {
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
     * Postavlja broj frizera u salonu na unetu vrednost.
     *
     * @param brojFrizera Broj frizera kao int.
     */
    public void setBrojFrizera(int brojFrizera) {
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
     * Postavlja vlasnika salona na unetu vrednost.
     *
     * @param vlasnik Vlasnik salona kao objekat klase Vlasnik.
     */
    public void setVlasnik(Vlasnik vlasnik) {
        this.vlasnik = vlasnik;
    }

    /**
     * Postavlja listu termina salona na unetu vrednost.
     *
     * @param termini Lista termina kao List<Termin>.
     */
    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }

    /**
     * Vraća PIB salona kao string.
     *
     * @return PIB salona kao String.
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

}
