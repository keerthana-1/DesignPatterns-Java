package edu.umb.cs680.distance;

import edu.umb.cs680.hw10.Car;
import edu.umb.cs680.hw10.Normalization;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    private static Car c1,c2,c3,c4,c5;
    @BeforeAll
    public static void initializeCars(){

        c1=new Car("toyota","RAV4",5000,2020,42000);
        c2=new Car("Audi","A7",6000,2019,41000);
        c3=new Car("Dodge","Viper",7000,2023,85000);
        c4=new Car("Chevrolet","Corvette",8000,2022,76000);
        c5=new Car("GMC","Acadia",9000,2021,41000);

    }
    
    @Test
    public void ManhattanMetricTest(){
        List<List<Double>> expected=List.of(List.of(0.0, 0.5227272727272727, 2.2272727272727275, 2.0227272727272725, 1.2727272727272727),
                List.of(0.5227272727272727, 0.0, 2.25, 2.0454545454545454, 1.25),
                List.of(2.2272727272727275, 2.25, 0.0, 0.7045454545454546, 2.0),
                List.of(2.0227272727272725, 2.0454545454545454, 0.7045454545454546, 0.0, 1.2954545454545454),
                List.of(1.2727272727272727, 1.25, 2.0, 1.2954545454545454, 0.0));

        List<List<Double>> cars=List.of(c1.getCarList(),c2.getCarList(),c3.getCarList(),c4.getCarList(),c5.getCarList());
        Normalization n=new Normalization();
        List<List<Double>> points = n.NormalizeCarList(cars);
        List<List<Double>> distanceMatrix = Distance.matrix(points,new Manhattan());
        assertIterableEquals(expected,distanceMatrix);
    }

    @Test
    public void EuclideanMetricTest(){

        List<List<Double>> expected=List.of(List.of(0.0, 0.35428311972999765, 1.3294968911099696, 1.187268898782634, 1.0310269292921597),
                List.of(0.35428311972999765, 0.0, 1.4361406616345072, 1.2021846504943812, 0.9013878188659973),
                List.of(1.3294968911099696, 1.4361406616345072, 0.0, 0.4084591080820779, 1.224744871391589),
                List.of(1.187268898782634, 1.2021846504943812, 0.4084591080820779, 0.0, 0.8704871819184344),
                List.of(1.0310269292921597, 0.9013878188659973, 1.224744871391589, 0.8704871819184344, 0.0));

        List<List<Double>> cars=List.of(c1.getCarList(),c2.getCarList(),c3.getCarList(),c4.getCarList(),c5.getCarList());
        Normalization n=new Normalization();
        List<List<Double>> points = n.NormalizeCarList(cars);
        List<List<Double>> distanceMatrix=Distance.matrix(points);
        assertIterableEquals(expected,distanceMatrix);

    }

}