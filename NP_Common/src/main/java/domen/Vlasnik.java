
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author Mihajlo Popovic
 */
/**
 * Predstavlja vlasnika u sistemu. Klasa Vlasnik nasledjuje klasu
 * OpstiDomenskiObjekat i implementira intefejs Serializable. Vlasnik ima svoj
 * ID, ime, prezime, email i šifru.
 *
 * @autor Mihajlo Popovic
 * @version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vlasnik extends OpstiDomenskiObjekat implements Serializable {

    /**
     * ID vlasnika kao long
     */
    private long vlasnikid;
    /**
     * Ime vlasnika kao String
     */
    private String ime;
    /**
     * Prezime vlasnika kao String
     */
    private String prezime;
    /**
     * Email vlasnika kao String
     */
    private String email;
    /**
     * Šifra vlasnika kao String
     */
    private String sifra;
    /**
     * Tip WHERE uslova kao int
     */
    private int whereType;

    /**
     * Pravi nov objekat klase Vlasnik.
     *
     * Atributi ostaju neinicijalizovani.
     */
    public Vlasnik() {
    }

    /**
     * Pravi nov objekat klase Vlasnik i postavlja vlasnikid, ime, prezime,
     * email i šifru na unete vrednosti.
     *
     * @param vlasnikid ID vlasnika kao long
     * @param ime Ime vlasnika kao String
     * @param prezime Prezime vlasnika kao String
     * @param email Email vlasnika kao String
     * @param sifra Šifra vlasnika kao String
     */
    public Vlasnik(long vlasnikid, String ime, String prezime, String email, String sifra) {
        this.vlasnikid = vlasnikid;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.sifra = sifra;
    }

    /**
     * Pravi nov objekat klase Vlasnik sa datim emailom i šifrom.
     *
     * @param email Email vlasnika kao String
     * @param sifra Šifra vlasnika kao String
     */
    public Vlasnik(String email, String sifra) {
        this.email = email;
        this.sifra = sifra;
    }

    /**
     * Pravi nov objekat klase Vlasnik sa datim imenom, prezimenom, emailom i
     * šifrom.
     *
     * @param ime Ime vlasnika kao String
     * @param prezime Prezime vlasnika kao String
     * @param email Email vlasnika kao String
     * @param sifra Šifra vlasnika kao String
     */
    public Vlasnik(String ime, String prezime, String email, String sifra) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.sifra = sifra;
    }

    /**
     * Pravi nov objekat klase Vlasnik sa datim ID-em.
     *
     * @param vlasnikid ID vlasnika kao long
     */
    public Vlasnik(long vlasnikid) {
        this.vlasnikid = vlasnikid;
    }

    /**
     * Vraca ID vlasnika.
     *
     * @return trenutni ID vlasnika kao long
     */
    public long getVlasnikid() {
        return vlasnikid;
    }

    /**
     * Postavlja ID vlasnika na unetu vrednost.
     *
     * @param vlasnikid ID vlasnika kao long
     */
    public void setVlasnikid(long vlasnikid) {
        this.vlasnikid = vlasnikid;
    }

    /**
     * Vraca ime vlasnika.
     *
     * @return trenutno ime vlasnika kao String
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime vlasnika na unetu vrednost.
     *
     * @param ime ime vlasnika kao String
     * @throws IllegalArgumentException ako je ime null ili prazno
     */
    public void setIme(String ime) {
        if (ime == null || ime.trim().isEmpty()) {
            throw new IllegalArgumentException("Ime ne sme biti null ili prazno.");
        }
        this.ime = ime;
    }

    /**
     * Vraca prezime vlasnika.
     *
     * @return trenutno prezime vlasnika kao String
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja prezime vlasnika na unetu vrednost.
     *
     * @param prezime prezime vlasnika kao String
     * @throws IllegalArgumentException ako je prezime null ili prazno
     */
    public void setPrezime(String prezime) {
        if (prezime == null || prezime.trim().isEmpty()) {
            throw new IllegalArgumentException("Prezime ne sme biti null ili prazno.");
        }
        this.prezime = prezime;
    }

    /**
     * Vraca email vlasnika.
     *
     * @return trenutni email vlasnika kao String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja email vlasnika na unetu vrednost.
     *
     * @param email email vlasnika kao String
     * @throws IllegalArgumentException ako je email null, prazan, ili nije
     * validan
     */
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email ne sme biti null ili prazan.");
        }

        this.email = email;
    }

    /**
     * Vraca šifru vlasnika.
     *
     * @return trenutna šifra vlasnika kao String
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * Postavlja šifru vlasnika na unetu vrednost.
     *
     * @param sifra šifra vlasnika kao String
     * @throws IllegalArgumentException ako je šifra null ili prazna
     */
    public void setSifra(String sifra) {
        if (sifra == null || sifra.trim().isEmpty()) {
            throw new IllegalArgumentException("Šifra ne sme biti null ili prazna.");
        }
        this.sifra = sifra;
    }

    /**
     * Vraca string reprezentaciju objekta Vlasnik.
     *
     * @return string reprezentacija objekta Vlasnik
     */
    @Override
    public String toString() {
        return "Vlasnik: " + ime + " " + prezime + " Email: " + email;
    }

    /**
     * Vraca hash kod objekta Vlasnik.
     *
     * @return hash kod objekta Vlasnik kao int
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Poredi dva objekta Vlasnik po emailu i šifri.
     *
     * @param obj objekat za poređenje
     * @return true ako su objekti jednaki, false inače
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
        final Vlasnik other = (Vlasnik) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }

    /**
     * Vraca naziv klase.
     *
     * @return naziv klase kao String
     */
    @Override
    public String getClassName() {
        return "vlasnik";
    }

    /**
     * Vraca uslov za WHERE klauzulu.
     *
     * @return uslov za WHERE klauzulu kao String
     */
    @Override
    public String getWhereCondition() {
        return "email = " + '\'' + email + '\'' + " AND " + "sifra = " + '\'' + sifra + '\'';
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
        return new Vlasnik(rs.getLong("vlasnikid"), rs.getString("ime"), rs.getString("prezime"), rs.getString("email"), rs.getString("sifra"));
    }

    /**
     * Vraca vrednosti atributa kao string za unos u bazu.
     *
     * @return vrednosti atributa kao String
     */
    @Override
    public String getAtrValue() {
        return vlasnikid + ", " + "'" + ime + "'" + ", " + "'" + prezime + "'" + ", " + "'" + email + "'" + ", " + "'" + sifra + "'";
    }

    /**
     * Vraca nazive atributa za unos u bazu.
     *
     * @return nazive atributa kao String
     */
    @Override
    public String getInsertData() {
        return "vlasnikid, ime, prezime, email, sifra";
    }

    /**
     * Vraca uslov za WHERE klauzulu po vlasnikid-u.
     *
     * @return uslov za WHERE klauzulu kao String
     */
    @Override
    public String getWhereCondition1() {
        return "vlasnikid = " + '\'' + vlasnikid + '\'';
    }

    /**
     * Vraca tip WHERE uslova.
     *
     * @return tip WHERE uslova kao int
     */
    @Override
    public int getWhereType() {
        return this.whereType;
    }

    /**
     * Postavlja tip WHERE uslova.
     *
     * @param whereType tip WHERE uslova kao int
     */
    @Override
    public void setWhereType(int whereType) {
        this.whereType = whereType;
    }

    @JsonIgnore
    @Override
    public String getWhereCondition2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @JsonIgnore
    @Override
    public String setAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @JsonIgnore
    @Override
    public String getWhereCondition3() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @JsonIgnore
    @Override
    public String setAtrValue1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @JsonIgnore
    @Override
    public String getWhereCondition4() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @JsonIgnore
    @Override
    public String setAtrValue2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
