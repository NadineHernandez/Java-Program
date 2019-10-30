package com.company.NadineHernandezU1M5Summative.dao;

import com.company.NadineHernandezU1M5Summative.dto.Author;

import java.util.List;

public interface AuthorDao {
    Author addAuthor(Author author);
    Author readAuthor(int id);
    List<Author> readAllAuthors();
    void updateAuthor(Author author);
    void removeAuthor(int id);
}
