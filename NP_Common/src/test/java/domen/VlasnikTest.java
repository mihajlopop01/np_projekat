/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VlasnikTest {

    @Test
    public void testKonstruktor() {
        Vlasnik vlasnik = new Vlasnik(1L, "Marko", "Marković", "marko@example.com", "sifra123");
        assertEquals(1L, vlasnik.getVlasnikid());
        assertEquals("Marko", vlasnik.getIme());
        assertEquals("Marković", vlasnik.getPrezime());
        assertEquals("marko@example.com", vlasnik.getEmail());
        assertEquals("sifra123", vlasnik.getSifra());
    }

    @Test
    public void testSeteriGeteri() {
        Vlasnik vlasnik = new Vlasnik();
        vlasnik.setVlasnikid(2L);
        vlasnik.setIme("Ana");
        vlasnik.setPrezime("Ana");
        vlasnik.setEmail("ana@example.com");
        vlasnik.setSifra("novaSifra");
        
        assertEquals(2L, vlasnik.getVlasnikid());
        assertEquals("Ana", vlasnik.getIme());
        assertEquals("Ana", vlasnik.getPrezime());
        assertEquals("ana@example.com", vlasnik.getEmail());
        assertEquals("novaSifra", vlasnik.getSifra());
    }

    @Test
    public void testToString() {
        Vlasnik vlasnik = new Vlasnik("Milan", "Milan", "milan@example.com", "123456");
        assertEquals("Vlasnik: Milan Milan Email: milan@example.com", vlasnik.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        Vlasnik vlasnik1 = new Vlasnik("email@example.com", "sifra123");
        Vlasnik vlasnik2 = new Vlasnik("email@example.com", "sifra123");
        Vlasnik vlasnik3 = new Vlasnik("other@example.com", "sifra456");

        assertTrue(vlasnik1.equals(vlasnik2));
        assertFalse(vlasnik1.equals(vlasnik3));
        assertFalse(vlasnik1.equals(null));
        assertFalse(vlasnik1.equals(new Object()));

        assertEquals(vlasnik1.hashCode(), vlasnik2.hashCode());
    }

    @Test
    public void testGetWhereCondition() {
        Vlasnik vlasnik = new Vlasnik("user@example.com", "password");
        String expected = "email = 'user@example.com' AND sifra = 'password'";
        assertEquals(expected, vlasnik.getWhereCondition());
    }

    @Test
    public void testGetNewRecord() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getLong("vlasnikid")).thenReturn(1L);
        when(rs.getString("ime")).thenReturn("Jovan");
        when(rs.getString("prezime")).thenReturn("Jovanovic");
        when(rs.getString("email")).thenReturn("jovan@example.com");
        when(rs.getString("sifra")).thenReturn("pass123");

        Vlasnik vlasnik = new Vlasnik();
        OpstiDomenskiObjekat noviVlasnik = vlasnik.getNewRecord(rs);

        assertTrue(noviVlasnik instanceof Vlasnik);
        Vlasnik v = (Vlasnik) noviVlasnik;
        assertEquals(1L, v.getVlasnikid());
        assertEquals("Jovan", v.getIme());
        assertEquals("Jovanovic", v.getPrezime());
        assertEquals("jovan@example.com", v.getEmail());
        assertEquals("pass123", v.getSifra());
    }

    @Test
    public void testGetAtrValue() {
        Vlasnik vlasnik = new Vlasnik(1L, "Ivan", "Ivan", "ivan@example.com", "sifra456");
        String expected = "1, 'Ivan', 'Ivan', 'ivan@example.com', 'sifra456'";
        assertEquals(expected, vlasnik.getAtrValue());
    }

    @Test
    public void testGetInsertData() {
        Vlasnik vlasnik = new Vlasnik();
        String expected = "vlasnikid, ime, prezime, email, sifra";
        assertEquals(expected, vlasnik.getInsertData());
    }

    @Test
    public void testGetWhereCondition1() {
        Vlasnik vlasnik = new Vlasnik(1L);
        String expected = "vlasnikid = '1'";
        assertEquals(expected, vlasnik.getWhereCondition1());
    }

    @Test
    public void testGetWhereType() {
        Vlasnik vlasnik = new Vlasnik();
        vlasnik.setWhereType(3);
        assertEquals(3, vlasnik.getWhereType());
    }
}

