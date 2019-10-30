package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.Sales_Tax_Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class Sales_Tax_RateDaoJdbcTemplateImpl implements Sales_Tax_RateDao{

    private static final String SELECT_SALES_TAX_RATE_SQL =
            "SELECT * FROM sales_tax_rate WHERE state = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Sales_Tax_RateDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Sales_Tax_Rate getSales_Tax_Rate(String state) {
        try {
            return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATE_SQL, this::mapToRowSales_Tax_Rate, state);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Sales_Tax_Rate mapToRowSales_Tax_Rate(ResultSet rs, int rowNum) throws SQLException{
        Sales_Tax_Rate sales_tax_rate = new Sales_Tax_Rate();
        sales_tax_rate.setState(rs.getString("state"));
        sales_tax_rate.setRate(rs.getBigDecimal("rate"));

        return sales_tax_rate;
    }
}
