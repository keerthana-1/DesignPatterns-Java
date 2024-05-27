import edu.umb.cs680.distance.Distance;
import edu.umb.cs680.distance.Manhattan;
import edu.umb.cs680.hw10.Car;
import edu.umb.cs680.hw10.Normalization;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Car c1=new Car("toyota","RAV4",5000,2020,42000);
        Car c2=new Car("Audi","A7",6000,2019,41000);
        Car c3=new Car("Dodge","Viper",7000,2023,85000);
        Car c4=new Car("Chevrolet","Corvette",8000,2022,76000);
        Car c5=new Car("GMC","Acadia",9000,2021,41000);

        List<List<Double>> cars=List.of(c1.getCarList(),c2.getCarList(),c3.getCarList(),c4.getCarList(),c5.getCarList());
        Normalization n=new Normalization();
        List<List<Double>> points = n.NormalizeCarList(cars);
        List<List<Double>> distanceMatrix=Distance.matrix(points);
       // List<List<Double>> distanceMatrix = Distance.matrix(points,new Manhattan());
        for(int i=0;i<points.size();i++)
        {
                System.out.println(distanceMatrix.get(i));
        }
    }

}