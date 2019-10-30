package com.company.CoffeeInventoryDaoNadineHernandez.dao;

import com.company.CoffeeInventoryDaoNadineHernandez.models.Coffee;
import com.company.CoffeeInventoryDaoNadineHernandez.models.Roaster;
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
public class CoffeeDaoTest {

    @Autowired
    protected CoffeeDao dao;

    @Autowired
    protected RoasterDao daor;

    @Before
    public void setUp() throws Exception {
        List<Coffee> coffeeList = dao.readAllCoffee();
        coffeeList.stream()
                .forEach(coffee -> dao.deleteCoffee(coffee.getCoffee_id()));

        List<Roaster> roasterList = daor.readAllRoaster();
        roasterList.stream()
                .forEach(roaster -> daor.deleteRoaster(roaster.getRoaster_id()));
    }

    @Test
    public void createCoffee() {
        Roaster roaster = new Roaster();
        roaster.setName("Java Roasters");
        roaster.setStreet("2059 Birchwood Ln");
        roaster.setCity("Greenville");
        roaster.setState("OH");
        roaster.setPostal_code("80132");
        roaster.setPhone("3805668896");
        roaster.setEmail("contact@javaroasters.com");
        roaster.setNote("Holiday Vendor");
        roaster = daor.createRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Kenya Decaf");
        coffee.setCount(50);
        coffee.setUnit_price(8.00);
        coffee.setDescription("Bitter");
        coffee.setType("Decaf");
        coffee = dao.createCoffee(coffee);

        assertEquals(coffee, dao.readCoffee(coffee.getCoffee_id()));
    }

    @Test
    public void readCoffee() {
        Roaster roaster = new Roaster();
        roaster.setName("Java Roasters");
        roaster.setStreet("2059 Birchwood Ln");
        roaster.setCity("Greenville");
        roaster.setState("OH");
        roaster.setPostal_code("80132");
        roaster.setPhone("3805668896");
        roaster.setEmail("contact@javaroasters.com");
        roaster.setNote("Holiday Vendor");
        roaster = daor.createRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Kenya Decaf");
        coffee.setCount(50);
        coffee.setUnit_price(8.00);
        coffee.setDescription("Bitter");
        coffee.setType("Decaf");
        coffee = dao.createCoffee(coffee);

        assertEquals(coffee, dao.readCoffee(coffee.getCoffee_id()));
    }

    @Test
    public void readAllCoffee() {
        Roaster roaster = new Roaster();
        roaster.setName("Java Roasters");
        roaster.setStreet("2059 Birchwood Ln");
        roaster.setCity("Greenville");
        roaster.setState("OH");
        roaster.setPostal_code("80132");
        roaster.setPhone("3805668896");
        roaster.setEmail("contact@javaroasters.com");
        roaster.setNote("Holiday Vendor");
        roaster = daor.createRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Kenya Decaf");
        coffee.setCount(50);
        coffee.setUnit_price(8.00);
        coffee.setDescription("Bitter");
        coffee.setType("Decaf");
        dao.createCoffee(coffee);

        Coffee coffee2 = new Coffee();
        coffee2.setRoaster_id(roaster.getRoaster_id());
        coffee2.setName("Brazil Java");
        coffee2.setCount(75);
        coffee2.setUnit_price(6.50);
        coffee2.setDescription("Dark Roast");
        coffee2.setType("Caffinated");
        dao.createCoffee(coffee2);

        assertEquals(2, dao.readAllCoffee().size());
    }

    @Test
    public void updateCoffee() {
        Roaster roaster = new Roaster();
        roaster.setName("Java Roasters");
        roaster.setStreet("2059 Birchwood Ln");
        roaster.setCity("Greenville");
        roaster.setState("OH");
        roaster.setPostal_code("80132");
        roaster.setPhone("3805668896");
        roaster.setEmail("contact@javaroasters.com");
        roaster.setNote("Holiday Vendor");
        roaster = daor.createRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Kenya Decaf");
        coffee.setCount(50);
        coffee.setUnit_price(8.00);
        coffee.setDescription("Bitter");
        coffee.setType("Decaf");
        coffee = dao.createCoffee(coffee);

        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Brazil Java");
        coffee.setCount(75);
        coffee.setUnit_price(6.50);
        coffee.setDescription("Dark Roast");
        coffee.setType("Caffinated");
        dao.updateCoffee(coffee);

        assertEquals(coffee, dao.readCoffee(coffee.getCoffee_id()));
    }

    @Test
    public void deleteCoffee() {
        Roaster roaster = new Roaster();
        roaster.setName("Java Roasters");
        roaster.setStreet("2059 Birchwood Ln");
        roaster.setCity("Greenville");
        roaster.setState("OH");
        roaster.setPostal_code("80132");
        roaster.setPhone("3805668896");
        roaster.setEmail("contact@javaroasters.com");
        roaster.setNote("Holiday Vendor");
        roaster = daor.createRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Kenya Decaf");
        coffee.setCount(50);
        coffee.setUnit_price(8.00);
        coffee.setDescription("Bitter");
        coffee.setType("Decaf");
        coffee = dao.createCoffee(coffee);

        assertEquals(coffee, dao.readCoffee(coffee.getCoffee_id()));

        dao.deleteCoffee(coffee.getCoffee_id());

        assertNull(coffee.getCoffee_id());
    }

    @Test
    public void findCoffeeByRoasterID() {
        Roaster roaster = new Roaster();
        roaster.setName("Java Roasters");
        roaster.setStreet("2059 Birchwood Ln");
        roaster.setCity("Greenville");
        roaster.setState("OH");
        roaster.setPostal_code("80132");
        roaster.setPhone("3805668896");
        roaster.setEmail("contact@javaroasters.com");
        roaster.setNote("Holiday Vendor");
        roaster = daor.createRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Kenya Decaf");
        coffee.setCount(50);
        coffee.setUnit_price(8.00);
        coffee.setDescription("Bitter");
        coffee.setType("Decaf");
        dao.createCoffee(coffee);

        Coffee coffee2 = new Coffee();
        coffee2.setRoaster_id(roaster.getRoaster_id());
        coffee2.setName("Brazil Java");
        coffee2.setCount(75);
        coffee2.setUnit_price(6.50);
        coffee2.setDescription("Dark Roast");
        coffee2.setType("Caffinated");
        dao.createCoffee(coffee2);

        assertEquals(2, dao.findCoffeeByRoasterID(coffee.getRoaster_id()));
    }

    @Test
    public void findCoffeeByTypeID() {
        Roaster roaster = new Roaster();
        roaster.setName("Java Roasters");
        roaster.setStreet("2059 Birchwood Ln");
        roaster.setCity("Greenville");
        roaster.setState("OH");
        roaster.setPostal_code("80132");
        roaster.setPhone("3805668896");
        roaster.setEmail("contact@javaroasters.com");
        roaster.setNote("Holiday Vendor");
        roaster = daor.createRoaster(roaster);

        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Kenya Decaf");
        coffee.setCount(50);
        coffee.setUnit_price(8.00);
        coffee.setDescription("Bitter");
        coffee.setType("Decaf");
        dao.createCoffee(coffee);

        Coffee coffee2 = new Coffee();
        coffee2.setRoaster_id(roaster.getRoaster_id());
        coffee2.setName("Brazil Java");
        coffee2.setCount(75);
        coffee2.setUnit_price(6.50);
        coffee2.setDescription("Dark Roast");
        coffee2.setType("Decaf");
        dao.createCoffee(coffee2);

        assertEquals(2, dao.findCoffeeByTypeID(coffee.getType()));
    }
}