package com.company.interfaces;

public class Square implements Shape{
    int x;
    int y;
    public double perimeter(){
        double perimeter = (x + y) * 2;
        return perimeter;
    }
    public double area() {
        double area = x * y;
        return area;
    }
}
