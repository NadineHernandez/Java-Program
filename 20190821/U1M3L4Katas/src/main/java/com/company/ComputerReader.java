package com.company;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ComputerReader {
    public static void main(String[] args) {
        try {
            List<Computers> computers = new CsvToBeanBuilder<Computers>
                    (new FileReader("starter-code/U1M3L4Katas/computers.csv"))
                    .withType(Computers.class).build().parse();

            for(Computers comp : computers){
                System.out.println(comp.getBrand() + " " + comp.getModel() + " " + comp.getCpu() + " " + comp.getRam() + " " + comp.getStorageSize());
            }

        } catch (IOException e){
            System.out.println("There was an error reading the file. " + e.getMessage());
        }
    }
}
