package com.company.dayconverter.model;

public class Day {
    public String convertDay(int dayNumber) {
        //String created to hold the resulting day because a return will result in unreachable code
        String converted;
        //switch will identify the matching case and assign converted the corresponding day string
        switch (dayNumber){
            case 1:
                converted = "Sunday";
                break;
            case 2:
                converted = "Monday";
                break;
            case 3:
                converted = "Tuesday";
                break;
            case 4:
                converted = "Wednesday";
                break;
            case 5:
                converted = "Thursday";
                break;
            case 6:
                converted = "Friday";
                break;
            case 7:
                converted = "Saturday";
                break;
            default:
                //if there is no case match that converted is invalid entry message
                converted = "Invalid entry. Please enter a number between 1 and 7.";
                break;
        }
        //now assigned string is returned
        return converted;
    }
}
