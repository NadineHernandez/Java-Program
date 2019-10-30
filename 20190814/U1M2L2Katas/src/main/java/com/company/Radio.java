package com.company;

public class Radio {
    private String manufacturer;
    private String model;
    private int numSpeakers;
    private String station;
    private int volume;
    private boolean powered;

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumSpeakers(int numSpeakers) {
        this.numSpeakers = numSpeakers;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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

    public int getNumSpeakers() {
        return numSpeakers;
    }

    public String getStation() {
        return station;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPowered() {
        return powered;
    }

    public void togglePower() {
        if (this.powered == false) {
            this.powered = true;
        } else {
            this.powered = false;
        }
    }

    public static void main(String[] args) {

    }

    public Radio(String manufacturer, String model, int numSpeakers, String station, int volume, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.numSpeakers = numSpeakers;
        this.station = station;
        this.volume = volume;
        this.powered = powered;

    }
}
