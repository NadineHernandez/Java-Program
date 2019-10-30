package com.company.VideoGameCollectionDaoNadineHernandez.dao;

import com.company.VideoGameCollectionDaoNadineHernandez.models.Game;

import java.util.List;

public interface GameDao {
    Game createGame(Game game);
    Game readGame(int id);
    List<Game> readAllGame();
    void updateGame(Game game);
    void deleteGame(int id);
    List<Game> findGameByConsole(int console_id);
    List<Game> findGameByPublisher(int publisher_id);
    List<Game> findGameByType(int type_id);
}
