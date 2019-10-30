package com.company.NadineHernandezU1Capstone.controller;

import com.company.NadineHernandezU1Capstone.dao.GameDaoJdbcTemplateImpl;
import com.company.NadineHernandezU1Capstone.dto.Game;
import com.company.NadineHernandezU1Capstone.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer repo;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createGame() throws Exception{
        Game inputGame = new Game();
        inputGame.setTitle("Breath of the Wild");
        inputGame.setEsrb_rating("PG-13");
        inputGame.setDescription("Cooking with Link");
        inputGame.setPrice(new BigDecimal("49.99"));
        inputGame.setStudio("Best Bois Studio");
        inputGame.setQuantity(25);

        String inputJson = mapper.writeValueAsString(inputGame);

        Game outputGame = new Game();
        outputGame.setGame_id(1);
        outputGame.setTitle("Breath of the Wild");
        outputGame.setEsrb_rating("PG-13");
        outputGame.setDescription("Cooking with Link");
        outputGame.setPrice(new BigDecimal("49.99"));
        outputGame.setStudio("Best Bois Studio");
        outputGame.setQuantity(25);

        String outputJson = mapper.writeValueAsString(outputGame);

        when(repo.saveGame(inputGame)).thenReturn(outputGame);

        this.mockMvc.perform(post("/game/")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllGames() throws Exception{
        Game game = new Game();
        game.setGame_id(1);
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(25);

        Game game1 = new Game();
        game.setGame_id(2);
        game1.setTitle("God of War");
        game1.setEsrb_rating("M");
        game1.setDescription("He has a son this time");
        game1.setPrice(new BigDecimal("39.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(20);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);
        gameList.add(game1);

        when(repo.findAllGames()).thenReturn(gameList);

        List<Game> listChecker = new ArrayList<>();
        listChecker.addAll(gameList);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/game/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameThatDoesNotExist404() throws Exception {
        Game game = null;

        int idGameDNE = 1000;

        when(repo.findGame(idGameDNE)).thenReturn(game);

        this.mockMvc.perform(get("/game/" + idGameDNE))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getAllGames404() throws Exception {
        when(repo.findAllGames()).thenReturn(null);

        this.mockMvc.perform(get("/game/"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getGame() throws Exception{
        Game game = new Game();
        game.setGame_id(1);
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(25);

        String outputJson = mapper.writeValueAsString(game);

        when(repo.findGame(1)).thenReturn(game);

        this.mockMvc.perform(get("/game/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void updateGame() throws Exception{
        Game game = new Game();
        game.setGame_id(1);
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(25);

        String inputJson = mapper.writeValueAsString(game);

        this.mockMvc.perform(put("/game/" + game.getGame_id())
        .content(inputJson)
        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteGame() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/game/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void findGamesByStudio() throws Exception{
        Game game = new Game();
        game.setGame_id(1);
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("BestBois");
        game.setQuantity(25);

        Game game1 = new Game();
        game.setGame_id(2);
        game1.setTitle("God of War");
        game1.setEsrb_rating("M");
        game1.setDescription("He has a son this time");
        game1.setPrice(new BigDecimal("39.99"));
        game1.setStudio("BestBois");
        game1.setQuantity(20);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);
        gameList.add(game1);

        when(repo.findGamesByStudio("BestBois")).thenReturn(gameList);

        List<Game> listChecker = new ArrayList<>();
        listChecker.addAll(gameList);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/game/studio/BestBois"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void findGamesByEsrb() throws Exception{
        Game game = new Game();
        game.setGame_id(1);
        game.setTitle("Breath of the Wild Extreme");
        game.setEsrb_rating("M");
        game.setDescription("Violence with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("BestBois");
        game.setQuantity(25);

        Game game1 = new Game();
        game.setGame_id(2);
        game1.setTitle("God of War");
        game1.setEsrb_rating("M");
        game1.setDescription("He has a son this time");
        game1.setPrice(new BigDecimal("39.99"));
        game1.setStudio("BestBois");
        game1.setQuantity(20);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);
        gameList.add(game1);

        when(repo.findGamesByESRB("M")).thenReturn(gameList);

        List<Game> listChecker = new ArrayList<>();
        listChecker.addAll(gameList);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/game/esrb/M"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void findGamesByTitle() throws Exception{
        Game game = new Game();
        game.setGame_id(1);
        game.setTitle("Lonk");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("BestBois");
        game.setQuantity(25);


        List<Game> gameList = new ArrayList<>();
        gameList.add(game);

        when(repo.findGamesByTitle("Lonk")).thenReturn(gameList);

        List<Game> listChecker = new ArrayList<>();
        listChecker.addAll(gameList);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/game/title/Lonk"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void findGamesByStudio404() throws Exception {
        when(repo.findGamesByStudio("BestBois")).thenReturn(null);

        this.mockMvc.perform(get("/game/studio/BestBois"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void findGamesByESRB404() throws Exception {
        when(repo.findGamesByESRB("pg13")).thenReturn(null);

        this.mockMvc.perform(get("/game/esrb_rating/pg13"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}