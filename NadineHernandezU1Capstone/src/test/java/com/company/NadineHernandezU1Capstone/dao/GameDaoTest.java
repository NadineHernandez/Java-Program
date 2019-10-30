package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        //create a list of all games
        List<Game> gameList = gameDao.getAllGames();

        //for each game in the list, delete that game from the db
        for(Game game : gameList){
            gameDao.deleteGame(game.getGame_id());
        }
    }

    @Test
    public void addGame() {
        //create new game
        Game game = new Game();
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(25);
        //add game to db
        game = gameDao.addGame(game);

        //assert that local game matches game in db
        assertEquals(game, gameDao.getGame(game.getGame_id()));
    }

    @Test
    public void getGame() {
        //create new game
        Game game = new Game();
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(25);
        //add game to db
        game = gameDao.addGame(game);

        //assert that local game matches game in db
        assertEquals(game, gameDao.getGame(game.getGame_id()));
    }

    @Test
    public void getAllGames() {
        //create new game
        Game game = new Game();
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(25);
        //add game to db
        gameDao.addGame(game);

        //create second new game
        Game game1 = new Game();
        game1.setTitle("God of War");
        game1.setEsrb_rating("M");
        game1.setDescription("He has a son this time");
        game1.setPrice(new BigDecimal("39.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(20);
        //add game to db
        gameDao.addGame(game1);

        //assert that there are now 2 games in the db
        assertEquals(2, gameDao.getAllGames().size());
    }

    @Test
    public void updateGame() {
        //create new game
        Game game = new Game();
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(25);
        //add game to db
        game = gameDao.addGame(game);

        //give new values to game
        game.setTitle("God of War");
        game.setEsrb_rating("M");
        game.setDescription("He has a son this time");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(20);
        //update game in db
        gameDao.updateGame(game);

        //assert that local game and update game in db match
        assertEquals(game, gameDao.getGame(game.getGame_id()));
    }

    @Test
    public void deleteGame() {
        //create new game
        Game game = new Game();
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(25);
        //add game to db
        game = gameDao.addGame(game);

        //assert that game is in db
        assertEquals(game, gameDao.getGame(game.getGame_id()));
        //delete game from db
        gameDao.deleteGame(game.getGame_id());
        //assert that game is no longer in db
        assertNull(gameDao.getGame(game.getGame_id()));
    }

    @Test
    public void findGamesByStudio() {
        //create new game
        Game game = new Game();
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(25);
        //add game to db
        gameDao.addGame(game);

        //create second new game
        Game game1 = new Game();
        game1.setTitle("God of War");
        game1.setEsrb_rating("M");
        game1.setDescription("He has a son this time");
        game1.setPrice(new BigDecimal("39.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(20);
        //add game to db
        gameDao.addGame(game1);

        //assert that there are now 2 games in the db with the same Studio
        assertEquals(2, gameDao.findGamesByStudio(game.getStudio()).size());
    }

    @Test
    public void findGamesByESRB() {
        //create new game
        Game game = new Game();
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(25);
        //add game to db
        gameDao.addGame(game);

        //create second new game
        Game game1 = new Game();
        game1.setTitle("Super Smash Brother Brawl");
        game1.setEsrb_rating("PG-13");
        game1.setDescription("Fight your friends Crossover");
        game1.setPrice(new BigDecimal("49.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(35);
        //add game to db
        gameDao.addGame(game1);

        //assert that there are now 2 games in the db with the same esrb rating
        assertEquals(2, gameDao.findGamesByESRB(game.getEsrb_rating()).size());
    }

    @Test
    public void findGamesByTitle() {
        //create new game
        Game game = new Game();
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(25);
        //add game to db
        gameDao.addGame(game);

        //create second new game
        Game game1 = new Game();
        game1.setTitle("Super Smash Brother Brawl");
        game1.setEsrb_rating("PG-13");
        game1.setDescription("Fight your friends Crossover");
        game1.setPrice(new BigDecimal("49.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(35);
        //add game to db
        gameDao.addGame(game1);

        //assert that there is now 1 game in the db titled Breath of the Wild
        assertEquals(1, gameDao.findGamesByTitle(game.getTitle()).size());
    }
}