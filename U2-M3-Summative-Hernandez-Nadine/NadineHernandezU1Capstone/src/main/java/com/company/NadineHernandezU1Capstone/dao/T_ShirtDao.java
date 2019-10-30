package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.T_Shirt;

import java.util.List;

public interface T_ShirtDao {
    T_Shirt addT_Shirt(T_Shirt t_shirt);
    T_Shirt getT_Shirt(int id);
    List<T_Shirt> getAllT_Shirts();
    void updateT_Shirt(T_Shirt t_shirt);
    void deleteT_Shirt(int id);
    List<T_Shirt> findT_ShirtsByColor(String color);
    List<T_Shirt> findT_ShirtsBySize(String size);
}
