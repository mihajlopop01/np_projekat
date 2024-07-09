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
 *
 * @author Mihajlo Popovic
 */
public class Vlasnik extends OpstiDomenskiObjekat implements Serializable{
    
    private long vlasnikid;
    private String ime;
    private String prezime;
    private String email;
    private String sifra;
    private int whereType;
    
   

    public Vlasnik() {
    }

    public Vlasnik(long vlasnikid, String ime, String prezime, String email, String sifra) {
        this.vlasnikid = vlasnikid;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.sifra = sifra;
    }

    public long getVlasnikid() {
        return vlasnikid;
    }

    public Vlasnik(String email, String sifra) {
        this.email = email;
        this.sifra = sifra;
    }

    public Vlasnik(String ime, String prezime, String email, String sifra) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.sifra = sifra;
    }
    
    public Vlasnik(long vlasnikid) {
        this.vlasnikid=vlasnikid;
    }
    
    
    
    

    public void setVlasnikid(long vlasnikid) {
        this.vlasnikid = vlasnikid;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String toString() {
        return "Vlasnik: "+ime+" "+prezime+" Email: "+email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

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

    @Override
    public String getClassName() {
        return "vlasnik";
    }

    @Override
    public String getWhereCondition() {
        return "email = "+'\''+email+'\''+" AND "+"sifra = "+'\''+sifra+'\'';
    }

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException{
        return new Vlasnik(rs.getLong("vlasnikid"),rs.getString("ime"),rs.getString("prezime"),rs.getString("email"),rs.getString("sifra"));
    }

    @Override
    public String getAtrValue() {
       return vlasnikid + ", " + "'" + ime + "'" + ", " + "'" + prezime + "'" + ", " + "'" + email + "'" + ", " + "'" + sifra + "'";
    }

    @Override
    public String getInsertData() {
       return "vlasnikid,ime,prezime,email,sifra";
    }

    @Override
    public String getWhereCondition1() {
        return "vlasnikid = "+'\''+vlasnikid+'\'';
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
