package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.util.messages.Comment;
import com.trilogyed.stwitter.util.messages.Post;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import viewmodel.PostViewModel;

import javax.validation.Valid;
import java.util.List;

@RestController
@CacheConfig(cacheNames = {"stwitter"})
@RefreshScope
public class StwitterController {

    @Autowired
    ServiceLayer service;

    public StwitterController(ServiceLayer service) {
        this.service = service;
    }

    //Takes in a postViewModel and saves it by through the service layer
    //returns PostViewModel
    @CachePut(key = "#result.getPostID()")
    @PostMapping(value = "/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public PostViewModel createPost(@RequestBody @Valid PostViewModel postViewModel){
        return service.savePost(postViewModel);
    }

    //Takes in a post id int and gets the post build into a post view model through the service layer
    @Cacheable
    @GetMapping(value = "/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel getPost(@PathVariable int id){
        try {
            int tester = service.findPost(id).getPostID();
        }catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Posts found with id: " + id, e
            );
        }
        return service.findPost(id);
    }

    //passes in poster name and retrieves a list of matching post view models through the service layer
    @GetMapping(value = "/posts/user/{poster_name}")
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getPostsForPoster(@PathVariable String poster_name){
        try {
            int tester = service.findPostsByPoster(poster_name).get(0).getPostID();
        }catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Posts found for poster: " + poster_name, e
            );
        }
        return service.findPostsByPoster(poster_name);
    }

    //not sure if necessary
    //adds a comment through the service layer and returns the comment as entered
    @PostMapping(value = "/comments")
    @ResponseStatus(HttpStatus.OK)
    public Comment createComment(@RequestBody Comment comment) {
        service.createComment(comment);
        return comment;
    }

    /*@PutMapping(value = "/comments/{id}")
    public void updateComment(@RequestBody Comment comment) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, comment);
    }

    @DeleteMapping(value = "/comment/{id}")
    public void deleteComment(@PathVariable int id){

    }

    @PutMapping(value = "/posts")
    public void updatePost(@RequestBody PostViewModel postViewModel) {

    }

    @DeleteMapping(value = "/posts/{id}")
    public void deletePost(@PathVariable int id) {

    }*/

}
