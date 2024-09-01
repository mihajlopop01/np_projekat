/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KorisnikTest {

    private Korisnik korisnik;

    @BeforeEach
    public void setUp() {
        korisnik = new Korisnik(1L, "Mihajlo", "Popovic", "mihajlo@example.com", "lozinka123");
    }

    @Test
    public void testGetKorisnikid() {
        assertEquals(1L, korisnik.getKorisnikid());
    }

    @Test
    public void testSetKorisnikidValid() {
        korisnik.setKorisnikid(2L);
        assertEquals(2L, korisnik.getKorisnikid());
    }

    @Test
    public void testSetKorisnikidInvalid() {
        Korisnik korisnik = new Korisnik();
        assertThrows(IllegalArgumentException.class, () -> korisnik.setKorisnikid(0L),
                "Očekivana je IllegalArgumentException za korisnikid <= 0");
    }

    @Test
    public void testGetIme() {
        assertEquals("Mihajlo", korisnik.getIme());
    }

    @Test
    public void testSetImeValid() {
        korisnik.setIme("Petar");
        assertEquals("Petar", korisnik.getIme());
    }

    @Test
    public void testSetImeInvalid() {
        Korisnik korisnik = new Korisnik();
        assertThrows(IllegalArgumentException.class, () -> korisnik.setIme(""),
                "Očekivana je IllegalArgumentException za prazan string");
        assertThrows(IllegalArgumentException.class, () -> korisnik.setIme(null),
                "Očekivana je IllegalArgumentException za null ime");
    }

    @Test
    public void testGetPrezime() {
        assertEquals("Popovic", korisnik.getPrezime());
    }

    @Test
    public void testSetPrezimeValid() {
        korisnik.setPrezime("Petrovic");
        assertEquals("Petrovic", korisnik.getPrezime());
    }

    @Test
    public void testSetPrezimeInvalid() {
        Korisnik korisnik = new Korisnik();
        assertThrows(IllegalArgumentException.class, () -> korisnik.setPrezime(""),
                "Očekivana je IllegalArgumentException za prazan string");
        assertThrows(IllegalArgumentException.class, () -> korisnik.setPrezime(null),
                "Očekivana je IllegalArgumentException za null prezime");
    }

    @Test
    public void testGetEmail() {
        assertEquals("mihajlo@example.com", korisnik.getEmail());
    }

    @Test
    public void testSetEmailValid() {
        korisnik.setEmail("petar@example.com");
        assertEquals("petar@example.com", korisnik.getEmail());
    }

    @Test
    public void testSetEmailInvalid() {
        Korisnik korisnik = new Korisnik();
        assertThrows(IllegalArgumentException.class, () -> korisnik.setEmail(""),
                "Očekivana je IllegalArgumentException za prazan string");
        assertThrows(IllegalArgumentException.class, () -> korisnik.setEmail("invalidEmail"),
                "Očekivana je IllegalArgumentException za nevalidan format emaila");
        assertThrows(IllegalArgumentException.class, () -> korisnik.setEmail(null),
                "Očekivana je IllegalArgumentException za null email");
    }

    @Test
    public void testGetSifra() {
        assertEquals("lozinka123", korisnik.getSifra());
    }

    @Test
    public void testSetSifraValid() {
        korisnik.setSifra("novaLozinka123");
        assertEquals("novaLozinka123", korisnik.getSifra());
    }

    @Test
    public void testSetSifraInvalid() {
        Korisnik korisnik = new Korisnik();
        assertThrows(IllegalArgumentException.class, () -> korisnik.setSifra("123"),
                "Očekivana je IllegalArgumentException za šifru kraću od 6 karaktera");
        assertThrows(IllegalArgumentException.class, () -> korisnik.setSifra(null),
                "Očekivana je IllegalArgumentException za null šifru");
    }
    
        @Test
    public void testGetNewRecord() throws SQLException {
       
        ResultSet rs = mock(ResultSet.class);

        
        when(rs.getLong("korisnikid")).thenReturn(12345L);
        when(rs.getString("ime")).thenReturn("John");
        when(rs.getString("prezime")).thenReturn("Doe");
        when(rs.getString("email")).thenReturn("john.doe@example.com");
        when(rs.getString("sifra")).thenReturn("password123");

       
        Korisnik newKorisnik = (Korisnik) new Korisnik().getNewRecord(rs);

        
        assertEquals(12345L, newKorisnik.getKorisnikid());
        assertEquals("John", newKorisnik.getIme());
        assertEquals("Doe", newKorisnik.getPrezime());
        assertEquals("john.doe@example.com", newKorisnik.getEmail());
        assertEquals("password123", newKorisnik.getSifra());
    }

    @Test
    public void testToString() {
        assertEquals("Korisnik: Mihajlo", korisnik.toString());
    }

    @ParameterizedTest
    @CsvSource({
        "marko@example.com, sifra123, marko@example.com, sifra123, true",
        "marko@example.com, sifra123, marko@example.com, sifra456, false",
        "marko@example.com, sifra123, janko@example.com, sifra123, false",
        "marko@example.com, sifra123, janko@example.com, sifra456, false"
    })
    public void testEquals(String email1, String sifra1, String email2, String sifra2, boolean expected) {
        Korisnik korisnik1 = new Korisnik();
        korisnik1.setEmail(email1);
        korisnik1.setSifra(sifra1);

        Korisnik korisnik2 = new Korisnik();
        korisnik2.setEmail(email2);
        korisnik2.setSifra(sifra2);

        assertEquals(expected, korisnik1.equals(korisnik2));
    }

    @Test
    public void testGetClassName() {
        assertEquals("korisnik", korisnik.getClassName());
    }

    @Test
    public void testGetWhereCondition() {
        assertEquals("email = 'mihajlo@example.com' AND sifra = 'lozinka123'", korisnik.getWhereCondition());
    }
}
