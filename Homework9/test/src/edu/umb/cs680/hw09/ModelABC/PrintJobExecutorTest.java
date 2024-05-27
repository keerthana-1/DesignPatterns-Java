package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw04.EncryptedString;
import edu.umb.cs680.hw04.LoggedIn;
import edu.umb.cs680.hw04.SecurityContext;
import edu.umb.cs680.hw09.PrintingFramework.Command;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {

    @Test
    public void PrintJobTest(){
        SecurityContext ctx=new SecurityContext("keerthana",new EncryptedString("ab123"));
        edu.umb.cs680.hw09.PrintingFramework.PrintJobExecutor ex=new edu.umb.cs680.hw09.ModelABC.PrintJobExecutor();
        PrintJob job= new PrintJob();
        try {
            ex.execute((Command) job,new EncryptedString("ab123"),ctx);
            assertTrue(ctx.getState() instanceof LoggedIn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @Test
    public void AbortPrintWhenLoggedOut() throws Exception {
        try
        {
            SecurityContext ctx=new SecurityContext("keerthana",new EncryptedString("ab123"));
            edu.umb.cs680.hw09.PrintingFramework.PrintJobExecutor ex=new edu.umb.cs680.hw09.ModelABC.PrintJobExecutor();
            Command job= new PrintJob();

            ex.execute((Command) job,new EncryptedString("ab13"),ctx);
            fail("Not LoggedIn");
        }
        catch (RuntimeException ex)
        {
            String expected = "Authentication Failed";
            assertEquals(expected, ex.getMessage());
        }
    }

}