package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcTemplateImpl implements GameDao{

    //prepared statements
    private static final String INSERT_GAME_SQL =
            "INSERT INTO game (title, esrb_rating, description, price, studio, quantity)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_GAME_SQL =
            "SELECT * FROM game WHERE game_id = ?";

    private static final String SELECT_ALL_GAMES_SQL =
            "SELECT * FROM game";

    private static final String UPDATE_GAME_SQL =
            "UPDATE game SET title = ?, esrb_rating = ?, description = ?, price = ?," +
                    " studio = ?, quantity = ? WHERE game_id = ?";

    private static final String DELETE_GAME_SQL =
            "DELETE FROM game WHERE game_id = ?";

    private static final String SELECT_GAMES_BY_STUDIO =
            "SELECT * FROM game WHERE studio = ?";

    private static final String SELECT_GAMES_BY_ESRB =
            "SELECT * FROM game WHERE esrb_rating = ?";

    private static final String SELECT_GAMES_BY_TITLE =
            "SELECT * FROM game WHERE title = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Game addGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL, game.getTitle(), game.getEsrb_rating(), game.getDescription(),
                game.getPrice(), game.getStudio(), game.getQuantity());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        game.setGame_id(id);
        return game;
    }

    @Override
    public Game getGame(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Game> getAllGames() {
        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(UPDATE_GAME_SQL, game.getTitle(), game.getEsrb_rating(), game.getDescription(),
                game.getPrice(), game.getStudio(), game.getQuantity(), game.getGame_id());
    }

    @Override
    public void deleteGame(int id) {
        jdbcTemplate.update(DELETE_GAME_SQL, id);
    }

    @Override
    public List<Game> findGamesByStudio(String studio) {
        return jdbcTemplate.query(SELECT_GAMES_BY_STUDIO, this::mapRowToGame, studio);
    }

    @Override
    public List<Game> findGamesByESRB(String esrb_rating) {
        return jdbcTemplate.query(SELECT_GAMES_BY_ESRB, this::mapRowToGame, esrb_rating);
    }

    @Override
    public List<Game> findGamesByTitle(String title) {
        return jdbcTemplate.query(SELECT_GAMES_BY_TITLE, this::mapRowToGame, title);
    }

    public Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGame_id(rs.getInt("game_id"));
        game.setTitle(rs.getString("title"));
        game.setEsrb_rating(rs.getString("esrb_rating"));
        game.setDescription(rs.getString("description"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setStudio(rs.getString("studio"));
        game.setQuantity(rs.getInt("quantity"));

        return game;
    }
}
