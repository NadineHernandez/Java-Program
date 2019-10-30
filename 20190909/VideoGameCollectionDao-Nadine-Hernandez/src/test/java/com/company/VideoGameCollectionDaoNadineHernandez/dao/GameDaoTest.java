package com.company.VideoGameCollectionDaoNadineHernandez.dao;

import com.company.VideoGameCollectionDaoNadineHernandez.models.Console;
import com.company.VideoGameCollectionDaoNadineHernandez.models.Game;
import com.company.VideoGameCollectionDaoNadineHernandez.models.Publisher;
import com.company.VideoGameCollectionDaoNadineHernandez.models.Type;
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
public class GameDaoTest {

    @Autowired
    protected GameDao gdao;

    @Autowired
    protected ConsoleDao cdao;

    @Autowired
    protected PublisherDao pdao;

    @Autowired
    protected TypeDao tdao;

    @Before
    public void setUp() throws Exception {
        List<Game> gameList = gdao.readAllGame();
        gameList.stream()
                .forEach(game -> gdao.deleteGame(game.getGame_id()));

        List<Console> consoleList = cdao.readAllConsole();
        consoleList.stream()
                .forEach(console -> cdao.deleteConsole(console.getConsole_id()));

        List<Publisher> publisherList = pdao.readAllPublishers();
        publisherList.stream()
                .forEach(publisher -> pdao.deletePublisher(publisher.getPublisher_id()));

        List<Type> typeList = tdao.readAllType();
        typeList.stream()
                .forEach(type -> tdao.deleteType(type.getType_id()));
    }

    @Test
    public void createGame() {
        Console console = new Console();
        console.setName("PS2");
        console.setYear("2000");
        console = cdao.createConsole(console);

        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        publisher = pdao.createPublisher(publisher);

        Type type = new Type();
        type.setName("Disk");
        type.setDescrption("265vx CD");
        type = tdao.createType(type);

        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gdao.createGame(game);

        assertEquals(game, gdao.readGame(game.getGame_id()));
    }

    @Test
    public void readGame() {
        Console console = new Console();
        console.setName("PS2");
        console.setYear("2000");
        console = cdao.createConsole(console);

        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        publisher = pdao.createPublisher(publisher);

        Type type = new Type();
        type.setName("Disk");
        type.setDescrption("265vx CD");
        type = tdao.createType(type);

        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gdao.createGame(game);

        assertEquals(game, gdao.readGame(game.getGame_id()));
    }

    @Test
    public void readAllGame() {
        Console console = new Console();
        console.setName("PS2");
        console.setYear("2000");
        console = cdao.createConsole(console);

        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        publisher = pdao.createPublisher(publisher);

        Type type = new Type();
        type.setName("Disk");
        type.setDescrption("265vx CD");
        type = tdao.createType(type);

        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        gdao.createGame(game);

        Console console2 = new Console();
        console2.setName("Wii");
        console2.setYear("2006");
        console2 = cdao.createConsole(console2);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Nitendo");
        publisher2.setWebsite("Nitendo.com");
        publisher2 = pdao.createPublisher(publisher2);

        Type type2 = new Type();
        type2.setName("Disk");
        type2.setDescrption("564v3 CD");
        type2 = tdao.createType(type);

        Game game2 = new Game();
        game2.setConsole_id(console2.getConsole_id());
        game2.setPublisher_id(publisher2.getPublisher_id());
        game2.setType_id(type2.getType_id());
        gdao.createGame(game2);

        assertEquals(2, gdao.readAllGame().size());
    }

    @Test
    public void updateGame() {
        Console console = new Console();
        console.setName("PS2");
        console.setYear("2000");
        console = cdao.createConsole(console);

        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        publisher = pdao.createPublisher(publisher);

        Type type = new Type();
        type.setName("Disk");
        type.setDescrption("265vx CD");
        type = tdao.createType(type);

        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gdao.createGame(game);

        Console console2 = new Console();
        console2.setName("Wii");
        console2.setYear("2006");
        console2 = cdao.createConsole(console2);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Nitendo");
        publisher2.setWebsite("Nitendo.com");
        publisher2 = pdao.createPublisher(publisher2);

        Type type2 = new Type();
        type2.setName("Disk");
        type2.setDescrption("564v3 CD");
        type2 = tdao.createType(type);

        game.setConsole_id(console2.getConsole_id());
        game.setPublisher_id(publisher2.getPublisher_id());
        game.setType_id(type2.getType_id());
        gdao.updateGame(game);

        assertEquals(game, gdao.readGame(game.getGame_id()));
    }

    @Test
    public void deleteGame() {
        Console console = new Console();
        console.setName("PS2");
        console.setYear("2000");
        console = cdao.createConsole(console);

        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        publisher = pdao.createPublisher(publisher);

        Type type = new Type();
        type.setName("Disk");
        type.setDescrption("265vx CD");
        type = tdao.createType(type);

        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gdao.createGame(game);

        gdao.deleteGame(game.getGame_id());

        assertNull(gdao.readGame(game.getGame_id()));
    }

    @Test
    public void findGameByConsole() {
        Console console = new Console();
        console.setName("PS2");
        console.setYear("2000");
        console = cdao.createConsole(console);

        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        publisher = pdao.createPublisher(publisher);

        Type type = new Type();
        type.setName("Disk");
        type.setDescrption("265vx CD");
        type = tdao.createType(type);

        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        gdao.createGame(game);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Nitendo");
        publisher2.setWebsite("Nitendo.com");
        publisher2 = pdao.createPublisher(publisher2);

        Type type2 = new Type();
        type2.setName("Disk");
        type2.setDescrption("564v3 CD");
        type2 = tdao.createType(type);

        Game game2 = new Game();
        game2.setConsole_id(console.getConsole_id());
        game2.setPublisher_id(publisher2.getPublisher_id());
        game2.setType_id(type2.getType_id());
        gdao.createGame(game2);

        assertEquals(2, gdao.findGameByConsole(console.getConsole_id()).size());
    }

    @Test
    public void findGameByPublisher() {
        Console console = new Console();
        console.setName("PS2");
        console.setYear("2000");
        console = cdao.createConsole(console);

        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        publisher = pdao.createPublisher(publisher);

        Type type = new Type();
        type.setName("Disk");
        type.setDescrption("265vx CD");
        type = tdao.createType(type);

        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        gdao.createGame(game);

        Console console2 = new Console();
        console2.setName("Wii");
        console2.setYear("2006");
        console2 = cdao.createConsole(console2);

        Type type2 = new Type();
        type2.setName("Disk");
        type2.setDescrption("564v3 CD");
        type2 = tdao.createType(type);

        Game game2 = new Game();
        game2.setConsole_id(console2.getConsole_id());
        game2.setPublisher_id(publisher.getPublisher_id());
        game2.setType_id(type2.getType_id());
        gdao.createGame(game2);

        assertEquals(2, gdao.findGameByPublisher(publisher.getPublisher_id()).size());
    }

    @Test
    public void findGameByType() {
        Console console = new Console();
        console.setName("PS2");
        console.setYear("2000");
        console = cdao.createConsole(console);

        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        publisher = pdao.createPublisher(publisher);

        Type type = new Type();
        type.setName("Disk");
        type.setDescrption("265vx CD");
        type = tdao.createType(type);

        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        gdao.createGame(game);

        Console console2 = new Console();
        console2.setName("Wii");
        console2.setYear("2006");
        console2 = cdao.createConsole(console2);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Nitendo");
        publisher2.setWebsite("Nitendo.com");
        publisher2 = pdao.createPublisher(publisher2);

        Game game2 = new Game();
        game2.setConsole_id(console2.getConsole_id());
        game2.setPublisher_id(publisher2.getPublisher_id());
        game2.setType_id(type.getType_id());
        gdao.createGame(game2);

        assertEquals(2, gdao.findGameByType(type.getType_id()).size());
    }
}