package com.company.CarLotDaoNadineHernandez.dao;

import com.company.CarLotDaoNadineHernandez.model.Car;

import java.util.List;

public interface CarLotDao {
    Car createCar(Car car);

    Car readCar(int id);

    List<Car> readAll();

    void updateCar(Car car);

    void deleteCar(int id);

    List<Car> findCarByMake(String make);

    List<Car> findCarByColor(String color);
}
