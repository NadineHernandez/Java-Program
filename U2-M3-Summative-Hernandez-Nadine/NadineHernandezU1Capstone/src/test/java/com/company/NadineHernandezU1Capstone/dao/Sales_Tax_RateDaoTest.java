package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.Sales_Tax_Rate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Sales_Tax_RateDaoTest {

    @Autowired
    Sales_Tax_RateDao sales_tax_rateDao;

    @Test
    public void getSales_Tax_Rate() {
        Sales_Tax_Rate sales_tax_rate = new Sales_Tax_Rate();
        sales_tax_rate.setState("AL");
        sales_tax_rate.setRate(new BigDecimal(".05"));

        assertEquals(sales_tax_rate, sales_tax_rateDao.getSales_Tax_Rate("AL"));
    }
}