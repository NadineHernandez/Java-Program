package com.company.statesandcities.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class City {
    @NotEmpty(message = "You must supply a City name")
    private String name;

    @NotEmpty(message = "You must supply a state")
    private String state;

    @NotNull(message = "You must supply a population")
    private int population;

    @NotNull(message = "You must supply whether city is a capital")
    private boolean isCapital;

    private static List<City> cityList = new ArrayList<>();

    public static List<City> getCityList() {
        return cityList;
    }

    public static void setCityList(List<City> cityList) {
        City.cityList = cityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }
}
