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
public class Korisnik extends OpstiDomenskiObjekat implements Serializable{ 
    
    private long korisnikid;
    private String ime;
    private String prezime;
    private String email;
    private String sifra;
    private int whereType;
    //mozda treba lista termina

    public Korisnik() {
    }
    
    public Korisnik(long id) {
    this.korisnikid = id;}

    public Korisnik(long korisnikid, String ime, String prezime, String email, String sifra) {
        this.korisnikid = korisnikid;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.sifra = sifra;
    }

    public long getKorisnikid() {
        return korisnikid;
    }

    public void setKorisnikid(long korisnikid) {
        this.korisnikid = korisnikid;
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
        return "Korisnik: "+ ime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }
    
    

    @Override
    public String getClassName() {
        return "korisnik";
    }

    @Override
    public String getWhereCondition() {
        return "email = "+'\''+email+'\''+" AND "+"sifra = "+'\''+sifra+'\'';
    }

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException{
        return new Korisnik(rs.getLong("korisnikid"),rs.getString("ime"),rs.getString("prezime"),rs.getString("email"),rs.getString("sifra"));
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
