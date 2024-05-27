package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.FSElement;
import edu.umb.cs680.hw12.fs.File;
import edu.umb.cs680.hw12.fs.FileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs= edu.umb.cs680.hw12.TestFixtureInitializer.createFS();
    }


    @Test
    public void getChildrenWithDefaultSort(){
        String[] expected={"lib","src","test","x","y"};
        String[] actual=new String[5];
        Directory rootdir=fs.getRootDirs().get(0);
        int i=0;
        for(FSElement f:rootdir.getChildren()){
            actual[i]=f.getName();
            i++;
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void getSubDirWithReverseAlphabeticalSort(){
        String[] expected={"test","src","lib"};
        String[] actual=new String[3];
        Directory rootdir= fs.getRootDirs().get(0);
        int i=0;
        for(Directory subdir:rootdir.getSubDirectories(new ReverseAlphabeticalComparator())){
            actual[i]=subdir.getName();
            i++;
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void getFilesWithAlphabeticalSort(){
       String[] expected={"c"};
        String[] actual=new String[1];
        Directory srcdir= fs.getRootDirs().get(0).getSubDirectories().get(0);
        int i=0;
        for(File file:srcdir.getFiles(new AlphabeticalComparator())){
            actual[i]=file.getName();
            System.out.println(actual[i]);
            i++;
        }

        assertArrayEquals(expected,actual);
    }

    @Test
    public void getFilesWithTimeStampSort(){
        String[] expected={"a","b"};
        String[] actual=new String[2];
        Directory srcdir= fs.getRootDirs().get(0).getSubDirectories().get(1);
        int i=0;
        for(File file:srcdir.getFiles(new TimeStampComparator())){
            actual[i]=file.getName();
            System.out.println(actual[i]);
            i++;
        }

        assertArrayEquals(expected,actual);
    }

    @Test
    public void getChildrenWithSizeSort(){
        String[] expected={"lib","src","test","x","y"};
        String[] actual=new String[5];
        Directory rootdir=fs.getRootDirs().get(0);
        int i=0;
        for(FSElement f:rootdir.getChildren(new SizeComparator())){
            actual[i]=f.getName();
            i++;
        }
        assertArrayEquals(expected,actual);
    }
}