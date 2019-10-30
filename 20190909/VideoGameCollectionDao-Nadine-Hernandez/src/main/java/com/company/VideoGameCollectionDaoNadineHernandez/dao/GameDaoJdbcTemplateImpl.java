package com.company.VideoGameCollectionDaoNadineHernandez.dao;

import com.company.VideoGameCollectionDaoNadineHernandez.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcTemplateImpl implements GameDao{

    private static final String INSERT_GAME_SQL =
            "INSERT INTO game (console_id, publisher_id, type_id) VALUES (?, ?, ?)";

    private static final String SELECT_GAME_SQL =
            "SELECT * FROM game WHERE game_id = ?";

    private static final String SELECT_ALL_GAMES_SQL =
            "SELECT * FROM game";

    private static final String DELETE_GAME_SQL =
            "DELETE FROM game WHERE game_id = ?";

    private static final String UPDATE_GAME_SQL =
            "UPDATE game SET console_id = ?, publisher_id = ?, type_id = ? WHERE game_id = ?";

    private static final String SELECT_GAMES_BY_CONSOLE_SQL =
            "SELECT * FROM game WHERE console = ?";

    private static final String SELECT_GAMES_BY_PUBLISHER_SQL =
            "SELECT * FROM game WHERE publisher = ?";

    private static final String SELECT_GAMES_BY_TYPE_SQL =
            "SELECT * FROM game WHERE type = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Game createGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL, game.getConsole_id(), game.getPublisher_id(), game.getType_id());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        game.setGame_id(id);
        return game;
    }

    @Override
    public Game readGame(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Game> readAllGame() {
        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(UPDATE_GAME_SQL, game.getConsole_id(), game.getPublisher_id(), game.getType_id(), game.getGame_id());
    }

    @Override
    public void deleteGame(int id) {
        jdbcTemplate.update(DELETE_GAME_SQL, id);
    }

    @Override
    public List<Game> findGameByConsole(int console_id) {
        return jdbcTemplate.query(SELECT_GAMES_BY_CONSOLE_SQL, this::mapRowToGame, console_id);
    }

    @Override
    public List<Game> findGameByPublisher(int publisher_id) {
        return jdbcTemplate.query(SELECT_GAMES_BY_PUBLISHER_SQL, this::mapRowToGame, publisher_id);
    }

    @Override
    public List<Game> findGameByType(int type_id) {
        return jdbcTemplate.query(SELECT_GAMES_BY_TYPE_SQL, this::mapRowToGame, type_id);
    }

    public Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGame_id(rs.getInt("game_id"));
        game.setConsole_id(rs.getInt("console_id"));
        game.setPublisher_id(rs.getInt("publisher_id"));
        game.setType_id(rs.getInt("type_id"));

        return game;
    }
}
