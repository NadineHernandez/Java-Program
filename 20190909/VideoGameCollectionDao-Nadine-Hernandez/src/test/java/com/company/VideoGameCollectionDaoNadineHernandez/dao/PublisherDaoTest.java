package com.company.VideoGameCollectionDaoNadineHernandez.dao;

import com.company.VideoGameCollectionDaoNadineHernandez.models.Publisher;
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
    protected PublisherDao dao;

    @Before
    public void setUp() throws Exception {
        List<Publisher> publisherList = dao.readAllPublishers();
        publisherList.stream()
                .forEach(publisher -> dao.deletePublisher(publisher.getPublisher_id()));
    }

    @Test
    public void createPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        publisher = dao.createPublisher(publisher);

        assertEquals(publisher, dao.readPublisher(publisher.getPublisher_id()));
    }

    @Test
    public void readPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        publisher = dao.createPublisher(publisher);

        assertEquals(publisher, dao.readPublisher(publisher.getPublisher_id()));
    }

    @Test
    public void readAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        dao.createPublisher(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setName("Nitendo");
        publisher1.setWebsite("Nitendo.com");
        dao.createPublisher(publisher1);

        assertEquals(2, dao.readAllPublishers().size());
    }

    @Test
    void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        publisher = dao.createPublisher(publisher);

        publisher.setName("Nitendo");
        publisher.setWebsite("Nitendo.com");
        dao.updatePublisher(publisher);

        assertEquals(publisher, dao.readPublisher(publisher.getPublisher_id()));
    }

    @Test
    void deletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Sony");
        publisher.setWebsite("Sony.com");
        publisher = dao.createPublisher(publisher);

        dao.deletePublisher(publisher.getPublisher_id());

        assertNull(dao.readPublisher(publisher.getPublisher_id()));
    }
}