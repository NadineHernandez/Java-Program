import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public void read(){
        try{
            ObjectMapper mapper = new ObjectMapper();

            List<Car> tempCarList;

            tempCarList = mapper.readValue(new File("car.json"), new TypeReference<List<Car>>(){});

            for (Car carz: tempCarList){
                Car.getCarList().add(new Car(carz.getMake(), carz.getModel(), carz.getYear(), carz.getColor(), carz.getMileage()));
            }

        }catch (IOException e){
            System.out.println("Error: Problem encountered reading JSON file: " + e.getMessage());
        }
    }

    public void write(List<Car> carList){
        PrintWriter writer = null;
        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonCarList = mapper.writeValueAsString(carList);

            writer = new PrintWriter(new FileWriter("car.json"));
            writer.println(jsonCarList);
        }catch (JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }

    public void start(){

        read();
        showInitialOptions();
    }

    public void showInitialOptions(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------");
        System.out.println("Welcome to Car Inventory Management.");
        System.out.println("------------------------------------");
        System.out.println("Select an action by entering a number: ");
        System.out.println("1. Add new car");
        System.out.println("2. Delete a car");
        System.out.println("3. List all cars");
        System.out.println("4. Search by attribute");
        System.out.println("5. Exit Program");

        int userNum = Integer.parseInt(scanner.nextLine());
        chooseInitial(userNum);
    }

    public void showSearchOptions(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------");
        System.out.println("Select a search option by entering a number: ");
        System.out.println("1. Make");
        System.out.println("2. Model");
        System.out.println("3. Year");
        System.out.println("4. Color");
        System.out.println("5. Mileage");
        System.out.println("6. Exit");
        int userNum = Integer.parseInt(scanner.nextLine());
        chooseSearch(userNum);
    }

    public void chooseInitial(int userNum){

        //switchcase
        switch (userNum){
            case 1:
                addCar();
                break;
            case 2:
                deleteCar();
                break;
            case 3:
                listAllCars();
                break;
            case 4:
                showSearchOptions();
                break;
            case 5:
                terminateProgram();
                break;
            default:
                System.out.println("enter a number between 1 and 5");
        }

    }

    public void chooseSearch(int userNum){
        //switchcase
        switch (userNum){
            case 1:
                searchBy("make");
                break;
            case 2:
                searchBy("model");
                break;
            case 3:
                searchBy("year");
                break;
            case 4:
                searchBy("color");
                break;
            case 5:
                searchBy("mileage");
                break;
            case 6:
                showInitialOptions();
                break;
            default:
                System.out.println("Enter a number between 1 and 5");
        }
    }

    public void addCar(){
        Scanner scanner = new Scanner(System.in);

        Car car = new Car();
        System.out.println("------------------------------------");
        System.out.println("Adding a car.");
        System.out.println("Enter a make");
        car.setMake(scanner.nextLine().toLowerCase());
        System.out.println("Enter a model");
        car.setModel(scanner.nextLine().toLowerCase());
        System.out.println("Enter a year");
        car.setYear(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter a color");
        car.setColor(scanner.nextLine().toLowerCase());
        System.out.println("Enter a mileage");
        car.setMileage(Integer.parseInt(scanner.nextLine()));

        Car.getCarList().add(car);
        System.out.println("Car added");

        showInitialOptions();
    }

    public void deleteCar(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------");
        System.out.println("Enter the number of the car you'd like to delete.");
        for (Car car: Car.getCarList()){
            System.out.println((Car.getCarList().indexOf(car) + 1)+ ". " +"Make: " + car.getMake() + " | Model: " + car.getModel() + " | Year: " + car.getYear()
                    + " | Color: " + car.getColor() + " | Mileage: " + car.getMileage());
        }
        int userInput = Integer.parseInt(scanner.nextLine()) - 1;
        Car car;
        car = Car.getCarList().get(userInput);
        System.out.println("Removing Car: ");
        System.out.println("Make: " + car.getMake() + " | Model: " + car.getModel() + " | Year: " + car.getYear()
                + " | Color: " + car.getColor() + " | Mileage: " + car.getMileage());
        Car.getCarList().remove(userInput);

        showInitialOptions();
    }

    public void listAllCars(){
        System.out.println("------------------------------------");
        for (Car car: Car.getCarList()) {
            System.out.println("Make: " + car.getMake() + " | Model: " + car.getModel() + " | Year: " + car.getYear()
                    + " | Color: " + car.getColor() + " | Mileage: " + car.getMileage());
        }

            showInitialOptions();
    }

    public void searchBy(String userInput){
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------");
        switch (userInput){
            case "make":
                System.out.println("Enter a make: ");
                String userMake = scanner.nextLine();
                Car.getCarList().stream()
                        .filter(make->make.getMake() .equals(userMake))
                        .forEach(make->{
                            System.out.println("Make: " + make.getMake() + " | Model: " + make.getModel() + " | Year: " + make.getYear()
                                    + " | Color: " + make.getColor() + " | Mileage: " + make.getMileage());
                        });
                break;
            case "model":
                System.out.println("Enter a model: ");
                String userModel = scanner.nextLine();
                Car.getCarList().stream()
                        .filter(make->make.getModel() .equals(userModel))
                        .forEach(make->{
                            System.out.println("Make: " + make.getMake() + " | Model: " + make.getModel() + " | Year: " + make.getYear()
                                    + " | Color: " + make.getColor() + " | Mileage: " + make.getMileage());
                        });
                break;
            case "year":
                System.out.println("Enter a year: ");
                int userYear = Integer.parseInt(scanner.nextLine());
                Car.getCarList().stream()
                        .filter(year->year.getYear() == (userYear))
                        .forEach(year->{
                            System.out.println("Make: " + year.getMake() + " | Model: " + year.getModel() + " | Year: " + year.getYear()
                                    + " | Color: " + year.getColor() + " | Mileage: " + year.getMileage());
                        });
                break;
            case "color":
                System.out.println("Enter a color: ");
                String userColor = scanner.nextLine();
                Car.getCarList().stream()
                        .filter(color->color.getColor() .equals(userColor))
                        .forEach(color->{
                            System.out.println("Make: " + color.getMake() + " | Model: " + color.getModel() + " | Year: " + color.getYear()
                                    + " | Color: " + color.getColor() + " | Mileage: " + color.getMileage());
                        });
                break;
            case "mileage":
                System.out.println("Enter a maximum milieage: ");
                int userMile = Integer.parseInt(scanner.nextLine());
                Car.getCarList().stream()
                        .filter(mile->mile.getMileage() < (userMile))
                        .forEach(mile->{
                            System.out.println("Make: " + mile.getMake() + " | Model: " + mile.getModel() + " | Year: " + mile.getYear()
                                    + " | Color: " + mile.getColor() + " | Mileage: " + mile.getMileage());
                        });
                break;
            default:
                System.out.println("There was an error in processing.");
                showInitialOptions();
        }
        showInitialOptions();
    }

    public void terminateProgram(){
        write(Car.getCarList());
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }
}
