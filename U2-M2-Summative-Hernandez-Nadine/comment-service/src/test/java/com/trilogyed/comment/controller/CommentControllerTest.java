package com.trilogyed.comment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
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
@WebMvcTest(CommentController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentDao repo;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createComment() throws Exception{
        Comment inputComment = new Comment(1, LocalDate.of(2019, 7, 30),
                "Sample Name", "Sample Comment");

        String inputJson = mapper.writeValueAsString(inputComment);

        Comment outputComment = new Comment(1, LocalDate.of(2019, 7, 30),
                "Sample Name", "Sample Comment");
        outputComment.setCommentId(1);

        String outputJson = mapper.writeValueAsString(outputComment);

        when(repo.addComment(inputComment)).thenReturn(outputComment);

        this.mockMvc.perform(post("/comments")
        .content(inputJson)
        .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllComments() throws Exception{
        Comment outputComment = new Comment(1, LocalDate.of(2019, 7, 30),
                "Sample Name", "Sample Comment");
        outputComment.setCommentId(1);

        List<Comment> comments = new ArrayList<>();
        comments.add(outputComment);

        when(repo.getAllComments()).thenReturn(comments);

        List<Comment> listChecker = new ArrayList<>();
        listChecker.addAll(comments);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/comments"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllCommentWhenNoneExistAndReturn404()throws Exception{
        when(repo.getAllComments()).thenReturn(null);

        this.mockMvc.perform(get("/posts"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getCommentsByPostId() throws Exception{
        Comment outputComment = new Comment(1, LocalDate.of(2019, 7, 30),
                "Sample Name", "Sample Comment");
        outputComment.setCommentId(1);

        List<Comment> comments = new ArrayList<>();
        comments.add(outputComment);

        when(repo.getCommentsByPostId(1)).thenReturn(comments);

        List<Comment> listChecker = new ArrayList<>();
        listChecker.addAll(comments);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/comments/post/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getCommentByPostIdThatDoesNotExistAndReturn404()throws Exception{
        int id = 90000;

        when(repo.getCommentsByPostId(id)).thenReturn(null);

        this.mockMvc.perform(get("/posts/poster/90000"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getComment() throws Exception{
        Comment outputComment = new Comment(1, LocalDate.of(2019, 7, 30),
                "Sample Name", "Sample Comment");
        outputComment.setCommentId(1);

        String outputJson = mapper.writeValueAsString(outputComment);

        when(repo.getComment(1)).thenReturn(outputComment);

        this.mockMvc.perform(get("/comments/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getCommentThatDoesNotExistAndReturn404()throws Exception{
        int id = 90000;

        when(repo.getComment(id)).thenReturn(null);

        this.mockMvc.perform(get("/posts/90000"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateComment() throws Exception {
        Comment inputComment = new Comment(1, LocalDate.of(2019, 7, 30),
                "Sample Name", "Sample Comment");
        inputComment.setCommentId(1);

        String inputJson = mapper.writeValueAsString(inputComment);

        this.mockMvc.perform(put("/comments")
        .content(inputJson)
        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteComment() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/comments/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}