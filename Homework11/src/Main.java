import edu.umb.cs680.hw11.*;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Car> usedcars=new ArrayList<Car>();
        usedcars.add(new Car("toyota","RAV4",5000,2020,42000));
        usedcars.add(new Car("Audi","A7",6000,2019,41000));
        usedcars.add(new Car("Dodge","Viper",7000,2023,85000));
        usedcars.add(new Car("Chevrolet","Corvette",8000,2022,76000));
        usedcars.add(new Car("GMC","Acadia",9000,2021,41000));

        Collections.sort(usedcars, new PriceComparator());
        Collections.sort(usedcars, new YearComparator());
        Collections.sort(usedcars, new MileageComparator());



        for (Car c:usedcars){
            System.out.println(c.getPrice());
        }

        for (Car c:usedcars){
           c.setDominationCount(usedcars);
        }

        Collections.sort(usedcars,new ParetoComparator<Car>());

        for (Car c:usedcars){
            System.out.println(c.getMake());
        }
        System.out.println("Hello world!");
    }
}