/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ZakazivanjeTest {

    private Zakazivanje zakazivanje;
    private Salon salon;
    private Korisnik korisnik;
    private Placanje placanje;

    @BeforeEach
    public void setUp() {
        // Kreiranje instanci potrebnih za testiranje
        salon = new Salon();
        salon.setPib(123456789L);

        korisnik = new Korisnik();
        korisnik.setKorisnikid(1);

        placanje = new Placanje(1, "kartica");

        zakazivanje = new Zakazivanje(salon, korisnik, 1000, 60, placanje);
        zakazivanje.setZakazivanjeid(1);
    }

    @Test
    public void testGetZakazivanjeid() {
        assertEquals(1, zakazivanje.getZakazivanjeid(), "ID zakazivanja treba da bude 1");
    }

    @Test
    public void testSetZakazivanjeid() {
        zakazivanje.setZakazivanjeid(2);
        assertEquals(2, zakazivanje.getZakazivanjeid(), "ID zakazivanja treba da bude 2");
    }

    @Test
    public void testGetSalon() {
        assertEquals(salon, zakazivanje.getSalon(), "Salon treba da bude isti kao onaj koji je postavljen");
    }

    @Test
    public void testSetSalon() {
        Salon noviSalon = new Salon();
        noviSalon.setPib(987654321L);
        zakazivanje.setSalon(noviSalon);
        assertEquals(noviSalon, zakazivanje.getSalon(), "Salon treba da bude noviSalon");
    }

    @Test
    public void testGetKorisnik() {
        assertEquals(korisnik, zakazivanje.getKorisnik(), "Korisnik treba da bude isti kao onaj koji je postavljen");
    }

    @Test
    public void testSetKorisnik() {
        Korisnik noviKorisnik = new Korisnik();
        noviKorisnik.setKorisnikid(2);
        zakazivanje.setKorisnik(noviKorisnik);
        assertEquals(noviKorisnik, zakazivanje.getKorisnik(), "Korisnik treba da bude noviKorisnik");
    }

    @Test
    public void testGetCena() {
        assertEquals(1000, zakazivanje.getCena(), "Cena zakazivanja treba da bude 1000");
    }

    @Test
    public void testSetCena() {
        zakazivanje.setCena(1500);
        assertEquals(1500, zakazivanje.getCena(), "Cena zakazivanja treba da bude 1500");
    }

    @Test
    public void testGetTrajanje() {
        assertEquals(60, zakazivanje.getTrajanje(), "Trajanje zakazivanja treba da bude 60 minuta");
    }

    @Test
    public void testSetTrajanje() {
        zakazivanje.setTrajanje(90);
        assertEquals(90, zakazivanje.getTrajanje(), "Trajanje zakazivanja treba da bude 90 minuta");
    }

    @Test
    public void testSetZakazivanjeidInvalid() {
        Zakazivanje zakazivanje = new Zakazivanje();
        assertThrows(IllegalArgumentException.class, () -> zakazivanje.setZakazivanjeid(-1));
    }

    @Test
    public void testSetSalonInvalid() {
        Zakazivanje zakazivanje = new Zakazivanje();
        assertThrows(IllegalArgumentException.class, () -> zakazivanje.setSalon(null));
    }

    @Test
    public void testSetKorisnikInvalid() {
        Zakazivanje zakazivanje = new Zakazivanje();
        assertThrows(IllegalArgumentException.class, () -> zakazivanje.setKorisnik(null));
    }

    @Test
    public void testSetCenaInvalid() {
        Zakazivanje zakazivanje = new Zakazivanje();
        assertThrows(IllegalArgumentException.class, () -> zakazivanje.setCena(-100));
    }

    @Test
    public void testSetTrajanjeInvalid() {
        Zakazivanje zakazivanje = new Zakazivanje();
        assertThrows(IllegalArgumentException.class, () -> zakazivanje.setTrajanje(-30));
    }

    @Test
    public void testGetClassName() {
        assertEquals("zakazivanje", zakazivanje.getClassName(), "Naziv klase treba da bude 'zakazivanje'");
    }

    @Test
    public void testGetWhereCondition() {
        assertEquals("PIB = '123456789'", zakazivanje.getWhereCondition(), "Uslov za WHERE klauzulu treba da bude 'PIB = '123456789''");
    }

    @Test
    public void testGetNewRecord() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt("cena")).thenReturn(1000);
        when(rs.getInt("trajanje")).thenReturn(60);

        Zakazivanje newZak = (Zakazivanje) zakazivanje.getNewRecord(rs);

        assertEquals(1000, newZak.getCena());
        assertEquals(60, newZak.getTrajanje());

    }

    @Test
    public void testGetAtrValue() {
        assertEquals("123456789, 1, 1000, 60", zakazivanje.getAtrValue(), "Vrednosti atributa treba da budu '123456789, 1, 1000, 60'");
    }

    @Test
    public void testGetInsertData() {
        assertEquals("PIB, korisnikid, cena, trajanje", zakazivanje.getInsertData(), "Nazivi atributa za unos treba da budu 'PIB, korisnikid, cena, trajanje'");
    }

    @Test
    public void testGetWhereCondition1() {
        assertEquals("PIB = '123456789'", zakazivanje.getWhereCondition1(), "Uslov za WHERE klauzulu treba da bude 'PIB = '123456789''");
    }

    @Test
    public void testGetWhereCondition2() {
        assertEquals("PIB = '123456789'", zakazivanje.getWhereCondition2(), "Uslov za WHERE klauzulu treba da bude 'PIB = '123456789''");
    }

    @Test
    public void testToString() {
        assertEquals("Zakazivanje: 1000 60", zakazivanje.toString(), "String reprezentacija objekta treba da bude 'Zakazivanje: 1000 60'");
    }

    @Test
    public void testToString1() {
        assertEquals("Zakazivanje: 1000 60 123456789 1", zakazivanje.toString1(), "Detaljan opis zakazivanja treba da bude 'Zakazivanje: 1000 60 123456789 1'");
    }

    @Test
    public void testSetAtrValue() {
        assertEquals("korisnikid=1", zakazivanje.setAtrValue(), "String za unos atributa treba da bude 'korisnikid=1'");
    }

    @Test
    public void testGetWhereType() {
        assertEquals(0, zakazivanje.getWhereType(), "Tip WHERE uslova treba da bude 0");
    }

    @Test
    public void testSetWhereType() {
        zakazivanje.setWhereType(1);
        assertEquals(1, zakazivanje.getWhereType(), "Tip WHERE uslova treba da bude 1");
    }

    @Test
    public void testSetPlacanje() {
        Placanje novoPlacanje = new Placanje(1, "kartica");
        zakazivanje.setPlacanje(novoPlacanje);
        assertEquals(novoPlacanje, zakazivanje.getPlacanje(), "Placanje treba da bude isto kao novoPlacanje");
    }

    @Test
    public void testGetPlacanje() {
        assertEquals(placanje, zakazivanje.getPlacanje(), "Placanje treba da bude isto kao postavljeno");
    }

@ParameterizedTest
@CsvSource({
    "1, 1001, 1, 1001, true",
    "1, 1001, 1, 1002, false",
    "1, 1001, 2, 1001, false",
    "1, 1001, 2, 1002, false"
})
public void testEquals(int id1, long salon1, int id2, long salon2, boolean expected) {
    Zakazivanje zakazivanje1 = new Zakazivanje();
    zakazivanje1.setZakazivanjeid(id1);
    zakazivanje1.setSalon(new Salon(salon1));

    Zakazivanje zakazivanje2 = new Zakazivanje();
    zakazivanje2.setZakazivanjeid(id2);
    zakazivanje2.setSalon(new Salon(salon2));

    assertEquals(expected, zakazivanje1.equals(zakazivanje2));
}
}
