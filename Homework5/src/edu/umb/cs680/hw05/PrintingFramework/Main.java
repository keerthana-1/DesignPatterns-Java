package edu.umb.cs680.hw05.PrintingFramework;

import edu.umb.cs680.hw04.EncryptedString;
import edu.umb.cs680.hw04.SecurityContext;
import edu.umb.cs680.hw05.ModelABC.PrintJobExecuter;

public class Main {
    public static void main(String[] args) throws Exception {

        SecurityContext ctx=new SecurityContext("keerthana",new EncryptedString("ab123"));
        PrintJobExecuter ex=new PrintJobExecuter();
        PrintJob job= new PrintJob();
        ex.execute(job,new EncryptedString("ab123"),ctx);
    }
}