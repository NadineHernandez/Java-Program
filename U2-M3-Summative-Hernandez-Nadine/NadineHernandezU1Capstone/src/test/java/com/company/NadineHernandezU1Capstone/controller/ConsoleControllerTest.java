package com.company.NadineHernandezU1Capstone.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import com.company.NadineHernandezU1Capstone.dto.Console;
import com.company.NadineHernandezU1Capstone.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer repo;

    @MockBean
    DataSource dataSource;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    @WithMockUser(username = "managerUser", authorities = "ROLE_MANAGER")
    public void createConsole() throws Exception {
        Console inputConsole = new Console();
        inputConsole.setModel("Wii");
        inputConsole.setManufacturer("Nitendo");
        inputConsole.setMemory_amount("32GB");
        inputConsole.setProcessor("JX2500");
        inputConsole.setPrice(new BigDecimal("299.99"));
        inputConsole.setQuantity(50);

        String inputJson = mapper.writeValueAsString(inputConsole);

        Console outputConsole = new Console();
        outputConsole.setConsole_id(1);
        outputConsole.setModel("Wii");
        outputConsole.setManufacturer("Nitendo");
        outputConsole.setMemory_amount("32GB");
        outputConsole.setProcessor("JX2500");
        outputConsole.setPrice(new BigDecimal("299.99"));
        outputConsole.setQuantity(50);

        String outputJson = mapper.writeValueAsString(outputConsole);

        when(repo.saveConsole(inputConsole)).thenReturn(outputConsole);

        this.mockMvc.perform(post("/console/")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllConsoles() throws Exception{
        Console console = new Console();
        console.setConsole_id(1);
        console.setModel("Wii");
        console.setManufacturer("Nitendo");
        console.setMemory_amount("32GB");
        console.setProcessor("JX2500");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(50);

        //create a second new console
        Console console1 = new Console();
        console.setConsole_id(2);
        console1.setModel("Wii-U");
        console1.setManufacturer("Nitendo");
        console1.setMemory_amount("64GB");
        console1.setProcessor("JX2800");
        console1.setPrice(new BigDecimal("349.99"));
        console1.setQuantity(75);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);
        consoleList.add(console1);

        when(repo.findAllConsoles()).thenReturn(consoleList);

        List<Console> listChecker = new ArrayList<>();
        listChecker.addAll(consoleList);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform((get("/console/").with(csrf().asHeader())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getConsole() throws Exception{
        Console console = new Console();
        console.setConsole_id(1);
        console.setModel("Wii");
        console.setManufacturer("Nitendo");
        console.setMemory_amount("32GB");
        console.setProcessor("JX2500");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(50);

        String outputJson = mapper.writeValueAsString(console);

        when(repo.findConsole(1)).thenReturn(console);

        this.mockMvc.perform((get("/console/1").with(csrf().asHeader())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getConsoleThatDoesNotExist404() throws Exception {
        int idConsoleDNE = 1000;

        when(repo.findConsole(idConsoleDNE)).thenReturn(null);

        this.mockMvc.perform((get("/console/" + idConsoleDNE).with(csrf().asHeader())))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

    @Test
    public void getAllConsoles404() throws Exception {
        when(repo.findAllConsoles()).thenReturn(null);

        this.mockMvc.perform((get("/console/").with(csrf().asHeader())))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "staffUser", authorities = {"ROLE_STAFF"})
    public void updateConsole() throws Exception{
        Console console = new Console();
        console.setConsole_id(1);
        console.setModel("Wii");
        console.setManufacturer("Nitendo");
        console.setMemory_amount("32GB");
        console.setProcessor("JX2500");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(50);

        String inputJson = mapper.writeValueAsString(console);

        this.mockMvc.perform((put("/console/" + console.getConsole_id()).with(csrf().asHeader()))
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "adminUser", authorities = {"ROLE_ADMIN"})
    public void deleteConsole() throws Exception{
        this.mockMvc.perform((MockMvcRequestBuilders.delete("/console/1").with(csrf().asHeader())))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void findConsolesByManufacturer404() throws Exception{
        when(repo.findConsolesByManufacturer("Nitendo")).thenReturn(null);

        this.mockMvc.perform((get("/console/manufacturer/Nitendo").with(csrf().asHeader())))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void findConsolesByManufacturer() throws Exception{
        Console console = new Console();
        console.setConsole_id(1);
        console.setModel("Wii");
        console.setManufacturer("Nitendo");
        console.setMemory_amount("32GB");
        console.setProcessor("JX2500");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(50);

        Console console1 = new Console();
        console.setConsole_id(2);
        console1.setModel("Wii-U");
        console1.setManufacturer("Nitendo");
        console1.setMemory_amount("64GB");
        console1.setProcessor("JX2800");
        console1.setPrice(new BigDecimal("349.99"));
        console1.setQuantity(75);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);
        consoleList.add(console1);

        when(repo.findConsolesByManufacturer("Nitendo")).thenReturn(consoleList);

        List<Console> listChecker = new ArrayList<>();
        listChecker.addAll(consoleList);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform((get("/console/manufacturer/Nitendo").with(csrf().asHeader())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
}