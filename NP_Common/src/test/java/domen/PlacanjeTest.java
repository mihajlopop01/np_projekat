/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlacanjeTest {

    private Placanje placanje;

    @BeforeEach
    public void setUp() {
        placanje = new Placanje(1L, "Gotovina");
    }

    @Test
    public void testGetPlacanjeid() {
        assertEquals(1L, placanje.getPlacanjeid());
    }

    @Test
    public void testSetPlacanjeidValid() {
        placanje.setPlacanjeid(2L);
        assertEquals(2L, placanje.getPlacanjeid());
    }

    @Test
    public void testSetPlacanjeidInvalid() {
        Placanje placanje = new Placanje();
        assertThrows(IllegalArgumentException.class, () -> placanje.setPlacanjeid(0));
        assertThrows(IllegalArgumentException.class, () -> placanje.setPlacanjeid(-1));
    }

    @Test
    public void testGetNacin() {
        assertEquals("Gotovina", placanje.getNacin());
    }

    @Test
    public void testSetNacin() {
        placanje.setNacin("Kartica");
        assertEquals("Kartica", placanje.getNacin());
    }

    @Test
    public void testSetNacinInvalid() {
        Placanje placanje = new Placanje();
        assertThrows(IllegalArgumentException.class, () -> placanje.setNacin(null));
        assertThrows(IllegalArgumentException.class, () -> placanje.setNacin(""));
        assertThrows(IllegalArgumentException.class, () -> placanje.setNacin("   "));
    }

    @Test
    public void testConstructorWithParams() {
        Placanje novoPlacanje = new Placanje(3L, "Online");
        assertEquals(3L, novoPlacanje.getPlacanjeid());
        assertEquals("Online", novoPlacanje.getNacin());
    }

    @Test
    public void testDefaultConstructor() {
        Placanje defaultPlacanje = new Placanje(0, "kartica");
        assertEquals("kartica", defaultPlacanje.getNacin());
        assertEquals(0, defaultPlacanje.getPlacanjeid());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, true",
        "1, 2, false",
        "2, 1, false"
    })
    public void testEquals(long id1, long id2, boolean expected) {
        Placanje placanje1 = new Placanje();
        placanje1.setPlacanjeid(id1);

        Placanje placanje2 = new Placanje();
        placanje2.setPlacanjeid(id2);

        assertEquals(expected, placanje1.equals(placanje2));
    }
}
