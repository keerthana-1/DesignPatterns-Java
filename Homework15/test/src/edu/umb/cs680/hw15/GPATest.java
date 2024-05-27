package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GPATest {

    @Test
    public void testGPAOnScale5(){

        double expected=3.87;
        GPA g=new GPA(3.096,new GPAOnScale5());
        assertEquals(expected,g.getGpa());
    }

    @Test
    public void testGPAOnScale8(){
        double expected=6.192;
        GPA g=new GPA(3.096,new GPAOnScale8());
        assertEquals(expected,g.getGpa());
    }

    @Test
    public void testGPAOnScale10(){

        double expected=7.74;
        GPA g=new GPA(3.096,new GPAOnScale10());
        assertEquals(expected,g.getGpa());
    }

}