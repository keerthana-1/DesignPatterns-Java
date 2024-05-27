package edu.umb.cs680.hw08.fs.util;

import edu.umb.cs680.hw08.fs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingVisitorTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs=TestFixtureInitializer.createFS();
    }

    @Test
    public void getAllFilesinprjRoot(){
        String[] expected={"a","b","c","d","x"};
        FileCrawlingVisitor crawl=new FileCrawlingVisitor();
        Directory prjRoot=fs.getRootDirs().get(0);
        prjRoot.accept(crawl);
        String[] actual=new String[5];
        int cnt=0;
        for(File f:crawl.getFiles()){
            actual[cnt]=f.getName();
            cnt++;
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void getFilesinprjRoot_src(){
        String[] expected={"a","b"};
        FileCrawlingVisitor crawl=new FileCrawlingVisitor();
        Directory prjRoot=fs.getRootDirs().get(0).getSubDirectories().get(0);
        prjRoot.accept(crawl);
        String[] actual=new String[2];
        int cnt=0;
        for(File f:crawl.getFiles()){
            actual[cnt]=f.getName();
            cnt++;
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void getFilesinTest_src(){
        String[] expected={"d"};
        FileCrawlingVisitor crawl=new FileCrawlingVisitor();
        Directory prjRoot=fs.getRootDirs().get(0).getSubDirectories().get(2).getSubDirectories().get(0);
        prjRoot.accept(crawl);
        String[] actual=new String[1];
        int cnt=0;
        for(File f:crawl.getFiles()){
            actual[cnt]=f.getName();
            cnt++;
        }
        assertArrayEquals(expected,actual);
    }
}