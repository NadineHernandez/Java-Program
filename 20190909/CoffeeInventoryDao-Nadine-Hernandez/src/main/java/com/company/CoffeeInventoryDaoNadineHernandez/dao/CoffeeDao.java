package com.company.CoffeeInventoryDaoNadineHernandez.dao;

import com.company.CoffeeInventoryDaoNadineHernandez.models.Coffee;

import java.util.List;

public interface CoffeeDao {
    Coffee createCoffee(Coffee coffee);
    Coffee readCoffee(int id);
    List<Coffee> readAllCoffee();
    void updateCoffee(Coffee coffee);
    void deleteCoffee(int id);
    List<Coffee> findCoffeeByRoasterID(int roasterID);
    List<Coffee> findCoffeeByTypeID(String type);
}
