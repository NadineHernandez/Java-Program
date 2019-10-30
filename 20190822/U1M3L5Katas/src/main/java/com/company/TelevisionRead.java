package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601Utils;
import org.w3c.dom.ls.LSOutput;


public class TelevisionRead {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> teleList;

            teleList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });

            System.out.println("Screen Sizes Over 60inch");
            int screenSize = 60;

            teleList.stream()
                    .filter(screen->screen.getScreenSize() > 60)
                    .forEach(screen-> {
                        System.out.println(screen.getScreenSize());
                    });

            System.out.println("Brands: ");
            Map<String, List<Television>> groupedTV =
            teleList.stream()
                    .collect(Collectors.groupingBy(brand->brand.getBrand()));

            Set<String> keys = groupedTV.keySet();

            for(String key:keys){
                System.out.println(key);
            }

            double avgScreen =
                    teleList.stream()
                    .mapToInt(screen->screen.getScreenSize())
                    .average()
                    .getAsDouble();

            System.out.println("Average Screen Size: " + avgScreen);

            int biggestScreen =
                    teleList.stream()
                    .mapToInt(screen->screen.getScreenSize())
                    .max()
                    .getAsInt();

            System.out.println("Biggest Screen: " + biggestScreen);

            System.out.println("Sorted Screens: ");
            List<Integer> myScreenList = new ArrayList<>();

            Map<Integer, List<Television>> screensOfTV =
                    teleList.stream()
                            .collect(Collectors.groupingBy(screen->screen.getScreenSize()));

            Set<Integer> keyz = screensOfTV.keySet();

            for(Integer key:keyz){
                myScreenList.add(key);
            }

            myScreenList.stream()
                    .sorted()
                    .forEach(screen->{
                        System.out.println(screen);
                    });


        } catch (IOException e) {
            System.out.println("ERROR encountered reading JSON file: " + e.getMessage());
        }
    }
}
