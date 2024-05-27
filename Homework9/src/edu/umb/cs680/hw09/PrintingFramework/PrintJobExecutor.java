package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw04.*;

public abstract class PrintJobExecutor {
    public void execute(Command job, EncryptedString pwd, SecurityContext ctx) throws Exception {
        doAuthentication(pwd,ctx);
        doAccessControl();
        doPrint(ctx,job);
        doErrorHandling();
    }
    protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx);

    protected abstract void doAccessControl();
    protected abstract void doPrint(SecurityContext ctx,Command job) throws Exception;
    protected abstract void doErrorHandling();
}
