package edu.umb.cs680.hw11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;


import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static ArrayList<Car> usedcars=new ArrayList<Car>();
    @BeforeAll
    public static void setUpCarsList(){
        usedcars.add(new Car("toyota","RAV4",5000,2020,42000));
        usedcars.add(new Car("Audi","A7",6000,2019,41000));
        usedcars.add(new Car("Dodge","Viper",7000,2023,85000));
        usedcars.add(new Car("Chevrolet","Corvette",8000,2022,76000));
        usedcars.add(new Car("GMC","Acadia",9000,2021,41000));
    }

    @Test
    public void MileageComparatorTest(){

        ArrayList<Integer> expected= new ArrayList<>();
        expected.add(5000);expected.add(6000);expected.add(7000);expected.add(8000);expected.add(9000);
        ArrayList<Integer> actual=new ArrayList<Integer>();
        Collections.sort(usedcars, new MileageComparator());
        for (Car c:usedcars){
            actual.add(c.getMileage());
        }
        assertEquals(expected,actual);

    }

    @Test
    public void PriceComparatorTest(){


        ArrayList<Integer> expected= new ArrayList<>();
        expected.add(41000);expected.add(41000);expected.add(42000);expected.add(76000);expected.add(85000);
        ArrayList<Integer> actual=new ArrayList<Integer>();
        Collections.sort(usedcars, new PriceComparator());
        for (Car c:usedcars){
            actual.add((int) c.getPrice());
        }
        assertEquals(expected,actual);
    }

    @Test
    public void YearComparatorTest(){

        ArrayList<Integer> expected= new ArrayList<>();
        expected.add(2023);expected.add(2022);expected.add(2021);expected.add(2020);expected.add(2019);
        ArrayList<Integer> actual=new ArrayList<Integer>();
        Collections.sort(usedcars, new YearComparator());
        for (Car c:usedcars){
            actual.add( c.getyear());
        }
        assertEquals(expected,actual);

    }

    @Test
    public void ParetoComparatorTest(){

        for (Car c:usedcars){
            c.setDominationCount(usedcars);
        }

        ArrayList<String> expected= new ArrayList<>();
        expected.add("Dodge");expected.add("Chevrolet");expected.add("toyota");expected.add("GMC");expected.add("Audi");
        ArrayList<String> actual=new ArrayList<String>();
        Collections.sort(usedcars,new ParetoComparator<Car>());
        for (Car c:usedcars){
            actual.add( c.getMake());
        }
        assertEquals(expected,actual);
    }

}