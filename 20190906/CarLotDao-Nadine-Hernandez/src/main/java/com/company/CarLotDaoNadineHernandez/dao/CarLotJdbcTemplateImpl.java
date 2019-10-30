package com.company.CarLotDaoNadineHernandez.dao;

import com.company.CarLotDaoNadineHernandez.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarLotJdbcTemplateImpl implements CarLotDao {

    private static final String INSERT_CAR_SQL =
            "INSERT INTO car (make, model, year, color) VALUES (?, ?, ?, ?)";

    private static final String SELECT_CAR_SQL =
            "SELECT * FROM car WHERE id = ?";

    private static final String SELECT_ALL_CARS_SQL =
            "SELECT * FROM car";

    private static final String DELETE_CAR_SQL =
            "DELETE FROM car WHERE id = ?";

    private static final String UPDATE_CAR_SQL =
            "UPDATE car SET make = ?, model =?, year = ?, color = ? WHERE id = ?";

    private static final String SELECT_CARS_BY_MAKE_SQL =
            "SELECT * FROM car WHERE make = ?";

    private static final String SELECT_CARS_BY_COLOR_SQL =
            "SELECT * FROM car WHERE color = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarLotJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Car createCar(Car car) {
            jdbcTemplate.update(INSERT_CAR_SQL, car.getMake(), car.getModel(), car.getYear(), car.getColor());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        car.setId(id);
        return car;
    }

    @Transactional
    public Car readCar(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_CAR_SQL, this::mapRowToCar, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public List<Car> readAll() {
        return jdbcTemplate.query(SELECT_ALL_CARS_SQL, this::mapRowToCar);
    }

    public void updateCar(Car car) {
        jdbcTemplate.update(UPDATE_CAR_SQL, car.getMake(), car.getModel(), car.getYear(), car.getColor(), car.getId());
    }

    public void deleteCar(int id) {
        jdbcTemplate.update(DELETE_CAR_SQL, id);
    }

    public List<Car> findCarByMake(String make) {
        return jdbcTemplate.query(SELECT_CARS_BY_MAKE_SQL, this::mapRowToCar, make);
    }

    public List<Car> findCarByColor(String color) {
        return jdbcTemplate.query(SELECT_CARS_BY_COLOR_SQL, this::mapRowToCar, color);
    }

    public Car mapRowToCar(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getString("year"));
        car.setColor(rs.getString("color"));

        return car;
    }
}
