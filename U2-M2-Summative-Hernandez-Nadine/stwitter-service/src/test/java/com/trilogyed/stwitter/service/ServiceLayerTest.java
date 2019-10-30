package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.util.messages.Comment;
import com.trilogyed.stwitter.util.messages.Post;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import viewmodel.PostViewModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class ServiceLayerTest {

    private ServiceLayer serviceLayer;
    private PostServiceClient postClient;
    private CommentServiceClient commentClient;
    private RabbitTemplate rabbitTemplate;

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create";

    private void setUpPostClientMock(){
        postClient = mock(PostServiceClient.class);

        Post post = new Post(LocalDate.of(2019,7,22),
                "Sample Poster", "Sample Content");
        post.setPostID(1);

        Post post1 = new Post(LocalDate.of(2019,7,22),
                "Sample Poster", "Sample Content");

        List<Post> posts = new ArrayList<>();
        posts.add(post);

        doReturn(post).when(postClient).createPost(post1);
        doReturn(post).when(postClient).getPost(1);
        doReturn(posts).when(postClient).getAllPosts();
        doReturn(posts).when(postClient).getPostsByPoster(post.getPosterName());
    }

    private void setUpCommentClientMock(){
        commentClient = mock(CommentServiceClient.class);
        rabbitTemplate = mock(RabbitTemplate.class);

        Comment comment = new Comment(1, LocalDate.of(2019,8,22),
                "Sample Commenter", "Sample Comment");
        comment.setCommentId(1);

        Comment comment1 = new Comment(1, LocalDate.of(2019,8,22),
                "Sample Commenter", "Sample Comment");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        doReturn(comment).when(commentClient).getComment(1);
        doReturn(comments).when(commentClient).getAllComments();
        doReturn(comments).when(commentClient).getCommentsByPostId(1);
    }

    @Before
    public void setUp() throws Exception {
        setUpCommentClientMock();
        setUpPostClientMock();
        serviceLayer = new ServiceLayer(postClient, commentClient, rabbitTemplate);
    }

    @Test
    public void savePost() {
        PostViewModel post = new PostViewModel(LocalDate.of(2019,7,22),
                "Sample Poster", "Sample Content");

        post = serviceLayer.savePost(post);
        assertEquals(post, serviceLayer.findPost(post.getPostID()));
    }

    @Test
    public void findPost() {
        PostViewModel post = new PostViewModel(LocalDate.of(2019,7,22),
                "Sample Poster", "Sample Content");

        post = serviceLayer.savePost(post);
        assertEquals(post, serviceLayer.findPost(post.getPostID()));
    }

    @Test
    public void findPostsByPoster() {
        PostViewModel post = new PostViewModel(LocalDate.of(2019,7,22),
                "Sample Poster", "Sample Content");

        post = serviceLayer.savePost(post);
        List<PostViewModel> posts = new ArrayList<>();
        posts.add(post);
        assertEquals(posts, serviceLayer.findPostsByPoster(post.getPosterName()));
    }

    @Test
    public void updatePost() {
        PostViewModel post = new PostViewModel(LocalDate.of(2019,7,22),
                "Sample Poster", "Sample Content");

        post = serviceLayer.savePost(post);

        ArgumentCaptor<Post> postCaptor = ArgumentCaptor.forClass(Post.class);
        serviceLayer.updatePost(post);

        verify(postClient, times(1)).updatePost(postCaptor.capture());

    }

    @Test
    public void deletePost() {
        PostViewModel post = new PostViewModel(LocalDate.of(2019,7,22),
                "Sample Poster", "Sample Content");

        post = serviceLayer.savePost(post);

        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        serviceLayer.deletePost(post.getPostID());

        verify(postClient, times(1)).deletePost(idCaptor.capture());
        assertEquals(1, idCaptor.getValue().intValue());
    }

    @Test
    public void deleteComment() {
        Comment comment = new Comment(1, LocalDate.of(2019,8,22),
                "Sample Commenter", "Sample Comment");
        comment.setCommentId(1);

        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        serviceLayer.deleteComment(comment.getCommentId());

        verify(commentClient, times(1)).deleteComment(idCaptor.capture());
        assertEquals(1, idCaptor.getValue().intValue());
    }

    @Test
    public void createComment(){
        Comment comment = new Comment(1, LocalDate.of(2019,8,22),
                "Sample Commenter", "Sample Comment");

        ArgumentCaptor<String> exchangeCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> routingKeyCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Comment> commentCaptor = ArgumentCaptor.forClass(Comment.class);
        serviceLayer.createComment(comment);

        verify(rabbitTemplate, times(1)).convertAndSend(exchangeCaptor.capture(), routingKeyCaptor.capture(), commentCaptor.capture());
        assertEquals(comment, commentCaptor.getValue());
    }
}