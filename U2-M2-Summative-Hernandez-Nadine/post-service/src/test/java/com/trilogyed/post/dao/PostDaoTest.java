package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostDaoTest {

    @Autowired
    PostDao postDao;

    @Before
    public void setUp() throws Exception {
        postDao.getAllPosts().stream()
                .forEach(post -> postDao.deletePost(post.getPostID()));
    }

    @Test
    public void addPost() {
        Post post = new Post(LocalDate.of(2019, 7,22), "Name", "post content");
        post = postDao.addPost(post);

        assertEquals(post, postDao.getPost(post.getPostID()));
    }

    @Test
    public void getPost() {
        Post post = new Post(LocalDate.of(2019, 7,22), "Name", "post content");
        post = postDao.addPost(post);

        assertEquals(post, postDao.getPost(post.getPostID()));
    }

    @Test
    public void getAllPosts() {
        Post post = new Post(LocalDate.of(2019, 7,22), "Name", "post content");
        post = postDao.addPost(post);

        assertEquals(1, postDao.getAllPosts().size());
    }

    @Test
    public void getPostsByPoster(){
        Post post = new Post(LocalDate.of(2019, 7,22), "Name", "post content");
        post = postDao.addPost(post);

        assertEquals(1, postDao.getPostsByPoster(post.getPosterName()).size());
    }

    @Test
    public void updatePost() {
        Post post = new Post(LocalDate.of(2019, 7,22), "Name", "post content");
        post = postDao.addPost(post);

        post.setPosterName("updated name");
        post.setPostDate(LocalDate.of(2019, 8, 22));
        post.setPost("updated post");
        postDao.updatePost(post);

        assertEquals(post, postDao.getPost(post.getPostID()));
    }

    @Test
    public void deletePost() {
        Post post = new Post(LocalDate.of(2019, 7,22), "Name", "post content");
        post = postDao.addPost(post);
        postDao.deletePost(post.getPostID());

        assertNull(postDao.getPost(post.getPostID()));
    }
}