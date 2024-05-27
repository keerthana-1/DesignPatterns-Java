package edu.umb.cs680.hw05.ModelXYZ;

import edu.umb.cs680.hw04.*;
import edu.umb.cs680.hw05.PrintingFramework.PrintJob;

public class PrintJobExecuter extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecuter {

    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) {

    }

    @Override
    protected void doAccessControl() {

    }

    @Override
    protected void doPrint(SecurityContext ctx,PrintJob job) throws Exception {
        job.Printing();
    }

    @Override
    protected void doErrorHandling() {

    }
}
