package edu.umb.cs680.hw15;

public class GPA {

    private Double gpa;
    private GPACalculator gpaCalculator;
    public GPA(Double gpa,GPACalculator gpaCalculator){
        this.gpa=gpa;
        this.gpaCalculator=gpaCalculator;
    }

    public Double getGpa(){
        return this.gpaCalculator.getGPA(this.gpa);
    }
}
