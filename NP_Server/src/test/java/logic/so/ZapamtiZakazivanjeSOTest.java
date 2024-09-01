/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import db.DBBroker;
import db.DatabaseConnection;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Placanje;
import domen.Salon;
import domen.Termin;
import domen.Usluga;
import domen.Zakazivanje;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Mihajlo Popovic
 */
public class ZapamtiZakazivanjeSOTest {
    private ZapamtiZakazivanjeSO zapamtiZakazivanjeSO;
    private DBBroker dbb;

    @BeforeEach
    public void setUp() throws Exception {
        dbb = new DBBroker(DatabaseConnection.getInstance().pop());
        zapamtiZakazivanjeSO = new ZapamtiZakazivanjeSO();
    }

    @Test
    public void testValidateValidArgument() {
        Zakazivanje z = new Zakazivanje(new Salon(123468L),new Korisnik(1),400,5, new Placanje(1,"kartica"));
        assertDoesNotThrow(() -> zapamtiZakazivanjeSO.validate((OpstiDomenskiObjekat) z));
    }

    @Test
    public void testValidateInvalidArgument() {
        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiZakazivanjeSO.validate(null);
        });
        assertEquals("Argument je null", exception.getMessage());
    }

    @Test
    public void testExecuteOperation() throws Exception {
        Zakazivanje z = new Zakazivanje(new Salon(123468L),new Korisnik(1),400,5, new Placanje(1,"kartica"));

      

        zapamtiZakazivanjeSO.execute(z);

        OpstiDomenskiObjekat result = (OpstiDomenskiObjekat) zapamtiZakazivanjeSO.getResult();
        assertNotNull(result);

    }
    
    
}
