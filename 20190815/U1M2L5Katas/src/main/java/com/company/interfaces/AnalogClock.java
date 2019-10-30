package com.company.interfaces;

public class AnalogClock implements Clock{
    String time;
    public void displayTime(){
        System.out.println(time);
    }

    public void timer(int hour, int minute){
        time = hour + ":" + minute;
    }
}
