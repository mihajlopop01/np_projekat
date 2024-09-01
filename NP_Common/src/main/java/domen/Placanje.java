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
     * Kreira novi objekat klase Korisnik sa neinicijalizovanim atributima.
     */
    public Placanje() {
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
     * Postavlja ID plaćanja na zadatu vrednost. ID mora biti pozitivan broj.
     *
     * @param placanjeid ID plaćanja kao long
     * @throws IllegalArgumentException ako je ID plaćanja manji ili jednak nuli
     */
    public void setPlacanjeid(long placanjeid) {
        if (placanjeid <= 0) {
            throw new IllegalArgumentException("ID plaćanja mora biti veći od nule.");
        }
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
     * Postavlja način plaćanja na zadatu vrednost. Način plaćanja ne sme biti
     * null ili prazan string.
     *
     * @param nacin Način plaćanja kao String
     * @throws IllegalArgumentException ako je način plaćanja null ili prazan
     * string
     */
    public void setNacin(String nacin) {
        if (nacin == null || nacin.trim().isEmpty()) {
            throw new IllegalArgumentException("Način plaćanja ne sme biti null ili prazan.");
        }
        this.nacin = nacin;
    }

/**
 * Proverava da li su dva objekta klase Placanje jednaka.
 * Objekti se smatraju jednakima ako imaju isti ID plaćanja.
 *
 * @param obj Objekat koji se poredi sa trenutnim objektom
 * @return true ako je prosleđeni objekat instance klase Placanje i ima isti ID plaćanja, u suprotnom false
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
        final Placanje other = (Placanje) obj;
        return this.placanjeid == other.placanjeid;
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
