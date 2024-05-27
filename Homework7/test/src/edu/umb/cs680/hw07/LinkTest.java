package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    private static FileSystem fs;
    @BeforeAll
    public static void setUpFS(){
        fs= edu.umb.cs680.hw07.TestFixtureInitializer.createFS();
    }

    private String[] LinkToStringArray(Link l){
        String[] fileInfo={l.getParent().getName(),l.getName(), String.valueOf(l.getSize()), String.valueOf(l.getCreationTime())};
        return fileInfo;
    }
    @Test
    public void getLinkInfo(){
        String[] expected={"prjRoot","y","10", String.valueOf(fs.getRootDirs().get(0).getChildren().get(4).getCreationTime())};
        Link l=(Link)fs.getRootDirs().get(0).getChildren().get(4);
        String[] actual=LinkToStringArray(l);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void linktotestsrc(){
        String expected="test_src";
        Link l=(Link)fs.getRootDirs().get(0).getChildren().get(4);
        String actual=l.getTarget().getName();
        assertEquals(expected,actual);
    }

    @Test
    public void instanceofLink(){
        boolean expected=true;
        Link l=(Link)fs.getRootDirs().get(0).getChildren().get(4);
        boolean actual= l instanceof Link;
        assertEquals(expected,actual);
    }

    @Test
    public void isLink(){
        boolean expected=false;
        Link l=(Link)fs.getRootDirs().get(0).getChildren().get(4);
        boolean actual=l.isDirectory();
        assertEquals(expected,actual);
    }



}