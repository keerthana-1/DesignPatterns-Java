package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityContextTest {

    @Test
    public void CheckdefaultLogout(){
        SecurityContext sc=new SecurityContext("keerthana",new EncryptedString("ab123"));
        assertTrue(sc.getState() instanceof LoggedOut);
    }

    @Test
    public void CheckSuccessfulLogin(){
        SecurityContext sc=new SecurityContext("keerthana",new EncryptedString("ab123"));
        sc.login(new EncryptedString("ab123"));
        assertTrue(sc.getState() instanceof LoggedIn);
    }

    @Test
    public void CheckFailedLogin(){
        try {
            SecurityContext sc = new SecurityContext("keerthana", new EncryptedString("ab123"));
            sc.login(new EncryptedString("abc123"));
        }
        catch (Exception ex){
            String expected="Authentication failed";
            assertEquals(expected,ex.getMessage());
        }
    }

    @Test
    public void CheckLogout(){
        SecurityContext sc=new SecurityContext("keerthana",new EncryptedString("ab123"));
        sc.login(new EncryptedString("ab123"));
        sc.logout();
        assertTrue(sc.getState() instanceof LoggedOut);
    }

}
