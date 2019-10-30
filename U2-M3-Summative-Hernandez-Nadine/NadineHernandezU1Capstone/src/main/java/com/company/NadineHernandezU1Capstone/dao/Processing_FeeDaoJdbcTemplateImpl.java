package com.company.NadineHernandezU1Capstone.dao;

import com.company.NadineHernandezU1Capstone.dto.Processing_Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class Processing_FeeDaoJdbcTemplateImpl implements Processing_FeeDao{

    private static final String SELECT_PROCESSING_FEE_SQL =
            "SELECT * FROM processing_fee WHERE product_type = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Processing_FeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Processing_Fee getProcessing_Fee(String item_type) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_SQL, this::mapRowToProcessing_Fee, item_type);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Processing_Fee mapRowToProcessing_Fee(ResultSet rs, int rowNum) throws SQLException{
        Processing_Fee processing_fee = new Processing_Fee();
        processing_fee.setProduct_type(rs.getString("product_type"));
        processing_fee.setFee(rs.getBigDecimal("fee"));

        return processing_fee;
    }
}
