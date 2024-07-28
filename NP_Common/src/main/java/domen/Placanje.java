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
 * Predstavlja način plačanja. Klasa Placanje nasleđuje klasu
 * OpstiDomenskiObjekat i implementira interfejs Serializable. Placanje ima svoj
 * ID i način plačanja.
 *
 * @autor Mihajlo Popović
 * @verzija 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Placanje extends OpstiDomenskiObjekat implements Serializable {

    /**
     * ID plačanja kao long
     */
    private long placanjeid;

    /**
     * Način plačanja kao String
     */
    private String nacin;

    /**
     * Kreira novi objekat klase Placanje sa neinicijalizovanim atributima.
     *
     * @param par Parametar koji se ne koristi u konstruktoru
     */
    public Placanje(int par) {
    }

    /**
     * Kreira novi objekat klase Placanje i postavlja ID i način plačanja na
     * zadate vrednosti.
     *
     * @param placanjeid ID plačanja kao long
     * @param iznos Način plačanja kao String
     */
    public Placanje(long placanjeid, String iznos) {
        this.placanjeid = placanjeid;
        this.nacin = iznos;
    }

    /**
     * Vraća ID plačanja.
     *
     * @return trenutni ID plačanja kao long
     */
    public long getPlacanjeid() {
        return placanjeid;
    }

    /**
     * Postavlja ID plačanja na zadatu vrednost.
     *
     * @param placanjeid ID plačanja kao long
     */
    public void setPlacanjeid(long placanjeid) {
        this.placanjeid = placanjeid;
    }

    /**
     * Vraća način plačanja.
     *
     * @return trenutni način plačanja kao String
     */
    public String getNacin() {
        return nacin;
    }

    /**
     * Postavlja način plačanja na zadatu vrednost.
     *
     * @param iznos Način plačanja kao String
     */
    public void setNacin(String iznos) {
        this.nacin = iznos;
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
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @JsonIgnore
    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
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
