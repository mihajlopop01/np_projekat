/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import db.DBBroker;
import db.DatabaseConnection;
import domen.OpstiDomenskiObjekat;
import domen.Salon;
import domen.Vlasnik;
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
public class UcitajSalonSOTest {
    private UcitajSalonSO ucitajSalonSO;
    private DBBroker dbb;

    @BeforeEach
    public void setUp() throws Exception {
        dbb = new DBBroker(DatabaseConnection.getInstance().pop());
        ucitajSalonSO = new UcitajSalonSO();
    }

    @Test
    public void testValidateValidArgument() {
        Salon salon = new Salon(123468L, "Danica DOO", "Kragujevac", 2);
        assertDoesNotThrow(() -> ucitajSalonSO.validate((OpstiDomenskiObjekat) salon));
    }

    @Test
    public void testValidateInvalidArgument() {
        Exception exception = assertThrows(Exception.class, () -> {
            ucitajSalonSO.validate(null);
        });
        assertEquals("Argument je null", exception.getMessage());
    }

    @Test
    public void testExecuteOperation() throws Exception {

       Salon salon = new Salon(123468L, "Danica DOO", "Kragujevac", 2, new Vlasnik(44));

        ucitajSalonSO.execute(salon);

        OpstiDomenskiObjekat result = (OpstiDomenskiObjekat) ucitajSalonSO.getResult();
        assertNotNull(result);
     

    }
    
    
}
