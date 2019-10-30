package com.company.NadineHernandezU1M5Summative.dao;

import com.company.NadineHernandezU1M5Summative.dto.Book;

import java.util.List;

public interface BookDao {
    Book addBook(Book book);
    Book readBook(int id);
    List<Book> readAllBooks();
    void updateBook(Book book);
    void removeBook(int id);
    List<Book> findBooksByAuthor(int author_id);
}
