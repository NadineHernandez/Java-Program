public class ConverterIf implements Converter {

    //method takes in integer and uses it in an if/else statement
    public String convertMonth(int monthNumber) {
        //compares monthNumber to each number 1-12 and returns a String with the corresponding month
        if (monthNumber == 1) {
            return "January";
        } else if (monthNumber == 2) {
            return "February";
        } else if (monthNumber == 3) {
            return "March";
        } else if (monthNumber == 4) {
            return "April";
        } else if (monthNumber == 5) {
            return "May";
        } else if (monthNumber == 6) {
            return "June";
        } else if (monthNumber == 7) {
            return "July";
        } else if (monthNumber == 8) {
            return "August";
        } else if (monthNumber == 9) {
            return "September";
        } else if (monthNumber == 10) {
            return "October";
        } else if (monthNumber == 11) {
            return "November";
        } else if (monthNumber == 12) {
            return "December";
        } else {
            //if there is no match then returns invalid entry message
            return "Invalid entry. Please enter a number between 1 and 12.";
        }
    }

    //method takes in integer and uses it in an if/else statement
    public String convertDay(int dayNumber) {
        //compares dayNumber to each number 1-7 and returns a String with the corresponding day
        if (dayNumber == 1) {
            return "Sunday";
        } else if (dayNumber == 2) {
            return "Monday";
        } else if (dayNumber == 3) {
            return "Tuesday";
        } else if (dayNumber == 4) {
            return "Wednesday";
        } else if (dayNumber == 5) {
            return "Thursday";
        } else if (dayNumber == 6) {
            return "Friday";
        } else if (dayNumber == 7) {
            return "Saturday";
        } else {
            //if there is no match then returns invalid entry message
            return "Invalid entry. Please enter a number between 1 and 7.";
        }
    }
}
