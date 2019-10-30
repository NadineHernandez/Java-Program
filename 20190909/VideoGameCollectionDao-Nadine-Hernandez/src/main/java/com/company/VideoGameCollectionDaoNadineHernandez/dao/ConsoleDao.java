package com.company.VideoGameCollectionDaoNadineHernandez.dao;

import com.company.VideoGameCollectionDaoNadineHernandez.models.Console;

import java.util.List;

public interface ConsoleDao {
    Console createConsole(Console console);
    Console readConsole(int id);
    List<Console> readAllConsole();
    void updateConsole(Console console);
    void deleteConsole(int id);
}
