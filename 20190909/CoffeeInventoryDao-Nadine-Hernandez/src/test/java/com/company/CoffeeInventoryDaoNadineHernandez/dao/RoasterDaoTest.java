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
public class RoasterDaoTest {

    @Autowired
    protected CoffeeDao dao;

    @Autowired
    protected RoasterDao daor;

    @Before
    public void setUp() throws Exception {
        List<Roaster> roasterList = daor.readAllRoaster();
        roasterList.stream()
                .forEach(roaster -> daor.deleteRoaster(roaster.getRoaster_id()));

        List<Coffee> coffeeList = dao.readAllCoffee();
        coffeeList.stream()
                .forEach(coffee -> dao.deleteCoffee(coffee.getCoffee_id()));
    }

    @Test
    public void createRoaster() {
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

        assertEquals(roaster, daor.readRoaster(roaster.getRoaster_id()));
    }

    @Test
    public void readRoaster() {
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

        assertEquals(roaster, daor.readRoaster(roaster.getRoaster_id()));
    }

    @Test
    public void readAllRoaster() {
        Roaster roaster = new Roaster();
        roaster.setName("Java Roasters");
        roaster.setStreet("2059 Birchwood Ln");
        roaster.setCity("Greenville");
        roaster.setState("Ohio");
        roaster.setPostal_code("80132");
        roaster.setPhone("3805668896");
        roaster.setEmail("contact@javaroasters.com");
        roaster.setNote("Holiday Vendor");

        Roaster roaster2 = new Roaster();
        roaster2.setName("Bean Juice");
        roaster2.setStreet("1508 Garland Rd");
        roaster2.setCity("Grandale");
        roaster2.setState("MN");
        roaster2.setPostal_code("90763");
        roaster2.setPhone("9108557027");
        roaster2.setEmail("info@beanjuice.com");
        roaster2.setNote("50 Units minimum order");

        assertEquals(2, daor.readAllRoaster().size());
    }

    @Test
    public void updateRoaster() {
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

        roaster.setName("Bean Juice");
        roaster.setStreet("1508 Garland Rd");
        roaster.setCity("Grandale");
        roaster.setState("MN");
        roaster.setPostal_code("90763");
        roaster.setPhone("9108557027");
        roaster.setEmail("info@beanjuice.com");
        roaster.setNote("50 Units minimum order");
        daor.updateRoaster(roaster);

        assertEquals(roaster, daor.readRoaster(roaster.getRoaster_id()));
    }

    @Test
    public void deleteRoaster() {
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

        daor.deleteRoaster(roaster.getRoaster_id());

        assertNull(daor.readRoaster(roaster.getRoaster_id()));
    }
}