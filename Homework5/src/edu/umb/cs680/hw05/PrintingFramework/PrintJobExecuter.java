package edu.umb.cs680.hw05.PrintingFramework;

import edu.umb.cs680.hw04.*;

public abstract class PrintJobExecuter {
    public void execute(PrintJob job,EncryptedString pwd, SecurityContext ctx) throws Exception {
        doAuthentication(pwd,ctx);
        doAccessControl();
        doPrint(ctx,job);
        doErrorHandling();
    }
    protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx);

    protected abstract void doAccessControl();
    protected abstract void doPrint(SecurityContext ctx,PrintJob job) throws Exception;
    protected abstract void doErrorHandling();
}
