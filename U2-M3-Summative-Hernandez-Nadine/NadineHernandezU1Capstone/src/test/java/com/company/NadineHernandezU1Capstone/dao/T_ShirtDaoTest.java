package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.T_Shirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class T_ShirtDaoTest {

    @Autowired
    T_ShirtDao t_shirtDao;

    @Before
    public void setUp() throws Exception {
        //make a list of all tshirts
        List<T_Shirt> t_shirtList = t_shirtDao.getAllT_Shirts();

        //go through list and for each tshirt delete it from the db
        for(T_Shirt t_shirt : t_shirtList){
            t_shirtDao.deleteT_Shirt(t_shirt.getT_shirt_id());
        }
    }

    @Test
    public void addT_Shirt() {
        //create new t-shirt object
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(5);
        //add to db
        t_shirt = t_shirtDao.addT_Shirt(t_shirt);

        //assert that local tshirt matches tshirt in db
        assertEquals(t_shirt, t_shirtDao.getT_Shirt(t_shirt.getT_shirt_id()));
    }

    @Test
    public void getT_Shirt() {
        //create new t-shirt object
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(5);
        //add to db
        t_shirt = t_shirtDao.addT_Shirt(t_shirt);

        //assert that local tshirt matches tshirt in db
        assertEquals(t_shirt, t_shirtDao.getT_Shirt(t_shirt.getT_shirt_id()));
    }

    @Test
    public void getAllT_Shirts() {
        //create new t-shirt object
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(5);
        //add to db
        t_shirtDao.addT_Shirt(t_shirt);

        //create second new t-shirt object
        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt1.setSize("Large");
        t_shirt1.setColor("Yellow");
        t_shirt1.setDescription("Mario Party T-Shirt");
        t_shirt1.setPrice(new BigDecimal("14.99"));
        t_shirt1.setQuantity(4);
        //add to db
        t_shirtDao.addT_Shirt(t_shirt1);

        //assert that there are now 2 tshirts in db
        assertEquals(2, t_shirtDao.getAllT_Shirts().size());
    }

    @Test
    public void updateT_Shirt() {
        //create new t-shirt object
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(5);
        //add to db
        t_shirt = t_shirtDao.addT_Shirt(t_shirt);

        //create new values for tshirt
        t_shirt.setSize("Large");
        t_shirt.setColor("Yellow");
        t_shirt.setDescription("Mario Party T-Shirt");
        t_shirt.setPrice(new BigDecimal("14.99"));
        t_shirt.setQuantity(4);
        //add to db
        t_shirtDao.addT_Shirt(t_shirt);

        //assert that local tshirt matches updated tshirt in db
        assertEquals(t_shirt, t_shirtDao.getT_Shirt(t_shirt.getT_shirt_id()));
    }

    @Test
    public void deleteT_Shirt() {
        //create new t-shirt object
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(5);
        //add to db
        t_shirt = t_shirtDao.addT_Shirt(t_shirt);

        //assert that tshirt is in db
        assertEquals(t_shirt, t_shirtDao.getT_Shirt(t_shirt.getT_shirt_id()));
        //delete from db
        t_shirtDao.deleteT_Shirt(t_shirt.getT_shirt_id());
        //assert that tshirt is no longer in db
        assertNull(t_shirtDao.getT_Shirt(t_shirt.getT_shirt_id()));
    }

    @Test
    public void findT_ShirtsByColor() {
        //create new t-shirt object
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(5);
        //add to db
        t_shirtDao.addT_Shirt(t_shirt);

        //create second new t-shirt object
        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt1.setSize("Large");
        t_shirt1.setColor("Blue");
        t_shirt1.setDescription("Mario Party T-Shirt");
        t_shirt1.setPrice(new BigDecimal("14.99"));
        t_shirt1.setQuantity(4);
        //add to db
        t_shirtDao.addT_Shirt(t_shirt1);

        //assert that there are now 2 blue tshirts in db
        assertEquals(2, t_shirtDao.findT_ShirtsByColor(t_shirt.getColor()).size());
    }

    @Test
    public void findT_ShirtsBySize() {
        //create new t-shirt object
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(5);
        //add to db
        t_shirtDao.addT_Shirt(t_shirt);

        //create second new t-shirt object
        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt1.setSize("Medium");
        t_shirt1.setColor("Yellow");
        t_shirt1.setDescription("Mario Party T-Shirt");
        t_shirt1.setPrice(new BigDecimal("14.99"));
        t_shirt1.setQuantity(4);
        //add to db
        t_shirtDao.addT_Shirt(t_shirt1);

        //assert that there are now 2 medium tshirts in db
        assertEquals(2, t_shirtDao.findT_ShirtsBySize(t_shirt.getSize()).size());
    }
}