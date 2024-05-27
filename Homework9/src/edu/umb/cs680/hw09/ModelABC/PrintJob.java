package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw04.EncryptedString;
import edu.umb.cs680.hw04.SecurityContext;
import edu.umb.cs680.hw09.PrintingFramework.Command;

public class PrintJob implements Command {

    public PrintJob(){

    }
    @Override
    public void execute() {
        Printer p=Printer.getInstance();
        p.print();
    }
}
