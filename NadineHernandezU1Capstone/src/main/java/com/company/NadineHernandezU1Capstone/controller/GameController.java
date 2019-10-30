package com.company.NadineHernandezU1Capstone.controller;

import com.company.NadineHernandezU1Capstone.dto.Game;
import com.company.NadineHernandezU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game){
        return serviceLayer.saveGame(game);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames(){
        try {int tester = serviceLayer.findAllGames().get(0).getGame_id();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Games not found", e);
        }
        return serviceLayer.findAllGames();
    }

    @RequestMapping(value = "/{game_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Game getGame(@PathVariable int game_id){
        try {int tester = serviceLayer.findGame(game_id).getGame_id();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Game not found", e);
        }
        return serviceLayer.findGame(game_id);
    }

    @RequestMapping(value = "/{game_id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateGame(@PathVariable int game_id, @RequestBody @Valid Game game){
        game.setGame_id(game_id);
        serviceLayer.updateGame(game);
    }

    @RequestMapping(value = "/{game_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteGame(@PathVariable int game_id){
        serviceLayer.removeGame(game_id);
    }

    @RequestMapping(value = "/studio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> findGamesByStudio(@PathVariable String studio){
        try {int tester = serviceLayer.findGamesByStudio(studio).get(0).getGame_id();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Games not found", e);
        }
        return serviceLayer.findGamesByStudio(studio);
    }

    @RequestMapping(value = "/esrb/{esrb_rating}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> findGamesByEsrb(@PathVariable String esrb_rating){
        try {int tester = serviceLayer.findGamesByESRB(esrb_rating).get(0).getGame_id();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Games not found", e);
        }
        return serviceLayer.findGamesByESRB(esrb_rating);
    }

    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> findGamesByTitle(@PathVariable String title){
        try {int tester = serviceLayer.findGamesByTitle(title).get(0).getGame_id();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Games not found", e);
        }
        return serviceLayer.findGamesByTitle(title);
    }
}
