public class ConverterSwitch implements Converter{

    //method takes in integer and uses it in the switch case statement
    public String convertMonth(int monthNumber) {
        //String created to hold the resulting month because a return will result in unreachable code
        String converted;
        //switch will identify the matching case and assign converted the corresponding month string
        switch (monthNumber){
            case 1:
                converted = "January";
                break;
            case 2:
                converted = "February";
                break;
            case 3:
                converted = "March";
                break;
            case 4:
                converted = "April";
                break;
            case 5:
                converted = "May";
                break;
            case 6:
                converted = "June";
                break;
            case 7:
                converted = "July";
                break;
            case 8:
                converted = "August";
                break;
            case 9:
                converted = "September";
                break;
            case 10:
                converted = "October";
                break;
            case 11:
                converted = "November";
                break;
            case 12:
                converted = "December";
                break;
            default:
                //if there is no case match that converted is invalid entry message
                converted = "Invalid entry. Please enter a number between 1 and 12.";
                break;
        }
        //now assigned string is returned
        return converted;
    }

    //method takes in integer and uses it in the switch case statement
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
