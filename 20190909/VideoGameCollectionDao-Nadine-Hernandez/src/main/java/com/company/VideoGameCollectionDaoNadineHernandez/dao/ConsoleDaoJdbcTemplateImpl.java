package com.company.VideoGameCollectionDaoNadineHernandez.dao;

import com.company.VideoGameCollectionDaoNadineHernandez.models.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao{

    private static final String INSERT_CONSOLE_SQL =
            "INSERT INTO console (name, year) VALUES (?, ?)";

    private static final String SELECT_CONSOLE_SQL =
            "SELECT * FROM console WHERE console_id = ?";

    private static final String SELECT_ALL_CONSOLES_SQL =
            "SELECT * FROM console";

    private static final String DELETE_CONSOLE_SQL =
            "DELETE FROM console WHERE console_id = ?";

    private static final String UPDATE_CONSOLE_SQL =
            "UPDATE console SET name = ?, year = ? WHERE console_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Console createConsole(Console console) {
        jdbcTemplate.update(INSERT_CONSOLE_SQL, console.getName(), console.getYear());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        console.setConsole_id(id);
        return console;
    }

    @Override
    public Console readConsole(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::mapRowToConsole, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Console> readAllConsole() {
        return jdbcTemplate.query(SELECT_ALL_CONSOLES_SQL, this::mapRowToConsole);
    }

    @Override
    public void updateConsole(Console console) {
        jdbcTemplate.update(UPDATE_CONSOLE_SQL, console.getName(), console.getYear(), console.getConsole_id());
    }

    @Override
    public void deleteConsole(int id) {
        jdbcTemplate.update(DELETE_CONSOLE_SQL, id);
    }

    public Console mapRowToConsole(ResultSet rs, int rowNum) throws SQLException {
        Console console = new Console();
        console.setConsole_id(rs.getInt("console_id"));
        console.setName(rs.getString("name"));
        console.setYear(rs.getString("year"));

        return console;
    }
}
