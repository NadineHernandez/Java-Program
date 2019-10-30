package com.company.NadineHernandezU1M5Summative.dao;

import com.company.NadineHernandezU1M5Summative.dto.Publisher;
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
public class PublisherDaoTest {

    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        //Clean out the test database before testing
        List<Publisher> publisherList = publisherDao.readAllPublishers();
        for (Publisher p : publisherList) {
            publisherDao.deletePublisher(p.getPublisher_id());
        }
    }

    @Test
    public void addPublisher() {
        //create publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setStreet("600 8th St");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("69332");
        publisher.setPhone("5557894561");
        publisher.setEmail("contact@penguin.com");
        //add to db
        publisher = publisherDao.addPublisher(publisher);

        //assert that local test publisher matches object in test db
        assertEquals(publisher, publisherDao.readPublisher(publisher.getPublisher_id()));
    }

    @Test
    public void readPublisher() {
        //create publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setStreet("600 8th St");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("69332");
        publisher.setPhone("5557894561");
        publisher.setEmail("contact@penguin.com");
        //add to db
        publisher = publisherDao.addPublisher(publisher);

        //assert that local test publisher matches object in test db
        assertEquals(publisher, publisherDao.readPublisher(publisher.getPublisher_id()));
    }

    @Test
    public void readAllPublishers() {
        //create publisher
        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setStreet("600 8th St");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("69332");
        publisher.setPhone("5557894561");
        publisher.setEmail("contact@penguin.com");
        //add to db
        publisherDao.addPublisher(publisher);

        //create second publisher
        Publisher publisher1 = new Publisher();
        publisher1.setName("Flamingo");
        publisher1.setStreet("221 5th St");
        publisher1.setCity("San Diego");
        publisher1.setState("CA");
        publisher1.setPostal_code("21169");
        publisher1.setPhone("5553216549");
        publisher1.setEmail("contact@flamingo.com");
        //add to db
        publisherDao.addPublisher(publisher1);

        //assert that there are now 2 publishers total in test db
        assertEquals(2, publisherDao.readAllPublishers().size());
    }

    @Test
    public void updatePublisher() {
        //create publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setStreet("600 8th St");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("69332");
        publisher.setPhone("5557894561");
        publisher.setEmail("contact@penguin.com");
        //add to db
        publisher = publisherDao.addPublisher(publisher);

        //set new values to publisher
        publisher.setName("Flamingo");
        publisher.setStreet("221 5th St");
        publisher.setCity("San Diego");
        publisher.setState("CA");
        publisher.setPostal_code("21169");
        publisher.setPhone("5553216549");
        publisher.setEmail("contact@flamingo.com");
        //update in db
        publisherDao.updatePublisher(publisher);

        //assert that publisher in local matches updated publisher in db
        assertEquals(publisher, publisherDao.readPublisher(publisher.getPublisher_id()));
    }

    @Test
    public void deletePublisher() {
        //create new publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setStreet("600 8th St");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("69332");
        publisher.setPhone("5557894561");
        publisher.setEmail("contact@penguin.com");

        //add publisher to db
        publisher = publisherDao.addPublisher(publisher);
        //assert that publisher is in db
        assertEquals(publisher, publisherDao.readPublisher(publisher.getPublisher_id()));

        //delete from db
        publisherDao.deletePublisher(publisher.getPublisher_id());
        //assert that we can no longer access deleted object
        assertNull(publisherDao.readPublisher(publisher.getPublisher_id()));
    }
}