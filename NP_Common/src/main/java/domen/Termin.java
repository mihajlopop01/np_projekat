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
 * Predstavlja termin u salonu za friziranje.
 *
 * Termin sadrži informacije o salonu, identifikacionom broju termina, vremenu,
 * datumu, frizeru, slobodnom statusu, korisniku koji je rezervisao termin,
 * oceni termina i usluzi.
 *
 * @author Mihajlo Popovic
 * @version 1.0
 */
public class Termin extends OpstiDomenskiObjekat implements Serializable {

    /**
     * Salon u kome je zakazan termin.
     */
    private Salon salon;

    /**
     * Identifikacioni broj termina.
     */
    private Long terminid;

    /**
     * Vreme termina.
     */
    private String vreme;

    /**
     * Datum termina.
     */
    private Date datum;

    /**
     * Ime frizera koji obavlja termin.
     */
    private String frizer;

    /**
     * Status da li je termin slobodan ili rezervisan.
     */
    private boolean slobodan;

    /**
     * Korisnik koji je rezervisao termin.
     */
    private Korisnik korisnik;

    /**
     * Tip WHERE uslova za upit baze podataka.
     */
    private int whereType;

    /**
     * Ocena koja je dodeljena terminu.
     */
    private int ocena;

    /**
     * Usluga koja je vezana za ovaj termin.
     */
    private Usluga usluga;

    /**
     * Konstruktor bez parametara za kreiranje praznog termina.
     */
    public Termin() {
    }

    /**
     * Konstruktor koji postavlja salon za termin.
     *
     * @param salon Salon u kome je termin.
     */
    public Termin(Salon salon) {
        this.salon = salon;
    }

    /**
     * Konstruktor koji postavlja osnovne informacije o terminu.
     *
     * @param vreme Vreme termina.
     * @param datum Datum termina.
     * @param frizer Ime frizera koji obavlja termin.
     * @param slobodan Status da li je termin slobodan ili rezervisan.
     * @param korisnik Korisnik koji je rezervisao termin.
     */
    public Termin(String vreme, Date datum, String frizer, boolean slobodan, Korisnik korisnik) {
        this.vreme = vreme;
        this.datum = datum;
        this.frizer = frizer;
        this.slobodan = slobodan;
        this.korisnik = korisnik;
    }

    /**
     * Konstruktor koji postavlja sve informacije o terminu.
     *
     * @param salon Salon u kome je termin.
     * @param terminid Identifikacioni broj termina.
     * @param vreme Vreme termina.
     * @param datum Datum termina.
     * @param frizer Ime frizera koji obavlja termin.
     * @param slobodan Status da li je termin slobodan ili rezervisan.
     * @param korisnik Korisnik koji je rezervisao termin.
     */
    public Termin(Salon salon, Long terminid, String vreme, Date datum, String frizer, boolean slobodan, Korisnik korisnik) {
        this.salon = salon;
        this.terminid = terminid;
        this.vreme = vreme;
        this.datum = datum;
        this.frizer = frizer;
        this.slobodan = slobodan;
        this.korisnik = korisnik;
    }

    /**
     * Konstruktor koji postavlja osnovne informacije o slobodnom terminu.
     *
     * @param vreme Vreme termina.
     * @param datum Datum termina.
     * @param frizer Ime frizera koji obavlja termin.
     * @param slobodan Status da li je termin slobodan ili rezervisan.
     */
    public Termin(String vreme, Date datum, String frizer, boolean slobodan) {
        this.vreme = vreme;
        this.datum = datum;
        this.frizer = frizer;
        this.slobodan = slobodan;
    }

    /**
     * Konstruktor koji postavlja sve informacije o terminu, uključujući ocenu.
     *
     * @param vreme Vreme termina.
     * @param datum Datum termina.
     * @param frizer Ime frizera koji obavlja termin.
     * @param slobodan Status da li je termin slobodan ili rezervisan.
     * @param salon Salon u kome je termin.
     * @param terminid Identifikacioni broj termina.
     * @param ocena Ocena dodeljena terminu.
     */
    public Termin(String vreme, Date datum, String frizer, boolean slobodan, Salon salon, long terminid, int ocena) {
        this.vreme = vreme;
        this.datum = datum;
        this.frizer = frizer;
        this.slobodan = slobodan;
        this.salon = salon;
        this.terminid = terminid;
        this.ocena = ocena;
    }

    /**
     * Vraća uslugu koja je vezana za ovaj termin.
     *
     * @return Usluga povezana sa terminom.
     */
    public Usluga getUsluga() {
        return usluga;
    }

    /**
     * Postavlja uslugu koja je vezana za ovaj termin.
     *
     * @param usluga Usluga koja se postavlja za ovaj termin.
     */
    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    /**
     * Vraća ocenu koja je dodeljena ovom terminu.
     *
     * @return Ocena dodeljena terminu.
     */
    public int getOcena() {
        return ocena;
    }

    /**
     * Postavlja ocenu za ovaj termin.
     *
     * @param ocena Ocena koja se postavlja za ovaj termin.
     */
    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    /**
     * Vraca salon.
     *
     * @return trenutni salon kao objekat klase Salon
     */
    public Salon getSalon() {
        return salon;
    }

    /**
     * Postavlja salon na unetu vrednost.
     *
     * @param salon salon kao objekat klase Salon
     */
    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    /**
     * Vraca ID termina.
     *
     * @return trenutni ID termina kao Long
     */
    public Long getTerminid() {
        return terminid;
    }

    /**
     * Postavlja ID termina na unetu vrednost.
     *
     * @param terminid ID termina kao Long
     */
    public void setTerminid(Long terminid) {
        this.terminid = terminid;
    }

    /**
     * Vraca vreme termina.
     *
     * @return trenutno vreme termina kao String
     */
    public String getVreme() {
        return vreme;
    }

    /**
     * Postavlja vreme termina na unetu vrednost.
     *
     * @param vreme vreme termina kao String
     */
    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    /**
     * Postavlja datum termina na unetu vrednost i vraca formatiran datum.
     *
     * @param datum datum kao Date
     * @return formatiran datum kao Date
     */
    public Date getDatum(Date datum) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        this.datum = java.sql.Date.valueOf(sm.format(datum));
        return this.datum;
    }

    /**
     * Vraca datum termina.
     *
     * @return trenutni datum termina kao Date
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * Postavlja datum termina na unetu vrednost.
     *
     * @param datum datum termina kao Date
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * Vraca frizera za termin.
     *
     * @return trenutni frizer za termin kao String
     */
    public String getFrizer() {
        return frizer;
    }

    /**
     * Postavlja frizera za termin na unetu vrednost.
     *
     * @param frizer frizer za termin kao String
     */
    public void setFrizer(String frizer) {
        this.frizer = frizer;
    }

    /**
     * Proverava da li je termin slobodan.
     *
     * @return true ako je termin slobodan, inace false
     */
    public boolean isSlobodan() {
        return slobodan;
    }

    /**
     * Postavlja status slobode termina.
     *
     * @param slobodan status slobode termina kao boolean
     */
    public void setSlobodan(boolean slobodan) {
        this.slobodan = slobodan;
    }

    /**
     * Vraca korisnika termina.
     *
     * @return trenutni korisnik termina kao objekat klase Korisnik
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Postavlja korisnika termina na unetu vrednost.
     *
     * @param korisnik korisnik termina kao objekat klase Korisnik
     */
    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    /**
     * Vraca naziv klase.
     *
     * @return naziv klase kao String
     */
    @Override
    public String getClassName() {
        return "termin";
    }

    /**
     * Vraca uslov za WHERE klauzulu.
     *
     * @return uslov za WHERE klauzulu kao String
     */
    @Override
    public String getWhereCondition() {
        // return "datum = "+'\''+getDatum(this.datum)+'\'';
        return "PIB = " + '\'' + salon.getPib() + '\'';
    }

    /**
     * Kreira novi zapis iz ResultSet-a.
     *
     * @param rs ResultSet iz baze podataka
     * @return novi objekat klase OpstiDomenskiObjekat
     * @throws SQLException ako dodje do greske pri radu sa bazom podataka
     */
    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new Termin(rs.getString("vreme"), rs.getDate("datum"), rs.getString("frizer"), rs.getBoolean("slobodan"), new Salon(rs.getLong("PIB")), rs.getLong("terminid"), rs.getInt("ocena"));
    }

    /**
     * Vraca vrednosti atributa za INSERT upit.
     *
     * @return vrednosti atributa kao String
     */
    @Override
    public String getAtrValue() {
        return salon.getPib() + ", " + "'" + vreme + "'" + ", " + "'" + getDatum(this.datum) + "'" + ", " + "'" + frizer + "'" + ", " + slobodan + ", " + korisnik.getKorisnikid() + ", " + usluga.getUslugaid();
    }

    /**
     * Vraca tekstualni prikaz objekta.
     *
     * @return tekstualni prikaz objekta kao String
     */
    @Override
    public String toString() {
        return "Terminid: " + terminid + " Vreme: " + vreme + " Datum: " + datum + " Frizer: " + frizer + " Slobodan: " + slobodan;
    }

    /**
     * Vraca podatke za INSERT upit.
     *
     * @return podatke za INSERT upit kao String
     */
    @Override
    public String getInsertData() {
        return "PIB,vreme,datum,frizer,slobodan,korisnikid,uslugaid";
    }

    /**
     * Vraca uslov za WHERE klauzulu 1.
     *
     * @return uslov za WHERE klauzulu 1 kao String
     */
    @Override
    public String getWhereCondition1() {
        // return "terminid = "+'\''+terminid+'\'';
        return "PIB = " + '\'' + salon.getPib() + '\'';
    }

    /**
     * Vraca uslov za WHERE klauzulu 2.
     *
     * @return uslov za WHERE klauzulu 2 kao String
     */
    @Override
    public String getWhereCondition2() {
        // return "frizer = "+'\''+getFrizer()+'\''+ " AND " + "vreme = "+'\''+getVreme()+'\'';
        return "terminid = " + terminid;
    }

    /**
     * Postavlja vrednosti atributa za UPDATE upit.
     *
     * @return vrednosti atributa kao String
     */
    @Override
    public String setAtrValue() {
        return "slobodan=" + slobodan + ", " + "korisnikid=" + korisnik.getKorisnikid();
    }

    /**
     * Vraca uslov za WHERE klauzulu 3.
     *
     * @return uslov za WHERE klauzulu 3 kao String
     */
    @Override
    public String getWhereCondition3() {
        return "korisnikid = " + korisnik.getKorisnikid();
    }

    /**
     * Postavlja vrednosti atributa za UPDATE upit 1.
     *
     * @return vrednosti atributa kao String
     */
    @Override
    public String setAtrValue1() {
        return "vreme = " + '\'' + getVreme() + '\'' + ", " + "datum = " + '\'' + getDatum(this.datum) + '\'';
    }

    /**
     * Vraca uslov za WHERE klauzulu 4.
     *
     * @return uslov za WHERE klauzulu 4 kao String
     */
    @Override
    public String getWhereCondition4() {
        return "terminid = " + terminid;
    }

    /**
     * Vraca tip WHERE klauzule.
     *
     * @return tip WHERE klauzule kao int
     */
    @Override
    public int getWhereType() {
        return this.whereType;
    }

    /**
     * Postavlja tip WHERE klauzule.
     *
     * @param whereType tip WHERE klauzule kao int
     */
    @Override
    public void setWhereType(int whereType) {
        this.whereType = whereType;
    }

    /**
     * Postavlja vrednosti atributa za UPDATE upit 2.
     *
     * @return vrednosti atributa kao String
     */
    @Override
    public String setAtrValue2() {
        return "ocena = " + ocena;
    }

}
