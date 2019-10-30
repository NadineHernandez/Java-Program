package com.trilogyed.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostDao repo;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createPost() throws Exception{
        Post inputPost = new Post(LocalDate.of(2019, 7,22), "Name", "post content");

        String inputJson = mapper.writeValueAsString(inputPost);

        Post outputPost = new Post(LocalDate.of(2019, 7,22), "Name", "post content");
        outputPost.setPostID(1);

        String outputJson = mapper.writeValueAsString(outputPost);

        when(repo.addPost(inputPost)).thenReturn(outputPost);

        this.mockMvc.perform(post("/posts")
        .content(inputJson)
        .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllPosts() throws Exception{
        Post outputPost = new Post(LocalDate.of(2019, 7,22), "Name", "post content");
        outputPost.setPostID(1);

        List<Post> posts = new ArrayList<>();
        posts.add(outputPost);

        when(repo.getAllPosts()).thenReturn(posts);

        List<Post> listChecker = new ArrayList<>();
        listChecker.addAll(posts);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/posts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllPostsWhenNoneExistAndReturn404() throws Exception{
        when(repo.getAllPosts()).thenReturn(null);

        this.mockMvc.perform(get("/posts"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getPost() throws Exception{
        Post outputPost = new Post(LocalDate.of(2019, 7,22), "Name", "post content");
        outputPost.setPostID(1);

        String outputJson = mapper.writeValueAsString(outputPost);

        when(repo.getPost(1)).thenReturn(outputPost);

        this.mockMvc.perform(get("/posts/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getPostThatDoesNotExistAndReturns404() throws Exception{
        int id = 90000;

        when(repo.getPost(id)).thenReturn(null);

        this.mockMvc.perform(get("/posts/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getPostsByPoster() throws Exception{
        Post outputPost = new Post(LocalDate.of(2019, 7,22), "Name", "post content");
        outputPost.setPostID(1);

        List<Post> posts = new ArrayList<>();
        posts.add(outputPost);

        when(repo.getPostsByPoster("Name")).thenReturn(posts);

        List<Post> listChecker = new ArrayList<>();
        listChecker.addAll(posts);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/posts/poster/Name"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getPostsByPosterThatDoesNotExistAndReturn404()throws Exception{
        String poster = "posterThatDNEInDatabase";

        when(repo.getPostsByPoster(poster)).thenReturn(null);

        this.mockMvc.perform(get("/posts/poster/posterThatDNEInDatabase"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void updatePost() throws Exception{
        Post outputPost = new Post(LocalDate.of(2019, 7,22), "Name", "post content");
        outputPost.setPostID(1);

        String inputJson = mapper.writeValueAsString(outputPost);

        this.mockMvc.perform(put("/posts")
        .content(inputJson)
        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deletePost() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/posts/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}