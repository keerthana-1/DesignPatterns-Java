package edu.umb.cs680.hw14.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {


    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs= edu.umb.cs680.hw14.fs.TestFixtureInitializer.createFS();
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
        for(Directory subdir:rootdir.getSubDirectories(Comparator.comparing((FSElement fselement)-> fselement.getName(),Comparator.reverseOrder()))){
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
        for(File file:srcdir.getFiles(Comparator.comparing((FSElement fselement)-> fselement.getName()))){
            actual[i]=file.getName();
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
        for(File file:srcdir.getFiles(Comparator.comparing((FSElement fselement)-> fselement.getCreationTime()))){
            actual[i]=file.getName();
            i++;
        }

        assertArrayEquals(expected,actual);
    }

    @Test
    public void getFilesWithTimeStampSortReverse(){
        String[] expected={"a","b"};
        String[] actual=new String[2];
        Directory srcdir= fs.getRootDirs().get(0).getSubDirectories().get(1);
        int i=0;
        for(File file:srcdir.getFiles(Comparator.comparing((FSElement fselement)-> fselement.getCreationTime(),Comparator.reverseOrder()))){
            actual[i]=file.getName();
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
        for(FSElement f:rootdir.getChildren(Comparator.comparing((FSElement fselement)-> fselement.getSize()))){
            actual[i]=f.getName();
            i++;
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void getChildrenWithSizeSortReverse(){
        String[] expected={"y","x","lib","src","test"};
        String[] actual=new String[5];
        Directory rootdir=fs.getRootDirs().get(0);
        int i=0;
        for(FSElement f:rootdir.getChildren(Comparator.comparing((FSElement fselement)-> fselement.getSize(),Comparator.reverseOrder()))){
            actual[i]=f.getName();
            i++;
        }
        assertArrayEquals(expected,actual);
    }

}