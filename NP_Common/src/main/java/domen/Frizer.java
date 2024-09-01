/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Predstavlja frizera u sistemu. Klasa Frizer nasleđuje klasu
 * OpstiDomenskiObjekat i implementira interfejs Serializable. Frizer ima svoj
 * ID, ime, prezime i referencu na salon u kojem radi.
 *
 * @autor Mihajlo Popović
 * @verzija 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Frizer extends OpstiDomenskiObjekat implements Serializable {

    /**
     * ID frizera kao long
     */
    private long frizerid;

    /**
     * Ime frizera kao String
     */
    private String ime;

    /**
     * Prezime frizera kao String
     */
    private String prezime;

    /**
     * Referenca na Salon u kojem frizer radi kao objekat klase Salon
     */
    private Salon salon;

    /**
     * Kreira novi objekat klase Frizer sa neinicijalizovanim atributima.
     */
    public Frizer() {
    }

    /**
     * Kreira novi objekat klase Frizer i postavlja ID, ime, prezime i salon na
     * zadate vrednosti.
     *
     * @param frizerid ID frizera kao long
     * @param ime Ime frizera kao String
     * @param prezime Prezime frizera kao String
     * @param salon Referenca na Salon kao objekat klase Salon
     */
    public Frizer(long frizerid, String ime, String prezime, Salon salon) {
        this.frizerid = frizerid;
        this.ime = ime;
        this.prezime = prezime;
        this.salon = salon;
    }

    /**
     * Vraća ID frizera.
     *
     * @return trenutni ID frizera kao long
     */
    public long getFrizerid() {
        return frizerid;
    }

    /**
     * Postavlja ID frizera na zadatu vrednost, pod uslovom da je ID pozitivan.
     *
     * @param frizerid ID frizera kao long
     * @throws IllegalArgumentException ako je frizerid manji ili jednak nuli
     */
    public void setFrizerid(long frizerid) {
        if (frizerid <= 0) {
            throw new IllegalArgumentException("ID frizera mora biti veći od nule.");
        }
        this.frizerid = frizerid;
    }

    /**
     * Vraća ime frizera.
     *
     * @return trenutno ime frizera kao String
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime frizera na zadatu vrednost, pod uslovom da nije null ili
     * prazan string.
     *
     * @param ime Ime frizera kao String
     * @throws IllegalArgumentException ako je ime null ili prazan string
     */
    public void setIme(String ime) {
        if (ime == null || ime.trim().isEmpty()) {
            throw new IllegalArgumentException("Ime frizera ne sme biti prazno ili null.");
        }
        this.ime = ime;
    }

    /**
     * Vraća prezime frizera.
     *
     * @return trenutno prezime frizera kao String
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja prezime frizera na zadatu vrednost, pod uslovom da nije null
     * ili prazan string.
     *
     * @param prezime Prezime frizera kao String
     * @throws IllegalArgumentException ako je prezime null ili prazan string
     */
    public void setPrezime(String prezime) {
        if (prezime == null || prezime.trim().isEmpty()) {
            throw new IllegalArgumentException("Prezime frizera ne sme biti prazno ili null.");
        }
        this.prezime = prezime;
    }

    /**
     * Vraća referencu na salon u kojem frizer radi.
     *
     * @return referenca na Salon kao objekat klase Salon
     */
    public Salon getSalon() {
        return salon;
    }

    /**
     * Postavlja referencu na salon u kojem frizer radi, pod uslovom da nije
     * null.
     *
     * @param salon Referenca na Salon kao objekat klase Salon
     * @throws IllegalArgumentException ako je salon null
     */
    public void setSalon(Salon salon) {
        if (salon == null) {
            throw new IllegalArgumentException("Salon ne sme biti null.");
        }
        this.salon = salon;
    }

    /**
     * Vraća String reprezentaciju objekta Frizer.
     *
     * @return String koji predstavlja ime i prezime frizera
     */
    @Override
    public String toString() {
        return "Frizer: " + ime + " " + prezime;
    }

    /**
     * Metod nije podržan.
     *
     * @throws UnsupportedOperationException Ako se pozove
     */
    @Override
    public int getWhereType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generisano iz nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Metod nije podržan.
     *
     * @param whereType Tip uslova za pretragu
     * @throws UnsupportedOperationException Ako se pozove
     */
    @Override
    public void setWhereType(int whereType) {
        throw new UnsupportedOperationException("Not supported yet."); // Generisano iz nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Vraća naziv klase.
     *
     * @return Naziv klase kao String
     */
    @Override
    public String getClassName() {
        return "frizer";
    }

    /**
     * Metod nije podržan.
     *
     * @return Usmereni uslov za pretragu kao String
     * @throws UnsupportedOperationException Ako se pozove
     */
    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generisano iz nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Kreira novi objekat klase Frizer iz rezultata upita.
     *
     * @param rs Rezultat upita kao ResultSet
     * @return Novi objekat klase Frizer
     * @throws SQLException Ako dođe do greške pri radu sa ResultSet-om
     */
    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new Frizer(rs.getLong("frizerid"), rs.getString("ime"), rs.getString("prezime"), new Salon(rs.getLong("PIB")));
    }

    /**
     * Vraća string vrednosti atributa za INSERT upit.
     *
     * @return String vrednosti atributa za INSERT upit
     */
    @Override
    public String getAtrValue() {
        return "'" + ime + "'" + ", " + "'" + prezime + "'" + ", " + salon.getPib();
    }

    /**
     * Vraća string imena atributa za INSERT upit.
     *
     * @return String imena atributa za INSERT upit
     */
    @Override
    public String getInsertData() {
        return "ime,prezime,PIB";
    }

    /**
     * Vraća uslov za pretragu na osnovu PIB-a salona.
     *
     * @return Uslov za pretragu kao String
     */
    @Override
    public String getWhereCondition1() {
        return "PIB = " + '\'' + salon.getPib() + '\'';
    }

    @Override
    @JsonIgnore
    public String getWhereCondition2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @JsonIgnore
    public String setAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @JsonIgnore
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
    public String setAtrValue2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @JsonIgnore
    public String getWhereCondition4() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
 * Proverava da li je objekat jednak trenutnom objektu klase Frizer.
 * Dva objekta su jednaka ako su oba instance klase Frizer i imaju isto ime i prezime.
 *
 * @param obj Objekat koji se poredi sa trenutnim objektom
 * @return true ako su objekti jednaki; false u suprotnom
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
        final Frizer other = (Frizer) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        return Objects.equals(this.prezime, other.prezime);
    }
    
    
    
    

}
