package com.company.CoffeeInventoryDaoNadineHernandez.dao;

import com.company.CoffeeInventoryDaoNadineHernandez.models.Roaster;

import java.util.List;

public interface RoasterDao {
    Roaster createRoaster(Roaster roaster);
    Roaster readRoaster(int id);
    List<Roaster> readAllRoaster();
    void updateRoaster(Roaster roaster);
    void deleteRoaster(int id);
}
