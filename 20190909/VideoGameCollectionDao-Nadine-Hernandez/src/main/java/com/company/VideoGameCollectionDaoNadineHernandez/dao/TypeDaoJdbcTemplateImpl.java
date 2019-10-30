package com.company.VideoGameCollectionDaoNadineHernandez.dao;

import com.company.VideoGameCollectionDaoNadineHernandez.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TypeDaoJdbcTemplateImpl implements TypeDao{

    private static final String INSERT_TYPE_SQL =
            "INSERT INTO type (name, descrption) VALUES (?, ?)";

    private static final String SELECT_TYPE_SQL =
            "SELECT * FROM type WHERE type_id = ?";

    private static final String SELECT_ALL_TYPES_SQL =
            "SELECT * FROM type";

    private static final String DELETE_TYPE_SQL =
            "DELETE FROM type WHERE type_id = ?";

    private static final String UPDATE_TYPE_SQL =
            "UPDATE type SET name = ?, descrption = ? WHERE type_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TypeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Type createType(Type type) {
        jdbcTemplate.update(INSERT_TYPE_SQL, type.getName(), type.getDescrption());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        type.setType_id(id);
        return type;
    }

    @Override
    public Type readType(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_TYPE_SQL, this::mapRowToType, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Type> readAllType() {
        return jdbcTemplate.query(SELECT_ALL_TYPES_SQL, this::mapRowToType);
    }

    @Override
    public void updateType(Type type) {
        jdbcTemplate.update(UPDATE_TYPE_SQL, type.getName(), type.getDescrption(), type.getType_id());
    }

    @Override
    public void deleteType(int id) {
        jdbcTemplate.update(DELETE_TYPE_SQL, id);
    }

    public Type mapRowToType(ResultSet rs, int rowNum) throws SQLException {
        Type type = new Type();
        type.setType_id(rs.getInt("type_id"));
        type.setName(rs.getString("name"));
        type.setDescrption(rs.getString("descrption"));

        return type;
    }
}
