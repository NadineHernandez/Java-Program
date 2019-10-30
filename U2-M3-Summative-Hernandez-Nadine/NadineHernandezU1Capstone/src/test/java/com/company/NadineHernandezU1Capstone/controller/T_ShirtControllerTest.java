package com.company.NadineHernandezU1Capstone.controller;

import com.company.NadineHernandezU1Capstone.dto.T_Shirt;
import com.company.NadineHernandezU1Capstone.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(T_ShirtController.class)
public class T_ShirtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer repo;

    @MockBean
    private DataSource dataSource;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @WithMockUser(username = "managerUser", authorities = "ROLE_MANAGER")
    public void createT_Shirt() throws Exception{
        T_Shirt inputT_shirt = new T_Shirt();
        inputT_shirt.setT_shirt_id(1);
        inputT_shirt.setSize("Medium");
        inputT_shirt.setColor("Blue");
        inputT_shirt.setDescription("Link T-shirt");
        inputT_shirt.setPrice(new BigDecimal("19.99"));
        inputT_shirt.setQuantity(5);

        String inputJson = mapper.writeValueAsString(inputT_shirt);

        T_Shirt outputT_shirt = new T_Shirt();
        outputT_shirt.setT_shirt_id(1);
        outputT_shirt.setSize("Medium");
        outputT_shirt.setColor("Blue");
        outputT_shirt.setDescription("Link T-shirt");
        outputT_shirt.setPrice(new BigDecimal("19.99"));
        outputT_shirt.setQuantity(5);

        String outputJson = mapper.writeValueAsString(outputT_shirt);

        when(repo.saveT_Shirt(inputT_shirt)).thenReturn(outputT_shirt);

        this.mockMvc.perform(post("/tshirt/")
                .with(csrf().asHeader())
        .content(inputJson)
        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllT_Shirts() throws Exception{
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setT_shirt_id(1);
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(5);

        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt.setT_shirt_id(2);
        t_shirt1.setSize("Large");
        t_shirt1.setColor("Yellow");
        t_shirt1.setDescription("Mario Party T-Shirt");
        t_shirt1.setPrice(new BigDecimal("14.99"));
        t_shirt1.setQuantity(4);

        List<T_Shirt> t_shirtList = new ArrayList<>();
        t_shirtList.add(t_shirt);
        t_shirtList.add(t_shirt1);

        when(repo.findAllT_Shirts()).thenReturn(t_shirtList);

        List<T_Shirt> listChecker = new ArrayList<>();
        listChecker.addAll(t_shirtList);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/tshirt/")
                .with(csrf().asHeader()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllT_Shirts404() throws Exception {
        when(repo.findAllT_Shirts()).thenReturn(null);

        this.mockMvc.perform(get("/tshirt0/")
                .with(csrf().asHeader()))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getT_Shirt() throws Exception{
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setT_shirt_id(1);
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(5);

        String outputJson = mapper.writeValueAsString(t_shirt);

        when(repo.findT_Shirt(1)).thenReturn(t_shirt);

        this.mockMvc.perform(get("/tshirt/1")
                .with(csrf().asHeader()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getT_ShirtThatDoesNotExist404() throws Exception {
        T_Shirt t_shirt = null;

        int idT_ShirtDNE = 1000;

        when(repo.findT_Shirt(idT_ShirtDNE)).thenReturn(t_shirt);

        this.mockMvc.perform(get("/tshirt/" + idT_ShirtDNE)
                .with(csrf().asHeader()))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "staffUser", authorities = {"ROLE_STAFF"})
    public void updateT_Shirt() throws Exception{
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setT_shirt_id(1);
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(5);

        String inputJson = mapper.writeValueAsString(t_shirt);

        this.mockMvc.perform(put("/tshirt/" + t_shirt.getT_shirt_id())
                .with(csrf().asHeader())
        .content(inputJson)
        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "adminUser", authorities = {"ROLE_ADMIN"})
    public void deleteT_Shirt() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tshirt/1")
                .with(csrf().asHeader()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void findT_ShirtsByColor() throws Exception{
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setT_shirt_id(1);
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(5);

        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt.setT_shirt_id(2);
        t_shirt1.setSize("Large");
        t_shirt1.setColor("Blue");
        t_shirt1.setDescription("Mario Party T-Shirt");
        t_shirt1.setPrice(new BigDecimal("14.99"));
        t_shirt1.setQuantity(4);

        List<T_Shirt> t_shirtList = new ArrayList<>();
        t_shirtList.add(t_shirt);
        t_shirtList.add(t_shirt1);

        when(repo.findT_ShirtsByColor("Blue")).thenReturn(t_shirtList);

        List<T_Shirt> listChecker = new ArrayList<>();
        listChecker.addAll(t_shirtList);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/tshirt/color/Blue")
                .with(csrf().asHeader()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void findT_ShirtsBySize() throws Exception{
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setT_shirt_id(1);
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(5);

        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt.setT_shirt_id(2);
        t_shirt1.setSize("Medium");
        t_shirt1.setColor("Yellow");
        t_shirt1.setDescription("Mario Party T-Shirt");
        t_shirt1.setPrice(new BigDecimal("14.99"));
        t_shirt1.setQuantity(4);

        List<T_Shirt> t_shirtList = new ArrayList<>();
        t_shirtList.add(t_shirt);
        t_shirtList.add(t_shirt1);

        when(repo.findT_ShirtsBySize("Medium")).thenReturn(t_shirtList);

        List<T_Shirt> listChecker = new ArrayList<>();
        listChecker.addAll(t_shirtList);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/tshirt/size/Medium")
                .with(csrf().asHeader()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void findT_ShirtsByColor404() throws Exception {
        when(repo.findT_ShirtsByColor("Blue")).thenReturn(null);

        this.mockMvc.perform(get("/tshirt/color/Blue")
                .with(csrf().asHeader()))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void findT_ShirtsBySize404() throws Exception {
        when(repo.findT_ShirtsBySize("Medium")).thenReturn(null);

        this.mockMvc.perform(get("/tshirt/size/Medium")
                .with(csrf().asHeader()))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}