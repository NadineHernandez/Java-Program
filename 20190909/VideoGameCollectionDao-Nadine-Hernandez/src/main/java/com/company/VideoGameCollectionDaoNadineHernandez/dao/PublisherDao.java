package com.company.VideoGameCollectionDaoNadineHernandez.dao;

import com.company.VideoGameCollectionDaoNadineHernandez.models.Publisher;

import java.util.List;

public interface PublisherDao {
    Publisher createPublisher(Publisher publisher);
    Publisher readPublisher(int id);
    List<Publisher> readAllPublishers();
    void updatePublisher(Publisher publisher);
    void deletePublisher(int id);
}
