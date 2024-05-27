package edu.umb.cs680.hw05.ModelABC;
import edu.umb.cs680.hw04.*;
import edu.umb.cs680.hw05.PrintingFramework.PrintJob;

public class PrintJobExecuter extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecuter {
    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) {
        if(Authenticator.authenticate(ctx,pwd)) {
            ctx.login(pwd);
        }
        else {
          throw new RuntimeException("Authentication Failed");
       }
    }

    @Override
    protected void doAccessControl() {

    }

    @Override
    protected void doPrint(SecurityContext ctx,PrintJob job) throws Exception {
        if(ctx.getState() instanceof LoggedIn){
            job.Printing();
        }
        else{
            throw new RuntimeException("not logged in");
        }
    }

    @Override
    protected void doErrorHandling() {

    }
}
