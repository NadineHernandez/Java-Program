package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.util.messages.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post-service")
public interface PostServiceClient {
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody Post post);

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts();

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id);

    @GetMapping(value = "/posts/poster/{poster}")
    public List<Post> getPostsByPoster(@PathVariable String poster);

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post);

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public void deletePost(@PathVariable int id);
}
