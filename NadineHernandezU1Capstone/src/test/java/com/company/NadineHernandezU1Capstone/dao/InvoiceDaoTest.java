package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.Invoice;
import com.company.NadineHernandezU1Capstone.dto.T_Shirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    T_ShirtDao t_shirtDao;

    @Before
    public void setUp() throws Exception {
        //make a list of all invoices
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        //go through list and for each invoice, delete it from the db
        for(Invoice invoice : invoiceList){
            invoiceDao.deleteInvoice(invoice.getInvoice_id());
        }

        //make a list of all tshirts
        List<T_Shirt> t_shirtList = t_shirtDao.getAllT_Shirts();

        //go through list and for each tshirt, delete it from the db
        for(T_Shirt t_shirt : t_shirtList){
            t_shirtDao.deleteT_Shirt(t_shirt.getT_shirt_id());
        }
    }

    @Test
    public void addInvoice() {
        //create new t-shirt object to be purchased in invoice
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("20.00"));
        t_shirt.setQuantity(5);
        //add to db
        t_shirt = t_shirtDao.addT_Shirt(t_shirt);

        //create new invoice
        Invoice invoice = new Invoice();
        invoice.setName("Nadine");
        invoice.setStreet("4304 Alison Jane Dr");
        invoice.setCity("Kennesaw");
        invoice.setState("GA");
        invoice.setZipcode("30144");
        invoice.setItem_type("T-Shirt");
        invoice.setItem_id(t_shirt.getT_shirt_id());
        invoice.setUnit_price(t_shirt.getPrice());
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("40.00"));
        invoice.setTax(new BigDecimal("0.07"));
        invoice.setProcessing_fee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("44.78"));
        invoice = invoiceDao.addInvoice(invoice);

        Invoice myinvoice = invoiceDao.getInvoice(invoice.getInvoice_id());
        //assert that local invoice matched invoice in db
        assertEquals(invoice, invoiceDao.getInvoice(invoice.getInvoice_id()));
    }

    @Test
    public void getInvoice() {
        //create new t-shirt object to be purchased in invoice
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("20.00"));
        t_shirt.setQuantity(5);
        //add to db
        t_shirt = t_shirtDao.addT_Shirt(t_shirt);

        //create new invoice
        Invoice invoice = new Invoice();
        invoice.setName("Nadine");
        invoice.setStreet("4304 Alison Jane Dr");
        invoice.setCity("Kennesaw");
        invoice.setState("GA");
        invoice.setZipcode("30144");
        invoice.setItem_type("T-Shirt");
        invoice.setItem_id(t_shirt.getT_shirt_id());
        invoice.setUnit_price(t_shirt.getPrice());
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("40.00"));
        invoice.setTax(new BigDecimal("0.07"));
        invoice.setProcessing_fee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("44.78"));
        invoice = invoiceDao.addInvoice(invoice);

        //assert that local invoice matched invoice in db
        assertEquals(invoice, invoiceDao.getInvoice(invoice.getInvoice_id()));
    }

    @Test
    public void getAllInvoices() {
        //create new t-shirt object to be purchased in invoice
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("20.00"));
        t_shirt.setQuantity(5);
        //add to db
        t_shirt = t_shirtDao.addT_Shirt(t_shirt);

        //create new invoice
        Invoice invoice = new Invoice();
        invoice.setName("Nadine");
        invoice.setStreet("4304 Alison Jane Dr");
        invoice.setCity("Kennesaw");
        invoice.setState("GA");
        invoice.setZipcode("30144");
        invoice.setItem_type("T-Shirt");
        invoice.setItem_id(t_shirt.getT_shirt_id());
        invoice.setUnit_price(t_shirt.getPrice());
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("40.00"));
        invoice.setTax(new BigDecimal("0.07"));
        invoice.setProcessing_fee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("44.78"));
        //add invoice to db
        invoiceDao.addInvoice(invoice);

        //create second new invoice
        Invoice invoice1 = new Invoice();
        invoice1.setName("Barbara");
        invoice1.setStreet("3201 Heritage Walk Ln");
        invoice1.setCity("Duluth");
        invoice1.setState("GA");
        invoice1.setZipcode("30069");
        invoice1.setItem_type("T-Shirt");
        invoice1.setItem_id(t_shirt.getT_shirt_id());
        invoice1.setUnit_price(t_shirt.getPrice());
        invoice1.setQuantity(1);
        invoice1.setSubtotal(new BigDecimal("20.00"));
        invoice1.setTax(new BigDecimal("0.07"));
        invoice1.setProcessing_fee(new BigDecimal("1.98"));
        invoice1.setTotal(new BigDecimal("23.38"));
        //add invoice to db
        invoiceDao.addInvoice(invoice1);

        //assert that there are now 2 invoices in the db
        assertEquals(2, invoiceDao.getAllInvoices().size());
    }

    @Test
    public void updateInvoice() {
        //create new t-shirt object to be purchased in invoice
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("20.00"));
        t_shirt.setQuantity(5);
        //add to db
        t_shirt = t_shirtDao.addT_Shirt(t_shirt);

        //create new invoice
        Invoice invoice = new Invoice();
        invoice.setName("Nadine");
        invoice.setStreet("4304 Alison Jane Dr");
        invoice.setCity("Kennesaw");
        invoice.setState("GA");
        invoice.setZipcode("30144");
        invoice.setItem_type("T-Shirt");
        invoice.setItem_id(t_shirt.getT_shirt_id());
        invoice.setUnit_price(t_shirt.getPrice());
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("40.00"));
        invoice.setTax(new BigDecimal("0.07"));
        invoice.setProcessing_fee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("44.78"));
        //add invoice to db
        invoice = invoiceDao.addInvoice(invoice);

        //change invoice properties
        invoice.setName("Barbara");
        invoice.setStreet("3201 Heritage Walk Ln");
        invoice.setCity("Duluth");
        invoice.setState("GA");
        invoice.setZipcode("30069");
        invoice.setItem_type("T-Shirt");
        invoice.setItem_id(t_shirt.getT_shirt_id());
        invoice.setUnit_price(t_shirt.getPrice());
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("20.00"));
        invoice.setTax(new BigDecimal("0.07"));
        invoice.setProcessing_fee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("23.38"));
        //update invoice in db
        invoiceDao.updateInvoice(invoice);

        //assert that local invoice matches with update invoice in db
        assertEquals(invoice, invoiceDao.getInvoice(invoice.getInvoice_id()));
    }

    @Test
    public void deleteInvoice() {
        //create new t-shirt object to be purchased in invoice
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("20.00"));
        t_shirt.setQuantity(5);
        //add to db
        t_shirt = t_shirtDao.addT_Shirt(t_shirt);

        //create new invoice
        Invoice invoice = new Invoice();
        invoice.setName("Nadine");
        invoice.setStreet("4304 Alison Jane Dr");
        invoice.setCity("Kennesaw");
        invoice.setState("GA");
        invoice.setZipcode("30144");
        invoice.setItem_type("T-Shirt");
        invoice.setItem_id(t_shirt.getT_shirt_id());
        invoice.setUnit_price(t_shirt.getPrice());
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("40.00"));
        invoice.setTax(new BigDecimal("0.07"));
        invoice.setProcessing_fee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("44.78"));
        invoice = invoiceDao.addInvoice(invoice);

        //assert that invoice is in db
        assertEquals(invoice, invoiceDao.getInvoice(invoice.getInvoice_id()));
        //delete invoice from db
        invoiceDao.deleteInvoice(invoice.getInvoice_id());
        //assert that invoice is no longer in db
        assertNull(invoiceDao.getInvoice(invoice.getInvoice_id()));
    }
}