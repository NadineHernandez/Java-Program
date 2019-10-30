package com.company.NadineHernandezU1M5Summative.dao;

import com.company.NadineHernandezU1M5Summative.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbcTemplateImpl implements BookDao {

    //prepared statements
    private static final String INSERT_BOOK_SQL =
            "INSERT INTO book (isbn, publish_date, author_id, title, publisher_id, price)" +
                    " VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BOOK_SQL =
            "SELECT * FROM book WHERE book_id = ?";

    private static final String SELECT_ALL_BOOKS_SQL =
            "SELECT * FROM book";

    private static final String UPDATE_BOOK_SQL =
            "UPDATE book SET isbn = ?, publish_date = ?, author_id = ?, title = ?, " +
                    "publisher_id = ?, price = ? WHERE book_id = ?";

    private static final String DELETE_BOOK_SQL =
            "DELETE FROM book WHERE book_id = ?";

    private static final String SELECT_BOOKS_BY_AUTHOR =
            "SELECT * FROM book WHERE author_id = ?";

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public BookDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book addBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL, book.getIsbn(), book.getPublish_date(), book.getAuthor_id(), book.getTitle(),
                book.getPublisher_id(), book.getPrice());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        book.setBook_id(id);
        return book;
    }

    @Override
    public Book readBook(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Book> readAllBooks() {
        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL, this::mapRowToBook);
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_SQL, book.getIsbn(), book.getPublish_date(), book.getAuthor_id(), book.getTitle(),
                book.getPublisher_id(), book.getPrice(), book.getBook_id());
    }

    @Override
    public void removeBook(int id) {
        jdbcTemplate.update(DELETE_BOOK_SQL, id);
    }

    @Override
    public List<Book> findBooksByAuthor(int author_id) {
        return jdbcTemplate.query(SELECT_BOOKS_BY_AUTHOR, this::mapRowToBook, author_id);
    }

    public Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBook_id(rs.getInt("book_id"));
        book.setIsbn(rs.getString("isbn"));
        book.setPublish_date(rs.getDate("publish_date").toLocalDate());
        book.setAuthor_id(rs.getInt("author_id"));
        book.setTitle(rs.getString("title"));
        book.setPublisher_id(rs.getInt("publisher_id"));
        book.setPrice(rs.getBigDecimal("price"));

        return book;
    }
}
