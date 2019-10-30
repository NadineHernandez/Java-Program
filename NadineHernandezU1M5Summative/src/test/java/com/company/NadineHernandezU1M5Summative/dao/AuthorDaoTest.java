package com.company.NadineHernandezU1M5Summative.dao;

import com.company.NadineHernandezU1M5Summative.dto.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {

    @Autowired
    AuthorDao authorDao;

    @Before
    public void setUp() throws Exception {
        //cleans out the test database before testing
        List<Author> authorList = authorDao.readAllAuthors();
        for (Author a : authorList) {
            authorDao.removeAuthor(a.getAuthor_id());
        }
    }

    @Test
    public void addAuthor() {
        //create author object
        Author author = new Author();
        author.setFirst_name("Jane");
        author.setLast_name("Doe");
        author.setStreet("562 Deer Ln");
        author.setCity("Greensdale");
        author.setState("MI");
        author.setPostal_code("80155");
        author.setPhone("5558991234");
        author.setEmail("janedoe@gmail.com");

        //add author to test db
        author = authorDao.addAuthor(author);

        //assert that author in local test matches author in test db
        assertEquals(author, authorDao.readAuthor(author.getAuthor_id()));
    }

    @Test
    public void readAuthor() {
        //create author object
        Author author = new Author();
        author.setFirst_name("Jane");
        author.setLast_name("Doe");
        author.setStreet("562 Deer Ln");
        author.setCity("Greensdale");
        author.setState("MI");
        author.setPostal_code("80155");
        author.setPhone("5558991234");
        author.setEmail("janedoe@gmail.com");

        //add author to test db
        author = authorDao.addAuthor(author);

        //assert that author in local test matches author in test db
        assertEquals(author, authorDao.readAuthor(author.getAuthor_id()));
    }

    @Test
    public void readAllAuthors() {
        //create new author object
        Author author = new Author();
        author.setFirst_name("Jane");
        author.setLast_name("Doe");
        author.setStreet("562 Deer Ln");
        author.setCity("Greensdale");
        author.setState("MI");
        author.setPostal_code("80155");
        author.setPhone("5558991234");
        author.setEmail("janedoe@gmail.com");
        //add to test db
        authorDao.addAuthor(author);

        //create second author object
        Author author1 = new Author();
        author1.setFirst_name("Kim");
        author1.setLast_name("Smith");
        author1.setStreet("369 Sweet Creek Rd");
        author1.setCity("Fairhills");
        author1.setState("TX");
        author1.setPostal_code("78968");
        author1.setPhone("5554567895");
        author1.setEmail("kimsmith@gmail.com");
        //add to test db
        authorDao.addAuthor(author1);

        //assert that the two authors we created are in the db by comparing the number of
        //authors to 2
        assertEquals(2, authorDao.readAllAuthors().size());
    }

    @Test
    public void updateAuthor() {
        //create new author object
        Author author = new Author();
        author.setFirst_name("Jane");
        author.setLast_name("Doe");
        author.setStreet("562 Deer Ln");
        author.setCity("Greensdale");
        author.setState("MI");
        author.setPostal_code("80155");
        author.setPhone("5558991234");
        author.setEmail("janedoe@gmail.com");
        //add to db
        author = authorDao.addAuthor(author);

        //set new values for author object
        author.setFirst_name("Kim");
        author.setLast_name("Smith");
        author.setStreet("369 Sweet Creek Rd");
        author.setCity("Fairhills");
        author.setState("TX");
        author.setPostal_code("78968");
        author.setPhone("5554567895");
        author.setEmail("kimsmith@gmail.com");
        //update author object in db
        authorDao.updateAuthor(author);

        //assert that local author matches updated author from db
        assertEquals(author, authorDao.readAuthor(author.getAuthor_id()));
    }

    @Test
    public void removeAuthor() {
        //create an author object
        Author author = new Author();
        author.setFirst_name("Jane");
        author.setLast_name("Doe");
        author.setStreet("562 Deer Ln");
        author.setCity("Greensdale");
        author.setState("MI");
        author.setPostal_code("80155");
        author.setPhone("5558991234");
        author.setEmail("janedoe@gmail.com");

        //add author to db
        author = authorDao.addAuthor(author);
        //make sure author is in db
        assertEquals(author, authorDao.readAuthor(author.getAuthor_id()));

        //delete author from db
        authorDao.removeAuthor(author.getAuthor_id());
        //assert that we cannot get author after deletion
        assertNull(authorDao.readAuthor(author.getAuthor_id()));
    }
}