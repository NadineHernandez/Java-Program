package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.Console;
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
public class ConsoleDaoTest {

    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {
        //create a list of all consoles
        List<Console> consoleList = consoleDao.getAllConsoles();

        //for each console in the list, delete it from db
        for(Console console : consoleList){
            consoleDao.deleteConsole(console.getConsole_id());
        }
    }

    @Test
    public void addConsole() {
        //create a new console
        Console console = new Console();
        console.setModel("Wii");
        console.setManufacturer("Nitendo");
        console.setMemory_amount("32GB");
        console.setProcessor("JX2500");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(50);

        //add console to test db
        console = consoleDao.addConsole(console);

        //assert that local console is the same as one in db
        assertEquals(console, consoleDao.getConsole(console.getConsole_id()));
    }

    @Test
    public void getConsole() {
        //create a new console
        Console console = new Console();
        console.setModel("Wii");
        console.setManufacturer("Nitendo");
        console.setMemory_amount("32GB");
        console.setProcessor("JX2500");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(50);

        //add console to test db
        console = consoleDao.addConsole(console);

        //assert that local console is the same as one in db
        assertEquals(console, consoleDao.getConsole(console.getConsole_id()));
    }

    @Test
    public void getAllConsoles() {
        //create a new console
        Console console = new Console();
        console.setModel("Wii");
        console.setManufacturer("Nitendo");
        console.setMemory_amount("32GB");
        console.setProcessor("JX2500");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(50);
        //add console to test db
        consoleDao.addConsole(console);

        //create a second new console
        Console console1 = new Console();
        console1.setModel("Wii-U");
        console1.setManufacturer("Nitendo");
        console1.setMemory_amount("64GB");
        console1.setProcessor("JX2800");
        console1.setPrice(new BigDecimal("349.99"));
        console1.setQuantity(75);
        //add console to test db
        consoleDao.addConsole(console1);

        //assert that there are now 2 consoles in the db
        assertEquals(2, consoleDao.getAllConsoles().size());
    }

    @Test
    public void updateConsole() {
        //create a new console
        Console console = new Console();
        console.setModel("Wii");
        console.setManufacturer("Nitendo");
        console.setMemory_amount("32GB");
        console.setProcessor("JX2500");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(50);
        //add console to test db
        console = consoleDao.addConsole(console);

        //update console values
        console.setModel("Wii-U");
        console.setManufacturer("Nitendo");
        console.setMemory_amount("64GB");
        console.setProcessor("JX2800");
        console.setPrice(new BigDecimal("349.99"));
        console.setQuantity(75);
        //update console in test db
        consoleDao.updateConsole(console);

        //assert that local console matches updated console in db
        assertEquals(console, consoleDao.getConsole(console.getConsole_id()));
    }

    @Test
    public void deleteConsole() {
        //create a console
        Console console = new Console();
        console.setModel("Wii");
        console.setManufacturer("Nitendo");
        console.setMemory_amount("32GB");
        console.setProcessor("JX2500");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(50);

        //add console to db
        console = consoleDao.addConsole(console);
        //assert that local console object matches one in db
        assertEquals(console, consoleDao.getConsole(console.getConsole_id()));

        //delete console from test db
        consoleDao.deleteConsole(console.getConsole_id());
        //confirm that console no longer exists on db
        assertNull(consoleDao.getConsole(console.getConsole_id()));
    }

    @Test
    public void findConsolesByManufacturer() {
        //create a new console
        Console console = new Console();
        console.setModel("Wii");
        console.setManufacturer("Nitendo");
        console.setMemory_amount("32GB");
        console.setProcessor("JX2500");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(50);
        //add console to test db
        consoleDao.addConsole(console);

        //create a second new console
        Console console1 = new Console();
        console1.setModel("Wii-U");
        console1.setManufacturer("Nitendo");
        console1.setMemory_amount("64GB");
        console1.setProcessor("JX2800");
        console1.setPrice(new BigDecimal("349.99"));
        console1.setQuantity(75);
        //add console to test db
        consoleDao.addConsole(console1);

        //assert that there are now 2 consoles with the same manufacturer in the db
        assertEquals(2, consoleDao.findConsolesByManufacturer(console.getManufacturer()).size());
    }
}