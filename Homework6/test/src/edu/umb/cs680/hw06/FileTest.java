package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs= TestFixtureInitializer.createFS();
    }

    private String[] fileToStringArray(File f){
        String[] fileInfo={f.getParent().getName(),f.getName(), String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
        return fileInfo;
    }

    @Test
    public void getFileInfo(){
        String[] expected={"prjRoot","x","5", String.valueOf(fs.getRootDirs().get(0).getFiles().get(0).getCreationTime())};
        FSElement f=fs.getRootDirs().get(0).getFiles().get(0);
        String[] actual=fileToStringArray((File)f);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void TestxisFile(){
        boolean expected=false;
        FSElement f=fs.getRootDirs().get(0).getFiles().get(0);
        boolean actual=f.isDirectory();
        assertEquals(expected,actual);
    }

    @Test
    public void equalInstances(){
        FSElement f1=fs.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0);
        FileSystem fs1=FileSystem.getFileSystem();
        assertSame(fs,fs1);
    }

}