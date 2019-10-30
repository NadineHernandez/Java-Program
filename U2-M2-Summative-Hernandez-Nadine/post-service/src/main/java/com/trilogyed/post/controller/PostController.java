package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
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
@CacheConfig(cacheNames = {"post"})
public class PostController {

    @Autowired
    private PostDao postDao;

    @CachePut(key = "#result.getPostID()")
    @PostMapping(value = "/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        return postDao.addPost(post);
    }

    @GetMapping(value = "/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPosts(){
        try {
            int tester = postDao.getAllPosts().get(0).getPostID();
        }catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Posts found", e
            );
        }
        return postDao.getAllPosts();
    }

    @Cacheable
    @GetMapping(value = "/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable int id) {
        try {
            int tester = postDao.getPost(id).getPostID();
        }catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Posts found with id: " + id, e
            );
        }
        return postDao.getPost(id);
    }

    @GetMapping(value = "/posts/poster/{poster}")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getPostsByPoster(@PathVariable String poster){
        try {
            int tester = postDao.getPostsByPoster(poster).get(0).getPostID();
        }catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Posts found with Poster: " + poster, e
            );
        }
        return postDao.getPostsByPoster(poster);
    }

    @CacheEvict(key = "#post.getPostID()")
    @PutMapping(value = "/posts")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@RequestBody Post post) {
        postDao.updatePost(post);
    }

    @CacheEvict
    @DeleteMapping(value = "/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable int id) {
        postDao.deletePost(id);
    }
}
