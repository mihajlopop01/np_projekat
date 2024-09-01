/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;

/**
 * Predstavlja zakazivanje u salonu. Klasa Zakazivanje nasleđuje klasu
 * OpstiDomenskiObjekat i implementira interfejs Serializable. Zakazivanje
 * sadrži informacije o salonu, korisniku, plačanju, ceni i trajanju
 * zakazivanja.
 *
 * @autor Mihajlo Popović
 * @verzija 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
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
     * Kreira novi objekat klase Zakazivanje i postavlja salon, korisnika, cenu,
     * trajanje i plačanje na zadate vrednosti.
     *
     * @param salon Salon u kojem je zakazivanje obavljeno kao objekat klase
     * Salon
     * @param korisnik Korisnik koji je napravio zakazivanje kao objekat klase
     * Korisnik
     * @param cena Cena zakazivanja kao int
     * @param trajanje Trajanje zakazivanja u minutima kao int
     * @param placanje Plačanje povezano sa zakazivanjem kao objekat klase
     * Placanje
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
     * @throws IllegalArgumentException ako je ID negativan
     */
    public void setZakazivanjeid(int zakazivanjeid) {
        if (zakazivanjeid < 0) {
            throw new IllegalArgumentException("ID zakazivanja ne može biti negativan.");
        }
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
     * @param salon Salon u kojem je zakazivanje obavljeno kao objekat klase
     * Salon
     * @throws IllegalArgumentException ako je salon null
     */
    public void setSalon(Salon salon) {
        if (salon == null) {
            throw new IllegalArgumentException("Salon ne sme biti null.");
        }
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
     * @param korisnik Korisnik koji je napravio zakazivanje kao objekat klase
     * Korisnik
     * @throws IllegalArgumentException ako je korisnik null
     */
    public void setKorisnik(Korisnik korisnik) {
        if (korisnik == null) {
            throw new IllegalArgumentException("Korisnik ne sme biti null.");
        }
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
     * @throws IllegalArgumentException ako je cena negativna
     */
    public void setCena(int cena) {
        if (cena < 0) {
            throw new IllegalArgumentException("Cena ne može biti negativna.");
        }
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
     * @throws IllegalArgumentException ako je trajanje negativno
     */
    public void setTrajanje(int trajanje) {
        if (trajanje < 0) {
            throw new IllegalArgumentException("Trajanje ne može biti negativno.");
        }
        this.trajanje = trajanje;
    }

    /**
     * Vraća naziv klase.
     *
     * @return naziv klase kao String
     */
    @Override
    public String getClassName() {
        return "zakazivanje";
    }

    /**
     * Vraća uslov za WHERE klauzulu u SQL upitu na osnovu PIB-a salona.
     *
     * @return uslov za WHERE klauzulu kao String
     */
    @Override
    public String getWhereCondition() {
        return "PIB = " + '\'' + salon.getPib() + '\'';
    }

    /**
     * Kreira novi objekat klase Zakazivanje na osnovu podataka iz ResultSet-a.
     *
     * @param rs ResultSet iz baze podataka
     * @return novi objekat klase Zakazivanje
     * @throws SQLException ako dođe do greške pri radu sa bazom podataka
     */
    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new Zakazivanje(rs.getInt("cena"), rs.getInt("trajanje"));
    }

    /**
     * Vraća vrednosti atributa objekta kao string za unos u bazu.
     *
     * @return vrednosti atributa kao String
     */
    @Override
    public String getAtrValue() {
        return salon.getPib() + ", " + korisnik.getKorisnikid() + ", " + cena + ", " + trajanje;
    }

    /**
     * Vraća nazive atributa za unos u bazu.
     *
     * @return nazivi atributa kao String
     */
    @Override
    public String getInsertData() {
        return "PIB, korisnikid, cena, trajanje";
    }

    /**
     * Vraća uslov za WHERE klauzulu u SQL upitu na osnovu PIB-a salona.
     *
     * @return uslov za WHERE klauzulu kao String
     */
    @Override
    public String getWhereCondition1() {
        return "PIB = " + '\'' + salon.getPib() + '\'';
    }

    /**
     * Vraća uslov za WHERE klauzulu u SQL upitu na osnovu PIB-a salona.
     *
     * @return uslov za WHERE klauzulu kao String
     */
    @Override
    public String getWhereCondition2() {
        return "PIB = " + '\'' + salon.getPib() + '\'';
    }

    /**
     * Vraća string reprezentaciju objekta Zakazivanje.
     *
     * @return string reprezentacija objekta Zakazivanje
     */
    @Override
    public String toString() {
        return "Zakazivanje: " + cena + " " + trajanje;
    }

    /**
     * Vraća detaljan opis zakazivanja uključujući PIB salona i ID korisnika.
     *
     * @return detaljan opis zakazivanja kao String
     */
    public String toString1() {
        return "Zakazivanje: " + cena + " " + trajanje + " " + salon.getPib() + " " + korisnik.getKorisnikid();
    }

    /**
     * Postavlja vrednost atributa korisnikid za unos u bazu.
     *
     * @return string sa vrednostima atributa za unos u bazu
     */
    @Override
    public String setAtrValue() {
        return "korisnikid=" + korisnik.getKorisnikid();
    }

    /**
     * Vraća tip WHERE uslova koji se koristi u SQL upitima.
     *
     * @return tip WHERE uslova kao int
     */
    @Override
    public int getWhereType() {
        return this.whereType;
    }

    /**
     * Postavlja tip WHERE uslova koji se koristi u SQL upitima.
     *
     * @param whereType tip WHERE uslova kao int
     */
    @Override
    public void setWhereType(int whereType) {
        this.whereType = whereType;
    }

    /**
     * Postavlja plačanje povezano sa zakazivanjem.
     *
     * @param placanje objekat klase Placanje
     */
    public void setPlacanje(Placanje placanje) {
        this.placanje = placanje;
    }

    /**
     * Vraća plačanje povezano sa zakazivanjem.
     *
     * @return objekat klase Placanje
     */
    public Placanje getPlacanje() {
        return placanje;
    }

    @JsonIgnore
    @Override
    public String setAtrValue2() {
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

    /**
     * Poredi dva objekta Zakazivanje po ID-ju i salonu.
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
        final Zakazivanje other = (Zakazivanje) obj;
        if (this.zakazivanjeid != other.zakazivanjeid) {
            return false;
        }
        return Objects.equals(this.salon, other.salon);
    }

}
