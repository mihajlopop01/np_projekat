/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UslugaTest {

    private Usluga usluga;

    @BeforeEach
    public void setUp() {
        usluga = new Usluga(1L, "Šišanje", "Kratka frizura");
    }

    @Test
    public void testGetUslugaid() {
        assertEquals(1L, usluga.getUslugaid());
    }

    @Test
    public void testSetUslugaid() {
        usluga.setUslugaid(2L);
        assertEquals(2L, usluga.getUslugaid());
    }

    @Test
    public void testGetNaziv() {
        assertEquals("Šišanje", usluga.getNaziv());
    }

    @Test
    public void testSetNaziv() {
        usluga.setNaziv("Farbanje");
        assertEquals("Farbanje", usluga.getNaziv());
    }

    @Test
    public void testGetOpis() {
        assertEquals("Kratka frizura", usluga.getOpis());
    }

    @Test
    public void testSetOpis() {
        usluga.setOpis("Duga frizura");
        assertEquals("Duga frizura", usluga.getOpis());
    }

    @Test
    public void testToString() {
        assertEquals("Šišanje", usluga.toString());
    }

    @Test
    public void testGetNewRecord() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getLong("uslugaid")).thenReturn(1L);
        when(rs.getString("naziv")).thenReturn("Šišanje");
        when(rs.getString("opis")).thenReturn("Kratka frizura");

        Usluga newUsluga = (Usluga) usluga.getNewRecord(rs);

        assertEquals(1L, newUsluga.getUslugaid());
        assertEquals("Šišanje", newUsluga.getNaziv());
        assertEquals("Kratka frizura", newUsluga.getOpis());
    }

    @Test
    public void testSetUslugaidInvalid() {
        Usluga usluga = new Usluga(1);
        assertThrows(IllegalArgumentException.class, () -> usluga.setUslugaid(-1));
        assertDoesNotThrow(() -> usluga.setUslugaid(1));
    }

    @Test
    public void testSetNazivInvalid() {
        Usluga usluga = new Usluga(1);
        assertThrows(IllegalArgumentException.class, () -> usluga.setNaziv(null));
        assertThrows(IllegalArgumentException.class, () -> usluga.setNaziv(""));
    }

    @Test
    public void testSetOpisInvalid() {
        Usluga usluga = new Usluga(1);
        assertThrows(IllegalArgumentException.class, () -> usluga.setOpis(null));
        assertDoesNotThrow(() -> usluga.setOpis("Valid opis"));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, true",
        "1, 2, false"
    })
    public void testEquals(long id1, long id2, boolean expected) {
        Usluga u1 = new Usluga(1);
        u1.setUslugaid(id1);

        Usluga u2 = new Usluga(1);
        u2.setUslugaid(id2);

        assertEquals(expected, u1.equals(u2));
    }
}
