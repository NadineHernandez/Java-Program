import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private int mileage;
    private static List<Car> carList = new ArrayList<>();

    public static List<Car> getCarList() {
        return carList;
    }

    public static void setCarList(List<Car> carList) {
        Car.carList = carList;
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
