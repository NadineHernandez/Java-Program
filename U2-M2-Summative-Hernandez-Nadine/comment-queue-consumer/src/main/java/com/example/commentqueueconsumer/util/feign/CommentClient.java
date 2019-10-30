package com.example.commentqueueconsumer.util.feign;

import com.example.commentqueueconsumer.util.message.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(name = "comment-service")
@RequestMapping("comment")
public interface CommentClient {
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Comment createComment(@RequestBody Comment post);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.PUT)
    public void updateComment(@RequestBody Comment post);
}
