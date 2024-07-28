/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import db.DBBroker;
import db.DatabaseConnection;
import domen.Frizer;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Salon;
import domen.Termin;
import domen.Usluga;
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
public class ZapamtiFrizeraSOTest {
    private ZapamtiFrizeraSO zapamtiFrizeraSO;
    private DBBroker dbb;

    @BeforeEach
    public void setUp() throws Exception {
        dbb = new DBBroker(DatabaseConnection.getInstance().pop());
        zapamtiFrizeraSO = new ZapamtiFrizeraSO();
    }

    @Test
    public void testValidateValidArgument() {
        Salon salon = new Salon(123468L, "Danica DOO", "Kragujevac", 2);
        assertDoesNotThrow(() -> zapamtiFrizeraSO.validate((OpstiDomenskiObjekat) salon));
    }

    @Test
    public void testValidateInvalidArgument() {
        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiFrizeraSO.validate(null);
        });
        assertEquals("Argument je null", exception.getMessage());
    }

    @Test
    public void testExecuteOperation() throws Exception {
        Salon salon = new Salon(123468L, "Danica DOO", "Kragujevac", 2);

      Frizer testFrizer = new Frizer(1L, "Danica", "Cutura", salon);

        zapamtiFrizeraSO.execute(testFrizer);

        OpstiDomenskiObjekat result = (OpstiDomenskiObjekat) zapamtiFrizeraSO.getResult();
        assertNotNull(result);
     

    }
    
    
}
