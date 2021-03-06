package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.Game;

import java.util.List;

public interface GameDao {
    Game addGame(Game game);
    Game getGame(int id);
    List<Game> getAllGames();
    void updateGame(Game game);
    void deleteGame(int id);
    List<Game> findGamesByStudio(String studio);
    List<Game> findGamesByESRB(String esrb_rating);
    List<Game> findGamesByTitle(String title);
}
