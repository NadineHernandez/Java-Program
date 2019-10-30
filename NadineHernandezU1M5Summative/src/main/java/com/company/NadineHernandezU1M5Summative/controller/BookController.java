package com.company.NadineHernandezU1M5Summative.controller;

import com.company.NadineHernandezU1M5Summative.dao.BookDao;
import com.company.NadineHernandezU1M5Summative.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//all paths will have /book before additions
@RequestMapping("/book")
public class BookController {

    //get access to bookDao
    @Autowired
    BookDao bookDao;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody @Valid Book book){
        return bookDao.addBook(book);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){
        List<Book> bookList = bookDao.readAllBooks();

        return bookList;
    }

    @RequestMapping(value = "/{book_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable int book_id){
        return bookDao.readBook(book_id);
    }

    @RequestMapping(value = "/{book_id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable int book_id, @RequestBody Book book){
        book.setBook_id(book_id);
        bookDao.updateBook(book);
    }

    @RequestMapping(value = "/{book_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable int book_id){
        bookDao.removeBook(book_id);
    }

    @RequestMapping(value = "/author/{author_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByAuthor(@PathVariable int author_id){
        List<Book> bookList = bookDao.findBooksByAuthor(author_id);

        return bookList;
    }
}
