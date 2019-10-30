package com.company.NadineHernandezU1Capstone.service;

import com.company.NadineHernandezU1Capstone.dao.*;
import com.company.NadineHernandezU1Capstone.dto.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ServiceLayerTest {
    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private InvoiceDao invoiceDao;
    private T_ShirtDao t_shirtDao;
    private Processing_FeeDao processing_feeDao;
    private Sales_Tax_RateDao sales_tax_rateDao;
    private ServiceLayer serviceLayer;

    //================================================================
    // Mocks
    //================================================================

    private void setupInvoiceDaoMock(){
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
        Invoice invoice = new Invoice();
        invoice.setInvoice_id(1);
        invoice.setName("Nadine");
        invoice.setStreet("4304 Alison Jane Dr");
        invoice.setCity("Kennesaw");
        invoice.setState("GA");
        invoice.setZipcode("30144");
        invoice.setItem_type("T-Shirt");
        invoice.setItem_id(1);
        invoice.setUnit_price(new BigDecimal("19.99"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("39.98"));
        invoice.setTax(new BigDecimal("0.07"));
        invoice.setProcessing_fee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("44.7586"));

        Invoice invoice1 = new Invoice();
        invoice1.setName("Nadine");
        invoice1.setStreet("4304 Alison Jane Dr");
        invoice1.setCity("Kennesaw");
        invoice1.setState("GA");
        invoice1.setZipcode("30144");
        invoice1.setItem_type("T-Shirt");
        invoice1.setItem_id(1);
        invoice1.setUnit_price(new BigDecimal("19.99"));
        invoice1.setQuantity(2);
        invoice1.setSubtotal(new BigDecimal("39.98"));
        invoice1.setTax(new BigDecimal("0.07"));
        invoice1.setProcessing_fee(new BigDecimal("1.98"));
        invoice1.setTotal(new BigDecimal("44.7586"));

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
        doReturn(invoice).when(invoiceDao).getInvoice(1);
        doReturn(invoiceList).when(invoiceDao).getAllInvoices();
    }

    private void setupConsoleDaoMock(){
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);
        Console console = new Console();
        console.setConsole_id(1);
        console.setModel("Wii");
        console.setManufacturer("Nitendo");
        console.setMemory_amount("32GB");
        console.setProcessor("JX2500");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(50);

        Console console1 = new Console();
        console1.setModel("Wii");
        console1.setManufacturer("Nitendo");
        console1.setMemory_amount("32GB");
        console1.setProcessor("JX2500");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(50);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);

        doReturn(console).when(consoleDao).addConsole(console1);
        doReturn(console).when(consoleDao).getConsole(1);
        doReturn(consoleList).when(consoleDao).getAllConsoles();
        doReturn(consoleList).when(consoleDao).findConsolesByManufacturer("Nitendo");
    }

    private void setupGameDaoMock(){
        gameDao = mock(GameDaoJdbcTemplateImpl.class);
        Game game = new Game();
        game.setGame_id(1);
        game.setTitle("Breath of the Wild");
        game.setEsrb_rating("PG-13");
        game.setDescription("Cooking with Link");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Best Bois Studio");
        game.setQuantity(25);

        Game game1 = new Game();
        game1.setTitle("Breath of the Wild");
        game1.setEsrb_rating("PG-13");
        game1.setDescription("Cooking with Link");
        game1.setPrice(new BigDecimal("49.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(25);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);

        doReturn(game).when(gameDao).addGame(game1);
        doReturn(game).when(gameDao).getGame(1);
        doReturn(gameList).when(gameDao).getAllGames();
        doReturn(gameList).when(gameDao).findGamesByStudio("Best Bois Studio");
        doReturn(gameList).when(gameDao).findGamesByESRB("PG-13");
        doReturn(gameList).when(gameDao).findGamesByTitle("Breath of the Wild");
    }

    private void setupT_ShirtDaoMock(){
        t_shirtDao = mock(T_ShirtDaoJdbcTemplateImpl.class);
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setT_shirt_id(1);
        t_shirt.setSize("Medium");
        t_shirt.setColor("Blue");
        t_shirt.setDescription("Link T-shirt");
        t_shirt.setPrice(new BigDecimal("19.99"));
        t_shirt.setQuantity(1000);

        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt1.setSize("Medium");
        t_shirt1.setColor("Blue");
        t_shirt1.setDescription("Link T-shirt");
        t_shirt1.setPrice(new BigDecimal("19.99"));
        t_shirt1.setQuantity(1000);

        List<T_Shirt> t_shirtList = new ArrayList<>();
        t_shirtList.add(t_shirt);

        doReturn(t_shirt).when(t_shirtDao).addT_Shirt(t_shirt1);
        doReturn(t_shirt).when(t_shirtDao).getT_Shirt(1);
        doReturn(t_shirtList).when(t_shirtDao).getAllT_Shirts();
        doReturn(t_shirtList).when(t_shirtDao).findT_ShirtsBySize("Medium");
        doReturn(t_shirtList).when(t_shirtDao).findT_ShirtsByColor("Blue");
    }

    private void setupProcessing_FeeDaoMock(){
        processing_feeDao = mock(Processing_FeeDaoJdbcTemplateImpl.class);
        Processing_Fee processing_fee = new Processing_Fee();
        processing_fee.setProduct_type("T-Shirt");
        processing_fee.setFee(new BigDecimal("1.98"));

        doReturn(processing_fee).when(processing_feeDao).getProcessing_Fee("T-Shirt");
    }

    private void setupSales_Tax_RateDaoMock(){
        sales_tax_rateDao = mock(Sales_Tax_RateDaoJdbcTemplateImpl.class);
        Sales_Tax_Rate sales_tax_rate = new Sales_Tax_Rate();
        sales_tax_rate.setState("GA");
        sales_tax_rate.setRate(new BigDecimal(".07"));

        doReturn(sales_tax_rate).when(sales_tax_rateDao).getSales_Tax_Rate("GA");
    }

    //================================================================
    // Setup
    //================================================================

    @Before
    public void setUp() throws Exception {
        setupInvoiceDaoMock();
        setupConsoleDaoMock();
        setupGameDaoMock();
        setupT_ShirtDaoMock();
        setupProcessing_FeeDaoMock();
        setupSales_Tax_RateDaoMock();

        serviceLayer = new ServiceLayer(consoleDao, invoiceDao, gameDao, t_shirtDao, processing_feeDao, sales_tax_rateDao);
    }

    //================================================================
    // Invoice Service Layer Tests
    //================================================================

    @Test
    public void saveInvoice() {
        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt1.setSize("Medium");
        t_shirt1.setColor("Blue");
        t_shirt1.setDescription("Link T-shirt");
        t_shirt1.setPrice(new BigDecimal("19.99"));
        t_shirt1.setQuantity(1000);

        t_shirt1 = serviceLayer.saveT_Shirt(t_shirt1);

        Invoice invoice1 = new Invoice();
        invoice1.setName("Nadine");
        invoice1.setStreet("4304 Alison Jane Dr");
        invoice1.setCity("Kennesaw");
        invoice1.setState("GA");
        invoice1.setZipcode("30144");
        invoice1.setItem_type("T-Shirt");
        invoice1.setItem_id(t_shirt1.getT_shirt_id());
        invoice1.setQuantity(2);

        invoice1 = serviceLayer.saveInvoice(invoice1);
        assertEquals(invoice1, serviceLayer.findInvoice(invoice1.getInvoice_id()));
    }

    @Test
    public void findInvoice() {
        Invoice invoice1 = new Invoice();
        invoice1.setName("Nadine");
        invoice1.setStreet("4304 Alison Jane Dr");
        invoice1.setCity("Kennesaw");
        invoice1.setState("GA");
        invoice1.setZipcode("30144");
        invoice1.setItem_type("T-Shirt");
        invoice1.setItem_id(1);
        invoice1.setQuantity(2);

        invoice1 = serviceLayer.saveInvoice(invoice1);
        assertEquals(invoice1, serviceLayer.findInvoice(invoice1.getInvoice_id()));
    }

    @Test
    public void findAllInvoices() {
        Invoice invoice1 = new Invoice();
        invoice1.setName("Nadine");
        invoice1.setStreet("4304 Alison Jane Dr");
        invoice1.setCity("Kennesaw");
        invoice1.setState("GA");
        invoice1.setZipcode("30144");
        invoice1.setItem_type("T-Shirt");
        invoice1.setItem_id(1);
        invoice1.setQuantity(2);

        invoice1 = serviceLayer.saveInvoice(invoice1);
        assertEquals(1, serviceLayer.findAllInvoices().size());
        assertEquals(invoice1, serviceLayer.findAllInvoices().get(0));
    }

    @Test
    public void updateInvoice() {
        Invoice invoice1 = new Invoice();
        invoice1.setInvoice_id(1);
        invoice1.setName("Nadine");
        invoice1.setStreet("4304 Alison Jane Dr");
        invoice1.setCity("Kennesaw");
        invoice1.setState("GA");
        invoice1.setZipcode("30144");
        invoice1.setItem_type("T-Shirt");
        invoice1.setItem_id(1);
        invoice1.setUnit_price(new BigDecimal("19.99"));
        invoice1.setQuantity(2);
        invoice1.setSubtotal(new BigDecimal("39.98"));
        invoice1.setTax(new BigDecimal("0.07"));
        invoice1.setProcessing_fee(new BigDecimal("1.98"));
        invoice1.setTotal(new BigDecimal("44.7586"));

        ArgumentCaptor<Invoice> invoiceCaptor = ArgumentCaptor.forClass(Invoice.class);

        doNothing().when(invoiceDao).updateInvoice(invoiceCaptor.capture());
        serviceLayer.updateInvoice(invoice1);
        verify(invoiceDao, times(1)).updateInvoice(invoiceCaptor.getValue());

        Invoice invoice = invoiceCaptor.getValue();
        assertEquals(invoice1.getInvoice_id(), invoice.getInvoice_id());
        assertEquals(invoice1.getName(), invoice.getName());
        assertEquals(invoice1.getStreet(), invoice.getStreet());
        assertEquals(invoice1.getCity(), invoice.getCity());
        assertEquals(invoice1.getState(), invoice.getState());
        assertEquals(invoice1.getZipcode(), invoice.getZipcode());
        assertEquals(invoice1.getItem_type(), invoice.getItem_type());
        assertEquals(invoice1.getItem_id(), invoice.getItem_id());
        assertEquals(invoice1.getUnit_price(), invoice.getUnit_price());
        assertEquals(invoice1.getQuantity(), invoice.getQuantity());
        assertEquals(invoice1.getSubtotal(), invoice.getSubtotal());
        assertEquals(invoice1.getTax(), invoice.getTax());
        assertEquals(invoice1.getProcessing_fee(), invoice.getProcessing_fee());
        assertEquals(invoice1.getTotal(), invoice.getTotal());
    }

    @Test
    public void removeInvoice() {
        Invoice invoice = new Invoice();
        invoice.setInvoice_id(1);

        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(invoiceDao).deleteInvoice(idCaptor.capture());
        serviceLayer.removeInvoice(1);

        verify(invoiceDao, times(1)).deleteInvoice(idCaptor.getValue());
        assertEquals(1, idCaptor.getValue().intValue());
    }

    //================================================================
    // Console Service Layer Tests
    //================================================================

    @Test
    public void saveConsole() {
        Console console1 = new Console();
        console1.setModel("Wii");
        console1.setManufacturer("Nitendo");
        console1.setMemory_amount("32GB");
        console1.setProcessor("JX2500");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(50);

        console1 = serviceLayer.saveConsole(console1);
        assertEquals(console1, serviceLayer.findConsole(console1.getConsole_id()));
    }

    @Test
    public void findConsole() {
        Console console1 = new Console();
        console1.setModel("Wii");
        console1.setManufacturer("Nitendo");
        console1.setMemory_amount("32GB");
        console1.setProcessor("JX2500");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(50);

        console1 = serviceLayer.saveConsole(console1);
        assertEquals(console1, serviceLayer.findConsole(console1.getConsole_id()));
    }

    @Test
    public void findAllConsoles() {
        Console console1 = new Console();
        console1.setModel("Wii");
        console1.setManufacturer("Nitendo");
        console1.setMemory_amount("32GB");
        console1.setProcessor("JX2500");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(50);

        console1 = serviceLayer.saveConsole(console1);
        assertEquals(1, serviceLayer.findAllConsoles().size());
        assertEquals(console1, serviceLayer.findAllConsoles().get(0));
    }

    @Test
    public void updateConsole() {
        Console console1 = new Console();
        console1.setConsole_id(1);
        console1.setModel("Wii");
        console1.setManufacturer("Nitendo");
        console1.setMemory_amount("32GB");
        console1.setProcessor("JX2500");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(50);

        ArgumentCaptor<Console> consoleCaptor = ArgumentCaptor.forClass(Console.class);

        doNothing().when(consoleDao).updateConsole(consoleCaptor.capture());
        serviceLayer.updateConsole(console1);
        verify(consoleDao, times(1)).updateConsole(consoleCaptor.getValue());

        Console console = consoleCaptor.getValue();
        assertEquals(console1.getConsole_id(), console.getConsole_id());
        assertEquals(console1.getModel(), console.getModel());
        assertEquals(console1.getManufacturer(), console.getManufacturer());
        assertEquals(console1.getMemory_amount(), console.getMemory_amount());
        assertEquals(console1.getProcessor(), console.getProcessor());
        assertEquals(console1.getPrice(), console.getPrice());
        assertEquals(console1.getQuantity(), console.getQuantity());
    }

    @Test
    public void removeConsole() {
        Console console = new Console();
        console.setConsole_id(1);

        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(consoleDao).deleteConsole(idCaptor.capture());
        serviceLayer.removeConsole(1);

        verify(consoleDao, times(1)).deleteConsole(idCaptor.getValue());
        assertEquals(1, idCaptor.getValue().intValue());
    }

    @Test
    public void findConsolesByManufacturer() {
        Console console1 = new Console();
        console1.setModel("Wii");
        console1.setManufacturer("Nitendo");
        console1.setMemory_amount("32GB");
        console1.setProcessor("JX2500");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(50);

        console1 = serviceLayer.saveConsole(console1);
        assertEquals(1, serviceLayer.findConsolesByManufacturer("Nitendo").size());
        assertEquals(console1, serviceLayer.findConsolesByManufacturer("Nitendo").get(0));
    }

    //================================================================
    // Game Service Layer Tests
    //================================================================

    @Test
    public void saveGame() {
        Game game1 = new Game();
        game1.setTitle("Breath of the Wild");
        game1.setEsrb_rating("PG-13");
        game1.setDescription("Cooking with Link");
        game1.setPrice(new BigDecimal("49.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(25);

        game1 = serviceLayer.saveGame(game1);
        assertEquals(game1, serviceLayer.findGame(game1.getGame_id()));
    }

    @Test
    public void findGame() {
        Game game1 = new Game();
        game1.setTitle("Breath of the Wild");
        game1.setEsrb_rating("PG-13");
        game1.setDescription("Cooking with Link");
        game1.setPrice(new BigDecimal("49.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(25);

        game1 = serviceLayer.saveGame(game1);
        assertEquals(game1, serviceLayer.findGame(game1.getGame_id()));
    }

    @Test
    public void findAllGames() {
        Game game1 = new Game();
        game1.setTitle("Breath of the Wild");
        game1.setEsrb_rating("PG-13");
        game1.setDescription("Cooking with Link");
        game1.setPrice(new BigDecimal("49.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(25);

        game1 = serviceLayer.saveGame(game1);
        assertEquals(1, serviceLayer.findAllGames().size());
        assertEquals(game1, serviceLayer.findAllGames().get(0));
    }

    @Test
    public void updateGame() {
        Game game1 = new Game();
        game1.setGame_id(1);
        game1.setTitle("Breath of the Wild");
        game1.setEsrb_rating("PG-13");
        game1.setDescription("Cooking with Link");
        game1.setPrice(new BigDecimal("49.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(25);

        ArgumentCaptor<Game> gameCaptor = ArgumentCaptor.forClass(Game.class);

        doNothing().when(gameDao).updateGame(gameCaptor.capture());
        serviceLayer.updateGame(game1);
        verify(gameDao, times(1)).updateGame(gameCaptor.getValue());

        Game game = gameCaptor.getValue();
        assertEquals(game1.getGame_id(), game.getGame_id());
    }

    @Test
    public void removeGame() {
        Game game = new Game();
        game.setGame_id(1);

        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);

        doNothing().when(gameDao).deleteGame(idCaptor.capture());
        serviceLayer.removeGame(1);
        verify(gameDao, times(1)).deleteGame(idCaptor.getValue());
        assertEquals(1, idCaptor.getValue().intValue());
    }

    @Test
    public void findGamesByStudio() {
        Game game1 = new Game();
        game1.setTitle("Breath of the Wild");
        game1.setEsrb_rating("PG-13");
        game1.setDescription("Cooking with Link");
        game1.setPrice(new BigDecimal("49.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(25);

        game1 = serviceLayer.saveGame(game1);
        assertEquals(1, serviceLayer.findGamesByStudio("Best Bois Studio").size());
        assertEquals(game1, serviceLayer.findGamesByStudio("Best Bois Studio").get(0));
    }

    @Test
    public void findGamesByESRB() {
        Game game1 = new Game();
        game1.setTitle("Breath of the Wild");
        game1.setEsrb_rating("PG-13");
        game1.setDescription("Cooking with Link");
        game1.setPrice(new BigDecimal("49.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(25);

        game1 = serviceLayer.saveGame(game1);
        assertEquals(1, serviceLayer.findGamesByESRB("PG-13").size());
        assertEquals(game1, serviceLayer.findGamesByESRB("PG-13").get(0));
    }

    @Test
    public void findGamesByTitle() {
        Game game1 = new Game();
        game1.setTitle("Breath of the Wild");
        game1.setEsrb_rating("PG-13");
        game1.setDescription("Cooking with Link");
        game1.setPrice(new BigDecimal("49.99"));
        game1.setStudio("Best Bois Studio");
        game1.setQuantity(25);

        game1 = serviceLayer.saveGame(game1);
        assertEquals(1, serviceLayer.findGamesByTitle("Breath of the Wild").size());
        assertEquals(game1, serviceLayer.findGamesByTitle("Breath of the Wild").get(0));
    }

    //================================================================
    // T_Shirt Service Layer Tests
    //================================================================

    @Test
    public void saveT_Shirt() {
        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt1.setSize("Medium");
        t_shirt1.setColor("Blue");
        t_shirt1.setDescription("Link T-shirt");
        t_shirt1.setPrice(new BigDecimal("19.99"));
        t_shirt1.setQuantity(1000);

        t_shirt1 = serviceLayer.saveT_Shirt(t_shirt1);
        assertEquals(t_shirt1, serviceLayer.findT_Shirt(t_shirt1.getT_shirt_id()));
    }

    @Test
    public void findT_Shirt() {
        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt1.setSize("Medium");
        t_shirt1.setColor("Blue");
        t_shirt1.setDescription("Link T-shirt");
        t_shirt1.setPrice(new BigDecimal("19.99"));
        t_shirt1.setQuantity(1000);

        t_shirt1 = serviceLayer.saveT_Shirt(t_shirt1);
        assertEquals(t_shirt1, serviceLayer.findT_Shirt(t_shirt1.getT_shirt_id()));
    }

    @Test
    public void findAllT_Shirts() {
        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt1.setSize("Medium");
        t_shirt1.setColor("Blue");
        t_shirt1.setDescription("Link T-shirt");
        t_shirt1.setPrice(new BigDecimal("19.99"));
        t_shirt1.setQuantity(1000);

        t_shirt1 = serviceLayer.saveT_Shirt(t_shirt1);
        assertEquals(1, serviceLayer.findAllT_Shirts().size());
        assertEquals(t_shirt1, serviceLayer.findAllT_Shirts().get(0));
    }

    @Test
    public void updateT_Shirt() {
        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt1.setT_shirt_id(1);
        t_shirt1.setSize("Medium");
        t_shirt1.setColor("Blue");
        t_shirt1.setDescription("Link T-shirt");
        t_shirt1.setPrice(new BigDecimal("19.99"));
        t_shirt1.setQuantity(1000);

        ArgumentCaptor<T_Shirt> t_ShirtCaptor = ArgumentCaptor.forClass(T_Shirt.class);

        doNothing().when(t_shirtDao).updateT_Shirt(t_ShirtCaptor.capture());
        serviceLayer.updateT_Shirt(t_shirt1);
        verify(t_shirtDao, times(1)).updateT_Shirt(t_ShirtCaptor.getValue());

        T_Shirt t_shirt = t_ShirtCaptor.getValue();
        assertEquals(t_shirt1.getT_shirt_id(), t_shirt.getT_shirt_id());
        assertEquals(t_shirt1.getSize(), t_shirt.getSize());
        assertEquals(t_shirt1.getColor(), t_shirt.getColor());
        assertEquals(t_shirt1.getDescription(), t_shirt.getDescription());
        assertEquals(t_shirt1.getPrice(), t_shirt.getPrice());
        assertEquals(t_shirt1.getQuantity(), t_shirt.getQuantity());
    }

    @Test
    public void removeT_Shirt() {
        T_Shirt t_shirt = new T_Shirt();
        t_shirt.setT_shirt_id(1);

        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(t_shirtDao).deleteT_Shirt(idCaptor.capture());
        serviceLayer.removeT_Shirt(1);

        verify(t_shirtDao, times(1)).deleteT_Shirt(idCaptor.getValue());
        assertEquals(1, idCaptor.getValue().intValue());
    }

    @Test
    public void findT_ShirtsByColor() {
        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt1.setSize("Medium");
        t_shirt1.setColor("Blue");
        t_shirt1.setDescription("Link T-shirt");
        t_shirt1.setPrice(new BigDecimal("19.99"));
        t_shirt1.setQuantity(1000);

        t_shirt1 = serviceLayer.saveT_Shirt(t_shirt1);
        assertEquals(1, serviceLayer.findT_ShirtsByColor("Blue").size());
        assertEquals(t_shirt1, serviceLayer.findT_ShirtsByColor("Blue").get(0));
    }

    @Test
    public void findT_ShirtsBySize() {
        T_Shirt t_shirt1 = new T_Shirt();
        t_shirt1.setSize("Medium");
        t_shirt1.setColor("Blue");
        t_shirt1.setDescription("Link T-shirt");
        t_shirt1.setPrice(new BigDecimal("19.99"));
        t_shirt1.setQuantity(1000);

        t_shirt1 = serviceLayer.saveT_Shirt(t_shirt1);
        assertEquals(1, serviceLayer.findT_ShirtsBySize("Medium").size());
        assertEquals(t_shirt1, serviceLayer.findT_ShirtsBySize("Medium").get(0));
    }
}