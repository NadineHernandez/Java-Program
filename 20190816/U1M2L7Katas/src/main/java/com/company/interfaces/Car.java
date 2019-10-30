package com.company.interfaces;

public class Car implements Vehicle {
    String make;
    String model;
    int milesTraveled;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(int milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    public void drive(int miles) {

    }

    public void displayMilesTraveled() {

    }
}
