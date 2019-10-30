package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.Processing_Fee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Processing_FeeDaoTest {

    @Autowired
    Processing_FeeDao processing_feeDao;

    @Test
    public void getProcessing_Fee() {
        Processing_Fee processing_fee = new Processing_Fee();
        processing_fee.setProduct_type("Consoles");
        processing_fee.setFee(new BigDecimal("14.99"));

        assertEquals(processing_fee, processing_feeDao.getProcessing_Fee("Consoles"));
    }
}