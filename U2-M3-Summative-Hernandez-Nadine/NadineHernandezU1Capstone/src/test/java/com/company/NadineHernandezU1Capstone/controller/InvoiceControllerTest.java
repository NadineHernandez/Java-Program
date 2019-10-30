package com.company.NadineHernandezU1Capstone.controller;

import com.company.NadineHernandezU1Capstone.dto.Invoice;
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

import javax.sql.DataSource;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

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
    public void createInvoice() throws Exception{
        Invoice inputInvoice = new Invoice();
        inputInvoice.setInvoice_id(1);
        inputInvoice.setName("Nadine");
        inputInvoice.setStreet("4304 Alison Jane Dr");
        inputInvoice.setCity("Kennesaw");
        inputInvoice.setState("GA");
        inputInvoice.setZipcode("30144");
        inputInvoice.setItem_type("T-Shirt");
        inputInvoice.setItem_id(1);
        inputInvoice.setQuantity(2);

        String inputJson = mapper.writeValueAsString(inputInvoice);

        Invoice outputInvoice = new Invoice();
        outputInvoice.setInvoice_id(1);
        outputInvoice.setName("Nadine");
        outputInvoice.setStreet("4304 Alison Jane Dr");
        outputInvoice.setCity("Kennesaw");
        outputInvoice.setState("GA");
        outputInvoice.setZipcode("30144");
        outputInvoice.setItem_type("T-Shirt");
        outputInvoice.setItem_id(1);
        outputInvoice.setUnit_price(new BigDecimal("19.99"));
        outputInvoice.setQuantity(2);
        outputInvoice.setSubtotal(new BigDecimal("39.98"));
        outputInvoice.setTax(new BigDecimal("0.07"));
        outputInvoice.setProcessing_fee(new BigDecimal("1.98"));
        outputInvoice.setTotal(new BigDecimal("44.7586"));

        String outputJson = mapper.writeValueAsString(outputInvoice);

        when(repo.saveInvoice(inputInvoice)).thenReturn(outputInvoice);

        this.mockMvc.perform(post("/purchase/")
                .with(csrf().asHeader())
        .content(inputJson)
        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }
}