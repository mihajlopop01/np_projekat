/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class SalonTest {

    private Salon salon;
    private Vlasnik vlasnik;

    @BeforeEach
    public void setUp() {
        vlasnik = new Vlasnik(123456789L, "Marko", "Marković","Marko", "Marković");
        salon = new Salon(123456789L, "Salon Lepote", "Beograd", 5, vlasnik);
    }

    @Test
    public void testGetPib() {
        assertEquals(123456789L, salon.getPib());
    }

    @Test
    public void testSetPib() {
        salon.setPib(987654321L);
        assertEquals(987654321L, salon.getPib());
    }

    @Test
    public void testGetIme() {
        assertEquals("Salon Lepote", salon.getIme());
    }

    @Test
    public void testSetIme() {
        salon.setIme("Novi Salon");
        assertEquals("Novi Salon", salon.getIme());
    }

    @Test
    public void testGetMesto() {
        assertEquals("Beograd", salon.getMesto());
    }

    @Test
    public void testSetMesto() {
        salon.setMesto("Novi Sad");
        assertEquals("Novi Sad", salon.getMesto());
    }

    @Test
    public void testGetBrojFrizera() {
        assertEquals(5, salon.getBrojFrizera());
    }

    @Test
    public void testSetBrojFrizera() {
        salon.setBrojFrizera(10);
        assertEquals(10, salon.getBrojFrizera());
    }

    @Test
    public void testGetVlasnik() {
        assertEquals(vlasnik, salon.getVlasnik());
    }

    @Test
    public void testSetVlasnik() {
        Vlasnik noviVlasnik = new Vlasnik(987654321L, "Petar", "Petrović","Petar", "Petrović");
        salon.setVlasnik(noviVlasnik);
        assertEquals(noviVlasnik, salon.getVlasnik());
    }

    @Test
    public void testGetTermini() {
        List<Termin> termini = new ArrayList<>();
        Termin termin = new Termin();
        termini.add(termin);
        salon.setTermini(termini);
        assertEquals(termini, salon.getTermini());
    }

    @Test
    public void testSetTermini() {
        List<Termin> termini = new ArrayList<>();
        Termin termin = new Termin();
        termini.add(termin);
        salon.setTermini(termini);
        assertEquals(termini, salon.getTermini());
    }

    @Test
    public void testConstructorWithPib() {
        Salon noviSalon = new Salon(123456789L);
        assertEquals(123456789L, noviSalon.getPib());
    }

    @Test
    public void testConstructorWithPibAndWhereType() {
        Salon noviSalon = new Salon(123456789L, 1);
        assertEquals(123456789L, noviSalon.getPib());
        assertEquals(1, noviSalon.getWhereType());
    }


    @Test
    public void testToString() {
        assertEquals("Salon: 123456789", salon.toString(), "ToString metoda treba da vrati 'Salon: 123456789'.");
    }

    @Test
    public void testToString1() {
        assertEquals("PIB: 123456789 Naziv salona: Salon Lepote Mesto: Beograd Broj frizera: 5", 
            salon.toString1(), "ToString1 metoda treba da vrati informacije o salonu.");
    }

    @Test
    public void testGetClassName() {
        assertEquals("salon", salon.getClassName(), "ClassName metoda treba da vrati 'salon'.");
    }

    @Test
    public void testGetWhereCondition() {
        assertEquals("vlasnikid = '123456789'", salon.getWhereCondition(), "WhereCondition metoda treba da vrati 'vlasnikid = '123456789''.");
    }
}
