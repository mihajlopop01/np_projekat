/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.*;
import java.text.SimpleDateFormat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TerminTest {

    private Salon salon;
    private Korisnik korisnik;
    private Usluga usluga;
    private Termin termin;

    @BeforeEach
    public void setUp() {
        salon = new Salon(123456789L, "Salon Lepote", "Beograd", 5, new Vlasnik(987654321L, "Marko", "Marković", "Marko", "Marković"));
        korisnik = new Korisnik(987654321L, "Jovan", "Jovanović", "Jovan", "Jovanović");
        usluga = new Usluga(1L, "Šišanje", "Sisanje klijenta");
        termin = new Termin(salon, 1L, "12:00", new Date(), "Ana Anić", true, korisnik);
        termin.setOcena(4);
        termin.setWhereType(1);
    }

    @Test
    public void testTerminDefaultConstructor() {
        Termin termin = new Termin();
        assertNull(termin.getSalon());
        assertNull(termin.getTerminid());
        assertNull(termin.getVreme());
        assertNull(termin.getDatum());
        assertNull(termin.getFrizer());
        assertFalse(termin.isSlobodan());
        assertNull(termin.getKorisnik());
    }

    @Test
    public void testTerminConstructorWithSalon() {
        Termin termin = new Termin(salon);
        assertEquals(salon, termin.getSalon());
    }

    @Test
    public void testTerminConstructorWithBasicInfo() {
        Date datum = new Date();
        Termin termin = new Termin("10:00", datum, "Petar Petrović", true, korisnik);

        assertEquals("10:00", termin.getVreme());
        assertEquals(datum, termin.getDatum());
        assertEquals("Petar Petrović", termin.getFrizer());
        assertTrue(termin.isSlobodan());
        assertEquals(korisnik, termin.getKorisnik());
    }

    @Test
    public void testTerminConstructorWithAllInfo() {
        Date datum = new Date();
        Termin termin = new Termin(salon, 1L, "10:00", datum, "Petar Petrović", true, korisnik);

        assertEquals(salon, termin.getSalon());
        assertEquals(Long.valueOf(1L), termin.getTerminid());
        assertEquals("10:00", termin.getVreme());
        assertEquals(datum, termin.getDatum());
        assertEquals("Petar Petrović", termin.getFrizer());
        assertTrue(termin.isSlobodan());
        assertEquals(korisnik, termin.getKorisnik());
    }

    @Test
    public void testTerminConstructorWithFreeTermin() {
        Date datum = new Date();
        Termin termin = new Termin("10:00", datum, "Petar Petrović", true);

        assertEquals("10:00", termin.getVreme());
        assertEquals(datum, termin.getDatum());
        assertEquals("Petar Petrović", termin.getFrizer());
        assertTrue(termin.isSlobodan());
    }

    @Test
    public void testTerminConstructorWithAllInfoAndRating() {
        Date datum = new Date();
        Termin termin = new Termin("10:00", datum, "Petar Petrović", true, salon, 1L, 5);

        assertEquals("10:00", termin.getVreme());
        assertEquals(datum, termin.getDatum());
        assertEquals("Petar Petrović", termin.getFrizer());
        assertTrue(termin.isSlobodan());
        assertEquals(salon, termin.getSalon());
        assertEquals(Long.valueOf(1L), termin.getTerminid());
        assertEquals(5, termin.getOcena());
    }

    @Test
    public void testGetAndSetUsluga() {
        Termin termin = new Termin();
        termin.setUsluga(usluga);
        assertEquals(usluga, termin.getUsluga());
    }

    @Test
    public void testGetAndSetOcena() {
        Termin termin = new Termin();
        termin.setOcena(5);
        assertEquals(5, termin.getOcena());
    }

    @Test
    public void testGetAndSetSalon() {
        Termin termin = new Termin();
        termin.setSalon(salon);
        assertEquals(salon, termin.getSalon());
    }

    @Test
    public void testGetAndSetTerminid() {
        Termin termin = new Termin();
        termin.setTerminid(1L);
        assertEquals(Long.valueOf(1L), termin.getTerminid());
    }

    @Test
    public void testGetAndSetVreme() {
        Termin termin = new Termin();
        termin.setVreme("12:00");
        assertEquals("12:00", termin.getVreme());
    }

    @Test
    public void testGetAndSetDatum() {
        Date datum = new Date();
        Termin termin = new Termin();
        termin.setDatum(datum);
        assertEquals(datum, termin.getDatum());
    }

    @Test
    public void testGetAndSetDatumFormatted() {
        Termin termin = new Termin();
        Date datum = new Date();
        Date formattedDate = termin.getDatum(datum);
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(java.sql.Date.valueOf(sm.format(datum)), formattedDate);
    }

    @Test
    public void testGetAndSetFrizer() {
        Termin termin = new Termin();
        termin.setFrizer("Ana Anić");
        assertEquals("Ana Anić", termin.getFrizer());
    }

    @Test
    public void testIsAndSetSlobodan() {
        Termin termin = new Termin();
        termin.setSlobodan(true);
        assertTrue(termin.isSlobodan());
        termin.setSlobodan(false);
        assertFalse(termin.isSlobodan());
    }

    @Test
    public void testGetAndSetKorisnik() {
        Termin termin = new Termin();
        termin.setKorisnik(korisnik);
        assertEquals(korisnik, termin.getKorisnik());
    }

    @Test
    public void testSetUslugaInvalid() {
        Termin termin = new Termin();
        assertThrows(IllegalArgumentException.class, () -> termin.setUsluga(null));
    }

    @Test
    public void testSetOcenaInvalid() {
        Termin termin = new Termin();
        assertThrows(IllegalArgumentException.class, () -> termin.setOcena(0));
        assertThrows(IllegalArgumentException.class, () -> termin.setOcena(6));
    }

    @Test
    public void testSetSalonInvalid() {
        Termin termin = new Termin();
        assertThrows(IllegalArgumentException.class, () -> termin.setSalon(null));
    }

    @Test
    public void testSetTerminidInvalid() {
        Termin termin = new Termin();
        assertThrows(IllegalArgumentException.class, () -> termin.setTerminid(-1L));
        assertDoesNotThrow(() -> termin.setTerminid(1L));
    }

    @Test
    public void testSetVremeInvalid() {
        Termin termin = new Termin();
        assertThrows(IllegalArgumentException.class, () -> termin.setVreme(null));
        assertThrows(IllegalArgumentException.class, () -> termin.setVreme(""));
    }

    @Test
    public void testSetDatumInvalid() {
        Termin termin = new Termin();
        assertThrows(IllegalArgumentException.class, () -> termin.setDatum(null));
    }

    @Test
    public void testSetFrizerInvalid() {
        Termin termin = new Termin();
        assertThrows(IllegalArgumentException.class, () -> termin.setFrizer(null));
        assertThrows(IllegalArgumentException.class, () -> termin.setFrizer(""));
    }

    @Test
    public void testGetClassName() {
        Termin termin = new Termin();
        assertEquals("termin", termin.getClassName());
    }

    @Test
    public void testGetWhereCondition() {
        Termin termin = new Termin();
        termin.setSalon(salon);
        assertEquals("PIB = " + '\'' + salon.getPib() + '\'', termin.getWhereCondition());
    }

    @Test
    public void testGetNewRecord() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getString("vreme")).thenReturn("10:00");

        when(rs.getString("frizer")).thenReturn("Jovan");
        when(rs.getBoolean("slobodan")).thenReturn(true);
        when(rs.getLong("PIB")).thenReturn(123456789L);
        when(rs.getLong("terminid")).thenReturn(1L);
        when(rs.getInt("ocena")).thenReturn(5);

        Termin newTermin = (Termin) new Termin().getNewRecord(rs);

        assertEquals("10:00", newTermin.getVreme());

        assertEquals("Jovan", newTermin.getFrizer());
        assertTrue(newTermin.isSlobodan());
        assertEquals(123456789L, newTermin.getSalon().getPib());
        assertEquals(1L, newTermin.getTerminid());
        assertEquals(5, newTermin.getOcena());
    }

    @Test
    public void testGetWhereCondition2() {
        assertEquals("terminid = 1", termin.getWhereCondition2());
    }

    @Test
    public void testSetAtrValue() {
        assertEquals("slobodan=true, korisnikid=987654321", termin.setAtrValue());
    }

    @Test
    public void testGetWhereCondition3() {
        assertEquals("korisnikid = 987654321", termin.getWhereCondition3());
    }

    @Test
    public void testSetAtrValue1() {
        Date datum = new Date();
        termin.setDatum(datum);
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        String expected = "vreme = '12:00', datum = '" + java.sql.Date.valueOf(sm.format(datum)) + "'";
        assertEquals(expected, termin.setAtrValue1());
    }

    @Test
    public void testGetWhereCondition4() {
        assertEquals("terminid = 1", termin.getWhereCondition4());
    }

    @Test
    public void testGetAndSetWhereType() {
        assertEquals(1, termin.getWhereType());
        termin.setWhereType(2);
        assertEquals(2, termin.getWhereType());
    }

    @Test
    public void testSetAtrValue2() {
        assertEquals("ocena = 4", termin.setAtrValue2());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, true",
        "1, 2, false",})
    public void testEquals(Long id1, Long id2, boolean expected) {
        Termin t1 = new Termin();
        t1.setTerminid(id1);

        Termin t2 = new Termin();
        t2.setTerminid(id2);

        assertEquals(expected, t1.equals(t2));
    }
}
