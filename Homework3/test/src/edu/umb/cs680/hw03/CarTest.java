package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private String[] carToStringArray(Car c){
        String[] CarInfo = {c.getMake(),c.getModel(), String.valueOf(c.getyear())};
        return CarInfo;
    }
    @Test
    public void verifyCarEqualityWithMakeModelYear(){
        String[] expected={"Toyota","RAV4","2018"};
        Car actual=new Car("Toyota","RAV4",70,2018,500000);
        assertArrayEquals(expected,carToStringArray(actual));
    }


}