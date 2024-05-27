package edu.umb.cs680.hw14.util;

import edu.umb.cs680.hw14.fs.Directory;
import edu.umb.cs680.hw14.fs.File;
import edu.umb.cs680.hw14.fs.Link;

public interface FSVisitor {
    public void visit(Link link);
    public void visit(Directory dir);
    public void visit(File file);
}
