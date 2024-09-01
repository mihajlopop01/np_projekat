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

/**
 * Predstavlja uslugu koja se može pružiti u salonu. Klasa Usluga nasleđuje
 * klasu OpstiDomenskiObjekat i implementira interfejs Serializable. Usluga ima
 * svoj ID, naziv i opis.
 *
 * @autor Mihajlo Popović
 * @verzija 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usluga extends OpstiDomenskiObjekat implements Serializable {

    /**
     * ID usluge kao long
     */
    private long uslugaid;

    /**
     * Naziv usluge kao String
     */
    private String naziv;

    /**
     * Opis usluge kao String
     */
    private String opis;

    /**
     * Kreira novi objekat klase Usluga sa neinicijalizovanim atributima.
     *
     * @param par Parametar koji se ne koristi u konstruktoru
     */
    public Usluga(int par) {
        this.uslugaid = par;
    }

    /**
     * Kreira novi objekat klase Usluga i postavlja naziv na zadatu vrednost.
     *
     * @param naziv Naziv usluge kao String
     */
    public Usluga(String naziv) {
        this.naziv = naziv;
    }

    /**
     * Kreira novi objekat klase Usluga i postavlja ID, naziv i opis na zadate
     * vrednosti.
     *
     * @param uslugaid ID usluge kao long
     * @param naziv Naziv usluge kao String
     * @param opis Opis usluge kao String
     */
    public Usluga(long uslugaid, String naziv, String opis) {
        this.uslugaid = uslugaid;
        this.naziv = naziv;
        this.opis = opis;
    }

    /**
     * Vraća ID usluge.
     *
     * @return trenutni ID usluge kao long
     */
    public long getUslugaid() {
        return uslugaid;
    }

    /**
     * Postavlja ID usluge na zadatu vrednost.
     *
     * @param uslugaid ID usluge kao long
     * @throws IllegalArgumentException ako ID usluge nije pozitivan
     */
    public void setUslugaid(long uslugaid) {
        if (uslugaid <= 0) {
            throw new IllegalArgumentException("ID usluge mora biti pozitivan.");
        }
        this.uslugaid = uslugaid;
    }

    /**
     * Vraća naziv usluge.
     *
     * @return trenutni naziv usluge kao String
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja naziv usluge na zadatu vrednost.
     *
     * @param naziv Naziv usluge kao String
     * @throws IllegalArgumentException ako naziv nije validan (null ili prazan)
     */
    public void setNaziv(String naziv) {
        if (naziv == null || naziv.isBlank()) {
            throw new IllegalArgumentException("Naziv ne sme biti null ili prazan.");
        }
        this.naziv = naziv;
    }

    /**
     * Vraća opis usluge.
     *
     * @return trenutni opis usluge kao String
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Postavlja opis usluge na zadatu vrednost.
     *
     * @param opis Opis usluge kao String
     * @throws IllegalArgumentException ako opis nije validan (null)
     */
    public void setOpis(String opis) {
        if (opis == null) {
            throw new IllegalArgumentException("Opis ne sme biti null.");
        }
        this.opis = opis;
    }

    @Override
    public String getWhereCondition() {
        return "";
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return naziv;
    }

/**
 * Upoređuje ovaj objekat sa datim objektom za jednakost.
 *
 * @param obj Objekat sa kojim se upoređuje ovaj objekat.
 * @return true ako su objekti isti (imaju isti ID usluge) ili ako su isti objekat, inače false
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
        final Usluga other = (Usluga) obj;
        return this.uslugaid == other.uslugaid;
    }
    
    

    @JsonIgnore
    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new Usluga(rs.getLong("uslugaid"), rs.getString("naziv"), rs.getString("opis"));
    }

    @JsonIgnore
    @Override
    public int getWhereType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @JsonIgnore
    @Override
    public void setWhereType(int whereType) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @JsonIgnore
    @Override
    public String getClassName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @JsonIgnore
    @Override
    public String getAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @JsonIgnore
    @Override
    public String getInsertData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public String setAtrValue2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @JsonIgnore
    @Override
    public String getWhereCondition4() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
