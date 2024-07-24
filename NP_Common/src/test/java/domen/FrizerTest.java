/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void testSetFrizerid() {
        frizer.setFrizerid(2L);
        assertEquals(2L, frizer.getFrizerid());
    }

    @Test
    public void testGetIme() {
        assertEquals("John", frizer.getIme());
    }

    @Test
    public void testSetIme() {
        frizer.setIme("Jane");
        assertEquals("Jane", frizer.getIme());
    }

    @Test
    public void testGetPrezime() {
        assertEquals("Doe", frizer.getPrezime());
    }

    @Test
    public void testSetPrezime() {
        frizer.setPrezime("Smith");
        assertEquals("Smith", frizer.getPrezime());
    }

    @Test
    public void testGetSalon() {
        assertEquals(salon, frizer.getSalon());
    }

    @Test
    public void testSetSalon() {
        Salon newSalon = new Salon(2L);
        frizer.setSalon(newSalon);
        assertEquals(newSalon, frizer.getSalon());
    }

    @Test
    public void testToString() {
        assertEquals("Frizer: John Doe", frizer.toString());
    }
}

