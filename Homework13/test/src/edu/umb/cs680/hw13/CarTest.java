package edu.umb.cs680.hw13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        Collections.sort(usedcars, Comparator.comparing((Car car)-> car.getMileage()));

        for (Car c:usedcars){
            actual.add(c.getMileage());
        }
        assertEquals(expected,actual);

    }
    @Test
    public void MileageComparatorTestReverseOrder(){

        ArrayList<Integer> expected= new ArrayList<>();
        expected.add(9000);expected.add(8000);expected.add(7000);expected.add(6000);expected.add(5000);
        ArrayList<Integer> actual=new ArrayList<Integer>();
        Collections.sort(usedcars, Comparator.comparing((Car car)-> car.getMileage(),Comparator.reverseOrder()));

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
        Collections.sort(usedcars, Comparator.comparing((Car car)-> car.getPrice()));
        for (Car c:usedcars){
            actual.add((int) c.getPrice());
        }
        assertEquals(expected,actual);
    }

    @Test
    public void PriceComparatorTestReverseorder(){


        ArrayList<Integer> expected= new ArrayList<>();
        expected.add(85000);expected.add(76000);expected.add(42000);expected.add(41000);expected.add(41000);
        ArrayList<Integer> actual=new ArrayList<Integer>();
        Collections.sort(usedcars, Comparator.comparing((Car car)-> car.getPrice(),Comparator.reverseOrder()));
        for (Car c:usedcars){
            actual.add((int) c.getPrice());
        }
        assertEquals(expected,actual);
    }

    @Test
    public void YearComparatorTestReverseOrder(){

        ArrayList<Integer> expected= new ArrayList<>();
        expected.add(2023);expected.add(2022);expected.add(2021);expected.add(2020);expected.add(2019);
        ArrayList<Integer> actual=new ArrayList<Integer>();
        Collections.sort(usedcars, Comparator.comparing((Car car)-> car.getyear(),Comparator.reverseOrder()));
        for (Car c:usedcars){
            actual.add( c.getyear());
        }
        assertEquals(expected,actual);

    }

    @Test
    public void YearComparatorTest(){

        ArrayList<Integer> expected= new ArrayList<>();
        expected.add(2019);expected.add(2020);expected.add(2021);expected.add(2022);expected.add(2023);
        ArrayList<Integer> actual=new ArrayList<Integer>();
        Collections.sort(usedcars, Comparator.comparing((Car car)-> car.getyear()));
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
        expected.add("Audi");expected.add("GMC");expected.add("toyota");expected.add("Chevrolet");expected.add("Dodge");
        ArrayList<String> actual=new ArrayList<String>();
        Collections.sort(usedcars, Comparator.comparing((Car car)-> car.getDominationCount()));
        for (Car c:usedcars){
            actual.add( c.getMake());
        }
        assertEquals(expected,actual);
    }

    @Test
    public void ParetoComparatorTestReverseOrder(){

        for (Car c:usedcars){
            c.setDominationCount(usedcars);
        }

        ArrayList<String> expected= new ArrayList<>();
        expected.add("Dodge");expected.add("toyota");expected.add("Chevrolet");expected.add("Audi");expected.add("GMC");
        ArrayList<String> actual=new ArrayList<String>();
        Collections.sort(usedcars, Comparator.comparing((Car car)-> car.getDominationCount(),Comparator.reverseOrder()));
        for (Car c:usedcars){
            actual.add( c.getMake());
        }
        assertEquals(expected,actual);
    }
}