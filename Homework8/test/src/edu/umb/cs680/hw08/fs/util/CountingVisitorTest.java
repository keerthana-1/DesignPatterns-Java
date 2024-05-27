package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs=TestFixtureInitializer.createFS();
    }

    @Test
    public void countDirectoriesofPrjRoot(){
        int expected=5;
        CountingVisitor visitor=new CountingVisitor();
        Directory prjRoot=fs.getRootDirs().get(0);
        prjRoot.accept(visitor);
        int actual=visitor.getDirNum();
        assertEquals(expected,actual);
    }

    @Test
    public void countFilesofPrjRoot_src(){
        int expected=2;
        CountingVisitor visitor=new CountingVisitor();
        Directory prjRoot=fs.getRootDirs().get(0).getSubDirectories().get(0);
        prjRoot.accept(visitor);
        int actual=visitor.getFileNum();
        assertEquals(expected,actual);
    }

    @Test
    public void countLinksofPrjRoot(){
        int expected=1;
        CountingVisitor visitor=new CountingVisitor();
        Directory prjRoot=fs.getRootDirs().get(0);
        prjRoot.accept(visitor);
        int actual=visitor.getLinkNum();
        assertEquals(expected,actual);
    }



}