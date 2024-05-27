import edu.umb.cs680.hw13.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> usedcars=new ArrayList<Car>();
        usedcars.add(new Car("toyota","RAV4",5000,2020,42000));
        usedcars.add(new Car("Audi","A7",6000,2019,41000));
        usedcars.add(new Car("Dodge","Viper",7000,2023,85000));
        usedcars.add(new Car("Chevrolet","Corvette",8000,2022,76000));
        usedcars.add(new Car("GMC","Acadia",9000,2021,41000));

        Collections.sort(usedcars, Comparator.comparing((Car car)-> car.getPrice(),Comparator.reverseOrder()));

        for (Car c:usedcars){
            System.out.println(c.getPrice());
        }

        Collections.sort(usedcars, Comparator.comparing((Car car)-> car.getyear()));
        Collections.sort(usedcars, Comparator.comparing((Car car)-> car.getMileage()));

        for (Car c:usedcars){
            c.setDominationCount(usedcars);
        }

        Collections.sort(usedcars,Comparator.comparing((Car car)-> car.getDominationCount()));

        for (Car c:usedcars){
            System.out.println(c.getMake());
        }
       // System.out.println("Hello world!");
    }
}