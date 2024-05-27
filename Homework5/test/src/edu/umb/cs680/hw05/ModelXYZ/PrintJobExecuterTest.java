package edu.umb.cs680.hw05.ModelXYZ;

import edu.umb.cs680.hw04.*;
import edu.umb.cs680.hw05.PrintingFramework.PrintJob;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecuterTest {

    @Test
    public void PrintWithoutAuthentication() throws Exception {
        SecurityContext ctx=new SecurityContext("keerthana",new EncryptedString("ab123"));
        edu.umb.cs680.hw05.ModelXYZ.PrintJobExecuter ex=new PrintJobExecuter();
        PrintJob job= new PrintJob();
        ex.execute(job,new EncryptedString("ab123"),ctx);
    }

}