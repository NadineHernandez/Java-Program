package com.company.NadineHernandezU1M5Summative.dao;

import com.company.NadineHernandezU1M5Summative.dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbcTemplateImpl implements PublisherDao {

    //prepared statements
    private static final String INSERT_PUBLISHER_SQL =
        "INSERT INTO publisher(name, street, city, state, postal_code, phone, email) Values(?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_PUBLISHER_SQL =
        "SELECT * FROM publisher WHERE publisher_id = ?";

    private static final String SELECT_ALL_PUBLISHERS_SQL =
        "SELECT * FROM publisher";

    private static final String UPDATE_PUBLISHER_SQL =
        "UPDATE publisher SET name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ?" +
                "WHERE publisher_id = ?";

    private static final String DELETE_PUBLISHER_SQL =
        "DELETE FROM publisher WHERE publisher_id = ?";

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public PublisherDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(INSERT_PUBLISHER_SQL, publisher.getName(), publisher.getStreet(), publisher.getCity(),
                publisher.getState(), publisher.getPostal_code(), publisher.getPhone(), publisher.getEmail());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        publisher.setPublisher_id(id);
        return publisher;
    }

    @Override
    public Publisher readPublisher(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Publisher> readAllPublishers() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHERS_SQL, this::mapRowToPublisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL, publisher.getName(), publisher.getStreet(), publisher.getCity(),
                publisher.getState(), publisher.getPostal_code(), publisher.getPhone(), publisher.getEmail(), publisher.getPublisher_id());
    }

    @Override
    public void deletePublisher(int id) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, id);
    }

    public Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisher_id(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setStreet(rs.getString("street"));
        publisher.setCity(rs.getString("city"));
        publisher.setState(rs.getString("state"));
        publisher.setPostal_code(rs.getString("postal_code"));
        publisher.setPhone(rs.getString("phone"));
        publisher.setEmail(rs.getString("email"));

        return publisher;
    }
}
