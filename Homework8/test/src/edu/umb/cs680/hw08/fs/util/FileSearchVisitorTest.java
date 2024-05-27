package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchVisitorTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs=TestFixtureInitializer.createFS();
    }

    @Test
    public void searchFile_a(){
        int expected=5;
        FileSearchVisitor search=new FileSearchVisitor("a");
        Directory prjRoot=fs.getRootDirs().get(0);
        prjRoot.accept(search);
        int actual=search.getFoundFiles().get(0).getSize();
        assertEquals(expected,actual);
    }
    @Test
    public void searchFile_c(){
        String expected="c";
        FileSearchVisitor search=new FileSearchVisitor("c");
        Directory prjRoot=fs.getRootDirs().get(0);
        prjRoot.accept(search);
        String actual=search.getFoundFiles().get(0).getName();
        assertEquals(expected,actual);
    }
    @Test
    public void getFoundFiles(){
        String expected="x";
        FileSearchVisitor search=new FileSearchVisitor("x");
        Directory prjRoot=fs.getRootDirs().get(0);
        prjRoot.accept(search);
        String actual=search.getFoundFiles().get(0).getName();
        assertEquals(expected,actual);
    }
}