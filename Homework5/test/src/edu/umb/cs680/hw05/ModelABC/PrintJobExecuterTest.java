package edu.umb.cs680.hw05.ModelABC;

import edu.umb.cs680.hw04.*;
import edu.umb.cs680.hw05.PrintingFramework.PrintJob;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecuterTest {

    edu.umb.cs680.hw05.ModelABC.PrintJobExecuter ex=new edu.umb.cs680.hw05.ModelABC.PrintJobExecuter();
    PrintJob job= new PrintJob();
    @Test
    public void FailedAuthentication(){

        try {
            SecurityContext ctx=new SecurityContext("keerthana",new EncryptedString("ab123"));
            ex.doAuthentication(new EncryptedString("abc123"),ctx);
            fail("Authentication Failed");
        } catch (RuntimeException ex) {
            String expected = "Authentication Failed";
            assertEquals(expected, ex.getMessage());
        }
    }
    @Test
    public void Authenticationsucceeds() {
        SecurityContext ctx=new SecurityContext("keerthana",new EncryptedString("ab123"));
        ex.doAuthentication(new EncryptedString("ab123"),ctx);
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void PrintWhenLoggedIn() throws Exception {
        SecurityContext ctx=new SecurityContext("keerthana",new EncryptedString("ab123"));
        ctx.login(new EncryptedString("ab123"));
        ex.doPrint(ctx,job);
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void AbortPrintWhenLoggedOut() throws Exception {
       try
       {
           SecurityContext ctx=new SecurityContext("keerthana",new EncryptedString("ab123"));
           ex.doPrint(ctx,job);
           fail("Not LoggedIn");
       }
       catch (RuntimeException ex)
       {
            String expected = "not logged in";
            assertEquals(expected, ex.getMessage());
       }
    }

    @Test
    public void checkFlow(){

        try {
            SecurityContext ctx = new SecurityContext("keerthana", new EncryptedString("ab123"));
            PrintJobExecuter ex = new PrintJobExecuter();
            PrintJob job = new PrintJob();
            ex.execute(job, new EncryptedString("ab123"), ctx);
            assertTrue(ctx.getState() instanceof LoggedIn);
        }
        catch(Exception e){
            String expected = "Authentication Failed";
            assertEquals(expected, e.getMessage());
        }
    }

}