import edu.umb.cs680.hw15.GPA;
import edu.umb.cs680.hw15.GPAOnScale10;
import edu.umb.cs680.hw15.GPAOnScale5;
import edu.umb.cs680.hw15.GPAOnScale8;

public class Main {
    public static void main(String[] args) {

        GPA g=new GPA(3.096,new GPAOnScale5());
        GPA g1=new GPA(3.250,new GPAOnScale8());
        GPA g2=new GPA(2.900,new GPAOnScale10());

        System.out.println(g.getGpa());
        System.out.println(g1.getGpa());
        System.out.println(g2.getGpa());
    }
}