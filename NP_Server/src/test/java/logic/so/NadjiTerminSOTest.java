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
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NadjiTerminSOTest {
    private NadjiTerminSO nadjiTerminSO;
    private DBBroker dbb;

    @BeforeEach
    public void setUp() throws Exception {
        dbb = new DBBroker(DatabaseConnection.getInstance().pop());
        nadjiTerminSO = new NadjiTerminSO();
    }

    @Test
    public void testValidateValidArgument() {
        Termin testTermin = new Termin( new Salon(2L));
        assertDoesNotThrow(() -> nadjiTerminSO.validate((OpstiDomenskiObjekat) testTermin));
    }

    @Test
    public void testValidateInvalidArgument() {
        Exception exception = assertThrows(Exception.class, () -> {
            nadjiTerminSO.validate(null);
        });
        assertEquals("Argument je null", exception.getMessage());
    }

    @Test
    public void testExecuteOperation() throws Exception {

        Termin testTermin = new Termin( new Salon(2L), 2L, "11:15", new Date(2024,10,10), "Petko", true, new Korisnik(1), new Usluga(1));

        nadjiTerminSO.execute(testTermin);

        List<OpstiDomenskiObjekat> result = (List<OpstiDomenskiObjekat>) nadjiTerminSO.getResult();
        assertNotNull(result);
     

    }
    }
