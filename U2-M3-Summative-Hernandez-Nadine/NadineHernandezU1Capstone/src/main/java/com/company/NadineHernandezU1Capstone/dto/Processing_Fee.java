package com.company.NadineHernandezU1Capstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Processing_Fee {
    private String product_type;
    private BigDecimal fee;

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processing_Fee that = (Processing_Fee) o;
        return product_type.equals(that.product_type) &&
                fee.equals(that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_type, fee);
    }
}
