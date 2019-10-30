package com.company.VideoGameCollectionDaoNadineHernandez.dao;

import com.company.VideoGameCollectionDaoNadineHernandez.models.Console;
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
public class ConsoleDaoTest {

    @Autowired
    protected ConsoleDao dao;

    @Before
    public void setUp() throws Exception {
        List<Console> consoleList = dao.readAllConsole();
        consoleList.stream()
                .forEach(console -> dao.deleteConsole(console.getConsole_id()));
    }

    @Test
    public void createConsole() {
        Console console = new Console();
        console.setName("Nitendo 64");
        console.setYear("1996");
        console = dao.createConsole(console);

        assertEquals(console, dao.readConsole(console.getConsole_id()));
    }

    @Test
    public void readConsole() {
        Console console = new Console();
        console.setName("Nitendo 64");
        console.setYear("1996");
        console = dao.createConsole(console);

        assertEquals(console, dao.readConsole(console.getConsole_id()));
    }

    @Test
    public void readAllConsole() {
        Console console = new Console();
        console.setName("Nitendo 64");
        console.setYear("1996");
        dao.createConsole(console);

        Console console2 = new Console();
        console2.setName("PlayStation 2");
        console2.setYear("2000");
        dao.createConsole(console2);

        assertEquals(2, dao.readAllConsole().size());
    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setName("Nitendo 64");
        console.setYear("1996");
        console = dao.createConsole(console);

        console.setName("SEGA Genesis");
        console.setYear("1993");
        dao.updateConsole(console);

        assertEquals(console, dao.readConsole(console.getConsole_id()));
    }

    @Test
    public void deleteConsole() {
        Console console = new Console();
        console.setName("Nitendo 64");
        console.setYear("1996");
        console = dao.createConsole(console);

        dao.deleteConsole(console.getConsole_id());

        assertNull(dao.readConsole(console.getConsole_id()));
    }
}