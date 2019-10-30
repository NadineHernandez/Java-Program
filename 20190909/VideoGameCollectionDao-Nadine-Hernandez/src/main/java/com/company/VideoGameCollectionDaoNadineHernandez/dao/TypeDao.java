package com.company.VideoGameCollectionDaoNadineHernandez.dao;

import com.company.VideoGameCollectionDaoNadineHernandez.models.Type;

import java.util.List;

public interface TypeDao {
    Type createType(Type type);
    Type readType(int id);
    List<Type> readAllType();
    void updateType(Type type);
    void deleteType(int id);
}
