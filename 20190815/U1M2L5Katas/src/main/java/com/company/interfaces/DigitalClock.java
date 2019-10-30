package com.company.interfaces;

public class DigitalClock implements Alarm, Clock{

    String time;

    public void sound() {
        System.out.println("BEEP BEEP BEEP");
    }

    public void displayTime(){
        System.out.println(time);
    }

    public void timer(int hour, int minute){
        time = hour + ":" + minute;
    }
}
