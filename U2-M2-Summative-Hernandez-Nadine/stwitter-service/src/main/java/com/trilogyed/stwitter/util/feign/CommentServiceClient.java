package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.util.messages.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentServiceClient {

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public List<Comment> getAllComments();

    @RequestMapping(value = "/comments/post/{id}", method = RequestMethod.GET)
    public List<Comment> getCommentsByPostId(@PathVariable int id);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public Comment getComment(@PathVariable int id);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public void deleteComment(@PathVariable int id);
}
