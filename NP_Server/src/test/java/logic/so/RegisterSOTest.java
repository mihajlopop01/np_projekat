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
import java.util.List;
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
public class RegisterSOTest {
    private RegisterSO registerSO;
    private DBBroker dbb;

    @BeforeEach
    public void setUp() throws Exception {
        dbb = new DBBroker(DatabaseConnection.getInstance().pop());
        registerSO = new RegisterSO();
    }

    @Test
    public void testValidateValidArgument() {
        Vlasnik testVlasnik = new Vlasnik(123);
        assertDoesNotThrow(() -> registerSO.validate((OpstiDomenskiObjekat) testVlasnik));
    }

    @Test
    public void testValidateInvalidArgument() {
        Exception exception = assertThrows(Exception.class, () -> {
            registerSO.validate(null);
        });
        assertEquals("Argument je null", exception.getMessage());
    }

    @Test
    public void testExecuteOperation() throws Exception {

        Vlasnik testVlasnik = new Vlasnik(123);

        registerSO.execute(testVlasnik);

        OpstiDomenskiObjekat result = (OpstiDomenskiObjekat) registerSO.getResult();
        assertNotNull(result);
     

    }
    
}
