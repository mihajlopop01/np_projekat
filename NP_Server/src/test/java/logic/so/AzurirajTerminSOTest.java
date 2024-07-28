/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import db.*;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.Salon;
import domen.Termin;
import domen.Usluga;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AzurirajTerminSOTest {

    private AzurirajTerminSO azurirajTerminSO;
    private OpstiDomenskiObjekat termin;
    private DBBroker dbb;

    @BeforeEach
    public void setUp() throws Exception {
        azurirajTerminSO = new AzurirajTerminSO();
        termin = new Termin( new Salon(1));
        dbb = new DBBroker(DatabaseConnection.getInstance().pop());
        // Initialize the termin object as needed for the test
    }

    @Test
    public void testValidateValidTermin() {
        assertDoesNotThrow(() -> azurirajTerminSO.validate(termin));
    }

    @Test
    public void testValidateInvalidTermin() {
        Exception exception = assertThrows(Exception.class, () -> {
            azurirajTerminSO.validate(null);
        });
        assertEquals("Argument je null", exception.getMessage());
    }

    @Test
    public void testExecuteOperation() throws Exception {
        Termin testTermin = new Termin( new Salon(2L), 2L, "11:15", new Date(2024,10,10), "Petko", true, new Korisnik(1), new Usluga(1));

        dbb.insert(testTermin);

        

        azurirajTerminSO.execute(testTermin);

        assertNotNull(azurirajTerminSO.getResult());
        assertTrue(azurirajTerminSO.getResult() instanceof OpstiDomenskiObjekat);
        assertEquals(testTermin.getSalon().getPib(), ((Termin) azurirajTerminSO.getResult()).getSalon().getPib());
        
    }
}

