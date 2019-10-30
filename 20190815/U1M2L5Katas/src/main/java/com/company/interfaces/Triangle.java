package com.company.interfaces;

public class Triangle implements Shape{
    int x;
    int y;
    int z;
    public double perimeter(){
        double perimeter = x + y + z;
        return perimeter;
    }
    public double area() {
        double area = (x * y) / 2;
        return area;
    }
}
