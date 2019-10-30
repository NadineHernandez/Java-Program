package com.company.NadineHernandezU1M5Summative.controller;

import com.company.NadineHernandezU1M5Summative.dao.AuthorDao;
import com.company.NadineHernandezU1M5Summative.dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//all paths will have /author before additions
@RequestMapping("/author")
public class AuthorController {

    //get access to authorDao
    @Autowired
    AuthorDao authorDao;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody @Valid Author author){
        return authorDao.addAuthor(author);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthors(){
        List<Author> authorList = authorDao.readAllAuthors();

        return authorList;
    }

    @RequestMapping(value = "/{author_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthor(@PathVariable int author_id){
        return authorDao.readAuthor(author_id);
    }

    @RequestMapping(value = "/{author_id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateAuthor(@PathVariable int author_id, @RequestBody Author author){
        author.setAuthor_id(author_id);
        authorDao.updateAuthor(author);
    }

    @RequestMapping(value = "/{author_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(@PathVariable int author_id){
        authorDao.removeAuthor(author_id);
    }
}
