package com.company;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TelevisionReader {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> teleList;

            teleList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });

            for (Television tele : teleList) {
                System.out.println(tele.getBrand() + " " + tele.getModel() + " " + tele.getPrice() + " " + tele.getScreenSize());
            }

        } catch (IOException e) {
            System.out.println("ERROR encountered reading JSON file: " + e.getMessage());
        }
    }
}
