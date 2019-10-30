package com.company.CoffeeInventoryDaoNadineHernandez.dao;

import com.company.CoffeeInventoryDaoNadineHernandez.models.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoffeeDaoJdbcTemplateImpl implements CoffeeDao{

    private static final String INSERT_COFFEE_SQL =
            "INSERT INTO coffee (roaster_id, name, count, unit_price, description, type) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_COFFEE_SQL =
            "SELECT * FROM coffee WHERE coffee_id = ?";

    private static final String SELECT_ALL_COFFEES_SQL =
            "SELECT * FROM coffee";

    private static final String DELETE_COFFEE_SQL =
            "DELETE FROM coffee WHERE coffee_id = ?";

    private static final String UPDATE_COFFEE_SQL =
            "UPDATE coffee SET roaster_id = ?, name =?, count = ?, unit_price = ?, description = ?, type = ?" +
                    " WHERE coffee_id = ?";

    private static final String SELECT_COFFEES_BY_ROASTER_SQL =
            "SELECT * FROM coffee WHERE roaster_id = ?";

    private static final String SELECT_COFFEES_BY_TYPE_SQL =
            "SELECT * FROM coffee WHERE type = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CoffeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Coffee createCoffee(Coffee coffee) {
        jdbcTemplate.update(INSERT_COFFEE_SQL, coffee.getRoaster_id(), coffee.getName(), coffee.getCount(), coffee.getUnit_price(), coffee.getDescription(), coffee.getType());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        coffee.setCoffee_id(id);
        return coffee;
    }

    @Override
    public Coffee readCoffee(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_COFFEE_SQL, this::mapRowToCoffee, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Coffee> readAllCoffee() {
        return jdbcTemplate.query(SELECT_ALL_COFFEES_SQL, this::mapRowToCoffee);
    }

    @Override
    public void updateCoffee(Coffee coffee) {
        jdbcTemplate.update(UPDATE_COFFEE_SQL, coffee.getRoaster_id(), coffee.getName(), coffee.getCount(), coffee.getUnit_price(), coffee.getDescription(), coffee.getType(), coffee.getCoffee_id());
    }

    @Override
    public void deleteCoffee(int id) {
        jdbcTemplate.update(DELETE_COFFEE_SQL, id);
    }

    @Override
    public List<Coffee> findCoffeeByRoasterID(int roaster_id) {
        return jdbcTemplate.query(SELECT_COFFEES_BY_ROASTER_SQL, this::mapRowToCoffee, roaster_id);
    }

    @Override
    public List<Coffee> findCoffeeByTypeID(String type) {
        return jdbcTemplate.query(SELECT_COFFEES_BY_TYPE_SQL, this::mapRowToCoffee, type);
    }

    public Coffee mapRowToCoffee(ResultSet rs, int rowNum) throws SQLException {
        Coffee coffee = new Coffee();
        coffee.setCoffee_id(rs.getInt("coffee_id"));
        coffee.setRoaster_id(rs.getInt("roaster_id"));
        coffee.setName(rs.getString("name"));
        coffee.setUnit_price(rs.getDouble("unit_price"));
        coffee.setDescription(rs.getString("description"));
        coffee.setType(rs.getString("type"));

        return coffee;
    }
}
