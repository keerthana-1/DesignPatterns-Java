package edu.umb.cs680.hw14.util;

import edu.umb.cs680.hw14.fs.Directory;
import edu.umb.cs680.hw14.fs.File;
import edu.umb.cs680.hw14.fs.Link;

import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor{

    private LinkedList<File> files=new LinkedList<File>();
    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        files.add(file);
    }

    public LinkedList<File> getFiles(){
        return files;
    }
}
