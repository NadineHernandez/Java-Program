package com.company;

public class CoffeeMaker {
    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarafeSize(int carafeSize) {
        this.carafeSize = carafeSize;
    }

    public void setCupsLeft(int cupsLeft) {
        this.cupsLeft = cupsLeft;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getCarafeSize() {
        return carafeSize;
    }

    public int getCupsLeft() {
        return cupsLeft;
    }

    public boolean isPowered() {
        return powered;
    }

    public void brew() {
        cupsLeft = carafeSize;
    }

    public void pourCoffee(int numCups) {
        cupsLeft = cupsLeft-numCups;
    }

    public CoffeeMaker(String manufacturer, String model, int carafeSize, int cupsLeft, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.carafeSize = carafeSize;
        this.cupsLeft = cupsLeft;
        this.powered = powered;
    }

    public static void main(String[] args) {

    }
}
