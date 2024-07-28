/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import db.DBBroker;
import db.DatabaseConnection;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Salon;
import domen.Termin;
import domen.Usluga;
import domen.Vlasnik;
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
public class ZapamtiTerminSOTest {
    private ZapamtiTerminSO zapamtiTerminSO;
    private DBBroker dbb;

    @BeforeEach
    public void setUp() throws Exception {
        dbb = new DBBroker(DatabaseConnection.getInstance().pop());
        zapamtiTerminSO = new ZapamtiTerminSO();
    }

    @Test
    public void testValidateValidArgument() {
        Salon salon = new Salon(123468L, "Danica DOO", "Kragujevac", 2);
        assertDoesNotThrow(() -> zapamtiTerminSO.validate((OpstiDomenskiObjekat) salon));
    }

    @Test
    public void testValidateInvalidArgument() {
        Exception exception = assertThrows(Exception.class, () -> {
            zapamtiTerminSO.validate(null);
        });
        assertEquals("Argument je null", exception.getMessage());
    }

    @Test
    public void testExecuteOperation() throws Exception {
        Termin testTermin = new Termin( new Salon(2L), 2L, "11:15", new Date(2024,10,10), "Petko", true, new Korisnik(1), new Usluga(1));

      

        zapamtiTerminSO.execute(testTermin);

        OpstiDomenskiObjekat result = (OpstiDomenskiObjekat) zapamtiTerminSO.getResult();
        assertNotNull(result);

    }
    
}
