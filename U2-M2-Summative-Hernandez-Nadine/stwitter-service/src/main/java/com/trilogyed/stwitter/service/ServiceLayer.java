package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.util.messages.Comment;
import com.trilogyed.stwitter.util.messages.Post;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import viewmodel.PostViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceLayer {
    //Feign Clients
    private PostServiceClient postClient;

    private CommentServiceClient commentClient;

    private RabbitTemplate rabbitTemplate;

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create";

    @Autowired
    public ServiceLayer(PostServiceClient postClient, CommentServiceClient commentClient, RabbitTemplate rabbitTemplate) {
        this.postClient = postClient;
        this.commentClient = commentClient;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Transactional
    public PostViewModel savePost(PostViewModel pvm){
        //assign pvm values to a post
        Post post = new Post(pvm.getPostDate(), pvm.getPosterName(), pvm.getPostContent());
        //save post in db and assign post to reflect post in db
        post = postClient.createPost(post);
        //send post to the builder which returns a full postviewmodel
        return buildPostViewModel(post);
    }

    //converts a post into a post view model
    private PostViewModel buildPostViewModel(Post post){
        //create a list of strings to hold comment strings
        List<String> comments = new ArrayList<>();
        //gets every comment matching the post id
        //converts comments to string
        //and adds string comments to list of strings
        commentClient.getCommentsByPostId(post.getPostID()).stream()
                .forEach(comment -> {
                    comments.add(comment.toString());
                });
        //assign values from post to post view model
        PostViewModel pvm = new PostViewModel(post.getPostDate(), post.getPosterName(), post.getPost());
        pvm.setPostID(post.getPostID());
        //assign comments to post view model
        pvm.setComments(comments);
        return pvm;
    }

    //gets post by post id from post feign client
    public PostViewModel findPost(int id){
        Post post = postClient.getPost(id);
        //converts post to pvm via build method and returns it
        return buildPostViewModel(post);
    }

    //gets a list of post view models by poster name from post feign client
    public List<PostViewModel> findPostsByPoster(String postName){
        //sends each post through the build method and collects them to a list of post view models
        List<PostViewModel> posts = postClient.getPostsByPoster(postName).stream()
                .map(this::buildPostViewModel)
                .collect(Collectors.toList());
        //returns the list of post view models
        return posts;
    }

    //updates a post through the post feign client
    @Transactional
    public void updatePost(PostViewModel pvm){
        //assigns values from pvm to a new post
        Post post = new Post(pvm.getPostDate(), pvm.getPosterName(), pvm.getPostContent());
        post.setPostID(pvm.getPostID());

        //used post to update post through feign client
        postClient.updatePost(post);

    }

    @Transactional
    public void deletePost(int id){
        //deletes post via post feign matching id
        postClient.deletePost(id);
    }

    @Transactional
    public void deleteComment(int id){
        //deletes post via comment feign matching id
        commentClient.deleteComment(id);
    }

    @Transactional
    public void createComment(Comment comment){
        //try catch determines if post matching comment's post id exists
        Post postTest;
        try{
            postTest = postClient.getPost(comment.getPostId());
            int tester = postTest.getPostID();
        } catch (Exception e){
            throw new IllegalArgumentException("No post matching post id");
        }

        //if matching post exists that send comment to que
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, comment);
    }
}
