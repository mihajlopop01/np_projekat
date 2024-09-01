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

public class FrizerTest {

    private Frizer frizer;
    private Salon salon;

    @BeforeEach
    public void setUp() {
        salon = new Salon(1L);
        frizer = new Frizer(1L, "John", "Doe", salon);
    }

    @Test
    public void testGetFrizerid() {
        assertEquals(1L, frizer.getFrizerid());
    }

    @Test
    public void testSetFrizeridValid() {
        frizer.setFrizerid(2L);
        assertEquals(2L, frizer.getFrizerid());
    }

    @Test
    public void testSetFrizeridInvalid() {
        Frizer frizer = new Frizer();
        assertThrows(IllegalArgumentException.class, () -> frizer.setFrizerid(0L),
                "Očekivana je IllegalArgumentException za frizerid <= 0");
    }

    @Test
    public void testGetIme() {
        assertEquals("John", frizer.getIme());
    }

    @Test
    public void testSetImeValid() {
        frizer.setIme("Jane");
        assertEquals("Jane", frizer.getIme());
    }

    @Test
    public void testSetImeInvalid() {
        Frizer frizer = new Frizer();
        assertThrows(IllegalArgumentException.class, () -> frizer.setIme(""),
                "Očekivana je IllegalArgumentException za prazan string");
        assertThrows(IllegalArgumentException.class, () -> frizer.setIme(null),
                "Očekivana je IllegalArgumentException za null ime");
    }

    @Test
    public void testGetPrezimeValid() {
        assertEquals("Doe", frizer.getPrezime());
    }

    @Test
    public void testSetPrezimeInvalid() {
        Frizer frizer = new Frizer();
        assertThrows(IllegalArgumentException.class, () -> frizer.setPrezime(""),
                "Očekivana je IllegalArgumentException za prazan string");
        assertThrows(IllegalArgumentException.class, () -> frizer.setPrezime(null),
                "Očekivana je IllegalArgumentException za null prezime");
    }

    @Test
    public void testSetPrezimeValid() {
        frizer.setPrezime("Smith");
        assertEquals("Smith", frizer.getPrezime());
    }

    @Test
    public void testGetSalon() {
        assertEquals(salon, frizer.getSalon());
    }

    @Test
    public void testSetSalonValid() {
        Salon newSalon = new Salon(2L);
        frizer.setSalon(newSalon);
        assertEquals(newSalon, frizer.getSalon());
    }

    @Test
    public void testSetSalonInvalid() {
        Frizer frizer = new Frizer();
        assertThrows(IllegalArgumentException.class, () -> frizer.setSalon(null),
                "Očekivana je IllegalArgumentException za null salon");
    }
    
       @Test
    public void testGetNewRecord() throws SQLException {
        ResultSet rs = mock(ResultSet.class);

        when(rs.getLong("frizerid")).thenReturn(56789L);
        when(rs.getString("ime")).thenReturn("Alice");
        when(rs.getString("prezime")).thenReturn("Smith");
        when(rs.getLong("PIB")).thenReturn(123456789L);

        Frizer newFrizer = (Frizer) new Frizer().getNewRecord(rs);

        assertEquals(56789L, newFrizer.getFrizerid());
        assertEquals("Alice", newFrizer.getIme());
        assertEquals("Smith", newFrizer.getPrezime());
        assertEquals(123456789L, newFrizer.getSalon().getPib());
    }

    @Test
    public void testToString() {
        assertEquals("Frizer: John Doe", frizer.toString());
    }
    
    @ParameterizedTest
    @CsvSource({
        "Marko, Petrovic, Marko, Petrovic, true",
        "Marko, Petrovic, Marko, Jovanovic, false",
        "Marko, Petrovic, Nikola, Petrovic, false",
        "Marko, Petrovic, Nikola, Jovanovic, false"
    })
    void testEquals(String ime1, String prezime1, String ime2, String prezime2, boolean expectedResult) {
        Frizer frizer1 = new Frizer();
        frizer1.setIme(ime1);
        frizer1.setPrezime(prezime1);

        Frizer frizer2 = new Frizer();
        frizer2.setIme(ime2);
        frizer2.setPrezime(prezime2);

        assertEquals(expectedResult, frizer1.equals(frizer2));
    }
}
