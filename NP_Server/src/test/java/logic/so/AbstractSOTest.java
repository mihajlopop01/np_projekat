/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import db.DBBroker;
import db.DatabaseConnection;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;

public class AbstractSOTest {
    
    private AbstractSO so;
    private DBBroker dbb;
    
    @BeforeEach
    public void setUp() throws Exception {
        dbb = new DBBroker(DatabaseConnection.getInstance().pop());
        so = new AbstractSO() {
            @Override
            protected void validate(Object argument) throws Exception {
                if (argument == null) {
                    throw new Exception("Argument cannot be null");
                }
            }
            @Override
            protected void executeOperation(OpstiDomenskiObjekat argument) throws Exception {
                // Dummy operation for testing
                result = argument;
            }
        };
    }

    @Test
    public void testExecuteValidArgument() throws Exception {
        OpstiDomenskiObjekat argument = new Korisnik(1);
        so.execute(argument);
        assertEquals(argument, so.getResult());
    }
    
    @Test
    public void testExecuteInvalidArgument() {
        Exception exception = assertThrows(Exception.class, () -> {
            so.execute(null);
        });
        assertEquals("Argument cannot be null", exception.getMessage());
    }
    
    @Test
    public void testCommit() throws Exception {
        Connection connection = dbb.getConnection();
        connection.setAutoCommit(false);
        so.commit();
        assertFalse(connection.getAutoCommit());
    }
    
    @Test
    public void testRollback() throws Exception {
        Connection connection = dbb.getConnection();
        connection.setAutoCommit(false);
        so.rollback();
        assertFalse(connection.getAutoCommit());
    }
}

