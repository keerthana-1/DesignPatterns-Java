package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs= edu.umb.cs680.hw06.TestFixtureInitializer.createFS();
    }

    private String[] dirToStringArray(Directory d){
        String parent;
        if(d.getParent()==null){
            parent="null";

        }else {
            parent=d.getParent().getName();
        }
        String[] dirInfo={parent, d.getName(), String.valueOf(d.getSize())};
        return dirInfo;
    }

    @Test
    public void getRootDirs(){
        String[] expected ={"null","prjRoot","0"};
        Directory rootDir=fs.getRootDirs().get(0);
        String[] actual=dirToStringArray(rootDir);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void equalInstances(){
        Directory d1=fs.getRootDirs().get(0);
        FileSystem fs1=FileSystem.getFileSystem();
        assertSame(fs,fs1);
    }

}