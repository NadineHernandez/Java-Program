package com.company.NadineHernandezU1M5Summative.dao;

import com.company.NadineHernandezU1M5Summative.dto.Publisher;

import java.util.List;

public interface PublisherDao {
    Publisher addPublisher(Publisher publisher);
    Publisher readPublisher(int id);
    List<Publisher> readAllPublishers();
    void updatePublisher(Publisher publisher);
    void deletePublisher(int id);
}
