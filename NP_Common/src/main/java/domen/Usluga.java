/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Predstavlja uslugu koja se može pružiti u salonu.
 * Klasa Usluga nasleđuje klasu OpstiDomenskiObjekat i implementira interfejs Serializable.
 * Usluga ima svoj ID, naziv i opis.
 *
 * @autor Mihajlo Popović
 * @verzija 1.0
 */
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
     * Kreira novi objekat klase Usluga i postavlja ID, naziv i opis na zadate vrednosti.
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
     */
    public void setUslugaid(long uslugaid) {
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
     */
    public void setNaziv(String naziv) {
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
     */
    public void setOpis(String opis) {
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

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new Usluga(rs.getLong("uslugaid"), rs.getString("naziv"), rs.getString("opis"));
    }

    @Override
    public int getWhereType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setWhereType(int whereType) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getClassName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public String setAtrValue2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereCondition4() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
    
}
