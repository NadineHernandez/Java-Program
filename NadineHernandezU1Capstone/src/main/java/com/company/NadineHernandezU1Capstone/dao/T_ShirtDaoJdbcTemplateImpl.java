package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.T_Shirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class T_ShirtDaoJdbcTemplateImpl implements T_ShirtDao{

    //prepared statements
    private static final String INSERT_T_SHIRT_SQL =
            "INSERT INTO t_shirt (size, color, description, price, quantity)" +
                    " VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_T_SHIRT_SQL =
            "SELECT * FROM t_shirt WHERE t_shirt_id = ?";

    private static final String SELECT_ALL_T_SHIRTS_SQL =
            "SELECT * FROM t_shirt";

    private static final String UPDATE_T_SHIRT_SQL =
            "UPDATE t_shirt SET size = ?, color = ?, description = ?, price = ?," +
                    " quantity = ? WHERE t_shirt_id = ?";

    private static final String DELETE_T_SHIRT_SQL =
            "DELETE FROM t_shirt WHERE t_shirt_id = ?";

    private static final String SELECT_T_SHIRTS_BY_COLOR =
            "SELECT * FROM t_shirt WHERE color = ?";

    private static final String SELECT_T_SHIRTS_BY_SIZE =
            "SELECT * FROM t_shirt WHERE size = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public T_ShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public T_Shirt addT_Shirt(T_Shirt t_shirt) {
        jdbcTemplate.update(INSERT_T_SHIRT_SQL, t_shirt.getSize(), t_shirt.getColor(), t_shirt.getDescription(),
                t_shirt.getPrice(), t_shirt.getQuantity());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        t_shirt.setT_shirt_id(id);
        return t_shirt;
    }

    @Override
    public T_Shirt getT_Shirt(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_T_SHIRT_SQL, this::mapRowToT_Shirt, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<T_Shirt> getAllT_Shirts() {
        return jdbcTemplate.query(SELECT_ALL_T_SHIRTS_SQL, this::mapRowToT_Shirt);
    }

    @Override
    public void updateT_Shirt(T_Shirt t_shirt) {
        jdbcTemplate.update(UPDATE_T_SHIRT_SQL, t_shirt.getSize(), t_shirt.getColor(), t_shirt.getDescription(),
                t_shirt.getPrice(), t_shirt.getQuantity(), t_shirt.getT_shirt_id());
    }

    @Override
    public void deleteT_Shirt(int id) {
        jdbcTemplate.update(DELETE_T_SHIRT_SQL, id);
    }

    @Override
    public List<T_Shirt> findT_ShirtsByColor(String color) {
        return jdbcTemplate.query(SELECT_T_SHIRTS_BY_COLOR, this::mapRowToT_Shirt, color);
    }

    @Override
    public List<T_Shirt> findT_ShirtsBySize(String size) {
        return jdbcTemplate.query(SELECT_T_SHIRTS_BY_SIZE, this::mapRowToT_Shirt, size);
    }

    public T_Shirt mapRowToT_Shirt(ResultSet rs, int rowNum) throws SQLException {
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setT_shirt_id(rs.getInt("t_shirt_id"));
        t_shirt.setSize(rs.getString("size"));
        t_shirt.setColor(rs.getString("color"));
        t_shirt.setDescription(rs.getString("description"));
        t_shirt.setPrice(rs.getBigDecimal("price"));
        t_shirt.setQuantity(rs.getInt("quantity"));

        return t_shirt;
    }
}
