package com.company.CarLotDaoNadineHernandez.dao;

import com.company.CarLotDaoNadineHernandez.model.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarLotDaoTest {

    @Autowired
    protected CarLotDao dao;

    @Before
    public void setUp() throws Exception {
        List<Car> carList = dao.readAll();
        carList.stream()
                .forEach(car -> dao.deleteCar(car.getId()));
    }

    @Test
    public void createReadCar() {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Carolla");
        car.setYear("2010");
        car.setColor("Blue");
        car = dao.createCar(car);

        assertEquals(car, dao.readCar(car.getId()));
    }

    @Test
    public void readAll() {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Carolla");
        car.setYear("2010");
        car.setColor("Blue");
        dao.createCar(car);

        Car car2 = new Car();
        car2.setMake("Toyota");
        car2.setModel("Camry");
        car2.setYear("2019");
        car2.setColor("Black");
        dao.createCar(car2);

        assertEquals(2, dao.readAll().size());
    }

    @Test
    public void updateCar() {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Carolla");
        car.setYear("2010");
        car.setColor("Blue");
        car = dao.createCar(car);

        car.setMake("Toyota");
        car.setModel("Camry");
        car.setYear("2019");
        car.setColor("Black");
        dao.updateCar(car);

        assertEquals(car, dao.readCar(car.getId()));
    }

    @Test
    public void deleteCar() {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Carolla");
        car.setYear("2010");
        car.setColor("Blue");
        car = dao.createCar(car);

        dao.deleteCar(car.getId());

        assertNull(dao.readCar(car.getId()));
    }

    @Test
    public void findCarByMake() {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Carolla");
        car.setYear("2010");
        car.setColor("Blue");
        car = dao.createCar(car);

        Car car2 = new Car();
        car2.setMake("Toyota");
        car2.setModel("Camry");
        car2.setYear("2019");
        car2.setColor("Black");
        dao.createCar(car2);

        assertEquals(2, dao.findCarByMake(car.getMake()).size());
    }

    @Test
    public void findCarByColor() {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Carolla");
        car.setYear("2010");
        car.setColor("Black");
        car = dao.createCar(car);

        Car car2 = new Car();
        car2.setMake("Honda");
        car2.setModel("Civic");
        car2.setYear("2019");
        car2.setColor("Black");
        dao.createCar(car2);

        assertEquals(2, dao.findCarByColor(car.getColor()).size());
    }
}