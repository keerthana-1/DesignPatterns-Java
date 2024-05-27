package edu.umb.cs680.hw10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Normalization {

    public Normalization(){

    }

    public List<List<Double>> NormalizeCarList(List<List<Double>> points) {

        List<Double> mileage=new ArrayList<>();
        List<Double> price=new ArrayList<>();
        List<Double> year=new ArrayList<>();

        List<Double> n_mileage=new ArrayList<>();
        List<Double> n_price=new ArrayList<>();
        List<Double> n_year=new ArrayList<>();

        List<Double> car1=new ArrayList<>();
        List<Double> car2=new ArrayList<>();
        List<Double> car3=new ArrayList<>();
        List<Double> car4=new ArrayList<>();
        List<Double> car5=new ArrayList<>();


        for(List<Double> d:points){
            mileage.add(d.get(0));
            year.add(d.get(1));
            price.add(d.get(2));
        }

        double mileage_min= Collections.min(mileage);
        double year_min= Collections.min(year);
        double price_min= Collections.min(price);

        double mileage_max= Collections.max(mileage);
        double year_max= Collections.max(year);
        double price_max= Collections.max(price);

        List<List<Double>> normalizedCarList = new ArrayList<>();

        for(Double m:mileage){
            n_mileage.add((m-mileage_min)/(mileage_max-mileage_min));
        }

        for(Double y:year){
            n_year.add((y-year_min)/(year_max-year_min));
        }

        for(Double p:price){
            n_price.add((p-price_min)/(price_max-price_min));
        }

        normalizedCarList.add(car1);
        normalizedCarList.add(car2);
        normalizedCarList.add(car3);
        normalizedCarList.add(car4);
        normalizedCarList.add(car5);

        int i=0;
        for(List<Double> car:normalizedCarList){
            car.add(n_mileage.get(i));
            car.add(n_year.get(i));
            car.add(n_price.get(i));
            i=i+1;
        }

        for(List<Double> car:normalizedCarList){
            System.out.println(car);
        }

        return normalizedCarList;


    }
}


