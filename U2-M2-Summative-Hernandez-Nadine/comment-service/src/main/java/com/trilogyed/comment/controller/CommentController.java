package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RefreshScope
@CacheConfig(cacheNames = {"comment"})
public class CommentController {
    @Autowired
    CommentDao commentDao;

    @CachePut(key = "#result.getCommentId()")
    @PostMapping(value = "/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment comment) {
        return commentDao.addComment(comment);
    }

    @GetMapping(value = "/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComments(){
        try {
            int tester = commentDao.getAllComments().get(0).getCommentId();
        }catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Comments found", e
            );
        }
        return commentDao.getAllComments();
    }

    @GetMapping(value = "/comments/post/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getCommentsByPostId(@PathVariable int id){
        try {
            int tester = commentDao.getCommentsByPostId(id).get(0).getPostId();
        }catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Comments found with post id: " + id, e
            );
        }
        return commentDao.getCommentsByPostId(id);
    }

    @Cacheable
    @GetMapping(value = "/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment getComment(@PathVariable int id) {
        try {
            int tester = commentDao.getComment(id).getCommentId();
        }catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Comments found with id: " + id, e
            );
        }
        return commentDao.getComment(id);
    }

    @CacheEvict(key = "#comment.getCommentId()")
    @PutMapping(value = "/comments")
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@RequestBody Comment comment) {
        commentDao.updateComment(comment);
    }

    @CacheEvict
    @DeleteMapping(value = "/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable int id) {
        commentDao.deleteComment(id);
    }
}
