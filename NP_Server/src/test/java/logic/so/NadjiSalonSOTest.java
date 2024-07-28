/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import db.DBBroker;
import db.DatabaseConnection;
import domen.Frizer;
import domen.OpstiDomenskiObjekat;
import domen.Salon;
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
public class NadjiSalonSOTest {
    private NadjiSalonSO nadjiSalonSO;
    private DBBroker dbb;

    @BeforeEach
    public void setUp() throws Exception {
        dbb = new DBBroker(DatabaseConnection.getInstance().pop());
        nadjiSalonSO = new NadjiSalonSO();
    }

    @Test
    public void testValidateValidArgument() {
        Frizer frizer = new Frizer(1L, "D", "a", new Salon(123468L));
        assertDoesNotThrow(() -> nadjiSalonSO.validate((OpstiDomenskiObjekat) frizer));
    }

    @Test
    public void testValidateInvalidArgument() {
        Exception exception = assertThrows(Exception.class, () -> {
            nadjiSalonSO.validate(null);
        });
        assertEquals("Argument je null", exception.getMessage());
    }

    @Test
    public void testExecuteOperation() throws Exception {

        Salon salon = new Salon(123468L, "Danica DOO", "Kragujevac", 2);

        nadjiSalonSO.execute(salon);

        List<OpstiDomenskiObjekat> result = (List<OpstiDomenskiObjekat>) nadjiSalonSO.getResult();
        assertNotNull(result);
     


    }
    
}
