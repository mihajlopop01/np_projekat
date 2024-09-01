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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    public void testSetImeValid() {
        Vlasnik vlasnik = new Vlasnik();
        vlasnik.setIme("Marko");
        assertEquals("Marko", vlasnik.getIme());
    }

    @Test
    public void testSetImeInvalid() {
        Vlasnik vlasnik = new Vlasnik();
        assertThrows(IllegalArgumentException.class, () -> vlasnik.setIme(null));
        assertThrows(IllegalArgumentException.class, () -> vlasnik.setIme(""));
    }

    @Test
    public void testSetPrezimeValid() {
        Vlasnik vlasnik = new Vlasnik();
        vlasnik.setPrezime("Markovic");
        assertEquals("Markovic", vlasnik.getPrezime());
    }

    @Test
    public void testSetPrezimeInvalid() {
        Vlasnik vlasnik = new Vlasnik();
        assertThrows(IllegalArgumentException.class, () -> vlasnik.setPrezime(null));
        assertThrows(IllegalArgumentException.class, () -> vlasnik.setPrezime(""));
    }

    @Test
    public void testSetEmailValid() {
        Vlasnik vlasnik = new Vlasnik();
        vlasnik.setEmail("marko.markovic@example.com");
        assertEquals("marko.markovic@example.com", vlasnik.getEmail());
    }

    @Test
    public void testSetEmail() {
        Vlasnik vlasnik = new Vlasnik();

        
        assertThrows(IllegalArgumentException.class, () -> vlasnik.setEmail(null));
        assertThrows(IllegalArgumentException.class, () -> vlasnik.setEmail(""));
        assertThrows(IllegalArgumentException.class, () -> vlasnik.setEmail("   "));

        
        assertDoesNotThrow(() -> vlasnik.setEmail("dobar@gmail.com"));
    }

    @Test
    public void testSetSifraValid() {
        Vlasnik vlasnik = new Vlasnik();
        vlasnik.setSifra("123456");
        assertEquals("123456", vlasnik.getSifra());
    }

    @Test
    public void testSetSifraInvalid() {
        Vlasnik vlasnik = new Vlasnik();
        assertThrows(IllegalArgumentException.class, () -> vlasnik.setSifra(null));
        assertThrows(IllegalArgumentException.class, () -> vlasnik.setSifra(""));
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
    
        @ParameterizedTest
    @CsvSource({
        "test@example.com, password123, test@example.com, password123, true",
        "test@example.com, password123, test@example.com, password456, false",
        "test@example.com, password123, different@example.com, password123, false",
      
    })
    public void testEquals(String email1, String sifra1, String email2, String sifra2, boolean expectedResult) {
        Vlasnik vlasnik1 = new Vlasnik();
        vlasnik1.setEmail(email1);
        vlasnik1.setSifra(sifra1);
        
        Vlasnik vlasnik2 = new Vlasnik();
        vlasnik2.setEmail(email2);
        vlasnik2.setSifra(sifra2);
        
        assertEquals(expectedResult, vlasnik1.equals(vlasnik2));
    }
}
