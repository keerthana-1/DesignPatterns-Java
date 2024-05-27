package edu.umb.cs680.hw10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Car {
    private String make,model;
    private int mileage,year;
    private float price;

    public Car(String make, String model, int mileage, int year, float price){
        this.make=make;
        this.model=model;
        this.mileage=mileage;
        this.year=year;
        this.price=price;
    }
    public String getMake(){
        return this.make;
    }
    public String getModel(){
        return this.model;
    }
    public int getMileage(){
        return this.mileage;
    }
    public int getyear(){
        return this.year;
    }
    public float getPrice(){
        return this.price;
    }

    public List<Double> getCarList(){
        List<Double> car= List.of((double) getMileage(),(double) getyear(),(double) getPrice());
        return car;
    }
   }
