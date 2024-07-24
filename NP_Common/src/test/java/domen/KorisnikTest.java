/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void testSetKorisnikid() {
        korisnik.setKorisnikid(2L);
        assertEquals(2L, korisnik.getKorisnikid());
    }

    @Test
    public void testGetIme() {
        assertEquals("Mihajlo", korisnik.getIme());
    }

    @Test
    public void testSetIme() {
        korisnik.setIme("Petar");
        assertEquals("Petar", korisnik.getIme());
    }

    @Test
    public void testGetPrezime() {
        assertEquals("Popovic", korisnik.getPrezime());
    }

    @Test
    public void testSetPrezime() {
        korisnik.setPrezime("Petrovic");
        assertEquals("Petrovic", korisnik.getPrezime());
    }

    @Test
    public void testGetEmail() {
        assertEquals("mihajlo@example.com", korisnik.getEmail());
    }

    @Test
    public void testSetEmail() {
        korisnik.setEmail("petar@example.com");
        assertEquals("petar@example.com", korisnik.getEmail());
    }

    @Test
    public void testGetSifra() {
        assertEquals("lozinka123", korisnik.getSifra());
    }

    @Test
    public void testSetSifra() {
        korisnik.setSifra("novaLozinka123");
        assertEquals("novaLozinka123", korisnik.getSifra());
    }

    @Test
    public void testToString() {
        assertEquals("Korisnik: Mihajlo", korisnik.toString());
    }

    @Test
    public void testEquals() {
        Korisnik drugiKorisnik = new Korisnik(1L, "Mihajlo", "Popovic", "mihajlo@example.com", "lozinka123");
        assertTrue(korisnik.equals(drugiKorisnik));
    }

    @Test
    public void testNotEquals() {
        Korisnik drugiKorisnik = new Korisnik(2L, "Petar", "Petrovic", "petar@example.com", "drugaLozinka");
        assertFalse(korisnik.equals(drugiKorisnik));
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

