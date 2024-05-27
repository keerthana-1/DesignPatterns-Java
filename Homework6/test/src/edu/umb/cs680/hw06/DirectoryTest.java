package edu.umb.cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs= edu.umb.cs680.hw06.TestFixtureInitializer.createFS();
    }

    private String[] dirToStringArray(Directory d){
        String[] dirInfo={d.getParent().getName(),d.getName(), String.valueOf(d.getSize()), String.valueOf(d.getCreationTime())};
        return dirInfo;
    }

    @Test
    public void getChildrenofprjRoot(){
        String[] expected={"src","lib","test","x"};
        String[] actual=new String[4];
        Directory rootdir=fs.getRootDirs().get(0);
         int i=0;
         for(FSElement f:rootdir.getChildren()){
             actual[i]=f.getName();
             i++;
         }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void countTestDirChildren(){
        int expected=1;
        Directory rootdir= fs.getRootDirs().get(0).getSubDirectories().get(2);
        int actual=rootdir.countChildren();
        assertEquals(expected,actual);
    }

    @Test
    public void getSubDirofprjRoot(){
        String[] expected={"src","lib","test"};
        String[] actual=new String[3];
        Directory rootdir= fs.getRootDirs().get(0);
        int i=0;
        for(Directory subdir:rootdir.getSubDirectories()){
            actual[i]=subdir.getName();
            i++;
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void getFilesofsrc(){
        String[] expected={"a","b"};
        String[] actual=new String[2];
        Directory srcdir= fs.getRootDirs().get(0).getSubDirectories().get(0);
        int i=0;
        for(FSElement file:srcdir.getFiles()){
            actual[i]=file.getName();
            i++;
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void getTotalSizeofsrcDir(){
        int expected=10;
        Directory testdir=fs.getRootDirs().get(0).getSubDirectories().get(0);
        int actual=testdir.getTotalSize();
        assertEquals(expected,actual);
    }

    @Test
    public void TestlibisDirectory(){
        boolean expected=true;
        Directory d=fs.getRootDirs().get(0).getSubDirectories().get(1);
        boolean actual=d.isDirectory();
        assertEquals(expected,actual);
    }

    @Test
    public void getSrcDirInfo(){
        String[] expected={"prjRoot","src","0", String.valueOf(fs.getRootDirs().get(0).getSubDirectories().get(0).getCreationTime())};
        String[] actual=dirToStringArray(fs.getRootDirs().get(0).getSubDirectories().get(0));
        assertArrayEquals(expected,actual);
    }

    @Test
    public void getTotalSize(){
        int expected=10;
        Directory src=fs.getRootDirs().get(0).getSubDirectories().get(0);
        int actual=src.getTotalSize();
        assertEquals(expected,actual);
    }

}