package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw04.Authenticator;
import edu.umb.cs680.hw04.EncryptedString;
import edu.umb.cs680.hw04.LoggedIn;
import edu.umb.cs680.hw04.SecurityContext;
import edu.umb.cs680.hw09.PrintingFramework.Command;

public class PrintJobExecutor extends edu.umb.cs680.hw09.PrintingFramework.PrintJobExecutor {
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
    protected void doPrint(SecurityContext ctx, Command job) throws Exception {
        if(ctx.getState() instanceof LoggedIn){
            job.execute();
        }
        else{
            throw new RuntimeException("not logged in");
        }
    }

    @Override
    protected void doErrorHandling() {

    }
}
