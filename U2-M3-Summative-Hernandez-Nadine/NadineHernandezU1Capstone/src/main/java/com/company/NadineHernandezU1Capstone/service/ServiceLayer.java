package com.company.NadineHernandezU1Capstone.service;

import com.company.NadineHernandezU1Capstone.dao.*;
import com.company.NadineHernandezU1Capstone.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ServiceLayer {
    private ConsoleDao consoleDao;
    private InvoiceDao invoiceDao;
    private GameDao gameDao;
    private T_ShirtDao t_shirtDao;
    private Processing_FeeDao processing_feeDao;
    private Sales_Tax_RateDao sales_tax_rateDao;

    @Autowired
    public ServiceLayer(ConsoleDao consoleDao, InvoiceDao invoiceDao, GameDao gameDao, T_ShirtDao t_shirtDao, Processing_FeeDao processing_feeDao, Sales_Tax_RateDao sales_tax_rateDao) {
        this.consoleDao = consoleDao;
        this.invoiceDao = invoiceDao;
        this.gameDao = gameDao;
        this.t_shirtDao = t_shirtDao;
        this.processing_feeDao = processing_feeDao;
        this.sales_tax_rateDao = sales_tax_rateDao;
    }

    //================================================================
    // Invoice Service Layer
    //================================================================

    @Transactional
    public Invoice saveInvoice(Invoice invoice){
        try {
            BigDecimal myTax = sales_tax_rateDao.getSales_Tax_Rate(invoice.getState()).getRate();
        } catch (Exception e) {
            throw new IllegalArgumentException("Illegal State Code");
        }
        BigDecimal myUnit_price;

        switch (invoice.getItem_type()){
            case "Console":
                myUnit_price = consoleDao.getConsole(invoice.getItem_id()).getPrice();
                if (invoice.getQuantity() <= consoleDao.getConsole(invoice.getItem_id()).getQuantity()) {
                    consoleDao.getConsole(invoice.getItem_id())
                            .setQuantity(consoleDao.getConsole(invoice.getItem_id()).getQuantity() - invoice.getQuantity());
                    consoleDao.getConsole(invoice.getItem_id()).getQuantity();
                } else {
                    throw new IllegalArgumentException("Insufficient Inventory");
                }
                break;
            case "Game":
                myUnit_price = gameDao.getGame(invoice.getItem_id()).getPrice();
                if (invoice.getQuantity() <= gameDao.getGame(invoice.getItem_id()).getQuantity()) {
                    gameDao.getGame(invoice.getItem_id())
                            .setQuantity(gameDao.getGame(invoice.getItem_id()).getQuantity() - invoice.getQuantity());
                } else {
                    throw new IllegalArgumentException("Insufficient Inventory");
                }
                break;
            case "T-Shirt":
                myUnit_price = t_shirtDao.getT_Shirt(invoice.getItem_id()).getPrice();
                if (invoice.getQuantity() <= t_shirtDao.getT_Shirt(invoice.getItem_id()).getQuantity()) {
                    t_shirtDao.getT_Shirt(invoice.getItem_id())
                            .setQuantity(t_shirtDao.getT_Shirt(invoice.getItem_id()).getQuantity() - invoice.getQuantity());
                } else {
                    throw new IllegalArgumentException("Insufficient Inventory");
                }
                break;
            default:
                myUnit_price = null;
        }

        BigDecimal mySubtotal = myUnit_price.multiply(new BigDecimal(invoice.getQuantity()));
        BigDecimal myTax = sales_tax_rateDao.getSales_Tax_Rate(invoice.getState()).getRate();

        BigDecimal myProcessing_Fee = processing_feeDao.getProcessing_Fee(invoice.getItem_type()).getFee();
        if (invoice.getQuantity() > 10){
            myProcessing_Fee = myProcessing_Fee.add(new BigDecimal("15.49"));
        }

        BigDecimal myTotal = (mySubtotal.multiply(new BigDecimal(String.valueOf(myTax.add(new BigDecimal(1)))))).add(myProcessing_Fee);

        invoice.setUnit_price(myUnit_price);
        invoice.setSubtotal(mySubtotal);
        invoice.setTax(myTax);
        invoice.setProcessing_fee(myProcessing_Fee);
        invoice.setTotal(myTotal);

        return invoiceDao.addInvoice(invoice);
    }

    public Invoice findInvoice(int id){
        return invoiceDao.getInvoice(id);
    }

    public List<Invoice> findAllInvoices(){
        return invoiceDao.getAllInvoices();
    }

    public void updateInvoice(Invoice invoice){
        BigDecimal myUnit_price;

        switch (invoice.getItem_type()){
            case "Console":
                myUnit_price = consoleDao.getConsole(invoice.getItem_id()).getPrice();
                break;
            case "Game":
                myUnit_price = gameDao.getGame(invoice.getItem_id()).getPrice();
                break;
            case "T-Shirt":
                myUnit_price = t_shirtDao.getT_Shirt(invoice.getItem_id()).getPrice();
                break;
            default:
                myUnit_price = null;
        }

        BigDecimal mySubtotal = myUnit_price.multiply(new BigDecimal(invoice.getQuantity()));
        BigDecimal myTax = sales_tax_rateDao.getSales_Tax_Rate(invoice.getState()).getRate();
        BigDecimal myProcessing_Fee = processing_feeDao.getProcessing_Fee(invoice.getItem_type()).getFee();
        BigDecimal myTotal = (mySubtotal.multiply(new BigDecimal(String.valueOf(myTax.add(new BigDecimal(1)))))).add(myProcessing_Fee);

        invoice.setUnit_price(myUnit_price);
        invoice.setSubtotal(mySubtotal);
        invoice.setTax(myTax);
        invoice.setProcessing_fee(myProcessing_Fee);
        invoice.setTotal(myTotal);

        invoiceDao.updateInvoice(invoice);
    }

    @Transactional
    public void removeInvoice(int id){
        invoiceDao.deleteInvoice(id);
    }

    //================================================================
    // Console Service Layer
    //================================================================

    public Console saveConsole(Console console){
        return consoleDao.addConsole(console);
    }

    public Console findConsole(int id){
        return consoleDao.getConsole(id);
    }

    public List<Console> findAllConsoles(){
        return consoleDao.getAllConsoles();
    }

    public void updateConsole(Console console){
        consoleDao.updateConsole(console);
    }

    public void removeConsole(int id){
        consoleDao.deleteConsole(id);
    }

    public List<Console> findConsolesByManufacturer(String manufacturer){
        return consoleDao.findConsolesByManufacturer(manufacturer);
    }

    //================================================================
    // Game Service Layer
    //================================================================

    public Game saveGame(Game game){
        return gameDao.addGame(game);
    }

    public Game findGame(int id){
        return gameDao.getGame(id);
    }

    public List<Game> findAllGames(){
        return gameDao.getAllGames();
    }

    public void updateGame(Game game){
        gameDao.updateGame(game);
    }

    public void removeGame(int id){
        gameDao.deleteGame(id);
    }

    public List<Game> findGamesByStudio(String studio){
        return gameDao.findGamesByStudio(studio);
    }

    public List<Game> findGamesByESRB(String esrb_rating){
        return gameDao.findGamesByESRB(esrb_rating);
    }

    public List<Game> findGamesByTitle(String title){
        return gameDao.findGamesByTitle(title);
    }

    //================================================================
    // T_Shirt Service Layer
    //================================================================

    public T_Shirt saveT_Shirt(T_Shirt t_shirt){
        return t_shirtDao.addT_Shirt(t_shirt);
    }

    public T_Shirt findT_Shirt(int id){
        return t_shirtDao.getT_Shirt(id);
    }

    public List<T_Shirt> findAllT_Shirts(){
        return t_shirtDao.getAllT_Shirts();
    }

    public void updateT_Shirt(T_Shirt t_shirt){
        t_shirtDao.updateT_Shirt(t_shirt);
    }

    public void removeT_Shirt(int id){
        t_shirtDao.deleteT_Shirt(id);
    }

    public List<T_Shirt> findT_ShirtsByColor(String color){
        return t_shirtDao.findT_ShirtsByColor(color);
    }

    public List<T_Shirt> findT_ShirtsBySize(String size){
        return t_shirtDao.findT_ShirtsBySize(size);
    }

}
