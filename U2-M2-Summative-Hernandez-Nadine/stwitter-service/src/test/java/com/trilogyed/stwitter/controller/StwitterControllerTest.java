package com.trilogyed.stwitter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.util.messages.Comment;
import com.trilogyed.stwitter.util.messages.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import viewmodel.PostViewModel;

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
@WebMvcTest(StwitterController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class StwitterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer service;

    @MockBean
    RabbitTemplate rabbitTemplate;

    @MockBean
    CommentServiceClient commentServiceClient;

    @MockBean
    PostServiceClient postServiceClient;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createPost() throws Exception{
        PostViewModel inputPvm = new PostViewModel(LocalDate.of(2019,7,22),
                "SamplePoster", "SampleContent");

        String inputJson = mapper.writeValueAsString(inputPvm);

        PostViewModel outputPvm = new PostViewModel(LocalDate.of(2019,7,22),
                "SamplePoster", "SampleContent");
        outputPvm.setPostID(1);
        List<String> comments = new ArrayList<>();
//        outputPvm.setComments(comments);

        String outputJson = mapper.writeValueAsString(outputPvm);

        when(service.savePost(inputPvm)).thenReturn(outputPvm);

        this.mockMvc.perform(post("/posts")
        .content(inputJson)
        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getPost() throws Exception{
        PostViewModel outputPvm = new PostViewModel(LocalDate.of(2019,7,22),
                "SamplePoster", "SampleContent");
        outputPvm.setPostID(1);
        List<String> comments = new ArrayList<>();
        outputPvm.setComments(comments);

        String outputJson = mapper.writeValueAsString(outputPvm);

        when(service.findPost(1)).thenReturn(outputPvm);

        this.mockMvc.perform(get("/posts/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getPostWhenPostDoesNotExistAndReturn404()throws Exception{
        int id = 90000;

        when(service.findPost(id)).thenReturn(null);

        this.mockMvc.perform(get("/posts/90000"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getPostsForPoster() throws Exception{
        PostViewModel outputPvm = new PostViewModel(LocalDate.of(2019,7,22),
                "SamplePoster", "Sample Content");
        outputPvm.setPostID(1);
        List<String> comments = new ArrayList<>();
        outputPvm.setComments(comments);

        List<PostViewModel> pvms = new ArrayList<>();
        pvms.add(outputPvm);

        when(service.findPostsByPoster(outputPvm.getPosterName())).thenReturn(pvms);

        List<PostViewModel> listChecker = new ArrayList<>();
        listChecker.addAll(pvms);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/posts/user/SamplePoster"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getPostsByPosterThatDoesNotExistAndReturn404()throws Exception{
        String poster = "posterThatDNEInDataBase";

        when(service.findPostsByPoster(poster)).thenReturn(null);

        this.mockMvc.perform(get("/posts/poster/posterThatDNEInDataBase"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void createComment() throws Exception{
        Comment comment = new Comment(1, LocalDate.of(2019,8,22),
                "Sample Commenter", "Sample Comment");

        String inputJson = mapper.writeValueAsString(comment);

        this.mockMvc.perform(post("/comments")
        .content(inputJson)
        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }
}