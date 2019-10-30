package com.company;
import java.util.*;

public class App {

    public void printKeys(Map myMap){
        Set<String> myKeys = myMap.keySet();
        myKeys = myMap.keySet();
        for (String key: myKeys) {
            System.out.println(key);
        }
    }

    public void printValues(Map myMap){
        Set<String> myKeys = myMap.keySet();
        myKeys = myMap.keySet();
        for (String key: myKeys) {
            System.out.println(myMap.get(key));
        }
    }

    public void printKeysAndValues(Map myMap){
        Set<String> myKeys = myMap.keySet();
        myKeys = myMap.keySet();
        for (String key: myKeys) {
            System.out.println(key + ": " + myMap.get(key));
        }
    }

    public Map mapFun (Map myMap){

        myMap.put("Ford Explorer", 2012);
        myMap.put("Smart Fortwo", 2013);
        myMap.remove("Jeep Wrangler");
        return myMap;
    }

    public Map listCars(List<Car> carList){
        List<Car> toyotaList = new ArrayList<>();
        List<Car> fordList = new ArrayList<>();
        List<Car> hondaList = new ArrayList<>();

        for(int i = 0; i < carList.size(); i++){
            Car currentCar = carList.get(i);
            if(currentCar.getMake().equals("Toyota")){
                toyotaList.add(currentCar);
            }
        }

        for(int i = 0; i < carList.size(); i++){
            Car currentCar = carList.get(i);
            if(currentCar.getMake().equals("Ford")){
                fordList.add(currentCar);
            }
        }

        for(int i = 0; i < carList.size(); i++){
            Car currentCar = carList.get(i);
            if(currentCar.getMake().equals("Honda")){
                hondaList.add(currentCar);
            }
        }

        Map<String, List> carsMap = new HashMap<>();
        carsMap.put("Toyota", toyotaList);
        carsMap.put("Ford", fordList);
        carsMap.put("Honda", hondaList);

        return carsMap;
    }

    
}
