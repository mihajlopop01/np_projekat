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
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NadjiFrizereSOTest {

    private NadjiFrizereSO nadjiFrizereSO;
    private DBBroker dbb;

    @BeforeEach
    public void setUp() throws Exception {
        dbb = new DBBroker(DatabaseConnection.getInstance().pop());
        nadjiFrizereSO = new NadjiFrizereSO();
    }

    @Test
    public void testValidateValidArgument() {
        Frizer frizer = new Frizer(1L, "Dan", "Cutura", new Salon(123468L));
        assertDoesNotThrow(() -> nadjiFrizereSO.validate((OpstiDomenskiObjekat) frizer));
    }

    @Test
    public void testValidateInvalidArgument() {
        Exception exception = assertThrows(Exception.class, () -> {
            nadjiFrizereSO.validate(null);
        });
        assertEquals("Argument je null", exception.getMessage());
    }

    @Test
    public void testExecuteOperation() throws Exception {

        Salon salon = new Salon(123468L, "Danica DOO", "Kragujevac", 2);
        Frizer frizer1 = new Frizer(1L, "Danica", "Cutura", salon);
        Frizer frizer2 = new Frizer(2L, "Tara", "Stojanovic", salon);

        dbb.insert(frizer1);
        dbb.insert(frizer2);

        nadjiFrizereSO.execute(salon);

        List<OpstiDomenskiObjekat> result = (List<OpstiDomenskiObjekat>) nadjiFrizereSO.getResult();
        assertNotNull(result);
     


    }
}
