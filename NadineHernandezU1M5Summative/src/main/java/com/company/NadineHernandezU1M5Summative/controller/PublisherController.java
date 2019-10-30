package com.company.NadineHernandezU1M5Summative.controller;

import com.company.NadineHernandezU1M5Summative.dao.PublisherDao;
import com.company.NadineHernandezU1M5Summative.dto.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//all paths will have /publisher before additions
@RequestMapping("/publisher")
public class PublisherController {

    //get access to publisherDao
    @Autowired
    PublisherDao publisherDao;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher createPublisher(@RequestBody @Valid Publisher publisher){
        return publisherDao.addPublisher(publisher);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> getAllPublishers(){
        List<Publisher> publisherList = publisherDao.readAllPublishers();

        return publisherList;
    }

    @RequestMapping(value = "/{publisher_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Publisher getPublisher(@PathVariable int publisher_id){
        return publisherDao.readPublisher(publisher_id);
    }

    @RequestMapping(value = "/{publisher_id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePublisher(@PathVariable int publisher_id, @RequestBody Publisher publisher){
        publisher.setPublisher_id(publisher_id);
        publisherDao.updatePublisher(publisher);
    }

    @RequestMapping(value = "/{publisher_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePublisher(@PathVariable int publisher_id){
        publisherDao.deletePublisher(publisher_id);
    }
}
