/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Predstavlja korisnika sistema.
 * Klasa Korisnik nasleđuje klasu OpstiDomenskiObjekat i implementira interfejs Serializable.
 * Korisnik ima svoj ID, ime, prezime, email, i šifru.
 *
 * @autor Mihajlo Popović
 * @verzija 1.0
 */
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
     * Kreira novi objekat klase Korisnik i postavlja ID, ime, prezime, email i šifru na zadate vrednosti.
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
     */
    public void setKorisnikid(long korisnikid) {
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
     */
    public void setIme(String ime) {
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
     */
    public void setPrezime(String prezime) {
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
     */
    public void setEmail(String email) {
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
     */
    public void setSifra(String sifra) {
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

    @Override
    public String getAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereCondition1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereCondition2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
