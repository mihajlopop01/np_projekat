/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testSetPlacanjeid() {
        placanje.setPlacanjeid(2L);
        assertEquals(2L, placanje.getPlacanjeid());
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
    public void testConstructorWithParams() {
        Placanje novoPlacanje = new Placanje(3L, "Online");
        assertEquals(3L, novoPlacanje.getPlacanjeid());
        assertEquals("Online", novoPlacanje.getNacin());
    }

    @Test
    public void testDefaultConstructor() {
        Placanje defaultPlacanje = new Placanje(0);
        assertNull(defaultPlacanje.getNacin());
        assertEquals(0, defaultPlacanje.getPlacanjeid());
    }
}

