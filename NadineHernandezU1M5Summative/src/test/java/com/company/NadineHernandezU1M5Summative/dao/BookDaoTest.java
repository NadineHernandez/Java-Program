package com.company.NadineHernandezU1M5Summative.dao;

import com.company.NadineHernandezU1M5Summative.dto.Author;
import com.company.NadineHernandezU1M5Summative.dto.Book;
import com.company.NadineHernandezU1M5Summative.dto.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {

    //Get access to all relevant daos
    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        //clear out database for all tables we plan to use before testing
        List<Book> bookList = bookDao.readAllBooks();
        for (Book b : bookList) {
            bookDao.removeBook(b.getBook_id());
        }

        List<Author> authorList = authorDao.readAllAuthors();
        for (Author a : authorList) {
            authorDao.removeAuthor(a.getAuthor_id());
        }

        List<Publisher> publisherList = publisherDao.readAllPublishers();
        for (Publisher p : publisherList) {
            publisherDao.deletePublisher(p.getPublisher_id());
        }
    }
//crud tests and find book by author test
    @Test
    public void addBook() {
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
        author = authorDao.addAuthor(author);

        //create publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setStreet("600 8th St");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("69332");
        publisher.setPhone("5557894561");
        publisher.setEmail("contact@penguin.com");
        publisher = publisherDao.addPublisher(publisher);

        //assemble book object
        Book book = new Book();
        book.setIsbn("1a2b3c4d5e");
        book.setPublish_date(LocalDate.of(2018, 05, 01));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Pete's Peas");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("9.99"));
        book = bookDao.addBook(book);

        //compare book in test to book we saved to test db
        assertEquals(book, bookDao.readBook(book.getBook_id()));
    }

    @Test
    public void readBook() {
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
        author = authorDao.addAuthor(author);

        //create publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setStreet("600 8th St");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("69332");
        publisher.setPhone("5557894561");
        publisher.setEmail("contact@penguin.com");
        publisher = publisherDao.addPublisher(publisher);

        //assemble book
        Book book = new Book();
        book.setIsbn("1a2b3c4d5e");
        book.setPublish_date(LocalDate.of(2018, 05, 01));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Pete's Peas");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("9.99"));
        book = bookDao.addBook(book);

        //compare book in test to book we saved to test db
        assertEquals(book, bookDao.readBook(book.getBook_id()));
    }

    @Test
    public void readAllBooks() {
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
        author = authorDao.addAuthor(author);

        //create publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setStreet("600 8th St");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("69332");
        publisher.setPhone("5557894561");
        publisher.setEmail("contact@penguin.com");
        publisher = publisherDao.addPublisher(publisher);

        //create first book object
        Book book = new Book();
        book.setIsbn("1a2b3c4d5e");
        book.setPublish_date(LocalDate.of(2018, 05, 01));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Pete's Peas");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("9.99"));
        bookDao.addBook(book);

        //create second book object
        Book book1 = new Book();
        book1.setIsbn("1g2h3j4k5l");
        book1.setPublish_date(LocalDate.of(2017, 07, 22));
        book1.setAuthor_id(author.getAuthor_id());
        book1.setTitle("Holly Loves Honey");
        book1.setPublisher_id(publisher.getPublisher_id());
        book1.setPrice(new BigDecimal("8.99"));
        bookDao.addBook(book1);

        //compare expected length on list of all books returned from database to the actual
        assertEquals(2, bookDao.readAllBooks().size());
    }

    @Test
    public void updateBook() {
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
        author = authorDao.addAuthor(author);

        //create publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setStreet("600 8th St");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("69332");
        publisher.setPhone("5557894561");
        publisher.setEmail("contact@penguin.com");
        publisher = publisherDao.addPublisher(publisher);

        //create book object
        Book book = new Book();
        book.setIsbn("1a2b3c4d5e");
        book.setPublish_date(LocalDate.of(2018, 05, 01));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Pete's Peas");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("9.99"));
        //add book to test db
        book = bookDao.addBook(book);

        //update local book in test
        book.setIsbn("1g2h3j4k5l");
        book.setPublish_date(LocalDate.of(2017, 07, 22));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Holly Loves Honey");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("8.99"));
        //update book in test database
        bookDao.updateBook(book);

        //compare local test book to updated book from test database
        assertEquals(book, bookDao.readBook(book.getBook_id()));
    }

    @Test
    public void removeBook() {
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
        author = authorDao.addAuthor(author);

        //create publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setStreet("600 8th St");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("69332");
        publisher.setPhone("5557894561");
        publisher.setEmail("contact@penguin.com");
        publisher = publisherDao.addPublisher(publisher);

        //assemble book
        Book book = new Book();
        book.setIsbn("1a2b3c4d5e");
        book.setPublish_date(LocalDate.of(2018, 05, 01));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Pete's Peas");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("9.99"));
        //add the book to test db
        book = bookDao.addBook(book);

        //make sure the book is in the test database
        assertEquals(book, bookDao.readBook(book.getBook_id()));
        //remove the book from test db
        bookDao.removeBook(book.getBook_id());

        //assert that old reference to the book in the test database now points to null
        assertNull(bookDao.readBook(book.getBook_id()));
    }

    @Test
    public void findBooksByAuthor() {
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
        author = authorDao.addAuthor(author);

        //create publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setStreet("600 8th St");
        publisher.setCity("Austin");
        publisher.setState("TX");
        publisher.setPostal_code("69332");
        publisher.setPhone("5557894561");
        publisher.setEmail("contact@penguin.com");
        publisher = publisherDao.addPublisher(publisher);

        //create book object
        Book book = new Book();
        book.setIsbn("1a2b3c4d5e");
        book.setPublish_date(LocalDate.of(2018, 05, 01));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Pete's Peas");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("9.99"));
        bookDao.addBook(book);

        //create second book object with same author
        Book book1 = new Book();
        book1.setIsbn("1g2h3j4k5l");
        book1.setPublish_date(LocalDate.of(2017, 07, 22));
        book1.setAuthor_id(author.getAuthor_id());
        book1.setTitle("Holly Loves Honey");
        book1.setPublisher_id(publisher.getPublisher_id());
        book1.setPrice(new BigDecimal("8.99"));
        bookDao.addBook(book1);

        //check that there are 2 objects in the list of books we expect to be returned
        assertEquals(2, bookDao.findBooksByAuthor(book.getAuthor_id()).size());
    }
}