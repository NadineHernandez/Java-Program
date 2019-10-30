package com.company;

public class App {

    public TV createTV() {
        TV myTV = new TV("Zenith", "U2121H", 83, "NBC", 55, false);
        return myTV;
    }

    public Radio createRadio() {
        Radio myRadio = new Radio("Sony", "V32", 2,"WUNV", 30, true);
        return myRadio;
    }

    public Microwave createMicrowave() {
        Microwave myMicrowave = new Microwave("Haier", "X1200w", 45, "12:00", false);
        return myMicrowave;
    }

    public CoffeeMaker createCoffeeMaker() {
        CoffeeMaker myCoffeeMaker = new CoffeeMaker("Sunbeam", "C12", 12, 8, true);
        return myCoffeeMaker;
    }

    public Car createCar() {
        Car myCar = new Car("Honda", "Accord", "Sedan", "Blue", "2.6L V6", "CVT", 4, 31.7, 25218);
        return myCar;
    }

    public ComputerMouse createComputerMouse() {
        int[] passArr = {0, 0};
        ComputerMouse myComputerMouse = new ComputerMouse("Razer", "Naga", 960, 540, passArr);
        return myComputerMouse;
    }

    public static void main(String[] args) {

    }

}
