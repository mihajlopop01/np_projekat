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
}
