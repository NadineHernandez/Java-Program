package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao{

    //prepared statements
    private static final String INSERT_CONSOLE_SQL =
            "INSERT INTO console (model, manufacturer, memory_amount, processor, price, quantity)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_CONSOLE_SQL =
            "SELECT * FROM console WHERE console_id = ?";

    private static final String SELECT_ALL_CONSOLES_SQL =
            "SELECT * FROM console";

    private static final String UPDATE_CONSOLE_SQL =
            "UPDATE console SET model = ?, manufacturer = ?, memory_amount = ?, processor = ?," +
                    " price = ?, quantity = ? WHERE console_id = ?";

    private static final String DELETE_CONSOLE_SQL =
            "DELETE FROM console WHERE console_id = ?";

    private static final String SELECT_CONSOLES_BY_MANUFACTURER =
            "SELECT * FROM console WHERE manufacturer = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Console addConsole(Console console) {
        jdbcTemplate.update(INSERT_CONSOLE_SQL, console.getModel(), console.getManufacturer(), console.getMemory_amount(),
                console.getProcessor(), console.getPrice(), console.getQuantity());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        console.setConsole_id(id);
        return console;
    }

    @Override
    public Console getConsole(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::mapRowToConsole, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Console> getAllConsoles() {
        return jdbcTemplate.query(SELECT_ALL_CONSOLES_SQL, this::mapRowToConsole);
    }

    @Override
    public void updateConsole(Console console) {
        jdbcTemplate.update(UPDATE_CONSOLE_SQL, console.getModel(), console.getManufacturer(), console.getMemory_amount(),
                console.getProcessor(), console.getPrice(), console.getQuantity(), console.getConsole_id());
    }

    @Override
    public void deleteConsole(int id) {
        jdbcTemplate.update(DELETE_CONSOLE_SQL, id);
    }

    @Override
    public List<Console> findConsolesByManufacturer(String manufacturer) {
        return jdbcTemplate.query(SELECT_CONSOLES_BY_MANUFACTURER, this::mapRowToConsole, manufacturer);
    }

    public Console mapRowToConsole(ResultSet rs, int rowNum) throws SQLException {
        Console console = new Console();
        console.setConsole_id(rs.getInt("console_id"));
        console.setModel(rs.getString("model"));
        console.setManufacturer(rs.getString("manufacturer"));
        console.setMemory_amount(rs.getString("memory_amount"));
        console.setProcessor(rs.getString("processor"));
        console.setPrice(rs.getBigDecimal("price"));
        console.setQuantity(rs.getInt("quantity"));

        return console;
    }
}
