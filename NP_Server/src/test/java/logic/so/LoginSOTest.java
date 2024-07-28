/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import db.*;

import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginSOTest {
    
    private LoginSO loginSO;
    private OpstiDomenskiObjekat user;
    private DBBroker dbb;
    
    @BeforeEach
    public void setUp() throws Exception {
        loginSO = new LoginSO();
        user = new Korisnik(1, "Toni","Toni","toni@gmail.com", "toni123");
        dbb = new DBBroker(DatabaseConnection.getInstance().pop());
        // Initialize the user object as needed for the test
    }
    
    @Test
    public void testValidateValidUser() {
        assertDoesNotThrow(() -> loginSO.validate(user));
    }
    
    @Test
    public void testValidateInvalidUser() {
        Exception exception = assertThrows(Exception.class, () -> {
            loginSO.validate(null);
        });
        assertEquals("Argument je null", exception.getMessage());
    }
    
    @Test
    public void testExecuteOperation() throws Exception {
    Korisnik testUser = new Korisnik(1, "Toni","Toni","toni@gmail.com", "toni123");

    
    dbb.insert(testUser);

    
    loginSO.execute(testUser);

    assertNotNull(loginSO.getResult());
    assertTrue(loginSO.getResult() instanceof OpstiDomenskiObjekat);
    assertEquals(testUser.getKorisnikid(), ((Korisnik) loginSO.getResult()).getKorisnikid());
    }
}

