package com.company.interfaces;

public class Circle implements Shape{
    int d;

    public double perimeter(){
        double perimeter = d * 3.14;
        return perimeter;
    }
    public double area() {
        double area = (d * 3.14) * (d * 3.14);
        return area;
    }
}
