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
 * Predstavlja korisnika sistema. Klasa Korisnik nasleđuje klasu
 * OpstiDomenskiObjekat i implementira interfejs Serializable. Korisnik ima svoj
 * ID, ime, prezime, email, i šifru.
 *
 * @autor Mihajlo Popović
 * @verzija 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Korisnik extends OpstiDomenskiObjekat implements Serializable {

    /**
     * ID korisnika kao long
     */
    private long korisnikid;

    /**
     * Ime korisnika kao String
     */
    private String ime;

    /**
     * Prezime korisnika kao String
     */
    private String prezime;

    /**
     * Email korisnika kao String
     */
    private String email;

    /**
     * Šifra korisnika kao String
     */
    private String sifra;

    /**
     * Tip uslova za pretragu
     */
    private int whereType;

    /**
     * Kreira novi objekat klase Korisnik sa neinicijalizovanim atributima.
     */
    public Korisnik() {
    }

    /**
     * Kreira novi objekat klase Korisnik sa zadatim ID-jem.
     *
     * @param id ID korisnika kao long
     */
    public Korisnik(long id) {
        this.korisnikid = id;
    }

    /**
     * Kreira novi objekat klase Korisnik i postavlja ID, ime, prezime, email i
     * šifru na zadate vrednosti.
     *
     * @param korisnikid ID korisnika kao long
     * @param ime Ime korisnika kao String
     * @param prezime Prezime korisnika kao String
     * @param email Email korisnika kao String
     * @param sifra Šifra korisnika kao String
     */
    public Korisnik(long korisnikid, String ime, String prezime, String email, String sifra) {
        this.korisnikid = korisnikid;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.sifra = sifra;
    }

    /**
     * Vraća ID korisnika.
     *
     * @return trenutni ID korisnika kao long
     */
    public long getKorisnikid() {
        return korisnikid;
    }

    /**
     * Postavlja ID korisnika na zadatu vrednost.
     *
     * @param korisnikid ID korisnika kao long
     * @throws IllegalArgumentException ako je korisnikid manji ili jednak nuli
     */
    public void setKorisnikid(long korisnikid) {
        if (korisnikid <= 0) {
            throw new IllegalArgumentException("ID korisnika mora biti veći od nule.");
        }
        this.korisnikid = korisnikid;
    }

    /**
     * Vraća ime korisnika.
     *
     * @return trenutno ime korisnika kao String
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime korisnika na zadatu vrednost.
     *
     * @param ime Ime korisnika kao String
     * @throws IllegalArgumentException ako je ime null ili prazan string
     */
    public void setIme(String ime) {
        if (ime == null || ime.trim().isEmpty()) {
            throw new IllegalArgumentException("Ime korisnika ne sme biti prazno ili null.");
        }
        this.ime = ime;
    }

    /**
     * Vraća prezime korisnika.
     *
     * @return trenutno prezime korisnika kao String
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja prezime korisnika na zadatu vrednost.
     *
     * @param prezime Prezime korisnika kao String
     * @throws IllegalArgumentException ako je prezime null ili prazan string
     */
    public void setPrezime(String prezime) {
        if (prezime == null || prezime.trim().isEmpty()) {
            throw new IllegalArgumentException("Prezime korisnika ne sme biti prazno ili null.");
        }
        this.prezime = prezime;
    }

    /**
     * Vraća email korisnika.
     *
     * @return trenutni email korisnika kao String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja email korisnika na zadatu vrednost.
     *
     * @param email Email korisnika kao String
     * @throws IllegalArgumentException ako je email null, prazan string ili
     * nevalidnog formata
     */
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Email korisnika ne sme biti prazan, null ili nevalidnog formata.");
        }
        this.email = email;
    }

    /**
     * Vraća šifru korisnika.
     *
     * @return trenutna šifra korisnika kao String
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * Postavlja šifru korisnika na zadatu vrednost.
     *
     * @param sifra Šifra korisnika kao String
     * @throws IllegalArgumentException ako je šifra null ili kraća od 6
     * karaktera
     */
    public void setSifra(String sifra) {
        if (sifra == null || sifra.length() < 6) {
            throw new IllegalArgumentException("Šifra korisnika mora imati najmanje 6 karaktera i ne sme biti null.");
        }
        this.sifra = sifra;
    }

    /**
     * Vraća String reprezentaciju objekta Korisnik.
     *
     * @return String koji predstavlja ime korisnika
     */
    @Override
    public String toString() {
        return "Korisnik: " + ime;
    }

    /**
     * Vraća hash kod objekta Korisnik.
     *
     * @return hash kod kao int
     */
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * Upoređuje objekat Korisnik sa datim objektom.
     *
     * @param obj Objekat koji se upoređuje
     * @return true ako su objekti isti, inače false
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }

    /**
     * Vraća naziv klase.
     *
     * @return Naziv klase kao String
     */
    @Override
    public String getClassName() {
        return "korisnik";
    }

    /**
     * Vraća uslov za pretragu na osnovu email-a i šifre korisnika.
     *
     * @return Uslov za pretragu kao String
     */
    @Override
    public String getWhereCondition() {
        return "email = " + '\'' + email + '\'' + " AND " + "sifra = " + '\'' + sifra + '\'';
    }

    /**
     * Kreira novi objekat klase Korisnik iz rezultata upita.
     *
     * @param rs Rezultat upita kao ResultSet
     * @return Novi objekat klase Korisnik
     * @throws SQLException Ako dođe do greške pri radu sa ResultSet-om
     */
    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new Korisnik(rs.getLong("korisnikid"), rs.getString("ime"), rs.getString("prezime"), rs.getString("email"), rs.getString("sifra"));
    }

    @JsonIgnore
    @Override
    public String getAtrValue() {
        return korisnikid + "";
    }

    @JsonIgnore
    @Override
    public String getInsertData() {
        return "korisnikid"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @JsonIgnore
    @Override
    public String getWhereCondition1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    @Override
    public String getWhereCondition3() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @JsonIgnore
    public String setAtrValue1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @JsonIgnore
    public String getWhereCondition4() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @JsonIgnore
    public int getWhereType() {
        return this.whereType;
    }

    @Override
    @JsonIgnore
    public void setWhereType(int whereType) {
        this.whereType = whereType;
    }

    @Override
    @JsonIgnore
    public String setAtrValue2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
