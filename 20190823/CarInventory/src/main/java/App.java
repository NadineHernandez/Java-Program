import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    //ReaderWriter readerWriter = new ReaderWriter();

    public void showInitialOptions(){
        App app = new App();
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------");
        System.out.println("Welcome to Car Inventory Management.");
        System.out.println("------------------------------------");
        System.out.println("Select an action by entering a number: ");
        System.out.println("1. Add new car");
        System.out.println("2. Delete a car");
        System.out.println("3. List all cars");
        System.out.println("4. Search by attribute");

        int userNum = Integer.parseInt(scanner.nextLine());
        app.chooseInitial(userNum);
    }

    public void showSearchOptions(){
        App app = new App();
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
        app.chooseSearch(userNum);
    }

    public void chooseInitial(int userNum){

        App app = new App();
        //switchcase
        switch (userNum){
            case 1:
                app.addCar();
                break;
            case 2:
                app.deleteCar();
                break;
            case 3:
                app.listAllCars();
                break;
            case 4:
                app.showSearchOptions();
                break;
            default:
                System.out.println("enter a number between 1 and 4");
        }

    }

    public void chooseSearch(int userNum){
        App app = new App();
        //switchcase
        switch (userNum){
            case 1:
                app.searchBy("make");
                break;
            case 2:
                app.searchBy("model");
                break;
            case 3:
                app.searchBy("year");
                break;
            case 4:
                app.searchBy("color");
                break;
            case 5:
                app.searchBy("mileage");
                break;
            case 6:
                app.showInitialOptions();
                break;
            default:
                System.out.println("Enter a number between 1 and 5");
        }
    }

    public void addCar(){
        Scanner scanner = new Scanner(System.in);
        App app = new App();

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

        app.showInitialOptions();
    }

    public void deleteCar(){
        Scanner scanner = new Scanner(System.in);
        App app = new App();

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

        app.showInitialOptions();
    }

    public void listAllCars(){
        App app = new App();
        System.out.println("------------------------------------");
        for (Car car: Car.getCarList()){
            System.out.println("Make: " + car.getMake() + " | Model: " + car.getModel() + " | Year: " + car.getYear()
                    + " | Color: " + car.getColor() + " | Mileage: " + car.getMileage());

            app.showInitialOptions();
        }
    }

    public void searchBy(String userInput){
        App app = new App();
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
                app.showInitialOptions();
        }
        app.showInitialOptions();
    }

    public static void main(String[] args) {
        App app = new App();
        app.showInitialOptions();
    }
}
