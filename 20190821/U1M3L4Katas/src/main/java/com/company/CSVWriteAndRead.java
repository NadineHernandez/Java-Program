package com.company;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVWriteAndRead {
    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        try {

            Writer writer = new FileWriter("carList.csv");
            StatefulBeanToCsv beanToCsv = new
                    StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(carList);

            writer.close();

            List<Car> cars = new CsvToBeanBuilder<Car>
                    (new FileReader("carList.csv"))
                    .withType(Car.class).build().parse();

            for (Car myCar : cars) {
                System.out.println(myCar.getYear() + " " + myCar.getMake() + " " + myCar.getModel() + " " + myCar.getColor());
            }
        } catch (CsvRequiredFieldEmptyException e) {
            System.out.println("Required fields empty. " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("There was an error in writing the file. " + e.getMessage());
        } catch (CsvDataTypeMismatchException e) {
            System.out.println("Incorrect data type. " + e.getMessage());
        }
    }
}
